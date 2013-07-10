package com.sun.btrace.btracel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MethodProbe {

    final private static Pattern clzFqn = Pattern.compile("[A-Za-z_][A-Za-z_0-9\\$]*(\\.[A-Za-z_][A-Za-z_0-9\\$]*)*");
    final private static Pattern simpleName = Pattern.compile("[A-Za-z_][A-Za-z_0-9\\$]*");

    private String clazz;
    private String method;
    private String retType = "", argTypes = "", type = "";
    final private List<Handler> handlers = new ArrayList<Handler>();

    public static MethodProbe fromString(String def) {
        String p = def.replace("\\:", "#"); // replace the colons with hash to be regex friendly

        int pos = 0;
        String clz = "", method = "";
        StringTokenizer st = new StringTokenizer(p.replace("::", " : : "), ":");
        if (st.hasMoreTokens()) {
            clz = st.nextToken().trim();
            pos += clz.length();
        }
        pos++;
        if (st.hasMoreTokens()) {
            method = st.nextToken().trim();
            pos += method.length();
        }
        pos++;

        MethodProbe td = new MethodProbe(clz.replace("#", "\\:"), method.replace("#", "\\:"));
        int blockDepth = 0;
        StringBuilder type = new StringBuilder();
        StringBuilder body = new StringBuilder();

        while(pos < def.length()) {
            char c = def.charAt(pos++);
            if (c != '{') {
                if (c != '}') {
                    if (blockDepth > 0) {
                        body.append(c);
                    } else {
                        if (c != ',' && c != ' ') {
                            type.append(c);
                        }
                    }
                } else {
                    if (--blockDepth == 0) {
                        td.addHandler(type.toString(), body.toString());
                        type = new StringBuilder();
                        body = new StringBuilder();
                    } else {
                        body.append(c);
                    }
                }
            } else {
                if (blockDepth++ > 0) {
                    body.append(c);
                }
            }
        }
        return td;
    }

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
