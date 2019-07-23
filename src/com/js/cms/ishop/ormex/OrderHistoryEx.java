package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:23:05"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class OrderHistoryEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderHistoryId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderStatusId;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int notify;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String comment;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


Map<String,Object> map=null;

public OrderHistoryEx(){}

public int getOrderHistoryId(){
return orderHistoryId;
}

public void setOrderHistoryId(int orderHistoryId){
this.orderHistoryId = orderHistoryId;
}
public int getOrderId(){
return orderId;
}

public void setOrderId(int orderId){
this.orderId = orderId;
}
public int getOrderStatusId(){
return orderStatusId;
}

public void setOrderStatusId(int orderStatusId){
this.orderStatusId = orderStatusId;
}
public int getNotify(){
return notify;
}

public void setNotify(int notify){
this.notify = notify;
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
        map.put("order_history_id",this.getOrderHistoryId());
        map.put("order_id",this.getOrderId());
        map.put("order_status_id",this.getOrderStatusId());
        map.put("notify",this.getNotify());
        map.put("comment",this.getComment());
        map.put("date_added",this.getDateAdded());
    }
return map;
}


}