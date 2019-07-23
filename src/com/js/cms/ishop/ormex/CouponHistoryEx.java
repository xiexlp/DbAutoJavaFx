package com.js.cms.ishop.ormex;

/**
* last update time:"18-07-16 14:36:03"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CouponHistoryEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int couponHistoryId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int couponId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerId;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double amount;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


Map<String,Object> map=null;

public CouponHistoryEx(){}

public int getCouponHistoryId(){
return couponHistoryId;
}

public void setCouponHistoryId(int couponHistoryId){
this.couponHistoryId = couponHistoryId;
}
public int getCouponId(){
return couponId;
}

public void setCouponId(int couponId){
this.couponId = couponId;
}
public int getOrderId(){
return orderId;
}

public void setOrderId(int orderId){
this.orderId = orderId;
}
public int getCustomerId(){
return customerId;
}

public void setCustomerId(int customerId){
this.customerId = customerId;
}
public double getAmount(){
return amount;
}

public void setAmount(double amount){
this.amount = amount;
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
        map.put("coupon_history_id",this.getCouponHistoryId());
        map.put("coupon_id",this.getCouponId());
        map.put("order_id",this.getOrderId());
        map.put("customer_id",this.getCustomerId());
        map.put("amount",this.getAmount());
        map.put("date_added",this.getDateAdded());
    }
return map;
}


}