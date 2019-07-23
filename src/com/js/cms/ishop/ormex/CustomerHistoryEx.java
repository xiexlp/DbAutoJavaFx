package com.js.cms.ishop.ormex;

/**
 * last update time:"18-06-09 17:10:24"
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CustomerHistoryEx{


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int customerHistoryId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int customerId;



    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String customName;


    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String comment;


    @TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
    private Timestamp dateAdded;


    Map<String,Object> map=null;

    public CustomerHistoryEx(){}

    public int getCustomerHistoryId(){
        return customerHistoryId;
    }

    public void setCustomerHistoryId(int customerHistoryId){
        this.customerHistoryId = customerHistoryId;
    }
    public int getCustomerId(){
        return customerId;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public String getComment(){
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }
    public Timestamp getDateAdded(){
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded){
        this.dateAdded = dateAdded;
    }

    public Map toMap(){
        if(map==null){
            map = new HashMap();
            map.put("customer_history_id",this.getCustomerHistoryId());
            map.put("customer_id",this.getCustomerId());
            map.put("comment",this.getComment());
            map.put("date_added",this.getDateAdded());
        }
        return map;
    }


}