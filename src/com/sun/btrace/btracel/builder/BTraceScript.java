package com.sun.btrace.btracel.builder;

import com.sun.btrace.btracel.model.MethodProbe;
import com.sun.btrace.btracel.model.Script;

public class BTraceScript implements OnMethodTarget, ModelProvider {
    final private Script script = new Script();

    @Override
    public OnMethodBuilder.Base onMethod(String clz, String method) {
        return onMethod(new MethodProbe(clz, method));
    }

    @Override
    public OnMethodBuilder.Base onMethod(String clz) {
        return onMethod(new MethodProbe(clz));
    }

    private OnMethodBuilder.Base onMethod(MethodProbe mp) {
        registerTraceDef(mp);
        return new OnMethodBuilder.Base(mp, this);
    }

    void registerTraceDef(MethodProbe mp) {
        script.addProbe(mp);
    }

    @Override
    public Script getModel() {
        return script;
    }
}
