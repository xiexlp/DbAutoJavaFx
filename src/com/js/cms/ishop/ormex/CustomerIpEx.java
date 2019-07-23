package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:19:28"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CustomerIpEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerIpId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerId;



    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String customName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int storeId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 40)
private String ip;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 2)
private String country;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


Map<String,Object> map=null;

public CustomerIpEx(){}

public int getCustomerIpId(){
return customerIpId;
}

public void setCustomerIpId(int customerIpId){
this.customerIpId = customerIpId;
}
public int getCustomerId(){
return customerId;
}

public void setCustomerId(int customerId){
this.customerId = customerId;
}
public int getStoreId(){
return storeId;
}

public void setStoreId(int storeId){
this.storeId = storeId;
}
public String getIp(){
return ip;
}

public void setIp(String ip){
this.ip = ip;
}
public String getCountry(){
return country;
}

public void setCountry(String country){
this.country = country;
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
        map.put("customer_ip_id",this.getCustomerIpId());
        map.put("customer_id",this.getCustomerId());
        map.put("store_id",this.getStoreId());
        map.put("ip",this.getIp());
        map.put("country",this.getCountry());
        map.put("date_added",this.getDateAdded());
    }
return map;
}


}