/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jbachorik
 */
public class TraceDef {
    public static enum HandlerType {
        ENTRY, RETURN, ERROR;

        public static TraceDef.HandlerType of(String s) {
            switch (s) {
                case "return":
                case "exit": {
                    return RETURN;
                }
                case "error":
                case "exception": {
                    return ERROR;
                }
                default: {
                    return ENTRY;
                }
            }
        }
    }
    
    final public static class Argument {
        private String annotation;
        private String type;
        private String name;

        public Argument(String annotation, String type, String name) {
            this.annotation = annotation;
            this.type = type;
            this.name = name;
        }

        public Argument(String type, String name) {
            this("", type, name);
        }

        public String getAnnotation() {
            return annotation;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    final public static class Handler {
        final private static Pattern argRef = Pattern.compile("@([a-zA-Z][a-zA-Z0-9_]*)");
        final private static Map<String, Argument> knownArguments = new HashMap<String, Argument>() {
            {
                put("pmn", new Argument("@ProbeMethodName", "java.lang.String", "pmn"));
                put("pcn", new Argument("@ProbeClassName", "java.lang.String", "pcn"));
                put("self", new Argument("@Self", "java.lang.Object", "self"));
                put("caught", new Argument("java.lang.Throwable", "caught"));
            }
        };

        private HandlerType type;
        private String body;
        final private List<Argument> args = new ArrayList<>();

        public Handler(final TraceDef def, String type, String body) {
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
                            String annotation = "", type = "", name = "";
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
            for(Map.Entry<String, Argument> e : replacements.entrySet()) {
                this.body = this.body.replace(e.getKey(), e.getValue().getName());
            }
        }

        @Override
        public String toString() {
            return "Handler{" + "type=" + type + ", body=" + body + '}';
        }

        public String getType() {
            return type.name();
        }

        public String getBody() {
            return body;
        }

        public List<Argument> getArgs() {
            return args;
        }
    }

    final private static Pattern clzFqn = Pattern.compile("[A-Za-z_][A-Za-z_0-9\\$]*(\\.[A-Za-z_][A-Za-z_0-9\\$]*)*");
    final private static Pattern simpleName = Pattern.compile("[A-Za-z_][A-Za-z_0-9\\$]*");

    private String clazz;
    private String method;
    private String retType = "", argTypes = "", type = "";
    final private List<Handler> handlers = new ArrayList<>();

    public TraceDef() {
        this(".*", ".*");
    }

    public TraceDef(String clazz) {
        this(clazz, "/.*/");
    }

    public TraceDef(String clazz, String method) {
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
