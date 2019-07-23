package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:21:10"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class InformationEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int informationId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 1)
private int bottom;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 3)
private int sortOrder;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
@TableField(len = 1)
private int status;

    @TableFieldType(fieldType = TableFieldType.TYPE.MEDIUMTEXT)
    //@TableField(len = 65535)
    private int infoDesc;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private int title;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private int meteTitle;

Map<String,Object> map=null;

public InformationEx(){}

public int getInformationId(){
return informationId;
}

public void setInformationId(int informationId){
this.informationId = informationId;
}
public int getBottom(){
return bottom;
}

public void setBottom(int bottom){
this.bottom = bottom;
}
public int getSortOrder(){
return sortOrder;
}

public void setSortOrder(int sortOrder){
this.sortOrder = sortOrder;
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
        map.put("information_id",this.getInformationId());
        map.put("bottom",this.getBottom());
        map.put("sort_order",this.getSortOrder());
        map.put("status",this.getStatus());
    }
return map;
}


}