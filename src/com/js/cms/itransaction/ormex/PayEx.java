package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:25:13"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class PayEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int payId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String memberName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String account;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 4)
    private int type;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 64)
    private int money;


@TableFieldType(fieldType = TableFieldType.TYPE.FLOAT)
        @TableField(len = 64,pointLen= 4)
    private double count;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String memberId;


Map<String,Object> map=null;

public PayEx(){}

public int getPayId(){
return payId;
}

public void setPayId(int payId){
this.payId = payId;
}
public String getMemberName(){
return memberName;
}

public void setMemberName(String memberName){
this.memberName = memberName;
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
public String getAccount(){
return account;
}

public void setAccount(String account){
this.account = account;
}
public int getType(){
return type;
}

public void setType(int type){
this.type = type;
}
public int getMoney(){
return money;
}

public void setMoney(int money){
this.money = money;
}
public double getCount(){
return count;
}

public void setCount(double count){
this.count = count;
}
public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}
public String getMemberId(){
return memberId;
}

public void setMemberId(String memberId){
this.memberId = memberId;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("pay_id",this.getPayId());
        map.put("member_name",this.getMemberName());
        map.put("add_time",this.getAddTime());
        map.put("status",this.getStatus());
        map.put("account",this.getAccount());
        map.put("type",this.getType());
        map.put("money",this.getMoney());
        map.put("count",this.getCount());
        map.put("currency_id",this.getCurrencyId());
        map.put("member_id",this.getMemberId());
    }
return map;
}


}