package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:24:48"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class MessageAllEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String title;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 100)
    private String uId;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int type;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String content;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


Map<String,Object> map=null;

public MessageAllEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public String getTitle(){
return title;
}

public void setTitle(String title){
this.title = title;
}
public String getUId(){
return uId;
}

public void setUId(String uId){
this.uId = uId;
}
public int getType(){
return type;
}

public void setType(int type){
this.type = type;
}
public String getContent(){
return content;
}

public void setContent(String content){
this.content = content;
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
        map.put("title",this.getTitle());
        map.put("u_id",this.getUId());
        map.put("type",this.getType());
        map.put("content",this.getContent());
        map.put("add_time",this.getAddTime());
    }
return map;
}


}