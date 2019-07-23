package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:25:32"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class TibiEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int userId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String url;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 8)
    private double num;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String tiId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int checkTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 4)
    private double fee;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 4)
    private double actual;


Map<String,Object> map=null;

public TibiEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public int getUserId(){
return userId;
}

public void setUserId(int userId){
this.userId = userId;
}
public String getUrl(){
return url;
}

public void setUrl(String url){
this.url = url;
}
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public int getAddTime(){
return addTime;
}

public void setAddTime(int addTime){
this.addTime = addTime;
}
public double getNum(){
return num;
}

public void setNum(double num){
this.num = num;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public String getTiId(){
return tiId;
}

public void setTiId(String tiId){
this.tiId = tiId;
}
public int getCheckTime(){
return checkTime;
}

public void setCheckTime(int checkTime){
this.checkTime = checkTime;
}
public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}
public double getFee(){
return fee;
}

public void setFee(double fee){
this.fee = fee;
}
public double getActual(){
return actual;
}

public void setActual(double actual){
this.actual = actual;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("id",this.getId());
        map.put("user_id",this.getUserId());
        map.put("url",this.getUrl());
        map.put("name",this.getName());
        map.put("add_time",this.getAddTime());
        map.put("num",this.getNum());
        map.put("status",this.getStatus());
        map.put("ti_id",this.getTiId());
        map.put("check_time",this.getCheckTime());
        map.put("currency_id",this.getCurrencyId());
        map.put("fee",this.getFee());
        map.put("actual",this.getActual());
    }
return map;
}


}