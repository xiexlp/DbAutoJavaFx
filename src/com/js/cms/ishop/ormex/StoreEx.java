package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:41:37"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class StoreEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int storeId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String name;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int userId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private int username;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String url;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String ssl;


Map<String,Object> map=null;

public StoreEx(){}

public int getStoreId(){
return storeId;
}

public void setStoreId(int storeId){
this.storeId = storeId;
}
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public String getUrl(){
return url;
}

public void setUrl(String url){
this.url = url;
}
public String getSsl(){
return ssl;
}

public void setSsl(String ssl){
this.ssl = ssl;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("store_id",this.getStoreId());
        map.put("name",this.getName());
        map.put("url",this.getUrl());
        map.put("ssl",this.getSsl());
    }
return map;
}


}