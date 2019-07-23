package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:23:58"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class FollowEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int followId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int uid;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


Map<String,Object> map=null;

public FollowEx(){}

public int getFollowId(){
return followId;
}

public void setFollowId(int followId){
this.followId = followId;
}
public int getMemberId(){
return memberId;
}

public void setMemberId(int memberId){
this.memberId = memberId;
}
public int getUid(){
return uid;
}

public void setUid(int uid){
this.uid = uid;
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

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("follow_id",this.getFollowId());
        map.put("member_id",this.getMemberId());
        map.put("uid",this.getUid());
        map.put("add_time",this.getAddTime());
        map.put("status",this.getStatus());
    }
return map;
}


}