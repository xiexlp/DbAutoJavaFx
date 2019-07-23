package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:20:40"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class BankEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String bankname;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int uid;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String cardname;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String address;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String cardnum;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String bname;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 2)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String bankBranch;


Map<String,Object> map=null;

public BankEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public String getBankname(){
return bankname;
}

public void setBankname(String bankname){
this.bankname = bankname;
}
public int getUid(){
return uid;
}

public void setUid(int uid){
this.uid = uid;
}
public String getCardname(){
return cardname;
}

public void setCardname(String cardname){
this.cardname = cardname;
}
public String getAddress(){
return address;
}

public void setAddress(String address){
this.address = address;
}
public String getCardnum(){
return cardnum;
}

public void setCardnum(String cardnum){
this.cardnum = cardnum;
}
public String getBname(){
return bname;
}

public void setBname(String bname){
this.bname = bname;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public String getBankBranch(){
return bankBranch;
}

public void setBankBranch(String bankBranch){
this.bankBranch = bankBranch;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("id",this.getId());
        map.put("bankname",this.getBankname());
        map.put("uid",this.getUid());
        map.put("cardname",this.getCardname());
        map.put("address",this.getAddress());
        map.put("cardnum",this.getCardnum());
        map.put("bname",this.getBname());
        map.put("status",this.getStatus());
        map.put("bank_branch",this.getBankBranch());
    }
return map;
}


}