package com.js.dbauto;

public class HtmlFieldWrapper {

    BFieldWrapper bFieldWrapper;

    String fieldname;

    public HtmlFieldWrapper(){
    }

    public String getFieldname() {
        return bFieldWrapper.getFieldname();
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    String htmlComponent;

    public String getHtmlComponent() {
        return htmlComponent;
    }

    public void setHtmlComponent(String htmlComponent) {
        this.htmlComponent = htmlComponent;
    }

    public String toString(){
        return bFieldWrapper.getFieldname()+" "+htmlComponent;
    }

    public BFieldWrapper getbFieldWrapper() {
        return bFieldWrapper;
    }

    public void setbFieldWrapper(BFieldWrapper bFieldWrapper) {
        this.bFieldWrapper = bFieldWrapper;
    }
}
