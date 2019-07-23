package com.js.cms.ishop.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class ItemToCategoryEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemToCategoryId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;



    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private int itemName;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int storeId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private int storeName;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int sellerId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private int sellerName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private int itemDesc;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private int image;

    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 11,pointLen = 4)
    private int price;


    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private int createTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int sortOrder;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int categoryId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private int categoryName;


}
