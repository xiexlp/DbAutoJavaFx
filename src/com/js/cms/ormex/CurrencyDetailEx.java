package com.js.cms.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CurrencyDetailEx {

    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int currencyId;

    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String currencyName;

    @TableField(len = 20)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String symbol;

    @TableField(len = 160)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String webSite;

    @TableField(len = 300)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String announceMent;

    @TableField(len = 160)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String explorer;

    @TableField(len = 160)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String explorer2;

    @TableField(len = 160)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String messageBoard;

    @TableField(len = 160)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String messageBoard2;

    @TableField(len = 160)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String chat;

    @TableField(len = 160)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String chat2;

    //源代码
    @TableField(len = 160)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String sourceCode;

    @TableField(len = 160)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String technicalDocumentation;

    @TableField(len = 256)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String coinDesc;

    @TableField(len = 32,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double initPrice;

    @TableField(len =20 ,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double roi;

    //这个需要及时更新
    @TableField(len = 32,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double currentPrice;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long circulatingSupply;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long totalSupply;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long maxSupply;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double allTimeHigh;

    //这个需要及时更新
    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double allTimeLow;


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
