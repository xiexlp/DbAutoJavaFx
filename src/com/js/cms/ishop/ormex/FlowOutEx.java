package com.js.cms.ishop.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class FlowOutEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int flowOutId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 50)
    private int transferId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 50)
    private int userId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 50)
    private int accountId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 50)
    private String username;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 50)
    private int toAccountId;

    /**
     * 下个中转站
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 50)
    private int toUserId;

    /**
     * 下个中转站用户名
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 50)
    private String toUsername;


    /**
     * 最终目的地用户id
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 50)
    private int destUserId;


    /**
     * 最终目的地 account id
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 50)
    private int destAccountId;

    /**
     * 最终目的地用户名
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 50)
    private String destUsername;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 50)
    private int currencyId;


    /**
     * 订单号
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long orderId;


    /**
     * 订单号
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 32)
    private double value;

    /**
     * 货币符号，如 yuan,dollar,eth等
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 20)
    private String symbol;


    /**
     * 创建时间
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long createTime;

    /**
     * 创建时间
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long updateTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    //附加说明
    private String flowOutDesc;


    /**
     * 状态，是否成功
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 4)
    private long dealStatus;

    /**
     * 状态，是什么类型转账，购物，账户到信用账户，信用账户到账户，还是账户到账户
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 4)
    private int flowType;





}
