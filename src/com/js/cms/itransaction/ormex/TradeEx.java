package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:25:38"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class TradeEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int tradeId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String tradeNo;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int bidId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int askId;


    //交易对的id
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int marketCurrencyId;


    //  eth/btc
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String marketCurrencyName;

//交易货币id
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int currencyId;

//交易货币 kcs,eth等
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 30)
    private int currencyName;

    //base交易货币id
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int baseCurrencyId;

    //base交易货币名
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 30)
    private int baseCurrencyName;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 4)
    private double price;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 4)
    private double num;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 4)
    private double money;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 4)
    private double fee;


@TableFieldType(fieldType = TableFieldType.TYPE.CHAR)
        @TableField(len = 10)
    private String type;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
        @TableField(len = 32)
    private long createTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long updateTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


Map<String,Object> map=null;

public TradeEx(){}

public int getTradeId(){
return tradeId;
}

public void setTradeId(int tradeId){
this.tradeId = tradeId;
}
public String getTradeNo(){
return tradeNo;
}

public void setTradeNo(String tradeNo){
this.tradeNo = tradeNo;
}



public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}

    public int getMarketCurrencyId() {
        return marketCurrencyId;
    }

    public void setMarketCurrencyId(int marketCurrencyId) {
        this.marketCurrencyId = marketCurrencyId;
    }

    public String getMarketCurrencyName() {
        return marketCurrencyName;
    }

    public void setMarketCurrencyName(String marketCurrencyName) {
        this.marketCurrencyName = marketCurrencyName;
    }

    public int getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(int currencyName) {
        this.currencyName = currencyName;
    }

    public int getBaseCurrencyId() {
        return baseCurrencyId;
    }

    public void setBaseCurrencyId(int baseCurrencyId) {
        this.baseCurrencyId = baseCurrencyId;
    }

    public int getBaseCurrencyName() {
        return baseCurrencyName;
    }

    public void setBaseCurrencyName(int baseCurrencyName) {
        this.baseCurrencyName = baseCurrencyName;
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
public double getMoney(){
return money;
}

public void setMoney(double money){
this.money = money;
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


    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}




}