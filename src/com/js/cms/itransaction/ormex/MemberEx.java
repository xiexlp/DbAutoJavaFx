package com.js.cms.itransaction.ormex;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class MemberEx {


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int memberId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 128)
    private String openid;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 30)
    private int groupId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 50)
    private String groupName;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String email;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String pwd;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String pid;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String pwdtrade;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String nick;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String name;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 4)
    private String cardtype;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 20)
    private String idcard;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 11)
    private String phone;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String ip;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 32)
    private int regTime;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String loginIp;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int loginTime;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int vipLevel;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int vipEndTime;


    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 20, pointLen = 4)
    private double rmb;


    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 20, pointLen = 4)
    private double forzenRmb;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String head;


    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String profile;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int province;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 10)
    private int city;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String job;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 2)
    private int isLock;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 4)
    private int status;


    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 10, pointLen = 4)
    private double dividendNum;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String threepwd;


    Map<String, Object> map = null;

    public MemberEx() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPwdtrade() {
        return pwdtrade;
    }

    public void setPwdtrade(String pwdtrade) {
        this.pwdtrade = pwdtrade;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getRegTime() {
        return regTime;
    }

    public void setRegTime(int regTime) {
        this.regTime = regTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public int getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(int loginTime) {
        this.loginTime = loginTime;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public int getVipEndTime() {
        return vipEndTime;
    }

    public void setVipEndTime(int vipEndTime) {
        this.vipEndTime = vipEndTime;
    }

    public double getRmb() {
        return rmb;
    }

    public void setRmb(double rmb) {
        this.rmb = rmb;
    }

    public double getForzenRmb() {
        return forzenRmb;
    }

    public void setForzenRmb(double forzenRmb) {
        this.forzenRmb = forzenRmb;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getIsLock() {
        return isLock;
    }

    public void setIsLock(int isLock) {
        this.isLock = isLock;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getDividendNum() {
        return dividendNum;
    }

    public void setDividendNum(double dividendNum) {
        this.dividendNum = dividendNum;
    }

    public String getThreepwd() {
        return threepwd;
    }

    public void setThreepwd(String threepwd) {
        this.threepwd = threepwd;
    }

    public Map toMap() {
        if (map == null) {
            map = new HashMap();
            map.put("member_id", this.getMemberId());
            map.put("openid", this.getOpenid());
            map.put("email", this.getEmail());
            map.put("pwd", this.getPwd());
            map.put("pid", this.getPid());
            map.put("pwdtrade", this.getPwdtrade());
            map.put("nick", this.getNick());
            map.put("name", this.getName());
            map.put("cardtype", this.getCardtype());
            map.put("idcard", this.getIdcard());
            map.put("phone", this.getPhone());
            map.put("ip", this.getIp());
            map.put("reg_time", this.getRegTime());
            map.put("login_ip", this.getLoginIp());
            map.put("login_time", this.getLoginTime());
            map.put("vip_level", this.getVipLevel());
            map.put("vip_end_time", this.getVipEndTime());
            map.put("rmb", this.getRmb());
            map.put("forzen_rmb", this.getForzenRmb());
            map.put("head", this.getHead());
            map.put("profile", this.getProfile());
            map.put("province", this.getProvince());
            map.put("city", this.getCity());
            map.put("job", this.getJob());
            map.put("is_lock", this.getIsLock());
            map.put("status", this.getStatus());
            map.put("dividend_num", this.getDividendNum());
            map.put("threepwd", this.getThreepwd());
        }
        return map;
    }


}