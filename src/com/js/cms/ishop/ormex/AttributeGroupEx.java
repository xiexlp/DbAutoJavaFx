package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-09 09:45:29"
* last update user:pku
*/

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class AttributeGroupEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int attributeGroupId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 3)
private int sortOrder;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String name;


Map<String,Object> map=null;

public AttributeGroupEx(){}

public int getAttributeGroupId(){
return attributeGroupId;
}

public void setAttributeGroupId(int attributeGroupId){
this.attributeGroupId = attributeGroupId;
}
public int getSortOrder(){
return sortOrder;
}

public void setSortOrder(int sortOrder){
this.sortOrder = sortOrder;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("attribute_group_id",this.getAttributeGroupId());
        map.put("sort_order",this.getSortOrder());
    }
return map;
}


}