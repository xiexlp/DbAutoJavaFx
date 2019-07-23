package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:25:21"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class PositionEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int positionId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String positionName;


Map<String,Object> map=null;

public PositionEx(){}

public int getPositionId(){
return positionId;
}

public void setPositionId(int positionId){
this.positionId = positionId;
}
public String getPositionName(){
return positionName;
}

public void setPositionName(String positionName){
this.positionName = positionName;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("position_id",this.getPositionId());
        map.put("position_name",this.getPositionName());
    }
return map;
}


}