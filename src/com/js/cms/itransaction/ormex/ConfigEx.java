package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:20:47"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class ConfigEx{


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int configId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String key;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String value;


Map<String,Object> map=null;

public ConfigEx(){}

public String getKey(){
return key;
}

public void setKey(String key){
this.key = key;
}
public String getValue(){
return value;
}

public void setValue(String value){
this.value = value;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("key",this.getKey());
        map.put("value",this.getValue());
    }
return map;
}


}