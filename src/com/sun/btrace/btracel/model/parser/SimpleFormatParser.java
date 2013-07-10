/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel.model.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jbachorik
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
