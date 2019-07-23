package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:41:17"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ProductToCategoryEx{

    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int productCategoryId;



@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String productName;



@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int categoryId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String categoryName;


Map<String,Object> map=null;

public ProductToCategoryEx(){}

public int getProductId(){
return productId;
}

public void setProductId(int productId){
this.productId = productId;
}
public int getCategoryId(){
return categoryId;
}

public void setCategoryId(int categoryId){
this.categoryId = categoryId;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("product_id",this.getProductId());
        map.put("category_id",this.getCategoryId());
    }
return map;
}


}