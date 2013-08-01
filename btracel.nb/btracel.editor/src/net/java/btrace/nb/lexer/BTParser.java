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
package net.java.btrace.nb.lexer;

import com.sun.btrace.btracel.model.parser.BTraceLLexer;
import com.sun.btrace.btracel.model.parser.BTraceLParser;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ChangeListener;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

/**
 *
 * @author Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
 */
public class BTParser extends Parser {
    public static class SyntaxError {
        final public int line;
        final public int charPositionInLine;
        final public String msg;

        public SyntaxError(int line, int charPositionInLine, String msg) {
            this.line = line;
            this.charPositionInLine = charPositionInLine;
            this.msg = msg;
        }
    }
    private Snapshot snapshot;
    private BTraceLParser btParser;
    final private Set<SyntaxError> exceptions = new HashSet<SyntaxError>();
    
    @Override
    public void parse(Snapshot snpsht, Task task, SourceModificationEvent sme) throws ParseException {
        exceptions.clear();
        this.snapshot = snpsht;
        ANTLRInputStream input = new ANTLRInputStream(snapshot.getText().toString());
        Lexer lexer = new BTraceLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        btParser = new BTraceLParser(tokens);
        btParser.addErrorListener(new ANTLRErrorListener() {

            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                if (line > -1) {
                    exceptions.add(new SyntaxError(line, charPositionInLine, msg));
                }
            }

            @Override
            public void reportAmbiguity(org.antlr.v4.runtime.Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
                
            }

            @Override
            public void reportAttemptingFullContext(org.antlr.v4.runtime.Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
                
            }

            @Override
            public void reportContextSensitivity(org.antlr.v4.runtime.Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
                
            }
        });
        try {
            btParser.program();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public BTraceLParser getParser() {
        return btParser;
    }
    
    @Override
    public Result getResult(Task task) throws ParseException {
        return new BTEditorParserResult(snapshot, this);
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
    }
    
    public Set<SyntaxError> getErrors() {
        return new HashSet<SyntaxError>(this.exceptions);
    }
    
    public static class BTEditorParserResult extends Result {

        private BTParser btParser;
        private boolean valid = true;

        BTEditorParserResult(Snapshot snapshot, BTParser parser) {
            super(snapshot);
            this.btParser = parser;
        }

        public BTParser getBTParser()
                throws ParseException {
            if (!valid) {
                throw new ParseException();
            }
            return btParser;
        }

        protected void invalidate() {
            valid = false;
        }
    }
}
