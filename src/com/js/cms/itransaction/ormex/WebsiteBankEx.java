package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:25:44"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class WebsiteBankEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int bankId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 125)
    private String bankName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 252)
    private String bankAdddress;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String bankNo;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 1)
    private int status;


Map<String,Object> map=null;

public WebsiteBankEx(){}

public int getBankId(){
return bankId;
}

public void setBankId(int bankId){
this.bankId = bankId;
}
public String getBankName(){
return bankName;
}

public void setBankName(String bankName){
this.bankName = bankName;
}
public String getBankAdddress(){
return bankAdddress;
}

public void setBankAdddress(String bankAdddress){
this.bankAdddress = bankAdddress;
}
public String getBankNo(){
return bankNo;
}

public void setBankNo(String bankNo){
this.bankNo = bankNo;
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
        map.put("bank_id",this.getBankId());
        map.put("bank_name",this.getBankName());
        map.put("bank_adddress",this.getBankAdddress());
        map.put("bank_no",this.getBankNo());
        map.put("status",this.getStatus());
    }
return map;
}


}