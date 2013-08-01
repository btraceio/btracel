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
import java.util.List;
import java.util.regex.Pattern;

/**
 * A tracing point identified by class/method
 * @author Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
 */
public class MethodProbe {

    final private static Pattern clzFqn = Pattern.compile("[A-Za-z_][A-Za-z_0-9\\$]*(\\.[A-Za-z_][A-Za-z_0-9\\$]*)*");
    final private static Pattern simpleName = Pattern.compile("[A-Za-z_][A-Za-z_0-9\\$]*");

    private String clazz;
    private String method;
    private String retType = "", argTypes = "", type = "";
    final private List<Handler> handlers = new ArrayList<>();

    public MethodProbe() {
        this(".*", ".*");
    }

    public MethodProbe(String clazz) {
        this(clazz, ".*");
    }

    public MethodProbe(String clazz, String method) {
        this.clazz = clazz;
        if(!clzFqn.matcher(clazz).matches()) {
            this.clazz = "/" + (this.clazz.isEmpty() ? ".*" : this.clazz.replace("\\", "\\\\")) + "/";
        }
        int firstSpace = method.indexOf(' ');
        if (firstSpace > -1) {
            this.retType = method.substring(0, firstSpace);
            int par = method.indexOf('(');
            if (par > -1) {
                this.argTypes = method.substring(par, method.length());
                this.method = method.substring(firstSpace + 1, par);
                this.type = this.retType + this.argTypes;
            }
        }
        if (this.method == null) {
            this.method = method;
        }
        if (!simpleName.matcher(this.method).matches()) {
            this.method = "/" + (this.method.isEmpty() ? ".*" : this.method.replace("\\", "\\\\")) + "/";
        }
    }

    public String getClazz() {
        return clazz;
    }

    public String getMethod() {
        return method;
    }

    public String getType() {
        return type;
    }

    public String getRetType() {
        return retType;
    }

    public String getArgTypes() {
        return argTypes;
    }

    public List<Handler> getHandlers() {
        return handlers;
    }

    public void addHandler(String type, String body) {
        handlers.add(new Handler(this, type, body));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TraceDef{" + "clazz=" + clazz + ", method=" + method + ", type=" + type + '}' + '\n');
        for(Handler h : handlers) {
            sb.append(h.toString()).append('\n');
        }
        return sb.toString();
    }
}
