/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel.model.parser;

/**
 *
 * @author jbachorik
 */
public class FormatCall extends FormatPart {
    public FormatCall(int start, String call) {
        super(start, start + call.length() - 1, call);
    }

    @Override
    public String toString() {
        return "Call{" + getFormatted() + '}';
    }
}
