package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:24:42"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class MessageEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int messageId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String title;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 100)
    private String memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int type;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String content;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int messageAllId;


Map<String,Object> map=null;

public MessageEx(){}

public int getMessageId(){
return messageId;
}

public void setMessageId(int messageId){
this.messageId = messageId;
}
public String getTitle(){
return title;
}

public void setTitle(String title){
this.title = title;
}
public String getMemberId(){
return memberId;
}

public void setMemberId(String memberId){
this.memberId = memberId;
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
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public int getMessageAllId(){
return messageAllId;
}

public void setMessageAllId(int messageAllId){
this.messageAllId = messageAllId;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("message_id",this.getMessageId());
        map.put("title",this.getTitle());
        map.put("member_id",this.getMemberId());
        map.put("type",this.getType());
        map.put("content",this.getContent());
        map.put("add_time",this.getAddTime());
        map.put("status",this.getStatus());
        map.put("message_all_id",this.getMessageAllId());
    }
return map;
}


}