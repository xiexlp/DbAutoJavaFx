package com.js.cms.ishop.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.util.Map;

public class ItemOptionValueEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemOptionValueId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemOptionId;


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

    /**
     * 值类型，是套餐(多个属性)还是单个属性
     * 0 为单个属性
     * 1 为多个属性组合即套餐
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 2)
    private int valueType;


    Map<String,Object> map=null;

}
