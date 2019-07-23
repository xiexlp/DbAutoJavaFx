package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:24:30"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class MemberCommentEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int commentId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String comment;


Map<String,Object> map=null;

public MemberCommentEx(){}

public int getCommentId(){
return commentId;
}

public void setCommentId(int commentId){
this.commentId = commentId;
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
public int getAddTime(){
return addTime;
}

public void setAddTime(int addTime){
this.addTime = addTime;
}
public String getComment(){
return comment;
}

public void setComment(String comment){
this.comment = comment;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("comment_id",this.getCommentId());
        map.put("member_id",this.getMemberId());
        map.put("currency_id",this.getCurrencyId());
        map.put("add_time",this.getAddTime());
        map.put("comment",this.getComment());
    }
return map;
}


}