package com.js.cms.ishop.ormex;

/**
 * last update time:"18-06-08 17:40:31"
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ProductEx {


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int productId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String productName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String model;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String sku;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 12)
    private String upc;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 14)
    private String ean;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 13)
    private String jan;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 17)
    private String isbn;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String mpn;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 128)
    private String location;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 4)
    private int quantity;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int stockStatusId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String image;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int manuId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String manuName;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String itemName;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int brandId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String brandName;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int shipping;


    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 15)
    private double price;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 8)
    private int points;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int taxClassId;


    @TableFieldType(fieldType = TableFieldType.TYPE.DATE)
    private Timestamp dateAvailable;


    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 15)
    private double weight;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int weightClassId;


    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 15)
    private double length;


    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 15)
    private double width;


    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 15)
    private double height;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int lengthClassId;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int subtract;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int minimum;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int sortOrder;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int status;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 5)
    private int viewed;


    @TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
    private Timestamp dateAdded;


    @TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
    private Timestamp dateModified;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String productDesc;


    Map<String, Object> map = null;

    public ProductEx() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getJan() {
        return jan;
    }

    public void setJan(String jan) {
        this.jan = jan;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getMpn() {
        return mpn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStockStatusId() {
        return stockStatusId;
    }

    public void setStockStatusId(int stockStatusId) {
        this.stockStatusId = stockStatusId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getShipping() {
        return shipping;
    }

    public void setShipping(int shipping) {
        this.shipping = shipping;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTaxClassId() {
        return taxClassId;
    }

    public void setTaxClassId(int taxClassId) {
        this.taxClassId = taxClassId;
    }

    public Timestamp getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(Timestamp dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getWeightClassId() {
        return weightClassId;
    }

    public void setWeightClassId(int weightClassId) {
        this.weightClassId = weightClassId;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getLengthClassId() {
        return lengthClassId;
    }

    public void setLengthClassId(int lengthClassId) {
        this.lengthClassId = lengthClassId;
    }

    public int getSubtract() {
        return subtract;
    }

    public void setSubtract(int subtract) {
        this.subtract = subtract;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified) {
        this.dateModified = dateModified;
    }


    public int getManuId() {
        return manuId;
    }

    public void setManuId(int manuId) {
        this.manuId = manuId;
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Map toMap() {
        if (map == null) {
            map = new HashMap();
            map.put("product_id", this.getProductId());
            map.put("model", this.getModel());
            map.put("sku", this.getSku());
            map.put("upc", this.getUpc());
            map.put("ean", this.getEan());
            map.put("jan", this.getJan());
            map.put("isbn", this.getIsbn());
            map.put("mpn", this.getMpn());
            map.put("location", this.getLocation());
            map.put("quantity", this.getQuantity());
            map.put("stock_status_id", this.getStockStatusId());
            map.put("image", this.getImage());
            map.put("manu_id", this.getManuId());
            map.put("shipping", this.getShipping());
            map.put("price", this.getPrice());
            map.put("points", this.getPoints());
            map.put("tax_class_id", this.getTaxClassId());
            map.put("date_available", this.getDateAvailable());
            map.put("weight", this.getWeight());
            map.put("weight_class_id", this.getWeightClassId());
            map.put("length", this.getLength());
            map.put("width", this.getWidth());
            map.put("height", this.getHeight());
            map.put("length_class_id", this.getLengthClassId());
            map.put("subtract", this.getSubtract());
            map.put("minimum", this.getMinimum());
            map.put("sort_order", this.getSortOrder());
            map.put("status", this.getStatus());
            map.put("viewed", this.getViewed());
            map.put("date_added", this.getDateAdded());
            map.put("date_modified", this.getDateModified());
        }
        return map;
    }


}