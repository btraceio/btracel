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
package com.sun.btrace.btracel.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Handler {
    private static final Pattern argRef = Pattern.compile("@([a-zA-Z][a-zA-Z0-9_]*)");
    private static final Map<String, Argument> knownArguments = new HashMap<String, Argument>() {
        {
            put("pmn", new Argument("@ProbeMethodName", "java.lang.String", "pmn"));
            put("pcn", new Argument("@ProbeClassName", "java.lang.String", "pcn"));
            put("self", new Argument("@Self", "java.lang.Object", "self"));
            put("caught", new Argument("java.lang.Throwable", "caught"));
            put("duration", new Argument("@Duration", "long", "dur"));
        }
    };
    private HandlerType type;
    private String body;
    private final List<Argument> args = new ArrayList<>();

    public Handler(final MethodProbe def, String type, String body) {
        this.type = HandlerType.of(type);
        this.body = body;
        Map<String, Argument> inferredArgs = new HashMap<String, Argument>() {
            {
                if (def.getRetType() != null && !def.getRetType().isEmpty()) {
                    Argument arg = new Argument("@Return", def.getRetType(), "ret");
                    put("return", arg);
                }
                if (def.getArgTypes() != null) {
                    StringTokenizer st = new StringTokenizer(def.getArgTypes().replace("(", "").replace(")", ""), ",");
                    while (st.hasMoreTokens()) {
                        String annotation = "";
                        String type = "";
                        String name = "";
                        String argDef = st.nextToken();
                        StringTokenizer st1 = new StringTokenizer(argDef, " ");
                        if (st1.countTokens() == 3) {
                            annotation = st1.nextToken();
                        }
                        if (st1.countTokens() == 2) {
                            type = st1.nextToken();
                            name = st1.nextToken();
                        }
                        Argument arg = new Argument(annotation, type, name);
                        put(name, arg);
                        args.add(arg);
                    }
                }
            }
        };
        Map<String, Argument> replacements = new HashMap<>();
        Matcher m = argRef.matcher(body);
        while (m.find()) {
            String argName = m.group(1);
            if (argName != null) {
                Argument arg = knownArguments.get(argName);
                if (arg == null) {
                    arg = inferredArgs.get(argName);
                }
                if (arg != null) {
                    replacements.put("@" + argName, arg);
                    if (!args.contains(arg)) {
                        args.add(arg);
                    }
                }
            }
        }
        for (Map.Entry<String, Argument> e : replacements.entrySet()) {
            this.body = this.body.replace(e.getKey(), e.getValue().getName());
        }
    }

    @Override
    public String toString() {
        return "Handler{" + "type=" + type + ", body=" + body + '}';
    }

    public HandlerType getType() {
        return type;
    }

    public String getBody() {
        return body;
    }

    public List<Argument> getArgs() {
        return args;
    }

}
