package com.js.cms.ishop.ormex;

/**
* last update time:"18-07-09 13:23:20"
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
@TableField(len = 11)
private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String title;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 3)
private String code;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 12)
private String symbolLeft;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 12)
private String symbolRight;


@TableFieldType(fieldType = TableFieldType.TYPE.CHAR)
@TableField(len = 1)
private String decimalPlace;


@TableFieldType(fieldType = TableFieldType.TYPE.DOUBLE)
@TableField(len = 15)
private double value;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateModified;


Map<String,Object> map=null;

public CurrencyEx(){}

public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}
public String getTitle(){
return title;
}

public void setTitle(String title){
this.title = title;
}
public String getCode(){
return code;
}

public void setCode(String code){
this.code = code;
}
public String getSymbolLeft(){
return symbolLeft;
}

public void setSymbolLeft(String symbolLeft){
this.symbolLeft = symbolLeft;
}
public String getSymbolRight(){
return symbolRight;
}

public void setSymbolRight(String symbolRight){
this.symbolRight = symbolRight;
}
public String getDecimalPlace(){
return decimalPlace;
}

public void setDecimalPlace(String decimalPlace){
this.decimalPlace = decimalPlace;
}
public double getValue(){
return value;
}

public void setValue(double value){
this.value = value;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public Timestamp getDateModified(){
return dateModified;
}

public void setDateModified(Timestamp dateModified){
this.dateModified = dateModified;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("currency_id",this.getCurrencyId());
        map.put("title",this.getTitle());
        map.put("code",this.getCode());
        map.put("symbol_left",this.getSymbolLeft());
        map.put("symbol_right",this.getSymbolRight());
        map.put("decimal_place",this.getDecimalPlace());
        map.put("value",this.getValue());
        map.put("status",this.getStatus());
        map.put("date_modified",this.getDateModified());
    }
return map;
}


}