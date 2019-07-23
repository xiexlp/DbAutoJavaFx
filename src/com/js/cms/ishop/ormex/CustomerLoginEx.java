package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:19:47"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CustomerLoginEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerLoginId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String customName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 40)
private String ip;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 4)
private int total;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateModified;


Map<String,Object> map=null;

public CustomerLoginEx(){}

public int getCustomerLoginId(){
return customerLoginId;
}

public void setCustomerLoginId(int customerLoginId){
this.customerLoginId = customerLoginId;
}
public int getCustomerId(){
return customerId;
}

public void setCustomerId(int customerId){
this.customerId = customerId;
}
public String getIp(){
return ip;
}

public void setIp(String ip){
this.ip = ip;
}
public int getTotal(){
return total;
}

public void setTotal(int total){
this.total = total;
}
public Timestamp getDateAdded(){
return dateAdded;
}

public void setDateAdded(Timestamp dateAdded){
this.dateAdded = dateAdded;
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
        map.put("customer_login_id",this.getCustomerLoginId());
        map.put("customer_id",this.getCustomerId());
        map.put("ip",this.getIp());
        map.put("total",this.getTotal());
        map.put("date_added",this.getDateAdded());
        map.put("date_modified",this.getDateModified());
    }
return map;
}


}