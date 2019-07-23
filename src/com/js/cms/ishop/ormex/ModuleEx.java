package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:21:51"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ModuleEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int moduleId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String code;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String setting;


Map<String,Object> map=null;

public ModuleEx(){}

public int getModuleId(){
return moduleId;
}

public void setModuleId(int moduleId){
this.moduleId = moduleId;
}
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public String getCode(){
return code;
}

public void setCode(String code){
this.code = code;
}
public String getSetting(){
return setting;
}

public void setSetting(String setting){
this.setting = setting;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("module_id",this.getModuleId());
        map.put("name",this.getName());
        map.put("code",this.getCode());
        map.put("setting",this.getSetting());
    }
return map;
}


}