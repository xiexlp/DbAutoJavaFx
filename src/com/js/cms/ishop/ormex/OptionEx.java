package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:22:06"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class OptionEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int optionId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String name;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String labelCn;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String type;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 3)
private int sortOrder;

//0 通用， 1，专用
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 3)
    private int generalType;


Map<String,Object> map=null;

public OptionEx(){}

public int getOptionId(){
    return optionId;
}

public void setOptionId(int optionId){
this.optionId = optionId;
}
public String getType(){
return type;
}

public void setType(String type){
this.type = type;
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
        map.put("option_id",this.getOptionId());
        map.put("type",this.getType());
        map.put("sort_order",this.getSortOrder());
    }
return map;
}


}