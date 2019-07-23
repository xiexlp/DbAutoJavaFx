package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:40:48"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/***
 * 注意，这个类修改较大
 */
public class ProductAttributeEx{


    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @AutoIncrement
    @TableField(len = 11)
    private int productAttributeId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private String productName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int attributeId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int languageId;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String text;


Map<String,Object> map=null;

public ProductAttributeEx(){}

public int getProductId(){
return productId;
}

public void setProductId(int productId){
this.productId = productId;
}
public int getAttributeId(){
return attributeId;
}

public void setAttributeId(int attributeId){
this.attributeId = attributeId;
}
public int getLanguageId(){
return languageId;
}

public void setLanguageId(int languageId){
this.languageId = languageId;
}
public String getText(){
return text;
}

public void setText(String text){
this.text = text;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("product_id",this.getProductId());
        map.put("attribute_id",this.getAttributeId());
        map.put("language_id",this.getLanguageId());
        map.put("text",this.getText());
    }
return map;
}


}