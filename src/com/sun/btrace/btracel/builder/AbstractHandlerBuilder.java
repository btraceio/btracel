package com.sun.btrace.btracel.builder;

import com.sun.btrace.btracel.model.parser.FormatPart;
import com.sun.btrace.btracel.model.parser.FormattedString;
import com.sun.btrace.btracel.model.parser.SimpleFormatParser;
import java.util.Collections;
import java.util.List;

abstract public class AbstractHandlerBuilder<T extends AbstractHandlerBuilder<T>> {
    private final StringBuilder codeBuilder = new StringBuilder();
    final public T print(String msg) {
        if (validate("print", msg)) {
            codeBuilder.append("print(").append(format(msg)).append(");\n");
            return (T)this;
        }
        throw new IllegalStateException();
    }

    final public T println(String msg) {
        if (validate("println", msg)) {
            codeBuilder.append("println(").append(format(msg)).append(");\n");
            return (T)this;
        }
        throw new IllegalStateException();
    }

    final public T dumpHeap(String path) {
        if (validate("dumpHeap", path)) {
            codeBuilder.append("dumpHeap(").append(format(path)).append(");\n");
            return (T)this;
        }
        throw new IllegalStateException();
    }

    final public T dumpHeap(String path, boolean live) {
        if (validate("dumpHeap", path, live)) {
            codeBuilder.append("dumpHeap(").append(format(path)).append(", ").
                        append(live).append(");\n");
            return (T)this;
        }
        throw new IllegalStateException();
    }

    private static String format(String msg) {
        if (msg.startsWith("#")) {
            return msg.substring(1);
        }
        
        FormattedString fs = new SimpleFormatParser().parse(msg);
        StringBuilder sb = new StringBuilder();
        int pcounter = 0;
        List<FormatPart> parts = fs.parts();
        Collections.reverse(parts);
        for(FormatPart p : parts) {
            if (pcounter++ > 0) {
                sb.insert(0, ", ").insert(0, p.getFormatted()).insert(0, "strcat(");
                sb.append(")");
            } else {
                sb.append(p.getFormatted());
            }
        }

        return sb.toString();
    }

    final String getCode() {
        return codeBuilder.toString();
    }

    abstract protected boolean validate(String call, Object ... args);
}
