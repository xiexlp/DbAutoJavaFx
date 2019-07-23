/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.dbauto;

/**
 *
 * @author Administrator
 */
public class BField {
    
    private String field;
    private String type;
    private String isNull;
    private String isKey;
    private String defaultKey;
    private String extra;
    private String cnname;
    //长度,这里使用字符串
    private String sqlSize;
    private boolean isIndex=false;
    private boolean needGetBy = false;
    private boolean isPart= false;


    private String defaultValue;


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getIsKey() {
        return isKey;
    }

    public void setIsKey(String isKey) {
        this.isKey = isKey;
    }

    public String getDefaultKey() {
        return defaultKey;
    }

    public void setDefaultKey(String defaultKey) {
        this.defaultKey = defaultKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }


    public boolean isIndex() {
        return isIndex;
    }

    public void setIndex(boolean index) {
        isIndex = index;
    }

    public String getSqlSize() {
        return sqlSize;
    }

    public void setSqlSize(String sqlSize) {
        this.sqlSize = sqlSize;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isNeedGetBy() {
        return needGetBy;
    }

    public void setNeedGetBy(boolean needGetBy) {
        this.needGetBy = needGetBy;
    }


    public boolean isPart() {
        return isPart;
    }

    public void setPart(boolean part) {
        isPart = part;
    }
}
