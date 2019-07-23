package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:20:52"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CustomerTransactionEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerTransactionId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String customName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String description;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double amount;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


Map<String,Object> map=null;

public CustomerTransactionEx(){}

public int getCustomerTransactionId(){
return customerTransactionId;
}

public void setCustomerTransactionId(int customerTransactionId){
this.customerTransactionId = customerTransactionId;
}
public int getCustomerId(){
return customerId;
}

public void setCustomerId(int customerId){
this.customerId = customerId;
}
public int getOrderId(){
return orderId;
}

public void setOrderId(int orderId){
this.orderId = orderId;
}
public String getDescription(){
return description;
}

public void setDescription(String description){
this.description = description;
}
public double getAmount(){
return amount;
}

public void setAmount(double amount){
this.amount = amount;
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
        map.put("customer_transaction_id",this.getCustomerTransactionId());
        map.put("customer_id",this.getCustomerId());
        map.put("order_id",this.getOrderId());
        map.put("description",this.getDescription());
        map.put("amount",this.getAmount());
        map.put("date_added",this.getDateAdded());
    }
return map;
}


}