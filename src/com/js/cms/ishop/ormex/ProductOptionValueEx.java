package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:41:10"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ProductOptionValueEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productOptionValueId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productOptionId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int productId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int optionId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String optionName;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String optionValueName;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemOptionValueId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int optionValueId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String value;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 3)
private int quantity;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int subtract;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double price;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 1)
private String pricePrefix;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 8)
private int points;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 1)
private String pointsPrefix;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double weight;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 1)
private String weightPrefix;


Map<String,Object> map=null;

public ProductOptionValueEx(){}

public int getProductOptionValueId(){
return productOptionValueId;
}

public void setProductOptionValueId(int productOptionValueId){
this.productOptionValueId = productOptionValueId;
}
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
public int getOptionValueId(){
return optionValueId;
}

public void setOptionValueId(int optionValueId){
this.optionValueId = optionValueId;
}
public int getQuantity(){
return quantity;
}

public void setQuantity(int quantity){
this.quantity = quantity;
}
public int getSubtract(){
return subtract;
}

public void setSubtract(int subtract){
this.subtract = subtract;
}
public double getPrice(){
return price;
}

public void setPrice(double price){
this.price = price;
}
public String getPricePrefix(){
return pricePrefix;
}

public void setPricePrefix(String pricePrefix){
this.pricePrefix = pricePrefix;
}
public int getPoints(){
return points;
}

public void setPoints(int points){
this.points = points;
}
public String getPointsPrefix(){
return pointsPrefix;
}

public void setPointsPrefix(String pointsPrefix){
this.pointsPrefix = pointsPrefix;
}
public double getWeight(){
return weight;
}

public void setWeight(double weight){
this.weight = weight;
}
public String getWeightPrefix(){
return weightPrefix;
}

public void setWeightPrefix(String weightPrefix){
this.weightPrefix = weightPrefix;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("product_option_value_id",this.getProductOptionValueId());
        map.put("product_option_id",this.getProductOptionId());
        map.put("product_id",this.getProductId());
        map.put("option_id",this.getOptionId());
        map.put("option_value_id",this.getOptionValueId());
        map.put("quantity",this.getQuantity());
        map.put("subtract",this.getSubtract());
        map.put("price",this.getPrice());
        map.put("price_prefix",this.getPricePrefix());
        map.put("points",this.getPoints());
        map.put("points_prefix",this.getPointsPrefix());
        map.put("weight",this.getWeight());
        map.put("weight_prefix",this.getWeightPrefix());
    }
return map;
}


}