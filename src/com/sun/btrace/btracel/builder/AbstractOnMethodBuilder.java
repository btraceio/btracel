package com.sun.btrace.btracel.builder;

import com.sun.btrace.btracel.model.MethodProbe;

abstract public class AbstractOnMethodBuilder {
    private BTraceScript script;
    private MethodProbe mp;

    public AbstractOnMethodBuilder(MethodProbe td, BTraceScript script) {
        this.script = script;
        this.mp = td;
    }

    final protected BTraceScript getScript() {
        return script;
    }

    final protected MethodProbe getMethodProbe() {
        return mp;
    }
}
