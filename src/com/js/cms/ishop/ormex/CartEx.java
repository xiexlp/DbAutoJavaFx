package com.js.cms.ishop.ormex;

/**
 * last update time:"18-06-08 17:44:13"
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CartEx{


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int cartId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int apiId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int customerId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String customName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String sessionId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int productId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String productName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int sellerId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private int sellerName;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int storeId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private int storeName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int recurringId;


    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String option;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 5)
    private int quantity;


    @TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
    private Timestamp dateAdded;

    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 15)
    private double unitPrice;

    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 15)
    private double totalPrice;




    Map<String,Object> map=null;

    public CartEx(){}

    public int getCartId(){
        return cartId;
    }

    public void setCartId(int cartId){
        this.cartId = cartId;
    }
    public int getApiId(){
        return apiId;
    }

    public void setApiId(int apiId){
        this.apiId = apiId;
    }
    public int getCustomerId(){
        return customerId;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public String getSessionId(){
        return sessionId;
    }

    public void setSessionId(String sessionId){
        this.sessionId = sessionId;
    }
    public int getProductId(){
        return productId;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }
    public int getRecurringId(){
        return recurringId;
    }

    public void setRecurringId(int recurringId){
        this.recurringId = recurringId;
    }
    public String getOption(){
        return option;
    }

    public void setOption(String option){
        this.option = option;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
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
            map.put("cart_id",this.getCartId());
            map.put("api_id",this.getApiId());
            map.put("customer_id",this.getCustomerId());
            map.put("session_id",this.getSessionId());
            map.put("product_id",this.getProductId());
            map.put("recurring_id",this.getRecurringId());
            map.put("option",this.getOption());
            map.put("quantity",this.getQuantity());
            map.put("date_added",this.getDateAdded());
        }
        return map;
    }


}