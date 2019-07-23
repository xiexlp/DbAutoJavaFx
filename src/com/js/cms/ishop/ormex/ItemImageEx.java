package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:40:55"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.util.HashMap;
import java.util.Map;

public class ItemImageEx {


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int itemImageId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;


    //路径
@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String image;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 3)
private int sortOrder;




}