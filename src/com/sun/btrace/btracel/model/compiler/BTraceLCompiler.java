/*
 * Copyright (c) 2013, Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.sun.btrace.btracel.model.compiler;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.btracel.builder.BTraceScript;
import com.sun.btrace.btracel.builder.EntryHandler;
import com.sun.btrace.btracel.builder.ExitHandler;
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
 * @author Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
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
                        if (ctx.signature() != null) {
                            StringBuilder sb = new StringBuilder(ctx.signature().pkgid().getText());
                            sb.append(' ');
                            sb.append(ctx.signature().NAME().getText()).append('(');
                            for(BTraceLParser.ArgContext ac : ctx.signature().arglist().arg()) {
                                sb.append(ac.pkgid().getText()).append(' ').append(ac.NAME().getText());
                            }
                            sb.append(')');
                            return sb.toString();
                        } else {
                            return ctx.NAME().getText();
                        }
                    }
                });

                return super.visitMethodmatch(ctx);
            }

            @Override
            public Void visitHandlers(BTraceLParser.HandlersContext ctx) {
                OnMethodBuilder.Base onMethod = method != null ? scr.onMethod(clazz, method) : scr.onMethod(clazz);

                Map<String, BTraceLParser.HandlerContext> hMap = new HashMap<>();
                for(BTraceLParser.HandlerContext h : ctx.handler()) {
                    hMap.put(h.type().getText(), h);
                }

                onMethod.
                    onEntry(entryHandler(hMap.get("entry"))).
                    onExit(exitHandler(hMap.get("exit")));
                

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
            
            private ExitHandler exitHandler(BTraceLParser.HandlerContext ctx) {
                ExitHandler eh = new ExitHandler();
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
