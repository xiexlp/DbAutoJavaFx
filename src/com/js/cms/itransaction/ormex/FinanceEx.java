package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:23:20"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class FinanceEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int financeId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int type;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String content;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int moneyType;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 2)
    private double money;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String ip;


Map<String,Object> map=null;

public FinanceEx(){}

public int getFinanceId(){
return financeId;
}

public void setFinanceId(int financeId){
this.financeId = financeId;
}
public int getMemberId(){
return memberId;
}

public void setMemberId(int memberId){
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
public int getMoneyType(){
return moneyType;
}

public void setMoneyType(int moneyType){
this.moneyType = moneyType;
}
public double getMoney(){
return money;
}

public void setMoney(double money){
this.money = money;
}
public int getAddTime(){
return addTime;
}

public void setAddTime(int addTime){
this.addTime = addTime;
}
public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}
public String getIp(){
return ip;
}

public void setIp(String ip){
this.ip = ip;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("finance_id",this.getFinanceId());
        map.put("member_id",this.getMemberId());
        map.put("type",this.getType());
        map.put("content",this.getContent());
        map.put("money_type",this.getMoneyType());
        map.put("money",this.getMoney());
        map.put("add_time",this.getAddTime());
        map.put("currency_id",this.getCurrencyId());
        map.put("ip",this.getIp());
    }
return map;
}


}