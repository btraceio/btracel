/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel.model.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author jbachorik
 */
final public class FormattedString {
    final private SortedSet<FormatPart> parts = new TreeSet<FormatPart>();

    public void addPart(FormatPart part) {
        parts.add(part);
    }

    public List<FormatPart> parts() {
        return new ArrayList<FormatPart>(parts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FormattedString{\n");
        
        for(FormatPart fp : parts) {
            sb.append('\t').append(fp.toString()).append('\n');
        }
        sb.append('}');
        
        return sb.toString();
    }
}
