package com.js.cms.index.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class QueryLogEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    long logId;

    //用户输入的字符串
    @TableField(len = 250)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String query;


    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    long createTime;

    //用户地址
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String ip;

    //用户终端类型
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String terminal;

    //从哪个网站输入进来的请求
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String webUrl;

    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    long indexStatus;


}
