package com.js.cms.ishop.ormex;

/**
* last update time:"18-07-16 14:34:51"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CouponEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int couponId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 20)
private String code;


@TableFieldType(fieldType = TableFieldType.TYPE.CHAR)
@TableField(len = 1)
private String type;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double discount;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int logged;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int shipping;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double total;


@TableFieldType(fieldType = TableFieldType.TYPE.DATE)
private Date dateStart;


@TableFieldType(fieldType = TableFieldType.TYPE.DATE)
private Date dateEnd;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int usesTotal;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 11)
private String usesCustomer;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int status;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int sellerId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int storeId;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


Map<String,Object> map=null;

public CouponEx(){}

public int getCouponId(){
return couponId;
}

public void setCouponId(int couponId){
this.couponId = couponId;
}
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public String getCode(){
return code;
}

public void setCode(String code){
this.code = code;
}
public String getType(){
return type;
}

public void setType(String type){
this.type = type;
}
public double getDiscount(){
return discount;
}

public void setDiscount(double discount){
this.discount = discount;
}
public int getLogged(){
return logged;
}

public void setLogged(int logged){
this.logged = logged;
}
public int getShipping(){
return shipping;
}

public void setShipping(int shipping){
this.shipping = shipping;
}
public double getTotal(){
return total;
}

public void setTotal(double total){
this.total = total;
}
public Date getDateStart(){
return dateStart;
}

public void setDateStart(Date dateStart){
this.dateStart = dateStart;
}
public Date getDateEnd(){
return dateEnd;
}

public void setDateEnd(Date dateEnd){
this.dateEnd = dateEnd;
}
public int getUsesTotal(){
return usesTotal;
}

public void setUsesTotal(int usesTotal){
this.usesTotal = usesTotal;
}
public String getUsesCustomer(){
return usesCustomer;
}

public void setUsesCustomer(String usesCustomer){
this.usesCustomer = usesCustomer;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
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
        map.put("coupon_id",this.getCouponId());
        map.put("name",this.getName());
        map.put("code",this.getCode());
        map.put("type",this.getType());
        map.put("discount",this.getDiscount());
        map.put("logged",this.getLogged());
        map.put("shipping",this.getShipping());
        map.put("total",this.getTotal());
        map.put("date_start",this.getDateStart());
        map.put("date_end",this.getDateEnd());
        map.put("uses_total",this.getUsesTotal());
        map.put("uses_customer",this.getUsesCustomer());
        map.put("status",this.getStatus());
        map.put("date_added",this.getDateAdded());
    }
return map;
}


}