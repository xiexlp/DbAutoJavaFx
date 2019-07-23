package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:22:20"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class OptionValueEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int optionValueId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int optionId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String optionName;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String value;

@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String image;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 3)
private int sortOrder;


Map<String,Object> map=null;

public OptionValueEx(){}

public int getOptionValueId(){
return optionValueId;
}

public void setOptionValueId(int optionValueId){
this.optionValueId = optionValueId;
}
public int getOptionId(){
return optionId;
}

public void setOptionId(int optionId){
this.optionId = optionId;
}
public String getImage(){
return image;
}

public void setImage(String image){
this.image = image;
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
        map.put("option_value_id",this.getOptionValueId());
        map.put("option_id",this.getOptionId());
        map.put("image",this.getImage());
        map.put("sort_order",this.getSortOrder());
    }
return map;
}


}