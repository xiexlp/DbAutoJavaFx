package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:21:59"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class FillEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int uid;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 2)
    private double num;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 5)
    private int bank;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 36)
    private String banknum;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 36)
    private String uname;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 20)
    private String tel;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 36)
    private String bankname;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int ctime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int random;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 255)
    private String tradeno;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int type;


Map<String,Object> map=null;

public FillEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public int getUid(){
return uid;
}

public void setUid(int uid){
this.uid = uid;
}
public double getNum(){
return num;
}

public void setNum(double num){
this.num = num;
}
public int getBank(){
return bank;
}

public void setBank(int bank){
this.bank = bank;
}
public String getBanknum(){
return banknum;
}

public void setBanknum(String banknum){
this.banknum = banknum;
}
public String getUname(){
return uname;
}

public void setUname(String uname){
this.uname = uname;
}
public String getTel(){
return tel;
}

public void setTel(String tel){
this.tel = tel;
}
public String getBankname(){
return bankname;
}

public void setBankname(String bankname){
this.bankname = bankname;
}
public int getCtime(){
return ctime;
}

public void setCtime(int ctime){
this.ctime = ctime;
}
public int getRandom(){
return random;
}

public void setRandom(int random){
this.random = random;
}
public String getTradeno(){
return tradeno;
}

public void setTradeno(String tradeno){
this.tradeno = tradeno;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public int getType(){
return type;
}

public void setType(int type){
this.type = type;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("id",this.getId());
        map.put("uid",this.getUid());
        map.put("num",this.getNum());
        map.put("bank",this.getBank());
        map.put("banknum",this.getBanknum());
        map.put("uname",this.getUname());
        map.put("tel",this.getTel());
        map.put("bankname",this.getBankname());
        map.put("ctime",this.getCtime());
        map.put("random",this.getRandom());
        map.put("tradeno",this.getTradeno());
        map.put("status",this.getStatus());
        map.put("type",this.getType());
    }
return map;
}


}