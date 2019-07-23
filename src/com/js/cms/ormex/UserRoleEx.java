package com.js.cms.ormex;

import com.js.common.anno.*;


public class UserRoleEx {

    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 20)
    private int userRoleId;

    @TableIndex
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int userId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 60)
    private int userName;

    @TableIndex
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int roleId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 60)
    private int roleName;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private int createTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private int updateTime;

    //当前时间
    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private int startTime;

    @TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
    @TableField(len = 32)
    private int endTime;

    //0,表示不可用，1表示可用，2，表示有效期
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int status;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private int userRoleDesc;

    //以天数计算
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 20)
    private int daySpan;

    //以月数计算
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 20)
    private int monthSpan;

    //以月数计算还是按年算的类型
    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int spanType;

    //@TableIndex
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 30)
    private int lastOrderId;

    //@TableIndex
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 30)
    private int lastProductId;


    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
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

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
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

    public int getUserRoleDesc() {
        return userRoleDesc;
    }

    public void setUserRoleDesc(int userRoleDesc) {
        this.userRoleDesc = userRoleDesc;
    }

    public int getLastOrderId() {
        return lastOrderId;
    }

    public void setLastOrderId(int lastOrderId) {
        this.lastOrderId = lastOrderId;
    }

    public int getLastProductId() {
        return lastProductId;
    }

    public void setLastProductId(int lastProductId) {
        this.lastProductId = lastProductId;
    }
}
