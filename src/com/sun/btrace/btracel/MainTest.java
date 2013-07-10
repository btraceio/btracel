/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel;

import com.sun.btrace.btracel.builder.BTraceScript;
import com.sun.btrace.btracel.builder.EntryHandler;
import com.sun.btrace.btracel.builder.ExceptionHandler;
import com.sun.btrace.btracel.builder.ExitHandler;
import com.sun.btrace.btracel.export.BTrace1JavaExporter;

/**
 *
 * @author jbachorik
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        String x = new BTraceScript().
            onMethod("com\\.toy\\..*", "int getWord(java.lang.String a, int b)").
                onEntry(new EntryHandler().
                    println("hello dolly from @pcn#@pmn (@a, @b)").
                    println(": value = @self.myvar")
                ).
                onExit(new ExitHandler().
                    print("Just do it \"- ").
                    println("--- NIKE ---").
                    println("got @return").
                    dumpHeap("/tmp/mydump_@freeMemory()\\.hprof")
                ).
            onMethod("+java.util.List").
                onException(new ExceptionHandler().
                    println("Got exception @exception").
                    dumpHeap("/tmp/dadump.bin", true)
                )
        .getModel().export(new BTrace1JavaExporter());

        System.err.println(x);
    }
}
