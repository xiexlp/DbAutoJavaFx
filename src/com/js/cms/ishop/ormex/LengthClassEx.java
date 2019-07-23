package com.js.cms.ishop.ormex;

/**
 * last update time:"18-07-29 15:59:30"
 * last update user:pku
 */

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class LengthClassEx{


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int lengthClassId;


    @TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
    @TableField(len = 15,pointLen= 8)
    private double value;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 20)
    private String lengthName;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 26)
    private String unit;


    Map<String,Object> map=null;

    public LengthClassEx(){}

    public int getLengthClassId(){
        return lengthClassId;
    }

    public void setLengthClassId(int lengthClassId){
        this.lengthClassId = lengthClassId;
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
            map.put("length_class_id",this.getLengthClassId());
            map.put("value",this.getValue());
        }
        return map;
    }


}