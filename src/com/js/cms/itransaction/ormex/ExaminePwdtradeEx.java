package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:21:52"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class ExaminePwdtradeEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int uId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String pwdtrade;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 20)
    private String idcard;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String idcardPositive;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String idcardSide;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String idcardHold;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int examineTime;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String examineName;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 2)
    private int status;


Map<String,Object> map=null;

public ExaminePwdtradeEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public int getUId(){
return uId;
}

public void setUId(int uId){
this.uId = uId;
}
public String getPwdtrade(){
return pwdtrade;
}

public void setPwdtrade(String pwdtrade){
this.pwdtrade = pwdtrade;
}
public String getIdcard(){
return idcard;
}

public void setIdcard(String idcard){
this.idcard = idcard;
}
public String getIdcardPositive(){
return idcardPositive;
}

public void setIdcardPositive(String idcardPositive){
this.idcardPositive = idcardPositive;
}
public String getIdcardSide(){
return idcardSide;
}

public void setIdcardSide(String idcardSide){
this.idcardSide = idcardSide;
}
public String getIdcardHold(){
return idcardHold;
}

public void setIdcardHold(String idcardHold){
this.idcardHold = idcardHold;
}
public int getAddTime(){
return addTime;
}

public void setAddTime(int addTime){
this.addTime = addTime;
}
public int getExamineTime(){
return examineTime;
}

public void setExamineTime(int examineTime){
this.examineTime = examineTime;
}
public String getExamineName(){
return examineName;
}

public void setExamineName(String examineName){
this.examineName = examineName;
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
        map.put("id",this.getId());
        map.put("u_id",this.getUId());
        map.put("pwdtrade",this.getPwdtrade());
        map.put("idcard",this.getIdcard());
        map.put("idcardPositive",this.getIdcardPositive());
        map.put("idcardSide",this.getIdcardSide());
        map.put("idcardHold",this.getIdcardHold());
        map.put("add_time",this.getAddTime());
        map.put("examine_time",this.getExamineTime());
        map.put("examine_name",this.getExamineName());
        map.put("status",this.getStatus());
    }
return map;
}


}