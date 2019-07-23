package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:41:24"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ProductToStoreEx{


    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int productShoreId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String productName;



@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int storeId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String shoreName;


Map<String,Object> map=null;

public ProductToStoreEx(){}

public int getProductId(){
return productId;
}

public void setProductId(int productId){
this.productId = productId;
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
        map.put("product_id",this.getProductId());
        map.put("store_id",this.getStoreId());
    }
return map;
}


}