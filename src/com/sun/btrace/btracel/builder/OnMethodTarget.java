package com.sun.btrace.btracel.builder;

public interface OnMethodTarget {
    OnMethodBuilder.Base onMethod(String clz, String method);
    OnMethodBuilder.Base onMethod(String clz);
}
