package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-12 10:44:11"
* last update user:pku
*/

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class BrandEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int brandId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 50)
private String brandName;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 10)
private int manuId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 100)
private String manuName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 200)
private String brief;


@TableFieldType(fieldType = TableFieldType.TYPE.BIGINT)
@TableField(len = 20)
private long createTime;


Map<String,Object> map=null;

public BrandEx(){}

public int getBrandId(){
return brandId;
}

public void setBrandId(int brandId){
this.brandId = brandId;
}
public String getBrandName(){
return brandName;
}

public void setBrandName(String brandName){
this.brandName = brandName;
}
public int getManuId(){
return manuId;
}

public void setManuId(int manuId){
this.manuId = manuId;
}
public String getManuName(){
return manuName;
}

public void setManuName(String manuName){
this.manuName = manuName;
}
public String getBrief(){
return brief;
}

public void setBrief(String brief){
this.brief = brief;
}
public long getCreateTime(){
return createTime;
}

public void setCreateTime(long createTime){
this.createTime = createTime;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("brand_id",this.getBrandId());
        map.put("brand_name",this.getBrandName());
        map.put("manu_id",this.getManuId());
        map.put("manu_name",this.getManuName());
        map.put("brief",this.getBrief());
        map.put("create_time",this.getCreateTime());
    }
return map;
}


}