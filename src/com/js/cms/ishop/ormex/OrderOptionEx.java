package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-18 09:45:55"
* last update user:pku
*/

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class OrderOptionEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderOptionId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderProductId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productOptionId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productOptionValueId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String name;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String productName;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String optionName;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String value;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String type;


Map<String,Object> map=null;

public OrderOptionEx(){}

public int getOrderOptionId(){
return orderOptionId;
}

public void setOrderOptionId(int orderOptionId){
this.orderOptionId = orderOptionId;
}
public int getOrderId(){
return orderId;
}

public void setOrderId(int orderId){
this.orderId = orderId;
}
public int getOrderProductId(){
return orderProductId;
}

public void setOrderProductId(int orderProductId){
this.orderProductId = orderProductId;
}
public int getProductOptionId(){
return productOptionId;
}

public void setProductOptionId(int productOptionId){
this.productOptionId = productOptionId;
}
public int getProductOptionValueId(){
return productOptionValueId;
}

public void setProductOptionValueId(int productOptionValueId){
this.productOptionValueId = productOptionValueId;
}
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public String getValue(){
return value;
}

public void setValue(String value){
this.value = value;
}
public String getType(){
return type;
}

public void setType(String type){
this.type = type;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("order_option_id",this.getOrderOptionId());
        map.put("order_id",this.getOrderId());
        map.put("order_product_id",this.getOrderProductId());
        map.put("product_option_id",this.getProductOptionId());
        map.put("product_option_value_id",this.getProductOptionValueId());
        map.put("name",this.getName());
        map.put("value",this.getValue());
        map.put("type",this.getType());
    }
return map;
}


}