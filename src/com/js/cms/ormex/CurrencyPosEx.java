package com.js.cms.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CurrencyPosEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int currencyPosId;

    @TableField(len = 32)
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int currencyId;


    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String currencyName;


    @TableField(len = 30)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String symbol;


    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    //标志图
    private String logoUrl;


    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    //当前价格
    private double currentPrice;


    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    //价格变化
    private double priceChange;


    @TableField(len = 32)
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long volume;


    @TableField(len = 64,pointLen = 8)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double marketCap;


    @TableField(len = 32,pointLen = 8)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    //回报率
    private double roi;

    @TableField(len = 20)
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int nodeNum;


    @TableField(len = 32)
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int requiredNum;


    @TableField(len = 32,pointLen = 8)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    //回报率
    private double mnWorth;


    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long createTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long updateTime;


    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    //这个时间是当前批的时间,当前批次都是一样的
    private long batchTime;


    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    //来源网站
    private String infoUrl;


    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    //详情链接
    private String detailLink;
















}
