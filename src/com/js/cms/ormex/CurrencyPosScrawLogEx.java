package com.js.cms.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CurrencyPosScrawLogEx {


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int currencyPosScrawLogId;


    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 64)
    private long posBatchTime;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private long posBatchNum;
}
