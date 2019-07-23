package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:24:56"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class MessageCategoryEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 50)
    private String name;


Map<String,Object> map=null;

public MessageCategoryEx(){}

public int getId(){
return id;
}

public void setId(int id){
this.id = id;
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
        map.put("id",this.getId());
        map.put("name",this.getName());
    }
return map;
}


}