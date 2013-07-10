/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel.model.compiler;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.btracel.builder.BTraceScript;
import com.sun.btrace.btracel.builder.EntryHandler;
import com.sun.btrace.btracel.builder.OnMethodBuilder;
import com.sun.btrace.btracel.model.Script;
import com.sun.btrace.btracel.model.parser.BTraceLBaseVisitor;
import com.sun.btrace.btracel.model.parser.BTraceLLexer;
import com.sun.btrace.btracel.model.parser.BTraceLParser;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.UnbufferedTokenStream;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

/**
 *
 * @author jbachorik
 */
public class BTraceLCompiler {
    final private static class ArgsToStringFormatter extends BTraceLBaseVisitor<String> {
        private boolean isEligible(String function) {
            for(Method m : BTraceUtils.class.getMethods()) {
                if (m.getName().equals(function) && m.getReturnType() != void.class) {
                    return true;
                }
            }
            return false;
        }
        @Override
        public String visitExp_unary(BTraceLParser.Exp_unaryContext ctx) {
            return getUnaryString(ctx);
        }

        @Override
        public String visitExp_plus(BTraceLParser.Exp_plusContext ctx) {
            return "strcat(" + getUnaryString(ctx.exp_unary()) + "," + ctx.exp().accept(new ArgsToStringFormatter()) + ")";
        }
        
        private String getUnaryString(BTraceLParser.Exp_unaryContext ctx) {
            if (ctx.STRING_LITERAL()!= null) {
                return ctx.STRING_LITERAL().getText();
            }
            if (ctx.NAME() != null) {
                return "str(" + ctx.NAME().getText() + ")";
            }
            if (ctx.NUMBER()!= null) {
                return "str(" + ctx.NUMBER().getText() + ")";
            }
            if (ctx.VAR_REF() != null) {
                return "str(" + ctx.VAR_REF().getText() + ")";
            }
            if (ctx.functionEval() != null) {
                if (isEligible(ctx.functionEval().NAME().getText())) {
                    return "str(" + ctx.functionEval().getText() + ")";
                }
            }
            
            return "<unknown>";
        }
    }
    
    public Script compile(String oneliner) throws IOException {
        BTraceLLexer lexer = new BTraceLLexer(new org.antlr.v4.runtime.ANTLRInputStream(oneliner));
        BTraceLParser parser = new BTraceLParser(new UnbufferedTokenStream(lexer));

        final BTraceScript scr = new BTraceScript();
        final AtomicBoolean error = new AtomicBoolean(false);
        parser.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                error.set(true);
            }

            @Override
            public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
                error.set(true);
            }

            @Override
            public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
                error.set(true);
            }

            @Override
            public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
                error.set(true);
            }
        });
        parser.program().accept(new BTraceLBaseVisitor<Void>() {
            String clazz = null;
            String method = null;

            @Override
            public Void visitClassmatch(BTraceLParser.ClassmatchContext ctx) {
                clazz = ctx.accept(new BTraceLBaseVisitor<String>(){
                    @Override
                    public String visitRegex(BTraceLParser.RegexContext ctx) {
                        return ctx.getText().substring(1, ctx.getText().length() - 1);
                    }

                    @Override
                    public String visitPkgid(BTraceLParser.PkgidContext ctx) {
                        return ctx.getText();
                    }
                });
                return super.visitClassmatch(ctx);
            }

            @Override
            public Void visitMethodmatch(BTraceLParser.MethodmatchContext ctx) {
                method = ctx.accept(new BTraceLBaseVisitor<String>(){
                    @Override
                    public String visitRegex(BTraceLParser.RegexContext ctx) {
                        return ctx.getText().substring(1, ctx.getText().length() - 1);
                    }

                    @Override
                    public String visitMethodid(BTraceLParser.MethodidContext ctx) {
                        return ctx.NAME().getText();
                    }
                });

                return super.visitMethodmatch(ctx);
            }

            @Override
            public Void visitHandlers(BTraceLParser.HandlersContext ctx) {
                OnMethodBuilder.Base onMethod = method != null ? scr.onMethod(clazz, method) : scr.onMethod(clazz);

                Map<String, BTraceLParser.HandlerContext> hMap = new HashMap<String, BTraceLParser.HandlerContext>();
                for(BTraceLParser.HandlerContext h : ctx.handler()) {
                    hMap.put(h.type().getText(), h);
                }

                onMethod.onEntry(entryHandler(hMap.get("entry")));

                return super.visitHandlers(ctx);
            }

            private EntryHandler entryHandler(BTraceLParser.HandlerContext ctx) {
                EntryHandler eh = new EntryHandler();
                for(BTraceLParser.StatementContext stmt : ctx.block().statement()) {
                    String func = stmt.functionEval().NAME().getText();
                    switch (func) {
                        case "println": {
                            String args = stmt.functionEval().arguments().accept(new ArgsToStringFormatter());
                            eh.println("#" + args);
                        }
                    }
                }

                return eh;
            }
        });
        
        if (error.get()) {
            throw new IOException();
        }
        
        return scr.getModel();
    }
}
