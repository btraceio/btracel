/**
 * Copyright (c) 2010-2013, Jaroslav Bachorik
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, 
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
 * this list of conditions and the following disclaimer in the documentation and/or 
 * other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR 
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND 
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE 
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.java.btrace.nb.lexer;

import com.sun.btrace.btracel.model.parser.BTraceLLexer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
 */
public class BTLanguageHierarchy extends LanguageHierarchy<BTTokenId> {
    final private static List<BTTokenId> tokens = new ArrayList<BTTokenId>();
    final private static Map<Integer, BTTokenId> idToToken = new HashMap<Integer, BTTokenId>();
    
    static {
        TokenType[] tokenTypes = TokenType.values();
        for (TokenType tokenType : tokenTypes) {
            tokens.add(new BTTokenId(tokenType.name(), tokenType.category, tokenType.id));
        }
        for (BTTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }
    
    static synchronized BTTokenId getToken(int id) {
        return idToToken.get(id);
    }
    
    @Override
    protected Collection<BTTokenId> createTokenIds() {
        return tokens;
    }

    @Override
    protected Lexer<BTTokenId> createLexer(LexerRestartInfo<BTTokenId> lri) {
        return new BTLexer(lri);
    }

    @Override
    protected String mimeType() {
        return "text/x-btscript";
    }
}
