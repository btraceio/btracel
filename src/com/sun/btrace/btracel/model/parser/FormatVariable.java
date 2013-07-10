/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel.model.parser;

/**
 *
 * @author jbachorik
 */
public class FormatVariable extends FormatPart {
    public FormatVariable(int start, String name) {
        super(start, start + name.length() - 1, name);
    }

    @Override
    public String toString() {
        return "Variable{" + getFormatted() + '}';
    }    
}
