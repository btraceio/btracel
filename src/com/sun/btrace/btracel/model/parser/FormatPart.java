/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel.model.parser;

import java.util.Objects;

/**
 *
 * @author jbachorik
 */
abstract public class FormatPart implements Comparable<FormatPart>{
    final private int start, end;
    final private String formatted;

    public FormatPart(int start, int end, String formatted) {
        this.start = start;
        this.end = end;
        this.formatted = formatted;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getFormatted() {
        return formatted;
    }

    @Override
    public int compareTo(FormatPart o) {
        if (start < o.start) {
            return -1;
        } else if (start > o.start) {
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.start;
        hash = 67 * hash + this.end;
        hash = 67 * hash + Objects.hashCode(this.formatted);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormatPart other = (FormatPart) obj;
        if (this.start != other.start) {
            return false;
        }
        if (this.end != other.end) {
            return false;
        }
        if (!Objects.equals(this.formatted, other.formatted)) {
            return false;
        }
        return true;
    }
}
