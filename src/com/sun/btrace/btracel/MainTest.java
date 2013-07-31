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
package com.sun.btrace.btracel;

import com.sun.btrace.btracel.builder.BTraceScript;
import com.sun.btrace.btracel.builder.EntryHandler;
import com.sun.btrace.btracel.builder.ExceptionHandler;
import com.sun.btrace.btracel.builder.ExitHandler;
import com.sun.btrace.btracel.export.BTrace1JavaExporter;

/**
 *
 * @author Jaroslav Bachorik <jaroslav.bachorik@oracle.com>
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
