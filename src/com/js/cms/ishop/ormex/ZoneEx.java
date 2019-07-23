package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:41:44"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ZoneEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int zoneId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int countryId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String code;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int status;


Map<String,Object> map=null;

public ZoneEx(){}

public int getZoneId(){
return zoneId;
}

public void setZoneId(int zoneId){
this.zoneId = zoneId;
}
public int getCountryId(){
return countryId;
}

public void setCountryId(int countryId){
this.countryId = countryId;
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
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("zone_id",this.getZoneId());
        map.put("country_id",this.getCountryId());
        map.put("name",this.getName());
        map.put("code",this.getCode());
        map.put("status",this.getStatus());
    }
return map;
}


}