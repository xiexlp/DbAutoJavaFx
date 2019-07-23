package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:40:55"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ProductImageEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productImageId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int productId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;


    //路径
@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String image;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 3)
private int sortOrder;


Map<String,Object> map=null;

public ProductImageEx(){}

public int getProductImageId(){
return productImageId;
}

public void setProductImageId(int productImageId){
this.productImageId = productImageId;
}
public int getProductId(){
return productId;
}

public void setProductId(int productId){
this.productId = productId;
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
        map.put("product_image_id",this.getProductImageId());
        map.put("product_id",this.getProductId());
        map.put("image",this.getImage());
        map.put("sort_order",this.getSortOrder());
    }
return map;
}


}