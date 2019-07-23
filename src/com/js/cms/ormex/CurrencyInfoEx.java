package com.js.cms.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CurrencyInfoEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int currencyId;

    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String name;


    @TableField(len = 30)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String symbol;


    @TableField(len = 32)
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long volume;

    @TableField(len = 32)
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long circulatingVolume;

    @TableField(len = 20,pointLen = 10)
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    private double initPrice;


    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 20)
    private long initDate;


    @TableField(len = 64)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String url;


    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String currencyDesc;


    //0:coinmarketcap
    //1:masternode
    @TableField(len = 2)
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int srcWebId;


    //作为唯一标志的名称
    @TableField(len = 64)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String currencyIdName;


    //作为唯一标志的名称
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String detailLink;


    //作为唯一标志的名称
    //在masteronline中的详情链接
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String masterLink;




}
