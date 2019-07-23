package com.js.cms.index.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class PostingsEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long postingId;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long tokenId;

    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String token;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int tokenSize;

    /**
     * 文档Id
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long docId;

    /***
     * 所属表格的字段，这样可以找到文章的源
     */
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String fieldname;

    //1 标题 2 内容 3 作者 4 开始时间 5 结束时间
    @TableField(len = 1)
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int fieldnameType;

    /***
     * 所属表格
     */
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String tablename;

    /**
     * 所属数据库
     */
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String dbname;

    /**
     * 出现次数
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int frequency;

    /***
     * 出现的位置,长度先暂定为255,其实应该为text更好点
     */
    @TableField(len = 65536)
    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String positions;

    /**
     * 创建时间
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long createTime;

    /**
     * 更新时间
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long updateTime;

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
