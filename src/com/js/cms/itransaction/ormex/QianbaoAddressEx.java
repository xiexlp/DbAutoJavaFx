package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:25:26"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class QianbaoAddressEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int userId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String qianbaoUrl;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int currencyId;


Map<String,Object> map=null;

public QianbaoAddressEx(){}

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
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public String getQianbaoUrl(){
return qianbaoUrl;
}

public void setQianbaoUrl(String qianbaoUrl){
this.qianbaoUrl = qianbaoUrl;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public int getAddTime(){
return addTime;
}

public void setAddTime(int addTime){
this.addTime = addTime;
}
public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("id",this.getId());
        map.put("user_id",this.getUserId());
        map.put("name",this.getName());
        map.put("qianbao_url",this.getQianbaoUrl());
        map.put("status",this.getStatus());
        map.put("add_time",this.getAddTime());
        map.put("currency_id",this.getCurrencyId());
    }
return map;
}


}