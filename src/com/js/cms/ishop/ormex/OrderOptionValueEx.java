package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-18 09:45:55"
* last update user:pku
*/

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.util.HashMap;
import java.util.Map;

public class OrderOptionValueEx {


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderOptionValueId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderOptionId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int optionValueId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private int optionValueName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 128)
    private String itemName;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String optionName;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String optionValue;


    public int getOrderOptionValueId() {
        return orderOptionValueId;
    }

    public void setOrderOptionValueId(int orderOptionValueId) {
        this.orderOptionValueId = orderOptionValueId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderOptionId() {
        return orderOptionId;
    }

    public void setOrderOptionId(int orderOptionId) {
        this.orderOptionId = orderOptionId;
    }

    public int getOptionValueId() {
        return optionValueId;
    }

    public void setOptionValueId(int optionValueId) {
        this.optionValueId = optionValueId;
    }

    public int getOptionValueName() {
        return optionValueName;
    }

    public void setOptionValueName(int optionValueName) {
        this.optionValueName = optionValueName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}