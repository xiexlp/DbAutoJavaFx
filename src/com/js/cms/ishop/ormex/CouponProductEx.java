package com.js.cms.ishop.ormex;

/**
* last update time:"18-07-16 14:36:56"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CouponProductEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int couponProductId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int couponId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productId;


Map<String,Object> map=null;

public CouponProductEx(){}

public int getCouponProductId(){
return couponProductId;
}

public void setCouponProductId(int couponProductId){
this.couponProductId = couponProductId;
}
public int getCouponId(){
return couponId;
}

public void setCouponId(int couponId){
this.couponId = couponId;
}
public int getProductId(){
return productId;
}

public void setProductId(int productId){
this.productId = productId;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("coupon_product_id",this.getCouponProductId());
        map.put("coupon_id",this.getCouponId());
        map.put("product_id",this.getProductId());
    }
return map;
}


}