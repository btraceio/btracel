/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel;

import com.sun.btrace.client.Main;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author jbachorik
 */
public class MainShort {
public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(MainShort.class, "");
        Template t = cfg.getTemplate("onmethod.ftl");

        String s = parseDef(args[1], t);

        Path f = java.nio.file.FileSystems.getDefault().getPath("/tmp/BTraceScript.java");
        Files.write(f, s.getBytes("utf-8"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        Main.main(new String[]{args[0], "/tmp/BTraceScript.java"});

//        String[] test = new String[]{
//            "com\\.toy\\.*:getWord:entry{println(\"Entering getWord()\")}",
//            "java.util.ArrayList:int size():entry{println(\"Huhahah\")},exit{println(\"buhahah \" + @return);}",
//            "java.util.ArrayList:boolean re.*All(java.util.Collection x):entry{println(@pmn);printCollection(@x);}",
//            "::error{println(@pcn + \" \" + @pmn + \" :\");printException(@caught);}"
//        };
    }

    private static int cntr = 0;

    private static String parseDef(String def, Template t) throws Exception {
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

        TraceDef td = new TraceDef(clz.replace("#", "\\:"), method.replace("#", "\\:"));
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

        Map<String, Object> params = new HashMap<>();
        params.put("td", td);
        params.put("probeName", String.valueOf(cntr++));

        StringWriter sw = new StringWriter();
        t.process(params, sw);
        return sw.toString();
    }
}
