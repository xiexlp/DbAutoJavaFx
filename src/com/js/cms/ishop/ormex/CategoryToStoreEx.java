package com.js.cms.ishop.ormex;

/**
* last update time:"18-08-05 22:06:04"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CategoryToStoreEx{

@PrimaryKey
@AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int categoryToStoreId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int categoryId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private int categoryName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 11)
    private int storeId;


Map<String,Object> map=null;

public CategoryToStoreEx(){}

public int getCategoryId(){
return categoryId;
}

public void setCategoryId(int categoryId){
this.categoryId = categoryId;
}
public int getStoreId(){
return storeId;
}

public void setStoreId(int storeId){
this.storeId = storeId;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("category_id",this.getCategoryId());
        map.put("store_id",this.getStoreId());
    }
return map;
}


}