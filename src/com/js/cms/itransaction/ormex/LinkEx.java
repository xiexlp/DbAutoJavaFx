package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:24:18"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class LinkEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 125)
    private String tupian;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 125)
    private String url;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


Map<String,Object> map=null;

public LinkEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public String getTupian(){
return tupian;
}

public void setTupian(String tupian){
this.tupian = tupian;
}
public String getUrl(){
return url;
}

public void setUrl(String url){
this.url = url;
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

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("id",this.getId());
        map.put("name",this.getName());
        map.put("tupian",this.getTupian());
        map.put("url",this.getUrl());
        map.put("status",this.getStatus());
        map.put("add_time",this.getAddTime());
    }
return map;
}


}