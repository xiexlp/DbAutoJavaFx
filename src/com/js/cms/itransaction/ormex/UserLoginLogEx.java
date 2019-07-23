package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-09 14:05:16"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class UserLoginLogEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int userLoginLogId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 10)
    private int userId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 50)
    private String username;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
        @TableField(len = 20)
    private long loginTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 1)
    private int loginType;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 100)
    private String loginIp;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 1)
    private int login;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 200)
    private String loginTerminalType;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 100)
    private String loginDesc;


Map<String,Object> map=null;

public UserLoginLogEx(){}

public int getUserLoginLogId(){
return userLoginLogId;
}

public void setUserLoginLogId(int userLoginLogId){
this.userLoginLogId = userLoginLogId;
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
public long getLoginTime(){
return loginTime;
}

public void setLoginTime(long loginTime){
this.loginTime = loginTime;
}
public int getLoginType(){
return loginType;
}

public void setLoginType(int loginType){
this.loginType = loginType;
}
public String getLoginIp(){
return loginIp;
}

public void setLoginIp(String loginIp){
this.loginIp = loginIp;
}
public int getLogin(){
return login;
}

public void setLogin(int login){
this.login = login;
}
public String getLoginTerminalType(){
return loginTerminalType;
}

public void setLoginTerminalType(String loginTerminalType){
this.loginTerminalType = loginTerminalType;
}
public String getLoginDesc(){
return loginDesc;
}

public void setLoginDesc(String loginDesc){
this.loginDesc = loginDesc;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("user_login_log_id",this.getUserLoginLogId());
        map.put("user_id",this.getUserId());
        map.put("username",this.getUsername());
        map.put("login_time",this.getLoginTime());
        map.put("login_type",this.getLoginType());
        map.put("login_ip",this.getLoginIp());
        map.put("login",this.getLogin());
        map.put("login_terminal_type",this.getLoginTerminalType());
        map.put("login_desc",this.getLoginDesc());
    }
return map;
}


}