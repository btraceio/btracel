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
package com.sun.btrace.btracel.export;

import com.sun.btrace.btracel.model.Argument;
import com.sun.btrace.btracel.model.Exporter;
import com.sun.btrace.btracel.model.Handler;
import static com.sun.btrace.btracel.model.HandlerType.ENTRY;
import static com.sun.btrace.btracel.model.HandlerType.ERROR;
import static com.sun.btrace.btracel.model.HandlerType.RETURN;
import com.sun.btrace.btracel.model.MethodProbe;
import com.sun.btrace.btracel.model.Script;
import java.io.IOException;

/**
 *
 * @author Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
 */
public class BTrace1JavaExporter implements Exporter<String> {
    @Override
    public String export(Script script) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("import com.sun.btrace.annotations.*;\n");
        sb.append("import static com.sun.btrace.BTraceUtils.*;\n");
        sb.append("@BTrace public class ").append(script.getName()).append(" {\n");
        int counter = 0;
        for (MethodProbe mp : script.probes()) {
            for (Handler h : mp.getHandlers()) {
                String location = null;
                switch (h.getType()) {
                    case RETURN: {
                        location = "Kind.RETURN";
                        break;
                    }
                    case ERROR: {
                        location = "Kind.ERROR";
                        break;
                    }
                    case ENTRY:
                    default: {
                        location = "Kind.ENTRY";
                    }
                }
                sb.append("@OnMethod(clazz=\"").append(mp.getClazz()).append("\",").
                        append("method=\"").append(mp.getMethod()).append("\",");
                if (!mp.getType().isEmpty()) {
                    sb.append("type=\"").append(mp.getType()).append("\",");
                }
                sb.append("location=@Location(").append(location).append("))\n");
                sb.append("public static void On").
                        append(h.getType().name()).
                        append(counter).
                        append("(");
                int argCounter = 0;
                for (Argument arg : h.getArgs()) {
                    if (argCounter++ > 0) {
                        sb.append(", ");
                    }
                    sb.append(arg.getAnnotation());
                    if (!arg.getAnnotation().isEmpty()) {
                        sb.append(" ");
                    }
                    sb.append(arg.getType());
                    if (!arg.getType().isEmpty()) {
                        sb.append(" ");
                    }
                    sb.append(arg.getName());
                }
                sb.append(") {\n");
                sb.append(h.getBody());
                sb.append("}\n");
            }
            counter++;
        }
        sb.append("\n}\n");
        return sb.toString();
    }
}
