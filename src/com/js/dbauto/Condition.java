package com.js.dbauto;

public class Condition {

    public Condition(String tablefieldname,String operator){
        this.tablefieldname=tablefieldname;
        this.operator = operator;
    }

    String tablefieldname;
    String operator;

    @Override
    public String toString(){
        return tablefieldname+ operator;
    }


    public String getTablefieldname() {
        return tablefieldname;
    }

    public void setTablefieldname(String tablefieldname) {
        this.tablefieldname = tablefieldname;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
