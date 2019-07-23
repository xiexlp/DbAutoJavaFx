package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:20:33"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class ArticleCategoryEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int parentId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 128)
    private String keywords;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int sort;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 2)
    private int status;


Map<String,Object> map=null;

public ArticleCategoryEx(){}

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
public int getParentId(){
return parentId;
}

public void setParentId(int parentId){
this.parentId = parentId;
}
public String getKeywords(){
return keywords;
}

public void setKeywords(String keywords){
this.keywords = keywords;
}
public int getSort(){
return sort;
}

public void setSort(int sort){
this.sort = sort;
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
        map.put("id",this.getId());
        map.put("name",this.getName());
        map.put("parent_id",this.getParentId());
        map.put("keywords",this.getKeywords());
        map.put("sort",this.getSort());
        map.put("status",this.getStatus());
    }
return map;
}


}