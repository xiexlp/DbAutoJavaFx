package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:24:10"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class IssueLogEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int iid;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int uid;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 32,pointLen= 0)
    private double num;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 32,pointLen= 3)
    private double price;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int buyCurrencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 32,pointLen= 0)
    private double deal;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int cid;


Map<String,Object> map=null;

public IssueLogEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public int getIid(){
return iid;
}

public void setIid(int iid){
this.iid = iid;
}
public int getUid(){
return uid;
}

public void setUid(int uid){
this.uid = uid;
}
public double getNum(){
return num;
}

public void setNum(double num){
this.num = num;
}
public double getPrice(){
return price;
}

public void setPrice(double price){
this.price = price;
}
public String getAddTime(){
return addTime;
}

public void setAddTime(String addTime){
this.addTime = addTime;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public int getBuyCurrencyId(){
return buyCurrencyId;
}

public void setBuyCurrencyId(int buyCurrencyId){
this.buyCurrencyId = buyCurrencyId;
}
public double getDeal(){
return deal;
}

public void setDeal(double deal){
this.deal = deal;
}
public int getCid(){
return cid;
}

public void setCid(int cid){
this.cid = cid;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("id",this.getId());
        map.put("iid",this.getIid());
        map.put("uid",this.getUid());
        map.put("num",this.getNum());
        map.put("price",this.getPrice());
        map.put("add_time",this.getAddTime());
        map.put("status",this.getStatus());
        map.put("buy_currency_id",this.getBuyCurrencyId());
        map.put("deal",this.getDeal());
        map.put("cid",this.getCid());
    }
return map;
}


}