package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:21:21"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CurrencyUserEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int cuId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int currencyId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String currencyName;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 40,pointLen= 4)
    private double num;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
        @TableField(len = 40,pointLen= 4)
    private double forzenNum;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String chongzhiUrl;


Map<String,Object> map=null;

public CurrencyUserEx(){}

public int getCuId(){
return cuId;
}

public void setCuId(int cuId){
this.cuId = cuId;
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
public double getNum(){
return num;
}

public void setNum(double num){
this.num = num;
}
public double getForzenNum(){
return forzenNum;
}

public void setForzenNum(double forzenNum){
this.forzenNum = forzenNum;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public String getChongzhiUrl(){
return chongzhiUrl;
}

public void setChongzhiUrl(String chongzhiUrl){
this.chongzhiUrl = chongzhiUrl;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("cu_id",this.getCuId());
        map.put("member_id",this.getMemberId());
        map.put("currency_id",this.getCurrencyId());
        map.put("num",this.getNum());
        map.put("forzen_num",this.getForzenNum());
        map.put("status",this.getStatus());
        map.put("chongzhi_url",this.getChongzhiUrl());
    }
return map;
}


}