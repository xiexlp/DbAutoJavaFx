package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:25:02"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class NavEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int navId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String navName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String navE;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String navUrl;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String catId;


Map<String,Object> map=null;

public NavEx(){}

public int getNavId(){
return navId;
}

public void setNavId(int navId){
this.navId = navId;
}
public String getNavName(){
return navName;
}

public void setNavName(String navName){
this.navName = navName;
}
public String getNavE(){
return navE;
}

public void setNavE(String navE){
this.navE = navE;
}
public String getNavUrl(){
return navUrl;
}

public void setNavUrl(String navUrl){
this.navUrl = navUrl;
}
public String getCatId(){
return catId;
}

public void setCatId(String catId){
this.catId = catId;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("nav_id",this.getNavId());
        map.put("nav_name",this.getNavName());
        map.put("nav_e",this.getNavE());
        map.put("nav_url",this.getNavUrl());
        map.put("cat_id",this.getCatId());
    }
return map;
}


}