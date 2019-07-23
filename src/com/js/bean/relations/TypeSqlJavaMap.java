package com.js.bean.relations;

import java.util.HashMap;
import java.util.Map;

public class TypeSqlJavaMap {

    public static Map javaMap =new HashMap();
    //public static Map fieldValueMap = new HashMap();

    static {
        init();
    }

    private static void init(){
        javaMap.put("int", "int");
        javaMap.put("varchar","String");
        javaMap.put("char", "String");
        javaMap.put("smallint","int");
        javaMap.put("longtext","String");
        javaMap.put("text","String");
        javaMap.put("datetime", "Timestamp");
        javaMap.put("timestamp","Timestamp");
        javaMap.put("double","double");
        javaMap.put("tinyint","int");
        javaMap.put("mediumint","int");
        javaMap.put("bigint", "long");
        javaMap.put("tinytext","String");
        javaMap.put("decimal", "double");
        javaMap.put("enum","String");
    }
}
