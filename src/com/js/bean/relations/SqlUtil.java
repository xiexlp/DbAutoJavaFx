package com.js.bean.relations;

import java.util.List;

public class SqlUtil {

   static int field_style=0;

    public static String getDropTableSql(TableWrapper tableWrapper){
        String tablename = tableWrapper.getTableName();
        StringBuffer dropSqlSb = new StringBuffer();
        dropSqlSb.append("drop table if exists ").append("`").append(tablename).append("`").append(";\n");
        return dropSqlSb.toString();
    }

    public static String getCreateSql(TableWrapper tableWrapper,String engine){
        String createSql = null;
        int keySize = tableWrapper.getKeyFieldWrapperList().size();
        if(keySize<=1){
            createSql = getCreateSqlSingleKey(tableWrapper,engine);
        }else if(keySize>1){
            createSql = getCreateSqlMultiplePrimaryKey(tableWrapper);
        }
        return createSql;
    }

    /**
     * 得到创建表格的语句
     * @param tableWrapper
     * @return
     */
    public static String getCreateSqlSingleKey(TableWrapper tableWrapper,String engine){
        String tablename = tableWrapper.getTableName();
        List<FieldWrapper> fieldWrapperList = tableWrapper.getFieldWrapperList();
        List<FieldWrapper> indexFieldWrapperList = tableWrapper.getIndexWrapperList();
        StringBuffer createSqlSb = new StringBuffer();

        createSqlSb.append("CREATE TABLE ").append("`").append(tablename).append("`").append("\n(\n");

        for(FieldWrapper fieldWrapper:fieldWrapperList){

            if(fieldWrapper.getFieldNameJava().equalsIgnoreCase("map")){
                System.out.println("map 跳过");
                continue;
            }

            String fieldname = fieldWrapper.getFieldNameSql();
            String fieldSqlType = fieldWrapper.getTypeSql();
            int len = fieldWrapper.getLen();
            int pointLen = fieldWrapper.getPointLen();
            boolean isPrimaryKey = fieldWrapper.isPrimaryKey();
            boolean autoIncrement = fieldWrapper.isAutoIncrement();
            System.out.println("name:"+fieldname+" primary:"+fieldWrapper.isPrimaryKey+" auto increment:"+fieldWrapper.isAutoIncrement());
            createSqlSb.append("  ").append("`");
            if(field_style==com.js.code.Config.FIELD_UNDERLINE) {
                String underline = StringTool.humpToUnderLine(fieldname);
                createSqlSb.append(underline);
            }else {
                createSqlSb.append(fieldname);
            }
            createSqlSb.append("`").append(" ").append(fieldSqlType);
            if(fieldSqlType.equalsIgnoreCase("varchar")){
                createSqlSb.append("(").append(len).append(")");
                createSqlSb.append(" not null ");
                createSqlSb.append(" default ''");
            }else if(fieldSqlType.equals("text")){
                //createSqlSb.append("(").append(1).append(")");
                createSqlSb.append(" not null ");
                //createSqlSb.append(" default ' '");
            }else if(fieldSqlType.equals("mediumtext")){
                //createSqlSb.append("(").append(1).append(")");
                createSqlSb.append(" not null");
                //createSqlSb.append(" default ' '");
            }
            else if(fieldSqlType.equals("int")){
                createSqlSb.append("(").append(10).append(")");
                if(isPrimaryKey){
                    createSqlSb.append("  PRIMARY KEY");
                }else {
                    createSqlSb.append(" not null ");
                    createSqlSb.append("  default 0");
                }
                if(autoIncrement){
                    createSqlSb.append(" AUTO_INCREMENT ");
                }
            }else if(fieldSqlType.equals("tinyint")){
                createSqlSb.append("(").append(1).append(")");
                createSqlSb.append(" not null");
                createSqlSb.append(" default 0");
            }else if(fieldSqlType.equals("bigint")){
                createSqlSb.append("(").append(20).append(")");
                if(isPrimaryKey){
                    createSqlSb.append(" PRIMARY KEY");
                }else {
                    createSqlSb.append(" default 0");
                }
                createSqlSb.append(" not null");
                if(autoIncrement){
                    createSqlSb.append(" auto_increment");
                }
            }else if(fieldSqlType.equals("float")){
                createSqlSb.append("(").append(10).append(")");
                createSqlSb.append(" not null");
                createSqlSb.append(" default 0");

            }else if(fieldSqlType.equals("double")){
                //double后面不能用长度一般是decimal类型，小数点前的是len,后面的是pointLen
                if(pointLen==0) pointLen=2;//默认给个2位
                createSqlSb.append("(").append(len).append(",").append(pointLen).append(")");
                createSqlSb.append(" not null");
                createSqlSb.append(" default 0");
            }
            createSqlSb.append(",");
            createSqlSb.append("\n");
            //createSqlSb.append("\\n");
        }
        createSqlSb = new StringBuffer(createSqlSb.substring(0,createSqlSb.length()-2));
        int indexSize = indexFieldWrapperList.size();
        if(indexSize>0){
            String indexCreateSql = indexCreateSQLInner(tableWrapper);
            createSqlSb.append(",\n").append(indexCreateSql);
            createSqlSb = new StringBuffer(createSqlSb.substring(0,createSqlSb.length()-2));
        }else {

        }

        createSqlSb.append("\n");
        createSqlSb.append(")");
        //createSqlSb.append("ENGINE=INNODB DEFAULT CHARSET=utf8");
        createSqlSb.append("ENGINE=").append(engine).append(" DEFAULT CHARSET=").append(com.js.code.Config.UTF8);


        return createSqlSb.toString();
    }


    public static String indexCreateSQLInner(TableWrapper tableWrapper){
        List<FieldWrapper> indexFieldWrapperList = tableWrapper.getIndexWrapperList();
        String tablename = tableWrapper.getTableName();
        StringBuffer indexSqlSb=new StringBuffer();
        for(FieldWrapper fieldWrapper:indexFieldWrapperList){
            if(fieldWrapper.indexUnique) {
                indexSqlSb.append(" unique index ");
            }else {
                indexSqlSb.append("  index ");
            }
            indexSqlSb.append(fieldWrapper.getFieldNameSql()).append("_index").append(" ").append("(").append(fieldWrapper.getFieldNameSql()).append("),\n");
        }
        return indexSqlSb.toString();
    }

    public static String indexCreateSQL(TableWrapper tableWrapper){
        List<FieldWrapper> indexFieldWrapperList = tableWrapper.getIndexWrapperList();
        String tablename = tableWrapper.getTableName();
        StringBuffer indexSqlSb=new StringBuffer();
        for(FieldWrapper fieldWrapper:indexFieldWrapperList){
            if(fieldWrapper.indexUnique) {
                indexSqlSb.append(" create unique index ");
            }else {
                indexSqlSb.append(" create index ");
            }
            indexSqlSb.append(fieldWrapper.getFieldNameSql()).append("_index").append(" ").append(" on ")
                    .append(tablename).append("(").append(fieldWrapper.getFieldNameSql()).append(");\n");
        }
        return indexSqlSb.toString();
    }

    public static String indexCreateSQLByFieldWrapper(TableWrapper tableWrapper,FieldWrapper fieldWrapper){
        List<FieldWrapper> indexFieldWrapperList = tableWrapper.getIndexWrapperList();
        String tablename = tableWrapper.getTableName();
        StringBuffer indexSqlSb=new StringBuffer();
        //这是一个FieldWrapper的index创建
            if(fieldWrapper.indexUnique) {
                indexSqlSb.append(" \n create unique index ");
            }else {
                indexSqlSb.append(" \n create index ");
            }
            indexSqlSb.append(fieldWrapper.getFieldNameSql()).append("_index").append(" ").append(" on ")
                    .append(tablename).append("(").append(fieldWrapper.getFieldNameSql()).append(");\n");
        return indexSqlSb.toString();
    }


    /**
     * 得到创建表格的语句
     * @param tableWrapper
     * @return
     */
    public static String getCreateSqlMultiplePrimaryKey(TableWrapper tableWrapper){
        String tablename = tableWrapper.getTableName();
        List<FieldWrapper> fieldWrapperList = tableWrapper.getFieldWrapperList();
        StringBuffer createSqlSb = new StringBuffer();

        createSqlSb.append("CREATE TABLE ").append("`").append(tablename).append("`").append("\n(\n");

        for(FieldWrapper fieldWrapper:fieldWrapperList){
            String fieldname = fieldWrapper.getFieldNameSql();
            String fieldSqlType = fieldWrapper.getTypeSql();
            int len = fieldWrapper.getLen();
            boolean isPrimaryKey = fieldWrapper.isPrimaryKey();
            boolean autoIncrement = fieldWrapper.isAutoIncrement();
            System.out.println("name:"+fieldname+" primary:"+fieldWrapper.isPrimaryKey+" auto increment:"+fieldWrapper.isAutoIncrement());
            createSqlSb.append("  ").append("`");
            if(field_style==com.js.code.Config.FIELD_UNDERLINE) {
                String underline = StringTool.humpToUnderLine(fieldname);
                createSqlSb.append(underline);
            }else {
                createSqlSb.append(fieldname);
            }
            createSqlSb.append("`").append(" ").append(fieldSqlType);
            if(fieldSqlType.equalsIgnoreCase("varchar")||fieldSqlType.equals("text")){
                createSqlSb.append("(").append(len).append(")");
                createSqlSb.append(" not null ");
                createSqlSb.append(" default ''");
            }else if(fieldSqlType.equals("int")){
                createSqlSb.append("(").append(10).append(")");
                if(isPrimaryKey){
                    //createSqlSb.append("  PRIMARY KEY");
                }else {
                    createSqlSb.append("  default 0");
                }
                createSqlSb.append(" not null");
                createSqlSb.append("  default 0");
                if(autoIncrement){
                    createSqlSb.append(" AUTO_INCREMENT");
                }

            }else if(fieldSqlType.equals("tinyint")){
                createSqlSb.append("(").append(1).append(")");
                createSqlSb.append(" not null");
                createSqlSb.append(" default 0");
            }else if(fieldSqlType.equals("bigint")){
                createSqlSb.append("(").append(20).append(")");
                if(isPrimaryKey){
                    //createSqlSb.append(" PRIMARY KEY");
                }else {
                    createSqlSb.append(" default 0");
                }
                createSqlSb.append(" not null");
                if(autoIncrement){
                    createSqlSb.append(" auto_increment");
                }
            }else if(fieldSqlType.equals("float")){
                createSqlSb.append("(").append(10).append(")");
                createSqlSb.append(" not null");
                createSqlSb.append(" default 0");
            }else if(fieldSqlType.equals("double")){
                //double后面不能用长度
                //createSqlSb.append("(").append(20).append(")");
                createSqlSb.append(" not null");
                createSqlSb.append(" default 0");
            }
            createSqlSb.append(",");
            createSqlSb.append("\n");
            //createSqlSb.append("\\n");
        }

        //这部分增加primarykey内容
        createSqlSb.append("primary key ");
        List<FieldWrapper> keyFieldWrapperList = tableWrapper.getKeyFieldWrapperList();
        createSqlSb.append(" (");
        for(FieldWrapper fieldWrapper:keyFieldWrapperList){
            createSqlSb.append(fieldWrapper.getFieldSqlUnderLine());
            createSqlSb.append(",");
        }
        createSqlSb.append("\n");
        createSqlSb = new StringBuffer(createSqlSb.substring(0,createSqlSb.length()-2));
        createSqlSb.append(")\n)");

        //createSqlSb = new StringBuffer(createSqlSb.substring(0,createSqlSb.length()-2));
        //createSqlSb.append("\n");
        //createSqlSb.append(")");
        //createSqlSb.append("ENGINE=INNODB DEFAULT CHARSET=utf8");
        createSqlSb.append("ENGINE=").append(com.js.code.Config.INNODB).append(" DEFAULT CHARSET=").append(com.js.code.Config.UTF8);


        int indexSize = tableWrapper.getIndexWrapperList().size();
        if(indexSize>0){
            String indexCreateSQL = indexCreateSQL(tableWrapper);
            createSqlSb.append(";").append(indexCreateSQL);
        }


        return createSqlSb.toString();
    }


}
