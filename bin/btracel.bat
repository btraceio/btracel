@echo off

if "%2"=="" goto usage
goto ok
:usage
    echo Attaching>
    echo "\tPID: %1"
    echo "\tHND: %2"
goto end

ok:

rem %~dp0 is expanded pathname of the current script under NT
set DEFAULT_BTRACE_HOME=%~dp0..

if "%BTRACE_HOME%"=="" set BTRACE_HOME=%DEFAULT_BTRACE_HOME%
set DEFAULT_BTRACE_HOME=

if not exist "%BTRACE_HOME%\build\btrace-client.jar" goto noBTraceHome

if "%JAVA_HOME%" == "" goto noJavaHome
  "%JAVA_HOME%/bin/java" -Dcom.sun.btrace.probeDescPath=. -Dcom.sun.btrace.dumpClasses=false -Dcom.sun.btrace.debug=false -Dcom.sun.btrace.unsafe=false -cp "%BTRACE_HOME%/build/btrace-client.jar;%JAVA_HOME%/lib/tools.jar;../lib/btracel.jar;../lib/freemarker-2.3.14.jar" com.sun.btrace.client.Main %1 "%2"
  goto end
:noJavaHome
  echo Please set JAVA_HOME before running this script
  goto end
:noBTraceHome
  echo Please set BTRACE_HOME before running this script
:end
