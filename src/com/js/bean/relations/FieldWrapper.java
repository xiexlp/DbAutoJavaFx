package com.js.bean.relations;

public class FieldWrapper {

    String fieldNameJava;
    String fieldNameSql;

    String fieldSqlUnderLine;

    String typeJava;
    String typeSql;

    boolean isPrimaryKey;
    boolean isAutoIncrement;
    boolean isPart;
    /**
     * 是否索引
     */
    boolean isIndex;
    boolean indexUnique;
    int len;
    int pointLen;

    String defaultValue;


    public String getFieldNameJava() {
        return fieldNameJava;
    }

    public void setFieldNameJava(String fieldNameJava) {
        this.fieldNameJava = fieldNameJava;
    }

    public String getFieldNameSql() {
        return fieldNameSql;
    }

    public void setFieldNameSql(String fieldNameSql) {
        this.fieldNameSql = fieldNameSql;
    }

    public String getTypeJava() {
        return typeJava;
    }

    public void setTypeJava(String typeJava) {
        this.typeJava = typeJava;
    }

    public String getTypeSql() {
        return typeSql;
    }

    public void setTypeSql(String typeSql) {
        this.typeSql = typeSql;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public boolean isAutoIncrement() {
        return isAutoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        isAutoIncrement = autoIncrement;
    }

    // blog_action
    public String getFieldSqlUnderLine() {
        return StringTool.humpToUnderLine(fieldNameSql);
    }

    public void setFieldSqlUnderLine(String fieldSqlUnderLine) {
        this.fieldSqlUnderLine = fieldSqlUnderLine;
    }


    public boolean isIndex() {
        return isIndex;
    }

    public void setIndex(boolean index) {
        isIndex = index;
    }

    public boolean isIndexUnique() {
        return indexUnique;
    }

    public void setIndexUnique(boolean indexUnique) {
        this.indexUnique = indexUnique;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }


    public int getPointLen() {
        return pointLen;
    }

    public void setPointLen(int pointLen) {
        this.pointLen = pointLen;
    }

    public boolean isPart() {
        return isPart;
    }

    public void setPart(boolean part) {
        isPart = part;
    }
}
