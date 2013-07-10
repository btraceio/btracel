/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel.model.parser;

/**
 *
 * @author jbachorik
 */
public class FormatLiteral extends FormatPart {
    public FormatLiteral(int start, String literal) {
        super(start, start + literal.length() - 1, "\"" + literal + "\"");
    }

    @Override
    public String toString() {
        return "Literal{" + getFormatted() + '}';
    }
}
