package com.sun.btrace.btracel.model;

import com.sun.btrace.btracel.model.Script;
import java.io.IOException;

public interface Exporter<T> {
    T export(Script script) throws IOException;
}
