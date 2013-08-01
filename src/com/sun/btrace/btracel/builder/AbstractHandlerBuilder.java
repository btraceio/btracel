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
package com.sun.btrace.btracel.builder;

import com.sun.btrace.btracel.builder.calls.DumpHeapCall;
import com.sun.btrace.btracel.builder.calls.PrintCall;
import com.sun.btrace.btracel.builder.calls.PrintlnCall;
import com.sun.btrace.btracel.model.parser.FormatPart;
import com.sun.btrace.btracel.model.parser.FormattedString;
import com.sun.btrace.btracel.model.parser.SimpleFormatParser;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class AbstractHandlerBuilder<T extends AbstractHandlerBuilder<T>> {
    private final StringBuilder codeBuilder = new StringBuilder();
    protected final Map<String, CallSpecification> specs = new HashMap<>();
    
    public AbstractHandlerBuilder() {
        addSpecs(new CallSpecification[] {
            new PrintCall(),
            new PrintlnCall(),
            new DumpHeapCall()
        });
    }
    
    private void addSpecs(CallSpecification ... specs) {
        for(CallSpecification spec : specs) {
            addSpec(spec);
        }
    }
    
    private void addSpec(CallSpecification spec) {
        specs.put(spec.getName(), spec);
    }
    
    final public T print(String msg) {
        CallSpecification spec = specs.get("print");
        if (spec != null) {
            if (spec.validate(getInvalidParams(), msg)) {
                codeBuilder.append("print(").append(format(msg)).append(");\n");
                return (T)this;
            }
        }
        throw new IllegalStateException();
    }

    final public T println(String msg) {
        CallSpecification spec = specs.get("println");
        if (spec != null) {
            if (spec.validate(getInvalidParams(), msg)) {
                codeBuilder.append("println(").append(format(msg)).append(");\n");
                return (T)this;
            }
        }
        throw new IllegalStateException();
    }

    final public T dumpHeap(String path) {
        CallSpecification spec = specs.get("dumpHeap");
        if (spec != null) {
            if (spec.validate(getInvalidParams(), path)) {
                codeBuilder.append("dumpHeap(").append(format(path)).append(");\n");
                return (T)this;
            }
        }
        throw new IllegalStateException();
    }

    final public T dumpHeap(String path, boolean live) {
         CallSpecification spec = specs.get("dumpHeap");
        if (spec != null) {
            if (spec.validate(getInvalidParams(), path, live)) {
                codeBuilder.append("dumpHeap(").append(format(path)).append(", ").
                            append(live).append(");\n");
                return (T)this;
            }
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
    
    abstract protected String[] getInvalidParams();
}
