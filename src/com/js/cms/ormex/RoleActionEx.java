package com.js.cms.ormex;

import com.js.common.anno.*;

public class RoleActionEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 20)
    private int roleActionId;

    @TableIndex
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int roleId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 60)
    private int roleName;

    @TableIndex
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int actionId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 60)
    private int actionName;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private int createTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private int updateTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private int endTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int status;


    public int getRoleActionId() {
        return roleActionId;
    }

    public void setRoleActionId(int roleActionId) {
        this.roleActionId = roleActionId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleName() {
        return roleName;
    }

    public void setRoleName(int roleName) {
        this.roleName = roleName;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public int getActionName() {
        return actionName;
    }

    public void setActionName(int actionName) {
        this.actionName = actionName;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
