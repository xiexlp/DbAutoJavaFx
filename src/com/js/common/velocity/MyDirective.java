package com.js.common.velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;

public class MyDirective {

    public static void main(String[] args) {
        VelocityContext context = new VelocityContext();
        VelocityEngine velocityEngine = new VelocityEngine();
        //String template = "hello, $name.split('_)";
        context.put("names","tiger_cat");
        StringWriter sw = new StringWriter();
        //合并文件
        velocityEngine.mergeTemplate("src/templates/stringexample.vm", "utf-8", context, sw);
        //合并字符串
        //velocityEngine.evaluate(context, sw, "log", template);
        System.out.println(sw.toString());
    }
}
