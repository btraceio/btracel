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

/**
 *
 * @author Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
 */
public enum TokenType {
    COLON(BTraceLLexer.COLON, "keyword"),
    NAME(BTraceLLexer.NAME, "literal"),
    NUMBER(BTraceLLexer.NUMBER, "literal"),
    BOOLEAN(BTraceLLexer.BOOLEAN, "literal"),
    WS(BTraceLLexer.WS, "whitespace"),
    TAB(BTraceLLexer.TAB, "whitespace"),
    NEWLINE(BTraceLLexer.NEWLINE, "whitespace"),
    STRING(BTraceLLexer.STRING_LITERAL, "string"),
    REGEXP(BTraceLLexer.REGEXP_LITERAL, "string"),
    LBRACKET(BTraceLLexer.LBRACKET, "character"),
    RBRACKER(BTraceLLexer.RBRACKET, "character"),
    LCBRACKET(BTraceLLexer.LCBRACKET, "character"),
    RCBRACKET(BTraceLLexer.RCBRACKET, "character"),
    LSBRACKET(BTraceLLexer.LSBRACKET, "character"),
    RSBRACKET(BTraceLLexer.RSBRACKET, "character"),
    PLUS(BTraceLLexer.PLUS, "operator"),
    MINUS(BTraceLLexer.MINUS, "operator"),
    MULTIPLY(BTraceLLexer.MULTIPLY, "operator"),
    DIVIDE(BTraceLLexer.DIVIDE, "operator"),
    PERCENT(BTraceLLexer.PERCENT, "operator"),
    LT(BTraceLLexer.LT, "operator"),
    GT(BTraceLLexer.GT, "operator"),
    LE(BTraceLLexer.LE, "operator"),
    GE(BTraceLLexer.GE, "operator"),
    EQ(BTraceLLexer.EQUALS, "operator"),
    NEQ(BTraceLLexer.NONEQUALS, "operator"),
    PERIOD(BTraceLLexer.PERIOD, "character"),
    COMMA(BTraceLLexer.COMMA, "character"),
    SEMI(BTraceLLexer.SEMI, "character"),
    QUOTE(BTraceLLexer.QUOTE, "character"),
    PIPE(BTraceLLexer.PIPE, "keyword"),
    TILDA(BTraceLLexer.TILDA, "keyword"),
    VAR_REF(BTraceLLexer.VAR_REF, "field"),
    EXCEPTION(BTraceLLexer.EXCEPTION, "keyword"),
    EXIT(BTraceLLexer.EXIT, "keyword"),
    ENTRY(BTraceLLexer.ENTRY, "keyword"),
    SL_COMMENT(BTraceLLexer.SL_COMMENT, "comment"),
    ML_COMMENT(BTraceLLexer.ML_COMMENT, "comment"),
    IF(BTraceLLexer.IF, "keyword"),
    ELSE(BTraceLLexer.ELSE, "keyword")
    ;
    
    public int id;
    public String category;
    public String text;

    private TokenType(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public static TokenType valueOf(int id) {
        TokenType[] values = values();
        for (TokenType value : values) {
            if (value.id == id) {
                return value;
            }
        }
        throw new IllegalArgumentException("The id " + id + " is not recognized");
    }
}
