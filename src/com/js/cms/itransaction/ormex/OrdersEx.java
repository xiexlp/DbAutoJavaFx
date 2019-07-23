package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:25:08"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.*;

public class OrdersEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int ordersId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int currencyId;


    //eth,kcs等等
    @PartField(value = true)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String currencyName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int marketId;

    //eth等等
    @PartField(value = true)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String marketName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int marketCurrencyId;


    //eth/btc
    @PartField(value = true)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String marketCurrencyName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int currencyTradeId;


    //btc，usdt等交易货币
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String currencyTradeName;

    @PartField(value = true)
@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 8)
    private double price;

//总量
@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 8)
    private double num;

//已经成交的
@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 8)
    private double tradeNum;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 8)
    private double fee;


    //1 买单 ask a
    //2 卖单 bid b
    @TableFieldType(fieldType = TableFieldType.TYPE.CHAR)
    @TableField(len = 4)
    private String type;

    //1 买单
    //2 卖单
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int orderType;


    //1 价格优先
    //2 时间优先
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 4)
    private int priority;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
        @TableField(len = 32)
    private long addTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long updateTime;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
        @TableField(len = 32)
    private long tradeTime;


//0 未成交，代成交
//1 已成交
//2 部分成交
//3 取消
@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 1)
    private int status;


    //0 未成交，代成交
//1 已成交
//2 部分成交
//3 取消
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int tradeStatus;


Map<String,Object> map=null;

public OrdersEx(){}

public int getOrdersId(){
return ordersId;
}

public void setOrdersId(int ordersId){
this.ordersId = ordersId;
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
public int getCurrencyTradeId(){
return currencyTradeId;
}

public void setCurrencyTradeId(int currencyTradeId){
this.currencyTradeId = currencyTradeId;
}
public double getPrice(){
return price;
}

public void setPrice(double price){
this.price = price;
}
public double getNum(){
return num;
}

public void setNum(double num){
this.num = num;
}
public double getTradeNum(){
return tradeNum;
}

public void setTradeNum(double tradeNum){
this.tradeNum = tradeNum;
}
public double getFee(){
return fee;
}

public void setFee(double fee){
this.fee = fee;
}
public String getType(){
return type;
}

public void setType(String type){
this.type = type;
}




public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}




}