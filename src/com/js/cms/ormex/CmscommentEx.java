package com.js.cms.ormex;

/**
 * last update time:"17-01-11 11:16:47" 
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;

public class CmscommentEx{

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int commentId;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int userId;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String username;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int attaches;
    @TableField(len = 2000)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String content;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long createTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int isBest;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int isHidePost;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String remoteIp;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int state;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int comments;
    @TableField(len = 150)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String title;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long updateTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int pcommentId;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int pcommentUserId;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int articleId;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int categoryId;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int articleUserId;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int commentType;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int reward;
        
    public CmscommentEx(){}

            public int getCommentId(){
            return commentId;
        }
        
        public void setCommentId(int commentId){
            this.commentId = commentId;
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
            public int getAttaches(){
            return attaches;
        }
        
        public void setAttaches(int attaches){
            this.attaches = attaches;
        }
            public String getContent(){
            return content;
        }
        
        public void setContent(String content){
            this.content = content;
        }
            public long getCreateTime(){
            return createTime;
        }
        
        public void setCreateTime(long createTime){
            this.createTime = createTime;
        }
            public int getIsBest(){
            return isBest;
        }
        
        public void setIsBest(int isBest){
            this.isBest = isBest;
        }
            public int getIsHidePost(){
            return isHidePost;
        }
        
        public void setIsHidePost(int isHidePost){
            this.isHidePost = isHidePost;
        }
            public String getRemoteIp(){
            return remoteIp;
        }
        
        public void setRemoteIp(String remoteIp){
            this.remoteIp = remoteIp;
        }
            public int getState(){
            return state;
        }
        
        public void setState(int state){
            this.state = state;
        }
            public int getComments(){
            return comments;
        }
        
        public void setComments(int comments){
            this.comments = comments;
        }
            public String getTitle(){
            return title;
        }
        
        public void setTitle(String title){
            this.title = title;
        }
            public long getUpdateTime(){
            return updateTime;
        }
        
        public void setUpdateTime(long updateTime){
            this.updateTime = updateTime;
        }


    public int getPcommentId() {
        return pcommentId;
    }

    public void setPcommentId(int pcommentId) {
        this.pcommentId = pcommentId;
    }

    public int getPcommentUserId() {
        return pcommentUserId;
    }

    public void setPcommentUserId(int pcommentUserId) {
        this.pcommentUserId = pcommentUserId;
    }

    public int getArticleId(){
            return articleId;
        }
        
        public void setArticleId(int articleId){
            this.articleId = articleId;
        }
            public int getCategoryId(){
            return categoryId;
        }
        
        public void setCategoryId(int categoryId){
            this.categoryId = categoryId;
        }
            public int getArticleUserId(){
            return articleUserId;
        }
        
        public void setArticleUserId(int articleUserId){
            this.articleUserId = articleUserId;
        }
            public int getCommentType(){
            return commentType;
        }
        
        public void setCommentType(int commentType){
            this.commentType = commentType;
        }
            public int getReward(){
            return reward;
        }
        
        public void setReward(int reward){
            this.reward = reward;
        }
        
}