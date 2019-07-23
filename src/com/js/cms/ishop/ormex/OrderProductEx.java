package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:23:28"
* last update user:pku
*/

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class OrderProductEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderProductId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String itemName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String model;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 4)
private int quantity;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double price;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double total;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double tax;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 8)
private int reward;


Map<String,Object> map=null;

public OrderProductEx(){}

public int getOrderProductId(){
return orderProductId;
}

public void setOrderProductId(int orderProductId){
this.orderProductId = orderProductId;
}
public int getOrderId(){
return orderId;
}

public void setOrderId(int orderId){
this.orderId = orderId;
}
public int getProductId(){
return productId;
}

public void setProductId(int productId){
this.productId = productId;
}
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public String getModel(){
return model;
}

public void setModel(String model){
this.model = model;
}
public int getQuantity(){
return quantity;
}

public void setQuantity(int quantity){
this.quantity = quantity;
}
public double getPrice(){
return price;
}

public void setPrice(double price){
this.price = price;
}
public double getTotal(){
return total;
}

public void setTotal(double total){
this.total = total;
}
public double getTax(){
return tax;
}

public void setTax(double tax){
this.tax = tax;
}
public int getReward(){
return reward;
}

public void setReward(int reward){
this.reward = reward;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("order_product_id",this.getOrderProductId());
        map.put("order_id",this.getOrderId());
        map.put("product_id",this.getProductId());
        map.put("name",this.getName());
        map.put("model",this.getModel());
        map.put("quantity",this.getQuantity());
        map.put("price",this.getPrice());
        map.put("total",this.getTotal());
        map.put("tax",this.getTax());
        map.put("reward",this.getReward());
    }
return map;
}


}