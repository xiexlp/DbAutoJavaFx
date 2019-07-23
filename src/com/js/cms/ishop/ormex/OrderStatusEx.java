package com.js.cms.ishop.ormex;

/**
* last update time:"18-07-07 15:47:10"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class OrderStatusEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderStatusId;


@PrimaryKey
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int languageId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String name;


Map<String,Object> map=null;

public OrderStatusEx(){}

public int getOrderStatusId(){
return orderStatusId;
}

public void setOrderStatusId(int orderStatusId){
this.orderStatusId = orderStatusId;
}
public int getLanguageId(){
return languageId;
}

public void setLanguageId(int languageId){
this.languageId = languageId;
}
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("order_status_id",this.getOrderStatusId());
        map.put("language_id",this.getLanguageId());
        map.put("name",this.getName());
    }
return map;
}


}