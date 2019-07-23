package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:36:50"
* last update user:pku
*/

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CustomerActivityEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerActivityId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String customName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String key;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String data;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 40)
private String ip;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


Map<String,Object> map=null;

public CustomerActivityEx(){}

public int getCustomerActivityId(){
return customerActivityId;
}

public void setCustomerActivityId(int customerActivityId){
this.customerActivityId = customerActivityId;
}
public int getCustomerId(){
return customerId;
}

public void setCustomerId(int customerId){
this.customerId = customerId;
}
public String getKey(){
return key;
}

public void setKey(String key){
this.key = key;
}
public String getData(){
return data;
}

public void setData(String data){
this.data = data;
}
public String getIp(){
return ip;
}

public void setIp(String ip){
this.ip = ip;
}
public Timestamp getDateAdded(){
return dateAdded;
}

public void setDateAdded(Timestamp dateAdded){
this.dateAdded = dateAdded;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("customer_activity_id",this.getCustomerActivityId());
        map.put("customer_id",this.getCustomerId());
        map.put("key",this.getKey());
        map.put("data",this.getData());
        map.put("ip",this.getIp());
        map.put("date_added",this.getDateAdded());
    }
return map;
}


}