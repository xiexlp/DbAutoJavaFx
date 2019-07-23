package com.js.cms.ishop.ormex;

/**
 * last update time:"18-06-08 17:44:34"
 * last update user:pku
 */

import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CityEx{


    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int cityId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int zoneId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String zoneName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int upId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 128)
    private String name;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int status;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 3)
    private int sortOrder;

    Map<String,Object> map=null;

    public CityEx(){}

    public int getCityId(){
        return cityId;
    }

    public void setCityId(int cityId){
        this.cityId = cityId;
    }
    public int getZoneId(){
        return zoneId;
    }

    public void setZoneId(int zoneId){
        this.zoneId = zoneId;
    }
    public int getUpId(){
        return upId;
    }

    public void setUpId(int upId){
        this.upId = upId;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public int getStatus(){
        return status;
    }

    public void setStatus(int status){
        this.status = status;
    }
    public int getSortOrder(){
        return sortOrder;
    }

    public void setSortOrder(int sortOrder){
        this.sortOrder = sortOrder;
    }

    public Map toMap(){
        if(map==null){
            map = new HashMap();
            map.put("city_id",this.getCityId());
            map.put("zone_id",this.getZoneId());
            map.put("up_id",this.getUpId());
            map.put("name",this.getName());
            map.put("status",this.getStatus());
            map.put("sort_order",this.getSortOrder());
        }
        return map;
    }


}