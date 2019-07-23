package com.js.cms.ormex;

import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CurrencyMutableEx {


    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int currencyId;

    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String currencyName;

    @TableField(len = 20)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String symbol;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double allTimeHigh;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double allTimeLow;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double week52High;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double week52Low;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double day90High;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double day90Low;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double day7High;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double day7Low;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double yesterdayHigh;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double yesterdayLow;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double yesterdayOpen;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double yesterdayClose;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double yesterdayChange;

    //这个需要及时更新
    @TableField(len = 32,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double yesterdayVolume;


    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long createTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long batchTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long updateTime;





}
