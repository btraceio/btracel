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
package com.sun.btrace.btracel.model.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
 */
final public class SimpleFormatParser {
    final private static Pattern REF = Pattern.compile("(\\@[a-zA-Z][a-zA-Z0-9_\\.]*)");

    public FormattedString parse(String input) {
        FormattedString fs = new FormattedString();
        Matcher m = REF.matcher(input);
        int index = 0;
        while (m.find(index)) {
            int start = m.start(1);
            String varName = m.group(1);
            if (start > 0) {
                fs.addPart(new FormatLiteral(index, input.substring(index, start)));
            }
            int endpos = start + varName.length();
            if (endpos < input.length() - 1 && input.charAt(endpos) == '(') {
                int level = 1;
                int maxlen = input.length() - 1;
                while (level > 0 && endpos < maxlen) {
                    if (input.charAt(++endpos) == '(') {
                        level++;
                    } else if (input.charAt(endpos) == ')') {
                        level--;
                    }
               }
               if (input.charAt(endpos) != ')') {
                   throw new IllegalStateException();
               }
               fs.addPart(new FormatCall(start, input.substring(start, endpos + 1)));
            } else {
                fs.addPart(new FormatVariable(start, varName));
            }
            index = endpos;
        }
        if (index < input.length() - 1) {
            fs.addPart(new FormatLiteral(index + 1, input.substring(index + 1)));
        }

        return fs;
    }

    public static void main(String[] args) {
        SimpleFormatParser p = new SimpleFormatParser();
        FormattedString s = p.parse("Hello world: @pcn\\.@pmn # @self.myvar");
        System.err.println(s);
    }
}
