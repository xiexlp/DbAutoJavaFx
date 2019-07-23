package com.js.cms.index.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class DocEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    long docId;
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String title;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    int titleSize;
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.MEDIUMTEXT)
    String body;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    int bodySize;

    @TableField(len = 60)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String tablename;
    //ejf_topic
    @TableField(len = 60)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String dbname;

    //content
    @TableField(len = 60)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String fieldname;

    //topicId
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    int fieldId;

    // localhost/链接
    @TableField(len = 60)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    //这个地方显示文档的相对地址
    String url;

    //localhost
    @TableField(len = 60)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    //这个地方显示文档的相对地址
    String host;

    //createTime
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    long createTime;

    //updateTime
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    long updateTime;

    //0为index,1已经indexed
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String indexStatus;

    //0,代表未索引，1,代表部分字段索引，2,代表所有字段已经索引
    //@TableField(type = "varchar",len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    int indexStage;




    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(int titleSize) {
        this.titleSize = titleSize;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getBodySize() {
        return bodySize;
    }

    public void setBodySize(int bodySize) {
        this.bodySize = bodySize;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getIndexStatus() {
        return indexStatus;
    }

    public void setIndexStatus(String indexStatus) {
        this.indexStatus = indexStatus;
    }




}
