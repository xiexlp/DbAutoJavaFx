/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.dbauto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class DbCodeUtil {
    /***
     * 数据库类型和java类型对照map
     */
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
        javaMap.put("mediumtext","String");
        javaMap.put("text","String");
        javaMap.put("datetime", "Timestamp");
        javaMap.put("date", "Date");
        javaMap.put("timestamp","Timestamp");
        javaMap.put("double","double");
        javaMap.put("tinyint","int");
        javaMap.put("mediumint","int");
        javaMap.put("bigint", "long");
        javaMap.put("tinytext","String");
        javaMap.put("decimal", "double");
        javaMap.put("enum","String");
        javaMap.put("float","double");
    }
    
    /***
     * 得到增加SQL
     * @param bTableWrapper
     * @return 
     */
    public static String getInsertSQL(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        String names = getFieldnameList(list);
        String questionSymbols = getQuestionSymbols(list);
        String insert_sql = "insert "+bTableWrapper.getTablename()+ "("+names+")"+" values("+questionSymbols+")";
        return insert_sql;
    }
    
    public static String getInsertAutoIDSQL(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        //如果没有非主键的话就直接退出
        if(bTableWrapper.getNoKeySize()<1) return "";
        String names = getFieldnameNOKeyidList(list);
        String questionSymbols = getQuestionSymbolsNoKey(bTableWrapper);
        String insert_sql = "insert "+bTableWrapper.getTablename()+ "("+names+")"+" values("+questionSymbols+")";
        return insert_sql;
    }
    
    public static String getKeyArguments(BTableWrapper bTableWrapper){
        List<BFieldWrapper> keyFieldWrapperList = bTableWrapper.getbKeyFieldWrapperList();
        System.out.println("key field wrapper list:"+keyFieldWrapperList.size());
        String key_arg="";
        for(BFieldWrapper keyWrapper:keyFieldWrapperList){
            key_arg+= keyWrapper.getJavatype();
            key_arg+=" "+keyWrapper.getFieldname();
            key_arg+=",";
        }
        System.out.println("key arg:----:"+key_arg);
        key_arg=key_arg.substring(0, key_arg.length()-1);
        return  key_arg;
    }
    
    public static String getKeyArgumentsNoType(BTableWrapper bTableWrapper){
        List<BFieldWrapper> keyFieldWrapperList = bTableWrapper.getbKeyFieldWrapperList();
        String key_arg="";
        for(BFieldWrapper keyWrapper:keyFieldWrapperList){
            //key_arg+= keyWrapper.getJavatype();
            key_arg+=keyWrapper.getFieldname();
            key_arg+=",";
        }
        key_arg=key_arg.substring(0, key_arg.length()-1);
        return  key_arg;
    }
    
    /***
     * 得到删除SQL
     * @param bTableWrapper
     * @return 
     */
    public static String getDelSQl(BTableWrapper bTableWrapper){
        //String del_sql = "delete from "+bTableWrapper.getTablename()+" where "+bTableWrapper.getKeyname()+" =?";
        
        String del_sql = "delete from "+bTableWrapper.getTablename();
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();
        del_sql+=getKeySelectCondition(keyList);
        return del_sql;
    }
    
    
    public static String getKeySelectCondition( List<BFieldWrapper> keyList){
        int size = keyList.size();
        System.out.println("key list size:"+size);
        String selectParam = " where ";
        for(BFieldWrapper keyFieldWrapper:keyList){
                selectParam += keyFieldWrapper.getTableFieldName()+"=? and ";
        }
        selectParam = selectParam.substring(0, selectParam.length()-4);
        return  selectParam;
    }

    public static String getSelectCondition( List<BFieldWrapper> selectList){
        int size = selectList.size();
        System.out.println("key list size:"+size);
        String selectParam = " where ";
        for(BFieldWrapper keyFieldWrapper:selectList){
            selectParam += keyFieldWrapper.getTableFieldName()+"=? and ";
        }
        selectParam = selectParam.substring(0, selectParam.length()-4);
        return  selectParam;
    }


    
    /**
     *  分页
     * @param bTableWrapper
     * @return 
     */
    public static String getSelectAllSQL(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        String suffex="a";
        String names = getFieldnameListSuffex(suffex,list);
        String select_sql = "select "+names+" from "+bTableWrapper.getTablename()+" as "+suffex;
        return select_sql;
    }
    
     public static String getSelectLimitSQL(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();

         String suffex="a";
         String names = getFieldnameListSuffex(suffex,list);

        List<String> nameList = new ArrayList<>();
        for(BFieldWrapper fieldWrapper:list){
            String name = fieldWrapper.getTableFieldName();
            nameList.add(name);
        }
        StringBuffer sb = new StringBuffer();
        sb.append("select ").append(names).append(" from ").append(bTableWrapper.getTablename()).append(" as ").append(suffex);
        if(nameList.contains("create_time")){
            sb.append(" ORDER BY "+suffex+".create_time DESC ");
        }
        sb.append(" LIMIT ?,? ");
        String select_sql = sb.toString();
        //String select_sql = "select "+names+" from "+bTableWrapper.getTablename()+" as "+suffex +" ORDER BY "+suffex+".create_time DESC LIMIT ?,?";
         System.out.println("selectSQL:"+select_sql);
        return select_sql;
    }


    public static String getSelectLimitSQLOrder(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        String suffex="a";
        String names = getFieldnameListSuffex(suffex,list);
        String select_sql = "select "+names+" from "+bTableWrapper.getTablename()+" as "+suffex;
        System.out.println("selectSQL:"+select_sql);
        return select_sql;
    }

    public static String getSelectByFieldSQL(BTableWrapper bTableWrapper,List<BFieldWrapper> selectFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        String names = getFieldnameList(list);
        String selectByID_sql = "select "+names+" from "+bTableWrapper.getTablename()+ getSelectCondition(selectFieldWrapperList);
        return selectByID_sql;
    }

    public static String getSelectByFieldLimitSQL(BTableWrapper bTableWrapper,List<BFieldWrapper> selectFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        String names = getFieldnameList(list);

        List<String> nameList = new ArrayList<>();
        for(BFieldWrapper fieldWrapper:list){
            String name = fieldWrapper.getTableFieldName();
            nameList.add(name);
        }
        StringBuffer sb = new StringBuffer();
        sb.append("select ").append(names);
        if(nameList.contains("create_time")){
            sb.append(" ORDER BY create_time DESC ");
        }
        sb.append(" LIMIT ?,? ");
        String selectByID_sql = sb.toString();


        //String selectByID_sql = "select "+names+" from "+bTableWrapper.getTablename()+ getSelectCondition(selectFieldWrapperList)+" ORDER BY create_time DESC LIMIT ?,?";

        System.out.println("limitSQL:"+selectByID_sql);
        return selectByID_sql;
    }

    public static String getUpdateFieldSQL(BTableWrapper bTableWrapper,List<BFieldWrapper> selectFieldWrapperList){
        //List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();
        String updateParam = getUpdateSet(selectFieldWrapperList);
        String update_sql = "update "+bTableWrapper.getTablename()+" "+getUpdateSet(selectFieldWrapperList)+ getSelectCondition(keyList);
        return update_sql;
    }

    public static String getIncFieldSQL(BTableWrapper bTableWrapper,List<BFieldWrapper> selectFieldWrapperList){
        //List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();
        String updateParam = getUpdateSet(selectFieldWrapperList);
        String update_sql = "update "+bTableWrapper.getTablename()+" "+getIncSet(selectFieldWrapperList)+ getSelectCondition(keyList);
        return update_sql;
    }

    public static String getDeleteByFieldSQL(BTableWrapper bTableWrapper,List<BFieldWrapper> selectFieldWrapperList){
        String delete_sql = "delete from "+bTableWrapper.getTablename()+getSelectCondition(selectFieldWrapperList);
        return delete_sql;
    }
    
    public static String getSelectByIDSQL(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        String names = getFieldnameList(list);
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();
        String selectByID_sql = "select "+names+" from "+bTableWrapper.getTablename()+ getKeySelectCondition(keyList);
        return selectByID_sql;
    }
    /**
     * set name=?,departDesc=? 
     * @param bTableWrapper
     * @return 
     */
    public static String getUpdateSQL(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();
        String updateParam = getUpdateSet(list);
        String update_sql = "update "+bTableWrapper.getTablename()+" "+getUpdateSet(list)+ getKeySelectCondition(keyList);
        return update_sql;
    }


    public static String getSelectByFieldSetParam(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");

        int size = list.size();
        String insertParam ="";
        int selectSize = selectBFieldWrapperList.size();
        int index=1;
        for (int i = 0; i < selectSize; i++) {
            BFieldWrapper bFieldWrapper = selectBFieldWrapperList.get(i);
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
            String javatype = bFieldWrapper.getCapitalJavatype();
            if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                insertParam+="p.set"+"Object"+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
            }else{
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
            }
            index++;
            //}
        }
        return insertParam;
    }

    public static String getSelectByFieldSetParamNoBean(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");

        int size = list.size();
        String insertParam ="";
        int selectSize = selectBFieldWrapperList.size();
        int index=1;
        for (int i = 0; i < selectSize; i++) {
            BFieldWrapper bFieldWrapper = selectBFieldWrapperList.get(i);
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
            String javatype = bFieldWrapper.getCapitalJavatype();
            if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                insertParam+="p.set"+"Object"+"("+index+","+bFieldWrapper.getFieldname()+");\n";
            }else{
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bFieldWrapper.getFieldname()+");\n";
            }
            index++;
            //}
        }
        return insertParam;
    }

    public static String getSelectByFieldLimitSetParam(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");

        int size = list.size();
        String insertParam ="";
        int selectSize = selectBFieldWrapperList.size();
        int index=1;
        for (int i = 0; i < selectSize; i++) {
            BFieldWrapper bFieldWrapper = selectBFieldWrapperList.get(i);
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
            String javatype = bFieldWrapper.getCapitalJavatype();
            if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                insertParam+="p.set"+"Object"+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
            }else{
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
            }
            index++;
            //}
        }

        insertParam+="p.setInt"+"("+(selectSize+1)+","+"list.getOffset());\n";
        insertParam+="p.setInt"+"("+(selectSize+2)+","+"list.getPageSize());\n";

        return insertParam;
    }

    public static String getSelectByFieldLimitSetParamNoBean(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");

        int size = list.size();
        String insertParam ="";
        int selectSize = selectBFieldWrapperList.size();
        int index=1;
        for (int i = 0; i < selectSize; i++) {
            BFieldWrapper bFieldWrapper = selectBFieldWrapperList.get(i);
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
            String javatype = bFieldWrapper.getCapitalJavatype();
            if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                insertParam+="p.set"+"Object"+"("+index+","+bFieldWrapper.getFieldname()+");\n";
            }else{
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bFieldWrapper.getFieldname()+");\n";
            }
            index++;
            //}
        }

        insertParam+="p.setInt"+"("+(selectSize+1)+","+"list.getOffset());\n";
        insertParam+="p.setInt"+"("+(selectSize+2)+","+"list.getPageSize());\n";

        return insertParam;
    }

    public static String getUpdateFieldSetParam(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();

        int size = selectBFieldWrapperList.size();
        String insertParam ="";
        int index=1;
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = selectBFieldWrapperList.get(i);
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
            String javatype = bFieldWrapper.getCapitalJavatype();
            if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                insertParam+="p.set"+"Object"+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
            }else{
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
            }
            index++;
            //}
        }

        int keySize = keyList.size();
        for(int i= 0;i<keySize;i++){
            BFieldWrapper bFieldWrapper = keyList.get(i);
            insertParam+="p.set"+"Object"+"("+(size+i+1)+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
        }
        return insertParam;
    }

    public static String getIncFieldSetParam(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();

        int size = selectBFieldWrapperList.size();
        String insertParam ="";
        int index=1;

        int keySize = keyList.size();
        for(int i= 0;i<keySize;i++){
            BFieldWrapper bFieldWrapper = keyList.get(i);
            insertParam+="p.set"+"Object"+"("+(i+1)+","+bFieldWrapper.getFieldname()+"());\n";
        }
        return insertParam;
    }

    public static String getUpdateFieldSetParamNoBean(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();

        int size = selectBFieldWrapperList.size();
        String insertParam ="";
        int index=1;
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = selectBFieldWrapperList.get(i);
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
            String javatype = bFieldWrapper.getCapitalJavatype();
            if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                insertParam+="p.set"+"Object"+"("+index+","+bFieldWrapper.getFieldname()+");\n";
            }else{
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bFieldWrapper.getFieldname()+");\n";
            }
            index++;
            //}
        }

        int keySize = keyList.size();
        for(int i= 0;i<keySize;i++){
            BFieldWrapper bFieldWrapper = keyList.get(i);
            insertParam+="p.set"+"Object"+"("+(index+i)+","+bFieldWrapper.getFieldname()+");\n";
        }
        return insertParam;
    }

    public static String getIncFieldSetParamNoBean(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();

        int size = selectBFieldWrapperList.size();
        String insertParam ="";
        int index=1;
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = selectBFieldWrapperList.get(i);
            String fieldname = bFieldWrapper.getFieldname();
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
            String javatype = bFieldWrapper.getCapitalJavatype();
            if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                insertParam+="p.set"+"Object"+"("+index+",num);\n";
            }else if(fieldname.equalsIgnoreCase("updateTime")||fieldname.equalsIgnoreCase("dateModified")){
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+"System.currentTimeMillis()"+");\n";
            }else{
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bFieldWrapper.getFieldname()+");\n";
            }
            index++;
            //}
        }

        int keySize = keyList.size();
        for(int i= 0;i<keySize;i++){
            BFieldWrapper bFieldWrapper = keyList.get(i);
            insertParam+="p.set"+"Object"+"("+(size+i+1)+","+bFieldWrapper.getFieldname()+");\n";
        }
        return insertParam;
    }

    public static String getDeleteByFieldSetParam(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");

        int size = selectBFieldWrapperList.size();
        String insertParam ="";
        int index=1;
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = selectBFieldWrapperList.get(i);
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
            String javatype = bFieldWrapper.getCapitalJavatype();
            if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                insertParam+="p.set"+"Object"+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
            }else{
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
            }
            index++;
            //}
        }
        return insertParam;
    }

    public static String getDeleteByFieldSetParamNoBean(BTableWrapper bTableWrapper,List<BFieldWrapper> selectBFieldWrapperList){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");

        int size = selectBFieldWrapperList.size();
        String insertParam ="";
        int index=1;
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = selectBFieldWrapperList.get(i);
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
            String javatype = bFieldWrapper.getCapitalJavatype();
            if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                insertParam+="p.set"+"Object"+"("+index+","+bFieldWrapper.getFieldname()+");\n";
            }else{
                insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bFieldWrapper.getFieldname()+");\n";
            }
            index++;
            //}
        }
        return insertParam;
    }

    
    private static String getUpdateSet(List<BFieldWrapper> list){
        String updateParam ="set ";
        int size = list.size();
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = (BFieldWrapper)list.get(i);
            String isKey = bFieldWrapper.getIskey();
            if(isKey!=null&&!isKey.equalsIgnoreCase("PRI")){
                updateParam +="`"+bFieldWrapper.getTableFieldName()+"`"+"=?,";
            }
        }
        updateParam = updateParam.substring(0,updateParam.length()-1);
        return updateParam;
    }

    private static String getIncSet(List<BFieldWrapper> list){
        String updateParam ="set ";
        int size = list.size();
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = (BFieldWrapper)list.get(i);
            String isKey = bFieldWrapper.getIskey();
            String fieldname = bFieldWrapper.getFieldname();
            //不是主键
            if(isKey!=null&&!isKey.equalsIgnoreCase("PRI")){
                //如果是updateTime就不需要+?
                if(!fieldname.equalsIgnoreCase("updateTime")) {
                    updateParam += "`" + bFieldWrapper.getTableFieldName() + "`" + "=`" + (bFieldWrapper.getTableFieldName() + "`+?") + ",";
                }else {
                    updateParam += "`" + bFieldWrapper.getTableFieldName() + "`" + "=?" + ",";
                }
            }
        }
        updateParam = updateParam.substring(0,updateParam.length()-1);
        return updateParam;
    }
    
    /***
     * 得到 departmentID,name,departDesc
     * @param list
     * @return 
     */
    private static String getFieldnameList(List<BFieldWrapper> list){
        int size = list.size();
        String names = "";
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = list.get(i);
            String name = bFieldWrapper.getTableFieldName();
            names +="`"+name+"`"+",";
        }
        names = names.substring(0, names.length()-1);
        System.out.println("names:"+names);
        return names;
    }
    
    private static String getFieldnameListSuffex(String suffex,List<BFieldWrapper> list){
        int size = list.size();
        String names = "";
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = list.get(i);
            String name = bFieldWrapper.getTableFieldName();
            names +=suffex+"."+name+",";
        }
        names = names.substring(0, names.length()-1);
        System.out.println("names:"+names);
        return names;
    }
    
    /***
     * 得到 name,departDesc
     * @param list
     * @return 
     */
    private static String getFieldnameNOKeyidList(List<BFieldWrapper> list){
        int size = list.size();
        String names = "";
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = list.get(i);
            String isKey = bFieldWrapper.getIskey();
            System.out.println("is Key:"+isKey);
            if(isKey!=null&&!isKey.equalsIgnoreCase("PRI")){
                String name = bFieldWrapper.getTableFieldName();
                names +="`"+name+"`"+",";
            }
        }
        if(names.equals("")) return "";
        names = names.substring(0, names.length()-1);
        System.out.println("names:"+names);
        return names;
    }
    
    /***
     * 得到 ?,?,?
     * @param list
     * @return 
     */
    private static String getQuestionSymbols(List<BFieldWrapper> list){
        int size = list.size();
        String questionSymbols = "";
        for (int i = 0; i < size; i++) {
            questionSymbols+="?,";
        }
        //去掉最后一个
        questionSymbols =questionSymbols.substring(0, questionSymbols.length()-1);
        System.out.println("questionSymbols:"+questionSymbols);
        return questionSymbols;
    }
    
    private static String getQuestionSymbolsNoKey(BTableWrapper bTableWrapper){
        int nokeySize = bTableWrapper.getNoKeySize();
        String questionSymbols = "";
        for (int i = 0; i < nokeySize; i++) {
            questionSymbols+="?,";
        }
        //去掉最后一个
        questionSymbols =questionSymbols.substring(0, questionSymbols.length()-1);
        System.out.println("questionSymbols:"+questionSymbols);
        return questionSymbols;
    }
    
    public static String getSelectParam(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        int size = list.size();
        String instantname= bTableWrapper.getInstancename();
        String methodString ="protected void setFindParam(ResultSet r,"+bTableWrapper.getBeanname()+" "+instantname+") throws Exception{\n";
        String selectSetParam="";
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = list.get(i);
            selectSetParam += instantname+".set"+bFieldWrapper.getCapitalname()+"(r.get"+bFieldWrapper.getCapitalJavatype()+"(\""+bFieldWrapper.getTableFieldName()+"\"));\n";
        }
        String selectParam = methodString+selectSetParam+"}";
        return selectParam;
    }
    
     public static String getSelectParamNo(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        int size = list.size();
        String instantname= bTableWrapper.getInstancename();
        String methodString ="protected void setFindParamNo(ResultSet r,"+bTableWrapper.getBeanname()+" "+instantname+") throws Exception{\n";
        String selectSetParam="";
        for (int i = 0; i < size; i++) {
            int index=i+1;
            BFieldWrapper bFieldWrapper = list.get(i);
            selectSetParam += instantname+".set"+bFieldWrapper.getCapitalname()+"(r.get"+bFieldWrapper.getCapitalJavatype()+"("+index+"));\n";
        }
        String selectParam = methodString+selectSetParam+"}";
        return selectParam;
    }
    
    public static String getInsertParam(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        System.out.println("--------"+bTableWrapper.getTablename()+"------------");
        
        int size = list.size();
        String insertParam ="";
        int index=1;
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = list.get(i);
            //String key = bFieldWrapper.getIskey();
            //if(key!=null&&!key.equalsIgnoreCase("PRI")){
                String javatype = bFieldWrapper.getCapitalJavatype();
                if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")||javatype.equalsIgnoreCase("Integer")){
                    insertParam+="p.set"+"Object"+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
                }else{  
                    insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
                }
                index++;
            //}
        }
        return insertParam;
    }
    
    public static String getInsertAutoIDParam(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        int size = list.size();
        String insertParam ="";
        int index=1;
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = list.get(i);
            String key = bFieldWrapper.getIskey();
            if(key!=null&&!key.equalsIgnoreCase("PRI")){
                String javatype = bFieldWrapper.getCapitalJavatype();
                if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")){
                    insertParam+="p.set"+"Object"+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
                }else{  
                    insertParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";
                }
                index++;
            }
        }
        return insertParam;
    }
    
    
    
    public static String getUpdateParam(BTableWrapper bTableWrapper){
        List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();
        int size = keyList.size();
        String updateParam ="";
        int index =1;
        for (int i = 0; i < list.size(); i++) {
            BFieldWrapper bFieldWrapper = list.get(i);
            String key = bFieldWrapper.getIskey();
            if(key!=null&&!key.equalsIgnoreCase("PRI")){
                String javatype = bFieldWrapper.getCapitalJavatype();
                if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")){
                    updateParam+="p.set"+"Object"+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";  
                }else{
                   updateParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";   
                }
                index++;
            }
        }
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = keyList.get(i);
            String key = bFieldWrapper.getIskey();
            if(key!=null&&key.equalsIgnoreCase("PRI")){
                String javatype = bFieldWrapper.getCapitalJavatype();
                if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")){
                    updateParam+="p.set"+"Int"+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";  
                }else{
                   updateParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bTableWrapper.getInstancename()+".get"+bFieldWrapper.getCapitalname()+"());\n";   
                }
                index++;
            }
        }
        //updateParam+="p.set"+MyStringUtils.UpperFirstString(bTableWrapper.getKeytype())+"("+size+","+bTableWrapper.getInstancename()+".get"+MyStringUtils.UpperFirstString(bTableWrapper.getKeyname())+"());\n";
        return updateParam;
    }
    
    public static String getDelParam(BTableWrapper bTableWrapper){
        //List<BFieldWrapper> list = bTableWrapper.getbFieldWrapperList();
        List<BFieldWrapper> keyList = bTableWrapper.getbKeyFieldWrapperList();
        int size = keyList.size();
        String delParam ="";
        int index =1;
        System.out.println("del param size:"+size);
        for (int i = 0; i < size; i++) {
            BFieldWrapper bFieldWrapper = keyList.get(i);
            String key = bFieldWrapper.getIskey();
            if(key!=null&&key.equalsIgnoreCase("PRI")){
                String javatype = bFieldWrapper.getCapitalJavatype();
                if(javatype.equalsIgnoreCase("int")||javatype.equalsIgnoreCase("double")||javatype.equalsIgnoreCase("float")){
                    delParam+="p.set"+"Int"+"("+index+","+bFieldWrapper.getFieldname()+");\n";  
                }else{
                   delParam+="p.set"+bFieldWrapper.getCapitalJavatype()+"("+index+","+bFieldWrapper.getFieldname()+");\n";   
                }
                index++;
            }
        }
        //delParam+="p.set"+MyStringUtils.UpperFirstString(bTableWrapper.getKeytype())+"("+size+","+bTableWrapper.getInstancename()+".get"+MyStringUtils.UpperFirstString(bTableWrapper.getKeyname())+"());\n";
        return delParam;
    }
    
}
