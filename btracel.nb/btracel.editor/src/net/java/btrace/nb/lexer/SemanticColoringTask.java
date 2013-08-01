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

import com.sun.btrace.btracel.model.parser.BTraceLBaseVisitor;
import com.sun.btrace.btracel.model.parser.BTraceLParser;
import java.awt.Color;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import org.netbeans.api.editor.settings.AttributesUtilities;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.ParserResultTask;
import org.netbeans.modules.parsing.spi.Scheduler;
import org.netbeans.modules.parsing.spi.SchedulerEvent;
import org.netbeans.spi.editor.highlighting.support.OffsetsBag;

/**
 *
 * @author Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
 */
public class SemanticColoringTask extends ParserResultTask<BTParser.BTEditorParserResult>{
    private static final AttributeSet defaultColors =
            AttributesUtilities.createImmutable(StyleConstants.Background,
            new Color(236, 235, 163));
    
    private static final AttributeSet italic;
    
    static {
        italic = AttributesUtilities.createImmutable(
            StyleConstants.Italic, Boolean.TRUE);
    }
    
    @Override
    public void run(final BTParser.BTEditorParserResult t, SchedulerEvent se) {
        try {
            final OffsetsBag bag = (OffsetsBag)t.getSnapshot().getSource().getDocument(false).getProperty(BTSemanticHighlighter.class);
            if (bag != null) {
                bag.clear();
                t.getBTParser().getParser().reset();
                t.getBTParser().getParser().program().accept(new BTraceLBaseVisitor<Void>(){
                    @Override
                    public Void visitFunctionEval(BTraceLParser.FunctionEvalContext fec) {
                        bag.addHighlight(fec.NAME().getSymbol().getStartIndex(), fec.NAME().getSymbol().getStopIndex() + 1, italic);

                        return super.visitFunctionEval(fec);
                    }

                });
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public Class<? extends Scheduler> getSchedulerClass() {
        return Scheduler.EDITOR_SENSITIVE_TASK_SCHEDULER;
    }

    @Override
    public void cancel() {
    }
    
}
