package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:41:02"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ProductOptionEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productOptionId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String productName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int optionId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String optionName;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String value;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int required;



Map<String,Object> map=null;

public ProductOptionEx(){}

public int getProductOptionId(){
return productOptionId;
}

public void setProductOptionId(int productOptionId){
this.productOptionId = productOptionId;
}
public int getProductId(){
return productId;
}

public void setProductId(int productId){
this.productId = productId;
}
public int getOptionId(){
return optionId;
}

public void setOptionId(int optionId){
this.optionId = optionId;
}
public String getValue(){
return value;
}

public void setValue(String value){
this.value = value;
}
public int getRequired(){
return required;
}

public void setRequired(int required){
this.required = required;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("product_option_id",this.getProductOptionId());
        map.put("product_id",this.getProductId());
        map.put("option_id",this.getOptionId());
        map.put("value",this.getValue());
        map.put("required",this.getRequired());
    }
return map;
}


}