/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.dbauto;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Administrator
 */
public class BFieldWrapper {
    //topicId
    private String fieldname;
    //topic_id
    private String tableFieldName;
    //TopicId
    private String Capitalname;//首写字母是大写
    private String capitalAllName;
    private String LowerFirstname;
    private String javatype;
    private String iskey;
    private String CapitalJavatype;
    private String keytype;
    private String sqlType;
    //这里使用字符串
    private String sqlSize;

    private String pointSize;
    private String extra;
    
    private String cnname;

    private boolean isIndex;
    private String defaultValue;
    private boolean isPart;
            
    private BField bField;
    
    public BFieldWrapper(BField bField){
        this.bField = bField;
        this.iskey = bField.getIsKey();
        this.fieldname = StringTool.underLineToHump(bField.getField());
        this.tableFieldName = bField.getField();
        this.Capitalname = StringUtils.capitalize(StringTool.underLineToHump(bField.getField()));
        this.capitalAllName = StringTool.upperWord(fieldname);
        this.LowerFirstname =this.fieldname.substring(0, 1).toLowerCase()+this.fieldname.substring(1);
        System.out.println("field type:"+bField.getType());
        this.javatype = (String)DbCodeUtil.javaMap.get(bField.getType());
        this.sqlType = bField.getType();

        String originSqlSize = bField.getSqlSize();

        if(originSqlSize!=null) {
            int indexComma = originSqlSize.indexOf(",");
            if (indexComma < 0)
                this.sqlSize = bField.getSqlSize();
            else {
                this.sqlSize = originSqlSize.substring(0, indexComma);
                this.pointSize = originSqlSize.substring(indexComma + 1, originSqlSize.length());
            }
        }


        this.CapitalJavatype = StringUtils.capitalize(this.javatype);
        if(javatype.toLowerCase().equals("int")) keytype= "Int";
        else if(javatype.toLowerCase().equals("string")) keytype="Str";
        else if(javatype.toLowerCase().equals("long")) keytype="Long";
        //else if(javatype.toLowerCase().equals(""))
        System.out.println("field java type:"+this.javatype);
        this.cnname = bField.getCnname();
        this.isIndex = bField.isIndex();
        this.extra = bField.getExtra();
        System.out.println("default value11111:"+bField.getDefaultValue());
        this.defaultValue = bField.getDefaultValue();
        this.isPart = bField.isPart();
    }

    public BField getbField() {
        return bField;
    }

    public void setbField(BField bField) {
        this.bField = bField;
    }

    public String getCapitalname() {
        return Capitalname;
    }

    public void setCapitalname(String Capitalname) {
        this.Capitalname = Capitalname;
    }

    public String getLowerFirstname() {
        return LowerFirstname;
    }

    public void setLowerFirstname(String LowerFirstname) {
        this.LowerFirstname = LowerFirstname;
    }

    public String getJavatype() {
        return javatype;
    }

    public void setJavatype(String javatype) {
        this.javatype = javatype;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getFieldname() {
        return fieldname;
    }

    public String getIskey() {
        return iskey;
    }

    public void setIskey(String iskey) {
        this.iskey = iskey;
    }

    public String getCapitalJavatype() {
        return CapitalJavatype;
    }

    public void setCapitalJavatype(String CapitalJavatype) {
        this.CapitalJavatype = CapitalJavatype;
    }

    public String getKeytype() {
        return keytype;
    }

    public void setKeytype(String keytype) {
        this.keytype = keytype;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }


    public String getTableFieldName() {
        return tableFieldName;
    }

    public void setTableFieldName(String tableFieldName) {
        this.tableFieldName = tableFieldName;
    }

    public String getCapitalAllName() {
        return capitalAllName;
    }

    public void setCapitalAllName(String capitalAllName) {
        this.capitalAllName = capitalAllName;
    }


    public boolean isIndex() {
        return isIndex;
    }

    public void setIndex(boolean index) {
        isIndex = index;
    }

    public String getSqlType() {
        return sqlType;
    }

    public String getSqlTypeUpper() {
        return StringTool.upperWord(sqlType);
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public String getSqlSize() {
        return sqlSize;
    }

    public void setSqlSize(String sqlSize) {
        this.sqlSize = sqlSize;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getPointSize() {
        return pointSize;
    }

    public void setPointSize(String pointSize) {
        this.pointSize = pointSize;
    }


    public boolean isPart() {
        return isPart;
    }

    public void setPart(boolean part) {
        isPart = part;
    }

    public static void main(String[] args) {

        String orgininSize = "16,5";
        int indexComma = orgininSize.indexOf(",");
        String len = orgininSize.substring(0,indexComma);
        System.out.println(orgininSize);
        String pointLen = orgininSize.substring(indexComma+1,orgininSize.length());

        System.out.println("len:"+len+" pointLen:"+pointLen);


    }

}
