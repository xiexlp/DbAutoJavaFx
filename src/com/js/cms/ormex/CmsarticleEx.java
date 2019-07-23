package com.js.cms.ormex;

/**
 * last update time:"17-01-11 11:16:39" 
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;

public class CmsarticleEx{

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int articleId;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String attachIcon;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int attaches;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int categoryId;
    //@TableField(type = "varchar",len = 250)
    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String content;
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String source;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int userId;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String username;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long createTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int diggdns;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int diggups;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String highColor;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long highExpireDate;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int isDigest;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int isHidePost;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int isReplyNotice;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int isSolved;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String lastUsername;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long lastPostTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int lastPostUserId;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String remoteIp;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int replies;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int reward;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int departId;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int specType;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int state;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    private String title;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long topExpireDate;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int topScope;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    private long updateTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int updateUserId;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    private int visits;
        
    public CmsarticleEx(){}

            public int getArticleId(){
            return articleId;
        }
        
        public void setArticleId(int articleId){
            this.articleId = articleId;
        }
            public String getAttachIcon(){
            return attachIcon;
        }
        
        public void setAttachIcon(String attachIcon){
            this.attachIcon = attachIcon;
        }
            public int getAttaches(){
            return attaches;
        }
        
        public void setAttaches(int attaches){
            this.attaches = attaches;
        }
            public int getCategoryId(){
            return categoryId;
        }
        
        public void setCategoryId(int categoryId){
            this.categoryId = categoryId;
        }
            public String getContent(){
            return content;
        }
        
        public void setContent(String content){
            this.content = content;
        }
            public String getSource(){
            return source;
        }
        
        public void setSource(String source){
            this.source = source;
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
            public long getCreateTime(){
            return createTime;
        }
        
        public void setCreateTime(long createTime){
            this.createTime = createTime;
        }
            public int getDiggdns(){
            return diggdns;
        }
        
        public void setDiggdns(int diggdns){
            this.diggdns = diggdns;
        }
            public int getDiggups(){
            return diggups;
        }
        
        public void setDiggups(int diggups){
            this.diggups = diggups;
        }
            public String getHighColor(){
            return highColor;
        }
        
        public void setHighColor(String highColor){
            this.highColor = highColor;
        }
            public long getHighExpireDate(){
            return highExpireDate;
        }
        
        public void setHighExpireDate(long highExpireDate){
            this.highExpireDate = highExpireDate;
        }
            public int getIsDigest(){
            return isDigest;
        }
        
        public void setIsDigest(int isDigest){
            this.isDigest = isDigest;
        }
            public int getIsHidePost(){
            return isHidePost;
        }
        
        public void setIsHidePost(int isHidePost){
            this.isHidePost = isHidePost;
        }
            public int getIsReplyNotice(){
            return isReplyNotice;
        }
        
        public void setIsReplyNotice(int isReplyNotice){
            this.isReplyNotice = isReplyNotice;
        }
            public int getIsSolved(){
            return isSolved;
        }
        
        public void setIsSolved(int isSolved){
            this.isSolved = isSolved;
        }
            public String getLastUsername(){
            return lastUsername;
        }
        
        public void setLastUsername(String lastUsername){
            this.lastUsername = lastUsername;
        }
            public long getLastPostTime(){
            return lastPostTime;
        }
        
        public void setLastPostTime(long lastPostTime){
            this.lastPostTime = lastPostTime;
        }
            public int getLastPostUserId(){
            return lastPostUserId;
        }
        
        public void setLastPostUserId(int lastPostUserId){
            this.lastPostUserId = lastPostUserId;
        }
            public String getRemoteIp(){
            return remoteIp;
        }
        
        public void setRemoteIp(String remoteIp){
            this.remoteIp = remoteIp;
        }
            public int getReplies(){
            return replies;
        }
        
        public void setReplies(int replies){
            this.replies = replies;
        }
            public int getReward(){
            return reward;
        }
        
        public void setReward(int reward){
            this.reward = reward;
        }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getSpecType(){
            return specType;
        }
        
        public void setSpecType(int specType){
            this.specType = specType;
        }

            public String getTitle(){
            return title;
        }
        
        public void setTitle(String title){
            this.title = title;
        }
            public long getTopExpireDate(){
            return topExpireDate;
        }
        
        public void setTopExpireDate(long topExpireDate){
            this.topExpireDate = topExpireDate;
        }

            public long getUpdateTime(){
            return updateTime;
        }
        
        public void setUpdateTime(long updateTime){
            this.updateTime = updateTime;
        }
            public int getUpdateUserId(){
            return updateUserId;
        }
        
        public void setUpdateUserId(int updateUserId){
            this.updateUserId = updateUserId;
        }
            public int getVisits(){
            return visits;
        }
        
        public void setVisits(int visits){
            this.visits = visits;
        }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTopScope() {
        return topScope;
    }

    public void setTopScope(int topScope) {
        this.topScope = topScope;
    }
}