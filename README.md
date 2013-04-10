btracel
=======

Simple tool allowing to write BTrace oneliners similar to the ones in DTrace

While BTrace scripts are rather powerful writing them is a tedious process because they are in fact complete java classes. This tool adds the possibility to use "oneliner" syntax to specify what and how should be traced. The syntax resembles DTrace a bit and is designed to be concise and easy to use even if not that powerful.

This project uses freemarker templates to convert the oneliners to the full-fledged BTrace scripts which can be submitted to the standard BTrace infrastructure.

### Oneliner

A oneliner has the following form:

&lt;class definition&gt;:&lt;method definition&gt;:[entry,exit,exception]{&lt;code&gt;}(,[entry,exit,exception]{&lt;code&gt;})*

The three main parts of the oneliner are separated by colon ":".

**&lt;class definition&gt;: Either a full class name or regex matching class names**
* java.util.ArrayList
* java\\.util\\..*

**&lt;method definition&gt;: Either a full method name or regex matching the method names. The method definition can contain full signature definition.**
* size
* .*All
* int calculate(int a, int b)

**handlers: Valid handlers are "entry", "exit" and "error". The handler code may contain calls to any valid BTrace methods (eg. println(), jstack() etc.)**
* entry: Matches a method entry; before any other code is executed
* exit: Matches any successful method return (eg. no uncaught exception)
* error: Matches method return upon uncaught exception

### Parameters
The handler code can reference various parameters. They are either built in parameters (eg. @pmn, @self) or the ones inferred from the method signature, if provided.

#### Built-in parameters
* @pcn: Probe Class Name; the name of the class currently probed
* @pmn: Probe Method Name; the name of the method currently probed
* @self: java.lang.Object reference to **this** valid at the time of probing
* @return: A value returned by the probed method; valid only for **exit** handlers
* @caught: A java.lang.Throwable that has caused the probed method to terminate; valid only for **error** handlers

#### Inferred parameters
The parameters may be inferred from the method signature if provider. They represent the arguments passed to the probed method. The method signature must specify the argument names which will be then used in the handler code.

**Example**
java.util.ArrayList:java.lang.Object get(int arrIndex):entry {println(str(@arrIndex));}

This will print the value of the int argument passed to each invocation of *java.util.ArrayList.get()* method.


### Installation
After checking out and building the project you can find the distribution directory in **{basedir}/dist/ext**. While you can use the command **bin/btracel** directly from that location a more convenient would be copying the contents of **{basedir}/dist/ext** over to the directory where your **BTrace** installation resides.

### Warning
This is just a proof-of-concept project. It might not be complete and the syntax may be changed in future.
