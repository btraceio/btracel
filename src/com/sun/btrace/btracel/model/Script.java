/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.btrace.btracel.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author jbachorik
 */
final public class Script {
    final private String name;
    final private Collection<MethodProbe> probes = new ArrayList<MethodProbe>();

    public Script(String name) {
        this.name = name;
    }

    public Script() {
        this("BTrace_" + System.currentTimeMillis());
    }

    public void addProbe(MethodProbe mp) {
        probes.add(mp);
    }

    public Iterable<MethodProbe> probes() {
        return Collections.unmodifiableCollection(probes);
    }

    public String getName() {
        return name;
    }

    public <T> T export(Exporter<T> exporter) throws IOException {
        return exporter.export(this);
    }
}
