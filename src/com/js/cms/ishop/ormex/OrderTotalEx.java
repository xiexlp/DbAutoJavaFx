package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-18 09:48:31"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class OrderTotalEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int orderTotalId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String code;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String title;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double value;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 3)
private int sortOrder;


Map<String,Object> map=null;

public OrderTotalEx(){}

public int getOrderTotalId(){
return orderTotalId;
}

public void setOrderTotalId(int orderTotalId){
this.orderTotalId = orderTotalId;
}
public int getOrderId(){
return orderId;
}

public void setOrderId(int orderId){
this.orderId = orderId;
}
public String getCode(){
return code;
}

public void setCode(String code){
this.code = code;
}
public String getTitle(){
return title;
}

public void setTitle(String title){
this.title = title;
}
public double getValue(){
return value;
}

public void setValue(double value){
this.value = value;
}
public int getSortOrder(){
return sortOrder;
}

public void setSortOrder(int sortOrder){
this.sortOrder = sortOrder;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("order_total_id",this.getOrderTotalId());
        map.put("order_id",this.getOrderId());
        map.put("code",this.getCode());
        map.put("title",this.getTitle());
        map.put("value",this.getValue());
        map.put("sort_order",this.getSortOrder());
    }
return map;
}


}