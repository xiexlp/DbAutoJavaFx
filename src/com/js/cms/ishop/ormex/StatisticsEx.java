package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:41:30"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class StatisticsEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int statisticsId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String code;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double value;


Map<String,Object> map=null;

public StatisticsEx(){}

public int getStatisticsId(){
return statisticsId;
}

public void setStatisticsId(int statisticsId){
this.statisticsId = statisticsId;
}
public String getCode(){
return code;
}

public void setCode(String code){
this.code = code;
}
public double getValue(){
return value;
}

public void setValue(double value){
this.value = value;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("statistics_id",this.getStatisticsId());
        map.put("code",this.getCode());
        map.put("value",this.getValue());
    }
return map;
}


}