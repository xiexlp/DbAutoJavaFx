package com.js.bean.relations;

import java.util.HashMap;
import java.util.Map;

public class TypeJavaSqlMap {

    public static Map  javaToSqlMap =new HashMap();
    //public static Map fieldValueMap = new HashMap();

    static {
        init();
    }

    private static void init(){
        javaToSqlMap.put("int", "int");
        javaToSqlMap.put("String","varchar");
        javaToSqlMap.put("char", "String");
        javaToSqlMap.put("smallint","int");
        javaToSqlMap.put("longtext","String");
        javaToSqlMap.put("text","String");
        javaToSqlMap.put("datetime", "Timestamp");
        javaToSqlMap.put("timestamp","Timestamp");
        javaToSqlMap.put("double","double");
        javaToSqlMap.put("tinyint","int");
        javaToSqlMap.put("mediumint","int");
        javaToSqlMap.put("bigint", "long");
        javaToSqlMap.put("tinytext","String");
        javaToSqlMap.put("decimal", "double");
        javaToSqlMap.put("enum","String");
    }

}
