package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:23:48"
* last update user:pku
*/

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class OrderRecurringEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderRecurringId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String reference;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String itemName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String productName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productQuantity;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int recurringId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String recurringName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String recurringDescription;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 25)
private String recurringFrequency;


@TableFieldType(fieldType = TableFieldType.TYPE.SMALLINT)
@TableField(len = 6)
private int recurringCycle;


@TableFieldType(fieldType = TableFieldType.TYPE.SMALLINT)
@TableField(len = 6)
private int recurringDuration;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 10)
private double recurringPrice;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int trial;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 25)
private String trialFrequency;


@TableFieldType(fieldType = TableFieldType.TYPE.SMALLINT)
@TableField(len = 6)
private int trialCycle;


@TableFieldType(fieldType = TableFieldType.TYPE.SMALLINT)
@TableField(len = 6)
private int trialDuration;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 10)
private double trialPrice;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 4)
private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


Map<String,Object> map=null;

public OrderRecurringEx(){}

public int getOrderRecurringId(){
return orderRecurringId;
}

public void setOrderRecurringId(int orderRecurringId){
this.orderRecurringId = orderRecurringId;
}
public int getOrderId(){
return orderId;
}

public void setOrderId(int orderId){
this.orderId = orderId;
}
public String getReference(){
return reference;
}

public void setReference(String reference){
this.reference = reference;
}
public int getProductId(){
return productId;
}

public void setProductId(int productId){
this.productId = productId;
}
public String getProductName(){
return productName;
}

public void setProductName(String productName){
this.productName = productName;
}
public int getProductQuantity(){
return productQuantity;
}

public void setProductQuantity(int productQuantity){
this.productQuantity = productQuantity;
}
public int getRecurringId(){
return recurringId;
}

public void setRecurringId(int recurringId){
this.recurringId = recurringId;
}
public String getRecurringName(){
return recurringName;
}

public void setRecurringName(String recurringName){
this.recurringName = recurringName;
}
public String getRecurringDescription(){
return recurringDescription;
}

public void setRecurringDescription(String recurringDescription){
this.recurringDescription = recurringDescription;
}
public String getRecurringFrequency(){
return recurringFrequency;
}

public void setRecurringFrequency(String recurringFrequency){
this.recurringFrequency = recurringFrequency;
}
public int getRecurringCycle(){
return recurringCycle;
}

public void setRecurringCycle(int recurringCycle){
this.recurringCycle = recurringCycle;
}
public int getRecurringDuration(){
return recurringDuration;
}

public void setRecurringDuration(int recurringDuration){
this.recurringDuration = recurringDuration;
}
public double getRecurringPrice(){
return recurringPrice;
}

public void setRecurringPrice(double recurringPrice){
this.recurringPrice = recurringPrice;
}
public int getTrial(){
return trial;
}

public void setTrial(int trial){
this.trial = trial;
}
public String getTrialFrequency(){
return trialFrequency;
}

public void setTrialFrequency(String trialFrequency){
this.trialFrequency = trialFrequency;
}
public int getTrialCycle(){
return trialCycle;
}

public void setTrialCycle(int trialCycle){
this.trialCycle = trialCycle;
}
public int getTrialDuration(){
return trialDuration;
}

public void setTrialDuration(int trialDuration){
this.trialDuration = trialDuration;
}
public double getTrialPrice(){
return trialPrice;
}

public void setTrialPrice(double trialPrice){
this.trialPrice = trialPrice;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
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
        map.put("order_recurring_id",this.getOrderRecurringId());
        map.put("order_id",this.getOrderId());
        map.put("reference",this.getReference());
        map.put("product_id",this.getProductId());
        map.put("product_name",this.getProductName());
        map.put("product_quantity",this.getProductQuantity());
        map.put("recurring_id",this.getRecurringId());
        map.put("recurring_name",this.getRecurringName());
        map.put("recurring_description",this.getRecurringDescription());
        map.put("recurring_frequency",this.getRecurringFrequency());
        map.put("recurring_cycle",this.getRecurringCycle());
        map.put("recurring_duration",this.getRecurringDuration());
        map.put("recurring_price",this.getRecurringPrice());
        map.put("trial",this.getTrial());
        map.put("trial_frequency",this.getTrialFrequency());
        map.put("trial_cycle",this.getTrialCycle());
        map.put("trial_duration",this.getTrialDuration());
        map.put("trial_price",this.getTrialPrice());
        map.put("status",this.getStatus());
        map.put("date_added",this.getDateAdded());
    }
return map;
}


}