package com.sun.btrace.btracel.builder;

import com.sun.btrace.btracel.model.MethodProbe;
import com.sun.btrace.btracel.model.Script;

public class OnMethodBuilder extends AbstractOnMethodBuilder implements OnMethodTarget, ModelProvider {
    public static class _0 extends AbstractOnMethodBuilder {
        public _0(MethodProbe td, BTraceScript script) {
            super(td, script);
        }

        final public _1 onEntry(EntryHandler h) {
            getMethodProbe().addHandler("entry", h.getCode());
            return new _1(this);
        }

        final public _2 onExit(ExitHandler h) {
            getMethodProbe().addHandler("exit", h.getCode());
            return new _2(this);
        }

        final public _4 onException(ExceptionHandler h) {
            getMethodProbe().addHandler("exception", h.getCode());
            return new _4(this);
        }
    }

    public static class Base extends _0 {
        public Base(MethodProbe td, BTraceScript script) {
            super(td, script);
        }

        public _0 followedBy(String clz, String method) {
            return this;
        }

        public _0 followedBy(String clz) {
            return this;
        }
    }

    public static class _1 extends OnMethodBuilder {
        public _1(AbstractOnMethodBuilder b) {
            super(b.getMethodProbe(), b.getScript());
        }

        final public _3 onExit(ExitHandler h) {
            getMethodProbe().addHandler("exit", h.getCode());
            return new _3(this);
        }

        final public _5 onException(ExceptionHandler h) {
            getMethodProbe().addHandler("exception", h.getCode());
            return new _5(this);
        }
    }

    public static class _2 extends OnMethodBuilder {
        public _2(AbstractOnMethodBuilder b) {
            super(b.getMethodProbe(), b.getScript());
        }

        final public _3 onEntry(EntryHandler h) {
            getMethodProbe().addHandler("exit", h.getCode());
            return new _3(this);
        }

        final public _6 onException(ExceptionHandler h) {
            getMethodProbe().addHandler("exception", h.getCode());
            return new _6(this);
        }
    }

    public static class _3 extends OnMethodBuilder {
        public _3(AbstractOnMethodBuilder b) {
            super(b.getMethodProbe(), b.getScript());
        }

        final public _7 onException(ExceptionHandler h) {
            getMethodProbe().addHandler("exception", h.getCode());
            return new _7(this);
        }
    }

    public static class _4 extends OnMethodBuilder {
        public _4(AbstractOnMethodBuilder b) {
            super(b.getMethodProbe(), b.getScript());
        }

        final public _5 onEntry(EntryHandler h) {
            getMethodProbe().addHandler("entry", h.getCode());
            return new _5(this);
        }

        final public _6 onExit(ExitHandler h) {
            getMethodProbe().addHandler("exit", h.getCode());
            return new _6(this);
        }
    }

    public static class _5 extends OnMethodBuilder {
        public _5(AbstractOnMethodBuilder b) {
            super(b.getMethodProbe(), b.getScript());
        }

        final public _7 onExit(ExitHandler h) {
            getMethodProbe().addHandler("exit", h.getCode());
            return new _7(this);
        }
    }

    public static class _6 extends OnMethodBuilder {
        public _6(AbstractOnMethodBuilder b) {
            super(b.getMethodProbe(), b.getScript());
        }

        final public _7 onEntry(EntryHandler h) {
            getMethodProbe().addHandler("entry", h.getCode());
            return new _7(this);
        }
    }

    public static class _7 extends OnMethodBuilder {
        public _7(AbstractOnMethodBuilder b) {
            super(b.getMethodProbe(), b.getScript());
        }
    }

    public OnMethodBuilder(MethodProbe td, BTraceScript script) {
        super(td, script);
    }

    @Override
    final public Base onMethod(String clz, String method) {
        return getScript().onMethod(clz, method);
    }

    @Override
    final public Base onMethod(String clz) {
        return getScript().onMethod(clz);
    }

    @Override
    public Script getModel() {
        return getScript().getModel();
    }
}
