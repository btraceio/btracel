package com.sun.btrace.btracel.builder;

final public class ExceptionHandler extends AbstractHandlerBuilder<ExceptionHandler> {

    @Override
    protected boolean validate(String call, Object... args) {
        switch (call) {
            case "print":
            case "println": {
                if (args.length == 1) {;
                    if (args[0] instanceof String) {
                        return checkRefs((String) args[0]);
                    }
                }
            }
            case "dumpHeap": {
                if (args.length == 1) {
                    if (args[0] instanceof String) {
                        return checkRefs((String)args[0]);
                    }
                } else if (args.length == 2) {
                    if (args[0] instanceof String && args[1] instanceof Boolean) {
                        return checkRefs((String)args[0]);
                    }
                }
                return false;
            }
            default:
                return false;
        }
    }

    private static boolean checkRefs(String sArg) {
        if (sArg.contains("@return") ||
            sArg.contains("@duration")) {
            return false;
        }
        return true;
    }
}
