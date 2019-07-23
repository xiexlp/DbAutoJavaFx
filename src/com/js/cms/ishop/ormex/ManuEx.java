package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:21:34"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ManuEx {


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int manuId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String image;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 3)
private int sortOrder;


Map<String,Object> map=null;

public ManuEx(){}


    public int getManuId() {
        return manuId;
    }

    public void setManuId(int manuId) {
        this.manuId = manuId;
    }

    public String getName(){
return name;
}

public void setName(String name){
this.name = name;
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
        map.put("manufacturer_id",this.getManuId());
        map.put("name",this.getName());
        map.put("image",this.getImage());
        map.put("sort_order",this.getSortOrder());
    }
return map;
}


}