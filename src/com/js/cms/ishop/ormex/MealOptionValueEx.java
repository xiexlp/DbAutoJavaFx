package com.js.cms.ishop.ormex;

import com.js.common.anno.*;

public class MealOptionValueEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int mealOptionValueId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    @TableIndex(value = true)
    private int mealId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private String mealName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int itemId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int optionId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int itemOptionValueId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String optionName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private String value;




}
