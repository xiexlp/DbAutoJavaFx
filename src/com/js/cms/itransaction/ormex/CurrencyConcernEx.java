package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:21:07"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CurrencyConcernEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int memberId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


Map<String,Object> map=null;

public CurrencyConcernEx(){}

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
public int getMemberId(){
return memberId;
}

public void setMemberId(int memberId){
this.memberId = memberId;
}
public String getAddTime(){
return addTime;
}

public void setAddTime(String addTime){
this.addTime = addTime;
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
        map.put("id",this.getId());
        map.put("currency_id",this.getCurrencyId());
        map.put("member_id",this.getMemberId());
        map.put("add_time",this.getAddTime());
        map.put("status",this.getStatus());
    }
return map;
}


}