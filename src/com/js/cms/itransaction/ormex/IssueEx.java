package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:24:05"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class IssueEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 3)
    private double num;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 3)
    private double price;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 3)
    private double deal;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String ctime;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 32,pointLen= 2)
    private double money;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 32,pointLen= 2)
    private double minLimit;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 32,pointLen= 2)
    private double limit;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int limitCount;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String title;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String info;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String url1;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String url2;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String wenjianUrl;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 64,pointLen= 0)
    private double numNosell;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int endTime;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 20,pointLen= 4)
    private double zhongchouSuccessBili;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int buyCurrencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int isForzen;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int removeForzenBili;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 20)
    private int removeForzenCycle;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String zcAwardsCurrencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String zcAwardsOneRatio;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String zcAwardsTwoRatio;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int zcAwardsStatus;


Map<String,Object> map=null;

public IssueEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}
public double getNum(){
return num;
}

public void setNum(double num){
this.num = num;
}
public double getPrice(){
return price;
}

public void setPrice(double price){
this.price = price;
}
public double getDeal(){
return deal;
}

public void setDeal(double deal){
this.deal = deal;
}
public String getCtime(){
return ctime;
}

public void setCtime(String ctime){
this.ctime = ctime;
}
public double getMoney(){
return money;
}

public void setMoney(double money){
this.money = money;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public double getMinLimit(){
return minLimit;
}

public void setMinLimit(double minLimit){
this.minLimit = minLimit;
}
public double getLimit(){
return limit;
}

public void setLimit(double limit){
this.limit = limit;
}
public int getLimitCount(){
return limitCount;
}

public void setLimitCount(int limitCount){
this.limitCount = limitCount;
}
public String getTitle(){
return title;
}

public void setTitle(String title){
this.title = title;
}
public String getInfo(){
return info;
}

public void setInfo(String info){
this.info = info;
}
public String getUrl1(){
return url1;
}

public void setUrl1(String url1){
this.url1 = url1;
}
public String getUrl2(){
return url2;
}

public void setUrl2(String url2){
this.url2 = url2;
}
public String getWenjianUrl(){
return wenjianUrl;
}

public void setWenjianUrl(String wenjianUrl){
this.wenjianUrl = wenjianUrl;
}
public double getNumNosell(){
return numNosell;
}

public void setNumNosell(double numNosell){
this.numNosell = numNosell;
}
public int getAddTime(){
return addTime;
}

public void setAddTime(int addTime){
this.addTime = addTime;
}
public int getEndTime(){
return endTime;
}

public void setEndTime(int endTime){
this.endTime = endTime;
}
public double getZhongchouSuccessBili(){
return zhongchouSuccessBili;
}

public void setZhongchouSuccessBili(double zhongchouSuccessBili){
this.zhongchouSuccessBili = zhongchouSuccessBili;
}
public int getBuyCurrencyId(){
return buyCurrencyId;
}

public void setBuyCurrencyId(int buyCurrencyId){
this.buyCurrencyId = buyCurrencyId;
}
public int getIsForzen(){
return isForzen;
}

public void setIsForzen(int isForzen){
this.isForzen = isForzen;
}
public int getRemoveForzenBili(){
return removeForzenBili;
}

public void setRemoveForzenBili(int removeForzenBili){
this.removeForzenBili = removeForzenBili;
}
public int getRemoveForzenCycle(){
return removeForzenCycle;
}

public void setRemoveForzenCycle(int removeForzenCycle){
this.removeForzenCycle = removeForzenCycle;
}
public String getZcAwardsCurrencyId(){
return zcAwardsCurrencyId;
}

public void setZcAwardsCurrencyId(String zcAwardsCurrencyId){
this.zcAwardsCurrencyId = zcAwardsCurrencyId;
}
public String getZcAwardsOneRatio(){
return zcAwardsOneRatio;
}

public void setZcAwardsOneRatio(String zcAwardsOneRatio){
this.zcAwardsOneRatio = zcAwardsOneRatio;
}
public String getZcAwardsTwoRatio(){
return zcAwardsTwoRatio;
}

public void setZcAwardsTwoRatio(String zcAwardsTwoRatio){
this.zcAwardsTwoRatio = zcAwardsTwoRatio;
}
public int getZcAwardsStatus(){
return zcAwardsStatus;
}

public void setZcAwardsStatus(int zcAwardsStatus){
this.zcAwardsStatus = zcAwardsStatus;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("id",this.getId());
        map.put("currency_id",this.getCurrencyId());
        map.put("num",this.getNum());
        map.put("price",this.getPrice());
        map.put("deal",this.getDeal());
        map.put("ctime",this.getCtime());
        map.put("money",this.getMoney());
        map.put("status",this.getStatus());
        map.put("min_limit",this.getMinLimit());
        map.put("limit",this.getLimit());
        map.put("limit_count",this.getLimitCount());
        map.put("title",this.getTitle());
        map.put("info",this.getInfo());
        map.put("url1",this.getUrl1());
        map.put("url2",this.getUrl2());
        map.put("wenjian_url",this.getWenjianUrl());
        map.put("num_nosell",this.getNumNosell());
        map.put("add_time",this.getAddTime());
        map.put("end_time",this.getEndTime());
        map.put("zhongchou_success_bili",this.getZhongchouSuccessBili());
        map.put("buy_currency_id",this.getBuyCurrencyId());
        map.put("is_forzen",this.getIsForzen());
        map.put("remove_forzen_bili",this.getRemoveForzenBili());
        map.put("remove_forzen_cycle",this.getRemoveForzenCycle());
        map.put("zc_awards_currency_id",this.getZcAwardsCurrencyId());
        map.put("zc_awards_one_ratio",this.getZcAwardsOneRatio());
        map.put("zc_awards_two_ratio",this.getZcAwardsTwoRatio());
        map.put("zc_awards_status",this.getZcAwardsStatus());
    }
return map;
}


}