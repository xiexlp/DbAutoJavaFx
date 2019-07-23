package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:24:37"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class MemberOldEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String email;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String password;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String paypwd;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String nike;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String realname;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int documentType;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String documentNum;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 11)
    private String phone;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int regTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int loginTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int vipLevel;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int vipEndTime;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 2)
    private double rmb;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 2)
    private double forzenRmb;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String head;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String profile;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int city;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int district;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


Map<String,Object> map=null;

public MemberOldEx(){}

public int getMemberId(){
return memberId;
}

public void setMemberId(int memberId){
this.memberId = memberId;
}
public String getEmail(){
return email;
}

public void setEmail(String email){
this.email = email;
}
public String getPassword(){
return password;
}

public void setPassword(String password){
this.password = password;
}
public String getPaypwd(){
return paypwd;
}

public void setPaypwd(String paypwd){
this.paypwd = paypwd;
}
public String getNike(){
return nike;
}

public void setNike(String nike){
this.nike = nike;
}
public String getRealname(){
return realname;
}

public void setRealname(String realname){
this.realname = realname;
}
public int getDocumentType(){
return documentType;
}

public void setDocumentType(int documentType){
this.documentType = documentType;
}
public String getDocumentNum(){
return documentNum;
}

public void setDocumentNum(String documentNum){
this.documentNum = documentNum;
}
public String getPhone(){
return phone;
}

public void setPhone(String phone){
this.phone = phone;
}
public int getRegTime(){
return regTime;
}

public void setRegTime(int regTime){
this.regTime = regTime;
}
public int getLoginTime(){
return loginTime;
}

public void setLoginTime(int loginTime){
this.loginTime = loginTime;
}
public int getVipLevel(){
return vipLevel;
}

public void setVipLevel(int vipLevel){
this.vipLevel = vipLevel;
}
public int getVipEndTime(){
return vipEndTime;
}

public void setVipEndTime(int vipEndTime){
this.vipEndTime = vipEndTime;
}
public double getRmb(){
return rmb;
}

public void setRmb(double rmb){
this.rmb = rmb;
}
public double getForzenRmb(){
return forzenRmb;
}

public void setForzenRmb(double forzenRmb){
this.forzenRmb = forzenRmb;
}
public String getHead(){
return head;
}

public void setHead(String head){
this.head = head;
}
public String getProfile(){
return profile;
}

public void setProfile(String profile){
this.profile = profile;
}
public int getCity(){
return city;
}

public void setCity(int city){
this.city = city;
}
public int getDistrict(){
return district;
}

public void setDistrict(int district){
this.district = district;
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
        map.put("member_id",this.getMemberId());
        map.put("email",this.getEmail());
        map.put("password",this.getPassword());
        map.put("paypwd",this.getPaypwd());
        map.put("nike",this.getNike());
        map.put("realname",this.getRealname());
        map.put("document_type",this.getDocumentType());
        map.put("document_num",this.getDocumentNum());
        map.put("phone",this.getPhone());
        map.put("reg_time",this.getRegTime());
        map.put("login_time",this.getLoginTime());
        map.put("vip_level",this.getVipLevel());
        map.put("vip_end_time",this.getVipEndTime());
        map.put("rmb",this.getRmb());
        map.put("forzen_rmb",this.getForzenRmb());
        map.put("head",this.getHead());
        map.put("profile",this.getProfile());
        map.put("city",this.getCity());
        map.put("district",this.getDistrict());
        map.put("status",this.getStatus());
    }
return map;
}


}