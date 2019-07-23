package com.js.cms.ishop.ormex;

/**
* last update time:"18-07-12 10:17:40"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class UserEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int userId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int id;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 100)
private String avatar;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
@TableField(len = 20)
private long birth;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 200)
private String brief;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 30)
private String city;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
@TableField(len = 20)
private long createTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int credits;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int deposit;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 50)
private String email;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int gender;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int groupId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 30)
private String icq;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 10)
private String isMailPub;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
@TableField(len = 20)
private long lastVisited;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int loginCount;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
@TableField(len = 20)
private long loginExpire;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 30)
private String nickname;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int posts;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 30)
private String pwd;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 50)
private String remoteIp;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
@TableField(len = 20)
private long setpwdExpire;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 10)
private String state;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int unreadSms;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
@TableField(len = 20)
private long updateTime;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int visitCount;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 100)
private String webpage;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 30)
private String mobilePhone;

//在新建的时候自动生成
@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 30)
private String salt;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 30)
private String username;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int blogs;

    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 2)
    //商户，或者用户
    private int userType;


Map<String,Object> map=null;

public UserEx(){}

public int getUserId(){
return userId;
}

public void setUserId(int userId){
this.userId = userId;
}
public int getId(){
return id;
}

public void setId(int id){
this.id = id;
}
public String getAvatar(){
return avatar;
}

public void setAvatar(String avatar){
this.avatar = avatar;
}
public long getBirth(){
return birth;
}

public void setBirth(long birth){
this.birth = birth;
}
public String getBrief(){
return brief;
}

public void setBrief(String brief){
this.brief = brief;
}
public String getCity(){
return city;
}

public void setCity(String city){
this.city = city;
}
public long getCreateTime(){
return createTime;
}

public void setCreateTime(long createTime){
this.createTime = createTime;
}
public int getCredits(){
return credits;
}

public void setCredits(int credits){
this.credits = credits;
}
public int getDeposit(){
return deposit;
}

public void setDeposit(int deposit){
this.deposit = deposit;
}
public String getEmail(){
return email;
}

public void setEmail(String email){
this.email = email;
}
public int getGender(){
return gender;
}

public void setGender(int gender){
this.gender = gender;
}
public int getGroupId(){
return groupId;
}

public void setGroupId(int groupId){
this.groupId = groupId;
}
public String getIcq(){
return icq;
}

public void setIcq(String icq){
this.icq = icq;
}
public String getIsMailPub(){
return isMailPub;
}

public void setIsMailPub(String isMailPub){
this.isMailPub = isMailPub;
}
public long getLastVisited(){
return lastVisited;
}

public void setLastVisited(long lastVisited){
this.lastVisited = lastVisited;
}
public int getLoginCount(){
return loginCount;
}

public void setLoginCount(int loginCount){
this.loginCount = loginCount;
}
public long getLoginExpire(){
return loginExpire;
}

public void setLoginExpire(long loginExpire){
this.loginExpire = loginExpire;
}
public String getNickname(){
return nickname;
}

public void setNickname(String nickname){
this.nickname = nickname;
}
public int getPosts(){
return posts;
}

public void setPosts(int posts){
this.posts = posts;
}
public String getPwd(){
return pwd;
}

public void setPwd(String pwd){
this.pwd = pwd;
}
public String getRemoteIp(){
return remoteIp;
}

public void setRemoteIp(String remoteIp){
this.remoteIp = remoteIp;
}
public long getSetpwdExpire(){
return setpwdExpire;
}

public void setSetpwdExpire(long setpwdExpire){
this.setpwdExpire = setpwdExpire;
}
public String getState(){
return state;
}

public void setState(String state){
this.state = state;
}
public int getUnreadSms(){
return unreadSms;
}

public void setUnreadSms(int unreadSms){
this.unreadSms = unreadSms;
}
public long getUpdateTime(){
return updateTime;
}

public void setUpdateTime(long updateTime){
this.updateTime = updateTime;
}
public int getVisitCount(){
return visitCount;
}

public void setVisitCount(int visitCount){
this.visitCount = visitCount;
}
public String getWebpage(){
return webpage;
}

public void setWebpage(String webpage){
this.webpage = webpage;
}
public String getMobilePhone(){
return mobilePhone;
}

public void setMobilePhone(String mobilePhone){
this.mobilePhone = mobilePhone;
}
public String getUsername(){
return username;
}

public void setUsername(String username){
this.username = username;
}
public int getBlogs(){
return blogs;
}

public void setBlogs(int blogs){
this.blogs = blogs;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("user_id",this.getUserId());
        map.put("id",this.getId());
        map.put("avatar",this.getAvatar());
        map.put("birth",this.getBirth());
        map.put("brief",this.getBrief());
        map.put("city",this.getCity());
        map.put("create_time",this.getCreateTime());
        map.put("credits",this.getCredits());
        map.put("deposit",this.getDeposit());
        map.put("email",this.getEmail());
        map.put("gender",this.getGender());
        map.put("group_id",this.getGroupId());
        map.put("icq",this.getIcq());
        map.put("is_mail_pub",this.getIsMailPub());
        map.put("last_visited",this.getLastVisited());
        map.put("login_count",this.getLoginCount());
        map.put("login_expire",this.getLoginExpire());
        map.put("nickname",this.getNickname());
        map.put("posts",this.getPosts());
        map.put("pwd",this.getPwd());
        map.put("remote_ip",this.getRemoteIp());
        map.put("setpwd_expire",this.getSetpwdExpire());
        map.put("state",this.getState());
        map.put("unread_sms",this.getUnreadSms());
        map.put("update_time",this.getUpdateTime());
        map.put("visit_count",this.getVisitCount());
        map.put("webpage",this.getWebpage());
        map.put("mobile_phone",this.getMobilePhone());
        map.put("username",this.getUsername());
        map.put("blogs",this.getBlogs());
    }
return map;
}


}