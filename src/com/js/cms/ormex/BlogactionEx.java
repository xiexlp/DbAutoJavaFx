package com.js.cms.ormex;

/**
 * last update time:"17-03-27 11:39:51" 
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;

public class BlogactionEx{
    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
            private int actionId;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String actionName;
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String actionUrl;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String actionMethodName;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String actionLabel;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String actionKey;
    @TableField(len = 100)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String actionResource;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
            private int actionType;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
            private int actionResourceType;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
            private long createTime;
//    @TableField(type = "bigint")
//    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
//    private long updateTime;
        
    public BlogactionEx(){}

            public int getActionId(){
            return actionId;
        }
        
        public void setActionId(int actionId){
            this.actionId = actionId;
        }
            public String getActionName(){
            return actionName;
        }
        
        public void setActionName(String actionName){
            this.actionName = actionName;
        }
            public String getActionUrl(){
            return actionUrl;
        }
        
        public void setActionUrl(String actionUrl){
            this.actionUrl = actionUrl;
        }
            public String getActionMethodName(){
            return actionMethodName;
        }
        
        public void setActionMethodName(String actionMethodName){
            this.actionMethodName = actionMethodName;
        }
            public String getActionLabel(){
            return actionLabel;
        }
        
        public void setActionLabel(String actionLabel){
            this.actionLabel = actionLabel;
        }
            public String getActionKey(){
            return actionKey;
        }
        
        public void setActionKey(String actionKey){
            this.actionKey = actionKey;
        }
            public String getActionResource(){
            return actionResource;
        }
        
        public void setActionResource(String actionResource){
            this.actionResource = actionResource;
        }
            public int getActionType(){
            return actionType;
        }
        
        public void setActionType(int actionType){
            this.actionType = actionType;
        }
            public int getActionResourceType(){
            return actionResourceType;
        }
        
        public void setActionResourceType(int actionResourceType){
            this.actionResourceType = actionResourceType;
        }
            public long getCreateTime(){
            return createTime;
        }
        
        public void setCreateTime(long createTime){
            this.createTime = createTime;
        }
        
}