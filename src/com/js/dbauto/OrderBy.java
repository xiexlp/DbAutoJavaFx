package com.js.dbauto;

public class OrderBy {

    public OrderBy(String fieldname,String order){
        this.fieldname=fieldname;
        this.order= order;
    }

    String fieldname;
    //desc asc
    String order;

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString(){
        return fieldname+" "+order;
    }
}
