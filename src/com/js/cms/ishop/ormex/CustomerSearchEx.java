package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:20:38"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CustomerSearchEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerSearchId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int storeId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int languageId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String customName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String keyword;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int categoryId;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int subCategory;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int description;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int products;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 40)
private String ip;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


Map<String,Object> map=null;

public CustomerSearchEx(){}

public int getCustomerSearchId(){
return customerSearchId;
}

public void setCustomerSearchId(int customerSearchId){
this.customerSearchId = customerSearchId;
}
public int getStoreId(){
return storeId;
}

public void setStoreId(int storeId){
this.storeId = storeId;
}
public int getLanguageId(){
return languageId;
}

public void setLanguageId(int languageId){
this.languageId = languageId;
}
public int getCustomerId(){
return customerId;
}

public void setCustomerId(int customerId){
this.customerId = customerId;
}
public String getKeyword(){
return keyword;
}

public void setKeyword(String keyword){
this.keyword = keyword;
}
public int getCategoryId(){
return categoryId;
}

public void setCategoryId(int categoryId){
this.categoryId = categoryId;
}
public int getSubCategory(){
return subCategory;
}

public void setSubCategory(int subCategory){
this.subCategory = subCategory;
}
public int getDescription(){
return description;
}

public void setDescription(int description){
this.description = description;
}
public int getProducts(){
return products;
}

public void setProducts(int products){
this.products = products;
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
        map.put("customer_search_id",this.getCustomerSearchId());
        map.put("store_id",this.getStoreId());
        map.put("language_id",this.getLanguageId());
        map.put("customer_id",this.getCustomerId());
        map.put("keyword",this.getKeyword());
        map.put("category_id",this.getCategoryId());
        map.put("sub_category",this.getSubCategory());
        map.put("description",this.getDescription());
        map.put("products",this.getProducts());
        map.put("ip",this.getIp());
        map.put("date_added",this.getDateAdded());
    }
return map;
}


}