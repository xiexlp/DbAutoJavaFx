package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:21:37"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class DividendConfigEx{

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 40)
    private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 40)
    private String value;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


Map<String,Object> map=null;

public DividendConfigEx(){}

public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public String getValue(){
return value;
}

public void setValue(String value){
this.value = value;
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
        map.put("name",this.getName());
        map.put("value",this.getValue());
        map.put("status",this.getStatus());
    }
return map;
}


}