package com.js.cms.ormex;

/**
 * last update time:"17-04-30 10:50:04" 
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;

public class BlogdepartEx{

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
            private int departId;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String name;
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String departDesc;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
            private long createTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
            private long updateTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
            private int parentId;
        
    public BlogdepartEx(){}

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public String getName(){
            return name;
        }
        
        public void setName(String name){
            this.name = name;
        }
            public String getDepartDesc(){
            return departDesc;
        }
        
        public void setDepartDesc(String departDesc){
            this.departDesc = departDesc;
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
            public int getParentId(){
            return parentId;
        }
        
        public void setParentId(int parentId){
            this.parentId = parentId;
        }
        
}