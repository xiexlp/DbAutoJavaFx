package com.js.bean.relations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWrapper {
    String javaName;
    String tableName;
    List<FieldWrapper> fieldWrapperList=new ArrayList<FieldWrapper>();
    List<FieldWrapper> keyFieldWrapperList=new ArrayList<FieldWrapper>();
    List<FieldWrapper> indexWrapperList = new ArrayList<>();

    public Map<String,FieldWrapper> fieldWrapperMap = new HashMap();

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<FieldWrapper> getFieldWrapperList() {
        return fieldWrapperList;
    }

    public void setFieldWrapperList(List<FieldWrapper> fieldWrapperList) {
        this.fieldWrapperList = fieldWrapperList;
    }


    public List<FieldWrapper> getKeyFieldWrapperList() {
        return keyFieldWrapperList;
    }

    public void setKeyFieldWrapperList(List<FieldWrapper> keyFieldWrapperList) {
        this.keyFieldWrapperList = keyFieldWrapperList;
    }

    public List<FieldWrapper> getIndexWrapperList() {
        return indexWrapperList;
    }

    public void setIndexWrapperList(List<FieldWrapper> indexWrapperList) {
        this.indexWrapperList = indexWrapperList;
    }

    public Map<String, FieldWrapper> getFieldWrapperMap() {
        return fieldWrapperMap;
    }

    public void setFieldWrapperMap(Map<String, FieldWrapper> fieldWrapperMap) {
        this.fieldWrapperMap = fieldWrapperMap;
    }



}
