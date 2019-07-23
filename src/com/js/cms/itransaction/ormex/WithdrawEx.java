package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:25:49"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class WithdrawEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int withdrawId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int uid;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 2)
    private double allMoney;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 2)
    private double withdrawFee;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 10,pointLen= 2)
    private double money;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String orderNum;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int checkTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int adminUid;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int bankId;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


Map<String,Object> map=null;

public WithdrawEx(){}

public int getWithdrawId(){
return withdrawId;
}

public void setWithdrawId(int withdrawId){
this.withdrawId = withdrawId;
}
public int getUid(){
return uid;
}

public void setUid(int uid){
this.uid = uid;
}
public double getAllMoney(){
return allMoney;
}

public void setAllMoney(double allMoney){
this.allMoney = allMoney;
}
public double getWithdrawFee(){
return withdrawFee;
}

public void setWithdrawFee(double withdrawFee){
this.withdrawFee = withdrawFee;
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
public String getOrderNum(){
return orderNum;
}

public void setOrderNum(String orderNum){
this.orderNum = orderNum;
}
public int getCheckTime(){
return checkTime;
}

public void setCheckTime(int checkTime){
this.checkTime = checkTime;
}
public int getAdminUid(){
return adminUid;
}

public void setAdminUid(int adminUid){
this.adminUid = adminUid;
}
public int getBankId(){
return bankId;
}

public void setBankId(int bankId){
this.bankId = bankId;
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
        map.put("withdraw_id",this.getWithdrawId());
        map.put("uid",this.getUid());
        map.put("all_money",this.getAllMoney());
        map.put("withdraw_fee",this.getWithdrawFee());
        map.put("money",this.getMoney());
        map.put("add_time",this.getAddTime());
        map.put("order_num",this.getOrderNum());
        map.put("check_time",this.getCheckTime());
        map.put("admin_uid",this.getAdminUid());
        map.put("bank_id",this.getBankId());
        map.put("status",this.getStatus());
    }
return map;
}


}