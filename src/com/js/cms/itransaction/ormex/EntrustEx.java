package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:21:46"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class EntrustEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int entrustId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 4)
    private double allNum;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 4)
    private double surplusNum;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 2)
    private double price;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int type;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 2)
    private double onPrice;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 2)
    private double fee;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


Map<String,Object> map=null;

public EntrustEx(){}

public int getEntrustId(){
return entrustId;
}

public void setEntrustId(int entrustId){
this.entrustId = entrustId;
}
public int getMemberId(){
return memberId;
}

public void setMemberId(int memberId){
this.memberId = memberId;
}
public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}
public double getAllNum(){
return allNum;
}

public void setAllNum(double allNum){
this.allNum = allNum;
}
public double getSurplusNum(){
return surplusNum;
}

public void setSurplusNum(double surplusNum){
this.surplusNum = surplusNum;
}
public double getPrice(){
return price;
}

public void setPrice(double price){
this.price = price;
}
public int getAddTime(){
return addTime;
}

public void setAddTime(int addTime){
this.addTime = addTime;
}
public int getType(){
return type;
}

public void setType(int type){
this.type = type;
}
public double getOnPrice(){
return onPrice;
}

public void setOnPrice(double onPrice){
this.onPrice = onPrice;
}
public double getFee(){
return fee;
}

public void setFee(double fee){
this.fee = fee;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("entrust_id",this.getEntrustId());
        map.put("member_id",this.getMemberId());
        map.put("currency_id",this.getCurrencyId());
        map.put("all_num",this.getAllNum());
        map.put("surplus_num",this.getSurplusNum());
        map.put("price",this.getPrice());
        map.put("add_time",this.getAddTime());
        map.put("type",this.getType());
        map.put("on_price",this.getOnPrice());
        map.put("fee",this.getFee());
        map.put("status",this.getStatus());
    }
return map;
}


}