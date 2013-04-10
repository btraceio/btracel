import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace public class BTraceScript {
<#assign tdtype=td.getType()!""/>
<#list td.handlers as h>
    @OnMethod(clazz="${td.clazz}", method="${td.method}", location=@Location(Kind.${h.type?upper_case})<#if tdtype?length &gt; 0>, type="${tdtype}</#if>)
    public static void OnMethod_${probeName}_${h.type}(<#list h.args as arg>${arg.annotation} ${arg.type} ${arg.name}<#if arg_has_next>,</#if></#list>) {
        ${h.body}
    }
</#list>
}
