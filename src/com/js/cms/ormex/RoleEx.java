package com.js.cms.ormex;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class RoleEx {


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 20)
    private int roleId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 150)
    private String roleName;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long createTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private long updateTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int status;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String roleDesc;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
