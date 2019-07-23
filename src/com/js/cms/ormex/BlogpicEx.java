package com.js.cms.ormex;

/**
 * last update time:"17-06-21 15:01:11" 
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class BlogpicEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int picId;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String name;
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String filename;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String relUrl;
    @TableField(len = 150)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String absUrl;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int userId;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String username;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int type;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int credits;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long fileSize;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String dateDir;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long createTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long updateTime;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String originalUrl;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String md5;
    @TableField(len = 150)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String picDesc;

    public BlogpicEx(){}

            public int getPicId(){
            return picId;
        }
        
        public void setPicId(int picId){
            this.picId = picId;
        }
            public String getName(){
            return name;
        }
        
        public void setName(String name){
            this.name = name;
        }
            public String getRelUrl(){
            return relUrl;
        }
        
        public void setRelUrl(String relUrl){
            this.relUrl = relUrl;
        }
            public String getAbsUrl(){
            return absUrl;
        }
        
        public void setAbsUrl(String absUrl){
            this.absUrl = absUrl;
        }
            public int getUserId(){
            return userId;
        }
        
        public void setUserId(int userId){
            this.userId = userId;
        }
            public String getUsername(){
            return username;
        }
        
        public void setUsername(String username){
            this.username = username;
        }
            public int getType(){
            return type;
        }
        
        public void setType(int type){
            this.type = type;
        }
            public int getCredits(){
            return credits;
        }
        
        public void setCredits(int credits){
            this.credits = credits;
        }
            public long getFileSize(){
            return fileSize;
        }
        
        public void setFileSize(long fileSize){
            this.fileSize = fileSize;
        }
            public String getDateDir(){
            return dateDir;
        }
        
        public void setDateDir(String dateDir){
            this.dateDir = dateDir;
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
            public String getOriginalUrl(){
            return originalUrl;
        }
        
        public void setOriginalUrl(String originalUrl){
            this.originalUrl = originalUrl;
        }
            public String getMd5(){
            return md5;
        }
        
        public void setMd5(String md5){
            this.md5 = md5;
        }
            public String getPicDesc(){
            return picDesc;
        }
        
        public void setPicDesc(String picDesc){
            this.picDesc = picDesc;
        }
        
}