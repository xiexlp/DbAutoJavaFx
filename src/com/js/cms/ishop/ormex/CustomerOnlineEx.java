package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:20:04"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CustomerOnlineEx{


    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 40)
    private String customerOnlineId;

@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 40)
private String ip;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String customName;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String url;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String referer;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


Map<String,Object> map=null;

public CustomerOnlineEx(){}

public String getIp(){
return ip;
}

public void setIp(String ip){
this.ip = ip;
}
public int getCustomerId(){
return customerId;
}

public void setCustomerId(int customerId){
this.customerId = customerId;
}
public String getUrl(){
return url;
}

public void setUrl(String url){
this.url = url;
}
public String getReferer(){
return referer;
}

public void setReferer(String referer){
this.referer = referer;
}
public Timestamp getDateAdded(){
return dateAdded;
}

public void setDateAdded(Timestamp dateAdded){
this.dateAdded = dateAdded;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("ip",this.getIp());
        map.put("customer_id",this.getCustomerId());
        map.put("url",this.getUrl());
        map.put("referer",this.getReferer());
        map.put("date_added",this.getDateAdded());
    }
return map;
}


}