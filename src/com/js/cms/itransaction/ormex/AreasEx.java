package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:12:19"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class AreasEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.SMALLINT)
        @TableField(len = 6)
    private int areaId;


@TableFieldType(fieldType = TableFieldType.TYPE.SMALLINT)
        @TableField(len = 6)
    private int parentId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 120)
    private String areaName;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 1)
    private int areaType;


Map<String,Object> map=null;

public AreasEx(){}

public int getAreaId(){
return areaId;
}

public void setAreaId(int areaId){
this.areaId = areaId;
}
public int getParentId(){
return parentId;
}

public void setParentId(int parentId){
this.parentId = parentId;
}
public String getAreaName(){
return areaName;
}

public void setAreaName(String areaName){
this.areaName = areaName;
}
public int getAreaType(){
return areaType;
}

public void setAreaType(int areaType){
this.areaType = areaType;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("area_id",this.getAreaId());
        map.put("parent_id",this.getParentId());
        map.put("area_name",this.getAreaName());
        map.put("area_type",this.getAreaType());
    }
return map;
}


}