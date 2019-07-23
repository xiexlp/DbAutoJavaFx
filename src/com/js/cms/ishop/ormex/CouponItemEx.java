package com.js.cms.ishop.ormex;

/**
* last update time:"18-07-16 14:36:56"
* last update user:pku
*/

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.util.HashMap;
import java.util.Map;

public class CouponItemEx {


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int couponItemId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int couponId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int itemId;




}