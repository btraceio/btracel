package com.sun.btrace.btracel.model;

public final class Argument {
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
