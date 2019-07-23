package com.js.dbauto;

public class CodeConcat {

    private String keyConcat;
    private String keyConcatWithType;
    private String keyConcatWithComma;


    private String conditionConcatWithType;
    private String conditionConcatWithComma;
    private String conditionConcat;

    //查询字段的组合
    private String searchFieldConcat;
    //这个是查询条件的字段的组合
    private String fieldConcat;
    //包含类型，这在函数的声明中使用
    private String fieldConcatWithType;
    //包括逗号，这在函数实例中使用
    private String fieldConcatWithComma;
    //inc方式，即多了一个updateTime的参数，需要显示

    //用于分页的函数形参
    private String fieldConcatWithTypePage;
    //用于分页的函数实参
    private String fieldConcatWithCommaPage;


    public String getFieldConcatWithTypePage() {
        if(fieldConcatWithType.equalsIgnoreCase("")){
            fieldConcatWithTypePage = "int pageNo,int total";
        }else {
            fieldConcatWithTypePage = fieldConcatWithType+",int pageNo,int total";
        }
        return fieldConcatWithTypePage;
    }

    public String getFieldConcatWithCommaPage() {
        if(fieldConcatWithComma.equalsIgnoreCase("")){
            fieldConcatWithCommaPage = "pageNo,total";
        }else {
            fieldConcatWithCommaPage = fieldConcatWithComma+",pageNo,total";
        }
        return fieldConcatWithCommaPage;
        //return fieldConcatWithCommaPage;
    }


    public String getKeyConcat() {
        return keyConcat;
    }

    public void setKeyConcat(String keyConcat) {
        this.keyConcat = keyConcat;
    }

    public String getKeyConcatWithType() {
        return keyConcatWithType;
    }

    public void setKeyConcatWithType(String keyConcatWithType) {
        this.keyConcatWithType = keyConcatWithType;
    }

    public String getKeyConcatWithComma() {
        return keyConcatWithComma;
    }

    public void setKeyConcatWithComma(String keyConcatWithComma) {
        this.keyConcatWithComma = keyConcatWithComma;
    }

    public String getFieldConcat() {
        return fieldConcat;
    }

    public void setFieldConcat(String fieldConcat) {
        this.fieldConcat = fieldConcat;
    }

    public String getFieldConcatWithType() {
        return fieldConcatWithType;
    }

    public void setFieldConcatWithType(String fieldConcatWithType) {
        this.fieldConcatWithType = fieldConcatWithType;
    }

    public String getFieldConcatWithComma() {
        return fieldConcatWithComma;
    }

    public void setFieldConcatWithComma(String fieldConcatWithComma) {
        this.fieldConcatWithComma = fieldConcatWithComma;
    }

    public String getSearchFieldConcat() {
        return searchFieldConcat;
    }

    public void setSearchFieldConcat(String searchFieldConcat) {
        this.searchFieldConcat = searchFieldConcat;
    }


    public String getConditionConcatWithType() {
        return conditionConcatWithType;
    }

    public void setConditionConcatWithType(String conditionConcatWithType) {
        this.conditionConcatWithType = conditionConcatWithType;
    }

    public String getConditionConcatWithComma() {
        return conditionConcatWithComma;
    }

    public void setConditionConcatWithComma(String conditionConcatWithComma) {
        this.conditionConcatWithComma = conditionConcatWithComma;
    }

    public String getConditionConcat() {
        return conditionConcat;
    }

    public void setConditionConcat(String conditionConcat) {
        this.conditionConcat = conditionConcat;
    }
}
