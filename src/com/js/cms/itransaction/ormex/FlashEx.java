package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:23:42"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class FlashEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int flashId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String title;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String pic;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String jumpUrl;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 16)
    private int sort;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 16)
    private String type;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


Map<String,Object> map=null;

public FlashEx(){}

public int getFlashId(){
return flashId;
}

public void setFlashId(int flashId){
this.flashId = flashId;
}
public String getTitle(){
return title;
}

public void setTitle(String title){
this.title = title;
}
public String getPic(){
return pic;
}

public void setPic(String pic){
this.pic = pic;
}
public String getJumpUrl(){
return jumpUrl;
}

public void setJumpUrl(String jumpUrl){
this.jumpUrl = jumpUrl;
}
public int getSort(){
return sort;
}

public void setSort(int sort){
this.sort = sort;
}
public String getType(){
return type;
}

public void setType(String type){
this.type = type;
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

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("flash_id",this.getFlashId());
        map.put("title",this.getTitle());
        map.put("pic",this.getPic());
        map.put("jump_url",this.getJumpUrl());
        map.put("sort",this.getSort());
        map.put("type",this.getType());
        map.put("add_time",this.getAddTime());
        map.put("status",this.getStatus());
    }
return map;
}


}