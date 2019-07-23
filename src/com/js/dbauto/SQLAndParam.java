/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.dbauto;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class SQLAndParam {

    private BTableWrapper bTableWrapper;
    String insert_sql;
    String insertAutoID_sql;
    String del_sql;
    String selectall_sql;
    String select_limit_sql;
    String select_byID_sql;
    String update_sql;

    String select_param;
    String select_param_no;
    String insert_param;
    String insertAutoID_param;
    String update_param;
    String del_param;
    String key_arguments;
    String key_argumentNoType;


    String select_by_field_sql;
    String select_by_field_limit_sql;
    String update_field_sql;
    String inc_field_sql;
    String delete_by_field_sql;

    String select_by_field_param;
    String select_by_field_limit_param;
    String update_field_param;
    String inc_field_param;
    String delete_by_field_param;

    String select_by_field_param_no_bean;
    String select_by_field_limit_param_no_bean;
    String update_field_param_no_bean;
    String inc_field_param_no_bean;
    String delete_by_field_param_no_bean;



    String select_limit_sql_order;


//    String select_complex_sql;
//    String select_complex_param;
//    String select_complex_set;


    public SQLAndParam(BTableWrapper bTableWrapper) {
        this.bTableWrapper = bTableWrapper;
        insert_sql = DbCodeUtil.getInsertSQL(bTableWrapper);
        insertAutoID_sql = DbCodeUtil.getInsertAutoIDSQL(bTableWrapper);
        del_sql = DbCodeUtil.getDelSQl(bTableWrapper);
        selectall_sql = DbCodeUtil.getSelectAllSQL(bTableWrapper);
        select_limit_sql =  DbCodeUtil.getSelectLimitSQL(bTableWrapper);
        select_byID_sql = DbCodeUtil.getSelectByIDSQL(bTableWrapper);
        update_sql = DbCodeUtil.getUpdateSQL(bTableWrapper);
        select_param = DbCodeUtil.getSelectParam(bTableWrapper);
        select_param_no = DbCodeUtil.getSelectParamNo(bTableWrapper);
        insert_param = DbCodeUtil.getInsertParam(bTableWrapper);
        insertAutoID_param = DbCodeUtil.getInsertAutoIDParam(bTableWrapper);
        update_param = DbCodeUtil.getUpdateParam(bTableWrapper);
        del_param = DbCodeUtil.getDelParam(bTableWrapper);
        key_arguments = DbCodeUtil.getKeyArguments(bTableWrapper);
        key_argumentNoType = DbCodeUtil.getKeyArgumentsNoType(bTableWrapper);

        select_limit_sql_order = DbCodeUtil.getSelectLimitSQLOrder(bTableWrapper);

    }

    public SQLAndParam(BTableWrapper bTableWrapper,List<BFieldWrapper> selectFieldWrapperList) {
        this.bTableWrapper = bTableWrapper;
        insert_sql = DbCodeUtil.getInsertSQL(bTableWrapper);
        insertAutoID_sql = DbCodeUtil.getInsertAutoIDSQL(bTableWrapper);
        del_sql = DbCodeUtil.getDelSQl(bTableWrapper);
        selectall_sql = DbCodeUtil.getSelectAllSQL(bTableWrapper);
        select_limit_sql =  DbCodeUtil.getSelectLimitSQL(bTableWrapper);
        select_byID_sql = DbCodeUtil.getSelectByIDSQL(bTableWrapper);
        update_sql = DbCodeUtil.getUpdateSQL(bTableWrapper);
        select_param = DbCodeUtil.getSelectParam(bTableWrapper);
        select_param_no = DbCodeUtil.getSelectParamNo(bTableWrapper);
        insert_param = DbCodeUtil.getInsertParam(bTableWrapper);
        insertAutoID_param = DbCodeUtil.getInsertAutoIDParam(bTableWrapper);
        update_param = DbCodeUtil.getUpdateParam(bTableWrapper);
        del_param = DbCodeUtil.getDelParam(bTableWrapper);
        key_arguments = DbCodeUtil.getKeyArguments(bTableWrapper);
        key_argumentNoType = DbCodeUtil.getKeyArgumentsNoType(bTableWrapper);

        //这部分是新增加的
        select_by_field_sql = DbCodeUtil.getSelectByFieldSQL(bTableWrapper,selectFieldWrapperList);
        select_by_field_limit_sql = DbCodeUtil.getSelectByFieldLimitSQL(bTableWrapper,selectFieldWrapperList);
        update_field_sql = DbCodeUtil.getUpdateFieldSQL(bTableWrapper,selectFieldWrapperList);
        inc_field_sql = DbCodeUtil.getIncFieldSQL(bTableWrapper,selectFieldWrapperList);
        delete_by_field_sql = DbCodeUtil.getDeleteByFieldSQL(bTableWrapper,selectFieldWrapperList);


         select_by_field_param= DbCodeUtil.getSelectByFieldSetParam(bTableWrapper,selectFieldWrapperList);
         select_by_field_limit_param= DbCodeUtil.getSelectByFieldLimitSetParam(bTableWrapper,selectFieldWrapperList);
         update_field_param=DbCodeUtil.getUpdateFieldSetParam(bTableWrapper,selectFieldWrapperList);
         inc_field_param = DbCodeUtil.getIncFieldSetParam(bTableWrapper,selectFieldWrapperList);
         delete_by_field_param= DbCodeUtil.getDeleteByFieldSetParam(bTableWrapper,selectFieldWrapperList);

        select_by_field_param_no_bean= DbCodeUtil.getSelectByFieldSetParamNoBean(bTableWrapper,selectFieldWrapperList);
        select_by_field_limit_param_no_bean= DbCodeUtil.getSelectByFieldLimitSetParamNoBean(bTableWrapper,selectFieldWrapperList);
        update_field_param_no_bean=DbCodeUtil.getUpdateFieldSetParamNoBean(bTableWrapper,selectFieldWrapperList);
        inc_field_param_no_bean = DbCodeUtil.getIncFieldSetParamNoBean(bTableWrapper,selectFieldWrapperList);
        delete_by_field_param_no_bean= DbCodeUtil.getDeleteByFieldSetParamNoBean(bTableWrapper,selectFieldWrapperList);


        select_limit_sql_order = DbCodeUtil.getSelectLimitSQLOrder(bTableWrapper);

    }



    public BTableWrapper getbTableWrapper() {
        return bTableWrapper;
    }

    public void setbTableWrapper(BTableWrapper bTableWrapper) {
        this.bTableWrapper = bTableWrapper;
    }

    public String getInsert_sql() {
        return insert_sql;
    }

    public void setInsert_sql(String insert_sql) {
        this.insert_sql = insert_sql;
    }

    public String getInsertAutoID_sql() {
        return insertAutoID_sql;
    }

    public void setInsertAutoID_sql(String insertAutoID_sql) {
        this.insertAutoID_sql = insertAutoID_sql;
    }

    public String getDel_sql() {
        return del_sql;
    }

    public void setDel_sql(String del_sql) {
        this.del_sql = del_sql;
    }

    public String getSelectall_sql() {
        return selectall_sql;
    }

    public void setSelectall_sql(String selectall_sql) {
        this.selectall_sql = selectall_sql;
    }

   

    public String getSelect_byID_sql() {
        return select_byID_sql;
    }

    public void setSelect_byID_sql(String select_byID_sql) {
        this.select_byID_sql = select_byID_sql;
    }

    public String getUpdate_sql() {
        return update_sql;
    }

    public void setUpdate_sql(String update_sql) {
        this.update_sql = update_sql;
    }

    public String getSelect_param() {
        return select_param;
    }

    public void setSelect_param(String select_param) {
        this.select_param = select_param;
    }

    public String getInsert_param() {
        return insert_param;
    }

    public void setInsert_param(String insert_param) {
        this.insert_param = insert_param;
    }

    public String getUpdate_param() {
        return update_param;
    }

    public void setUpdate_param(String update_param) {
        this.update_param = update_param;
    }

    public String getSelect_param_no() {
        return select_param_no;
    }

    public void setSelect_param_no(String select_param_no) {
        this.select_param_no = select_param_no;
    }

    public String getInsertAutoID_param() {
        return insertAutoID_param;
    }

    public void setInsertAutoID_param(String insertAutoID_param) {
        this.insertAutoID_param = insertAutoID_param;
    }

    public String getDel_param() {
        return del_param;
    }

    public void setDel_param(String del_param) {
        this.del_param = del_param;
    }

    public String getKey_arguments() {
        return key_arguments;
    }

    public void setKey_arguments(String key_arguments) {
        this.key_arguments = key_arguments;
    }

    public String getKey_argumentNoType() {
        return key_argumentNoType;
    }

    public void setKey_argumentNoType(String key_argumentNoType) {
        this.key_argumentNoType = key_argumentNoType;
    }


    public String getSelect_by_field_sql() {
        return select_by_field_sql;
    }

    public void setSelect_by_field_sql(String select_by_field_sql) {
        this.select_by_field_sql = select_by_field_sql;
    }

    public String getSelect_by_field_limit_sql() {
        return select_by_field_limit_sql;
    }

    public void setSelect_by_field_limit_sql(String select_by_field_limit_sql) {
        this.select_by_field_limit_sql = select_by_field_limit_sql;
    }

    public String getUpdate_field_sql() {
        return update_field_sql;
    }

    public void setUpdate_field_sql(String update_field_sql) {
        this.update_field_sql = update_field_sql;
    }

    public String getDelete_by_field_sql() {
        return delete_by_field_sql;
    }

    public void setDelete_by_field_sql(String delete_by_field_sql) {
        this.delete_by_field_sql = delete_by_field_sql;
    }

    public String getSelect_by_field_param() {
        return select_by_field_param;
    }

    public void setSelect_by_field_param(String select_by_field_param) {
        this.select_by_field_param = select_by_field_param;
    }

    public String getSelect_by_field_limit_param() {
        return select_by_field_limit_param;
    }

    public void setSelect_by_field_limit_param(String select_by_field_limit_param) {
        this.select_by_field_limit_param = select_by_field_limit_param;
    }

    public String getUpdate_field_param() {
        return update_field_param;
    }

    public void setUpdate_field_param(String update_field_param) {
        this.update_field_param = update_field_param;
    }

    public String getDelete_by_field_param() {
        return delete_by_field_param;
    }

    public void setDelete_by_field_param(String delete_by_field_param) {
        this.delete_by_field_param = delete_by_field_param;
    }

    public String getSelect_by_field_param_no_bean() {
        return select_by_field_param_no_bean;
    }

    public void setSelect_by_field_param_no_bean(String select_by_field_param_no_bean) {
        this.select_by_field_param_no_bean = select_by_field_param_no_bean;
    }

    public String getSelect_by_field_limit_param_no_bean() {
        return select_by_field_limit_param_no_bean;
    }

    public void setSelect_by_field_limit_param_no_bean(String select_by_field_limit_param_no_bean) {
        this.select_by_field_limit_param_no_bean = select_by_field_limit_param_no_bean;
    }

    public String getUpdate_field_param_no_bean() {
        return update_field_param_no_bean;
    }

    public void setUpdate_field_param_no_bean(String update_field_param_no_bean) {
        this.update_field_param_no_bean = update_field_param_no_bean;
    }

    public String getDelete_by_field_param_no_bean() {
        return delete_by_field_param_no_bean;
    }

    public void setDelete_by_field_param_no_bean(String delete_by_field_param_no_bean) {
        this.delete_by_field_param_no_bean = delete_by_field_param_no_bean;
    }


    public String getInc_field_sql() {
        return inc_field_sql;
    }

    public void setInc_field_sql(String inc_field_sql) {
        this.inc_field_sql = inc_field_sql;
    }

    public String getInc_field_param() {
        return inc_field_param;
    }

    public void setInc_field_param(String inc_field_param) {
        this.inc_field_param = inc_field_param;
    }

    public String getInc_field_param_no_bean() {
        return inc_field_param_no_bean;
    }

    public void setInc_field_param_no_bean(String inc_field_param_no_bean) {
        this.inc_field_param_no_bean = inc_field_param_no_bean;
    }

    public String getSelect_limit_sql() {
        return select_limit_sql;
    }

    public void setSelect_limit_sql(String select_limit_sql) {
        this.select_limit_sql = select_limit_sql;
    }

    public String getSelect_limit_sql_order() {
        return select_limit_sql_order;
    }

    public void setSelect_limit_sql_order(String select_limit_sql_order) {
        this.select_limit_sql_order = select_limit_sql_order;
    }


//    public String getSelect_complex_sql() {
//        return select_complex_sql;
//    }
//
//    public void setSelect_complex_sql() {
//        this.select_complex_sql = SqlUtils.getFindComplexSql(getbTableWrapper().getTablename(),);
//    }
//
//    public String getSelect_complex_param() {
//        return select_complex_param;
//    }
//
//    public void setSelect_complex_param(String select_complex_param) {
//        this.select_complex_param = select_complex_param;
//    }
//
//    public String getSelect_complex_set() {
//        return select_complex_set;
//    }
//
//    public void setSelect_complex_set(String select_complex_set) {
//        this.select_complex_set = select_complex_set;
//    }
}
