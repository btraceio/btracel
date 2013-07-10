package com.sun.btrace.btracel.model;

public enum HandlerType {
    ENTRY, RETURN, ERROR;

    public static HandlerType of(String s) {
        switch (s) {
            case "return":
            case "exit":
                {
                    return RETURN;
                }
            case "error":
            case "exception":
                {
                    return ERROR;
                }
            default:
                {
                    return ENTRY;
                }
        }
    }

}
