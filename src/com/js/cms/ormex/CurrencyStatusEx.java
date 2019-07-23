package com.js.cms.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CurrencyStatusEx {


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int currencyStatusId;

    //pos截面数据个数
    @TableField(len = 20)
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int posPanelNum;

    //price价格截面个数
    @TableField(len = 20)
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int pricePanelNum;

    //pos最后获取数据时间
    @TableField(len = 32)
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long posLastBatchTime;

    //pos最后获取数据时间
    @TableField(len = 32)
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long priceLastBatchTime;


    @TableField(len = 32)
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long createTime;

    @TableField(len = 32)
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long updateTime;


}
