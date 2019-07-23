package com.js.cms.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

/**
 * 用户登录日志
 */
public class UserLoginLogEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int userLoginLogId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 50)
    private int userId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 50)
    private String username;


    /**
     * 登录时间
     */
    /**
     * 订单号
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long loginTime;

    /**
     * 登录类型,登录为0默认，登出1
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int loginType;

    /**
     * 登录ip
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private String loginIp;

    /**
     * 登录方式
     * 通过用户提交登录还是系统自动登录
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int login;

    /**
     * 登录终端类型
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 200)
    private  String loginTerminalType;


    /**
     * 登录描述
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private String loginDesc;




}
