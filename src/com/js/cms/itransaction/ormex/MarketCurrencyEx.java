package com.js.cms.itransaction.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class MarketCurrencyEx {


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int marketCurrencyId;

    // eth/btc
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String marketCurrencyName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int currencyId;

    //kcs等等
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String currencyName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int marketId;

    //btc等等
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String marketName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int baseCurrencyId;

    //btc,eth等等
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String baseCurrencyName;

    //当前价格
    @TableFieldType(fieldType = TableFieldType.TYPE.FLOAT)
    @TableField(len = 64,pointLen= 8)
    private double price;

    //当前价格
    @TableFieldType(fieldType = TableFieldType.TYPE.FLOAT)
    @TableField(len = 64,pointLen= 8)
    private double priceUp;


    //当前价格
    @TableFieldType(fieldType = TableFieldType.TYPE.FLOAT)
    @TableField(len = 64,pointLen= 8)
    private double priceDown;


    //1运行中
    //2停牌
    //3下架
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int status;

}
