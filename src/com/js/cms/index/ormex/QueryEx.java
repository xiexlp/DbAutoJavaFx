package com.js.cms.index.ormex;

import com.js.common.anno.*;

public class QueryEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    long queryId;

    //用户输入的字符串分词
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableIndex
    String token;

    //用户输入的整字符串
    @TableField(len = 250)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String query;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    long createTime;


    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    long updateTime;


    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    long queryNum;


    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }


}
