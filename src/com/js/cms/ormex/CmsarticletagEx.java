package com.js.cms.ormex;

/**
 * last update time:"17-01-11 11:14:05" 
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CmsarticletagEx {
    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int articleTagId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int articleId;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private int title;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int cmstagId;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long createTime;
    //关联的人
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int userId;



    public CmsarticletagEx(){}

    public int getArticleTagId() {
        return articleTagId;
    }

    public void setArticleTagId(int articleTagId) {
        this.articleTagId = articleTagId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }


    public int getCmstagId() {
        return cmstagId;
    }

    public void setCmstagId(int cmstagId) {
        this.cmstagId = cmstagId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}