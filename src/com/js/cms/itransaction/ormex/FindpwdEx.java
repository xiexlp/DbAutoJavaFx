package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:23:35"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class FindpwdEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 100)
    private String token;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 20)
    private String addTime;


Map<String,Object> map=null;

public FindpwdEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public int getMemberId(){
return memberId;
}

public void setMemberId(int memberId){
this.memberId = memberId;
}
public String getToken(){
return token;
}

public void setToken(String token){
this.token = token;
}
public String getAddTime(){
return addTime;
}

public void setAddTime(String addTime){
this.addTime = addTime;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("id",this.getId());
        map.put("member_id",this.getMemberId());
        map.put("token",this.getToken());
        map.put("add_time",this.getAddTime());
    }
return map;
}


}