package com.js.cms.ishop.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class BankEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int bankId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 50)
    private String bankName;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 50)
    private String cnName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 50)
    private String symbol;

    /**
     * 图片地址
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private String logo;


    /***
     * 状态是否可以使用转账之类的关闭，启用等，默认启用
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int status;




}
