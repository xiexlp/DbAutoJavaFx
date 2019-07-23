package com.js.cms.ormex;

/**
 * last update time:"17-01-11 11:15:11" 
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;

public class BlogdepartmentEx{
    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
            private int departmentId;
    @TableField(len = 50)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String name;
    @TableField(len = 200)
    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
            private String departDesc;
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
            private long createTime;
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    private int status;
        
    public BlogdepartmentEx(){}

            public int getDepartmentId(){
            return departmentId;
        }
        
        public void setDepartmentId(int departmentId){
            this.departmentId = departmentId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}