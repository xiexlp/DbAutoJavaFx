package com.js.cms.ishop.ormex;

/**
* last update time:"18-07-11 14:26:18"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class ShippingCourierEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int shippingCourierId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
    //运单号
private String shippingCourierCode;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int orderShipmentId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int orderId;

@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String shippingCourierName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    //联系人姓名
    private String concator;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    //联系人姓名联系方式
    private String phone;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 165)
    //当前地点
    private String currentStation;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 165)
    //下站地点
    private String nextStation;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    //创建时间
    private long createTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    //更新时间
    private long updateTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 2)
    //始发站，中转站，终点站
    private int shippingStatus;





Map<String,Object> map=null;

public ShippingCourierEx(){}

public int getShippingCourierId(){
return shippingCourierId;
}

public void setShippingCourierId(int shippingCourierId){
this.shippingCourierId = shippingCourierId;
}
public String getShippingCourierCode(){
return shippingCourierCode;
}

public void setShippingCourierCode(String shippingCourierCode){
this.shippingCourierCode = shippingCourierCode;
}
public String getShippingCourierName(){
return shippingCourierName;
}

public void setShippingCourierName(String shippingCourierName){
this.shippingCourierName = shippingCourierName;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("shipping_courier_id",this.getShippingCourierId());
        map.put("shipping_courier_code",this.getShippingCourierCode());
        map.put("shipping_courier_name",this.getShippingCourierName());
    }
return map;
}


}