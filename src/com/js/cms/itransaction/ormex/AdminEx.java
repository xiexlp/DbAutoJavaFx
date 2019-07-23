package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:11:52"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class AdminEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int adminId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String username;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String password;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String pwdShow;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 30)
    private int groupId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 50)
    private String groupName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 255)
    private String nav;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


Map<String,Object> map=null;

public AdminEx(){}

public int getAdminId(){
return adminId;
}

public void setAdminId(int adminId){
this.adminId = adminId;
}
public String getUsername(){
return username;
}

public void setUsername(String username){
this.username = username;
}
public String getPassword(){
return password;
}

public void setPassword(String password){
this.password = password;
}
public String getPwdShow(){
return pwdShow;
}

public void setPwdShow(String pwdShow){
this.pwdShow = pwdShow;
}
public String getNav(){
return nav;
}

public void setNav(String nav){
this.nav = nav;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("admin_id",this.getAdminId());
        map.put("username",this.getUsername());
        map.put("password",this.getPassword());
        map.put("pwd_show",this.getPwdShow());
        map.put("nav",this.getNav());
        map.put("status",this.getStatus());
    }
return map;
}


}