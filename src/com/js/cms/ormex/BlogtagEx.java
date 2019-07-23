package com.js.cms.ormex;

/**
 * last update time:"17-04-30 10:50:04" 
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class BlogtagEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
            private int blogtagId;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String name;
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String tagDesc;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
            private long createTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
            private long updateTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
            //引用文章次数
            private int referNum;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int userId;

    public BlogtagEx(){}


    public String getName(){
            return name;
        }
        
        public void setName(String name){
            this.name = name;
        }

            public long getCreateTime(){
            return createTime;
        }
        
        public void setCreateTime(long createTime){
            this.createTime = createTime;
        }
            public long getUpdateTime(){
            return updateTime;
        }
        
        public void setUpdateTime(long updateTime){
            this.updateTime = updateTime;
        }

    public int getBlogtagId() {
        return blogtagId;
    }

    public void setBlogtagId(int blogtagId) {
        this.blogtagId = blogtagId;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    public int getReferNum() {
        return referNum;
    }

    public void setReferNum(int referNum) {
        this.referNum = referNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}