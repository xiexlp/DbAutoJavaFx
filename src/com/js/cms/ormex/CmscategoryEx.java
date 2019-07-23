package com.js.cms.ormex;

/**
 * last update time:"17-01-11 11:16:43" 
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;

public class CmscategoryEx{

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int categoryId;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String name;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String categoryDesc;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int level;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int hasChild;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int departId;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long createTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int pcategoryId;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int userId;
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String path;
        
    public CmscategoryEx(){}

            public int getCategoryId(){
            return categoryId;
        }
        
        public void setCategoryId(int categoryId){
            this.categoryId = categoryId;
        }
            public String getName(){
            return name;
        }
        
        public void setName(String name){
            this.name = name;
        }
            public String getCategoryDesc(){
            return categoryDesc;
        }
        
        public void setCategoryDesc(String categoryDesc){
            this.categoryDesc = categoryDesc;
        }
            public int getLevel(){
            return level;
        }
        
        public void setLevel(int level){
            this.level = level;
        }
            public int getHasChild(){
            return hasChild;
        }
        
        public void setHasChild(int hasChild){
            this.hasChild = hasChild;
        }


    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public long getCreateTime(){
            return createTime;
        }
        
        public void setCreateTime(long createTime){
            this.createTime = createTime;
        }
            public int getPcategoryId(){
            return pcategoryId;
        }
        
        public void setPcategoryId(int pcategoryId){
            this.pcategoryId = pcategoryId;
        }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}