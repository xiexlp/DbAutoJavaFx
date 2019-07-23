package com.js.cms.ishop.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class ItemAttrGroupEx {

    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @AutoIncrement
    @TableField(len = 11)
    private int itemAttrGroupId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int attributeGroupId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 40)
    private String groupName;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int sortOrder;

}
