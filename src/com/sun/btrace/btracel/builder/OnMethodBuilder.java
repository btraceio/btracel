
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
package com.sun.btrace.btracel.builder;

import com.sun.btrace.btracel.model.MethodProbe;
import com.sun.btrace.btracel.model.Script;

public class OnMethodBuilder extends AbstractOnMethodBuilder implements OnMethodTarget, ModelProvider {
    public static class _0 extends AbstractOnMethodBuilder {
        public _0(MethodProbe td, BTraceScript script) {
            super(td, script);
        }

        final public _1 onEntry(EntryHandlerBuilder h) {
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

        final public _3 onEntry(EntryHandlerBuilder h) {
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

        final public _5 onEntry(EntryHandlerBuilder h) {
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

        final public _7 onEntry(EntryHandlerBuilder h) {
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
