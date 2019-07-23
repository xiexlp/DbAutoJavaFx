package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:20:54"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CurrencyEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String currencyName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 255)
    private String currencyLogo;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String currencyMark;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String currencyContent;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 40,pointLen= 6)
    private double currencyAllMoney;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 40,pointLen= 4)
    private double currencyAllNum;


@TableFieldType(fieldType = TableFieldType.TYPE.FLOAT)
        @TableField(len = 64,pointLen= 4)
    private double currencyBuyFee;


@TableFieldType(fieldType = TableFieldType.TYPE.FLOAT)
        @TableField(len = 64,pointLen= 4)
    private double currencySellFee;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String currencyUrl;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int tradeCurrencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int isLine;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int isLock;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int portNumber;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 255)
    private String rpcUrl;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 255)
    private String rpcPwd;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 255)
    private String rpcUser;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int currencyAllTibi;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String detailUrl;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String qianbaoUrl;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String qianbaoKey;


@TableFieldType(fieldType = TableFieldType.TYPE.FLOAT)
        @TableField(len = 32,pointLen= 4)
    private double priceUp;


@TableFieldType(fieldType = TableFieldType.TYPE.FLOAT)
        @TableField(len = 32,pointLen= 4)
    private double priceDown;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int sort;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int currencyDigitNum;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String guanwangUrl;


Map<String,Object> map=null;

public CurrencyEx(){}

public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}
public String getCurrencyName(){
return currencyName;
}

public void setCurrencyName(String currencyName){
this.currencyName = currencyName;
}
public String getCurrencyLogo(){
return currencyLogo;
}

public void setCurrencyLogo(String currencyLogo){
this.currencyLogo = currencyLogo;
}
public String getCurrencyMark(){
return currencyMark;
}

public void setCurrencyMark(String currencyMark){
this.currencyMark = currencyMark;
}
public String getCurrencyContent(){
return currencyContent;
}

public void setCurrencyContent(String currencyContent){
this.currencyContent = currencyContent;
}
public double getCurrencyAllMoney(){
return currencyAllMoney;
}

public void setCurrencyAllMoney(double currencyAllMoney){
this.currencyAllMoney = currencyAllMoney;
}
public double getCurrencyAllNum(){
return currencyAllNum;
}

public void setCurrencyAllNum(double currencyAllNum){
this.currencyAllNum = currencyAllNum;
}
public double getCurrencyBuyFee(){
return currencyBuyFee;
}

public void setCurrencyBuyFee(double currencyBuyFee){
this.currencyBuyFee = currencyBuyFee;
}
public double getCurrencySellFee(){
return currencySellFee;
}

public void setCurrencySellFee(double currencySellFee){
this.currencySellFee = currencySellFee;
}
public String getCurrencyUrl(){
return currencyUrl;
}

public void setCurrencyUrl(String currencyUrl){
this.currencyUrl = currencyUrl;
}
public int getTradeCurrencyId(){
return tradeCurrencyId;
}

public void setTradeCurrencyId(int tradeCurrencyId){
this.tradeCurrencyId = tradeCurrencyId;
}
public int getIsLine(){
return isLine;
}

public void setIsLine(int isLine){
this.isLine = isLine;
}
public int getIsLock(){
return isLock;
}

public void setIsLock(int isLock){
this.isLock = isLock;
}
public int getPortNumber(){
return portNumber;
}

public void setPortNumber(int portNumber){
this.portNumber = portNumber;
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
public String getRpcUrl(){
return rpcUrl;
}

public void setRpcUrl(String rpcUrl){
this.rpcUrl = rpcUrl;
}
public String getRpcPwd(){
return rpcPwd;
}

public void setRpcPwd(String rpcPwd){
this.rpcPwd = rpcPwd;
}
public String getRpcUser(){
return rpcUser;
}

public void setRpcUser(String rpcUser){
this.rpcUser = rpcUser;
}
public int getCurrencyAllTibi(){
return currencyAllTibi;
}

public void setCurrencyAllTibi(int currencyAllTibi){
this.currencyAllTibi = currencyAllTibi;
}
public String getDetailUrl(){
return detailUrl;
}

public void setDetailUrl(String detailUrl){
this.detailUrl = detailUrl;
}
public String getQianbaoUrl(){
return qianbaoUrl;
}

public void setQianbaoUrl(String qianbaoUrl){
this.qianbaoUrl = qianbaoUrl;
}
public String getQianbaoKey(){
return qianbaoKey;
}

public void setQianbaoKey(String qianbaoKey){
this.qianbaoKey = qianbaoKey;
}
public double getPriceUp(){
return priceUp;
}

public void setPriceUp(double priceUp){
this.priceUp = priceUp;
}
public double getPriceDown(){
return priceDown;
}

public void setPriceDown(double priceDown){
this.priceDown = priceDown;
}
public int getSort(){
return sort;
}

public void setSort(int sort){
this.sort = sort;
}
public int getCurrencyDigitNum(){
return currencyDigitNum;
}

public void setCurrencyDigitNum(int currencyDigitNum){
this.currencyDigitNum = currencyDigitNum;
}
public String getGuanwangUrl(){
return guanwangUrl;
}

public void setGuanwangUrl(String guanwangUrl){
this.guanwangUrl = guanwangUrl;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("currency_id",this.getCurrencyId());
        map.put("currency_name",this.getCurrencyName());
        map.put("currency_logo",this.getCurrencyLogo());
        map.put("currency_mark",this.getCurrencyMark());
        map.put("currency_content",this.getCurrencyContent());
        map.put("currency_all_money",this.getCurrencyAllMoney());
        map.put("currency_all_num",this.getCurrencyAllNum());
        map.put("currency_buy_fee",this.getCurrencyBuyFee());
        map.put("currency_sell_fee",this.getCurrencySellFee());
        map.put("currency_url",this.getCurrencyUrl());
        map.put("trade_currency_id",this.getTradeCurrencyId());
        map.put("is_line",this.getIsLine());
        map.put("is_lock",this.getIsLock());
        map.put("port_number",this.getPortNumber());
        map.put("add_time",this.getAddTime());
        map.put("status",this.getStatus());
        map.put("rpc_url",this.getRpcUrl());
        map.put("rpc_pwd",this.getRpcPwd());
        map.put("rpc_user",this.getRpcUser());
        map.put("currency_all_tibi",this.getCurrencyAllTibi());
        map.put("detail_url",this.getDetailUrl());
        map.put("qianbao_url",this.getQianbaoUrl());
        map.put("qianbao_key",this.getQianbaoKey());
        map.put("price_up",this.getPriceUp());
        map.put("price_down",this.getPriceDown());
        map.put("sort",this.getSort());
        map.put("currency_digit_num",this.getCurrencyDigitNum());
        map.put("guanwang_url",this.getGuanwangUrl());
    }
return map;
}


}