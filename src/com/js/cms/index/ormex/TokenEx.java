package com.js.cms.index.ormex;

import com.js.common.anno.*;

public class TokenEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    int tokenId;

    @TableIndex(value = true,unique = true)
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    String token;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    int tokenSize;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    int docCount;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    int positionCount;

    //@TableField(type = "varchar",len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.MEDIUMTEXT)
    String docs;

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTokenSize() {
        return tokenSize;
    }

    public void setTokenSize(int tokenSize) {
        this.tokenSize = tokenSize;
    }

    public int getDocCount() {
        return docCount;
    }

    public void setDocCount(int docCount) {
        this.docCount = docCount;
    }
}
