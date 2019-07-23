package com.js.cms.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class UserSearchLogEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int userSearchLogId;

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
    private long searchTime;



    /**
     * 登录ip
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private String searchIp;



    /**
     * 登录终端类型
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 200)
    private  String searchTerminalType;


    /**
     * 登录描述
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private String searchDesc;

    /**
     * 登录描述
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 400)
    private String query;


}
