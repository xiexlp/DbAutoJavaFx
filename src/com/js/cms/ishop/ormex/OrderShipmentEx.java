package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:24:06"
* last update user:pku
*/

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class OrderShipmentEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderShipmentId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 32)
private int shippingCourierId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String trackingNumber;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    //开始地点
    private String sourceStation;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int sellerId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private int sellerName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    //目的地点
    private String destStation;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int customerUserId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private int customerName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    //目的地点
    private String customerPhone;

    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 2)
    //状态，已发送，运转中，已到站，已接收等
    private int shipmentStatus;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    //快运公司
    private int expressId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    //快运公司名
    private int expressName;





    Map<String,Object> map=null;

public OrderShipmentEx(){}

public int getOrderShipmentId(){
return orderShipmentId;
}

public void setOrderShipmentId(int orderShipmentId){
this.orderShipmentId = orderShipmentId;
}
public int getOrderId(){
return orderId;
}

public void setOrderId(int orderId){
this.orderId = orderId;
}
public Timestamp getDateAdded(){
return dateAdded;
}

public void setDateAdded(Timestamp dateAdded){
this.dateAdded = dateAdded;
}




public String getTrackingNumber(){
return trackingNumber;
}

public void setTrackingNumber(String trackingNumber){
this.trackingNumber = trackingNumber;
}




}