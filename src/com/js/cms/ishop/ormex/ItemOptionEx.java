package com.js.cms.ishop.ormex;

/**
 * last update time:"18-06-08 17:41:02"
 * last update user:pku
 */
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ItemOptionEx{


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemOptionId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private int itemName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int optionId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private int optionName;


    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String value;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int required;


    Map<String,Object> map=null;


    public void setOptionId(int optionId){
        this.optionId = optionId;
    }
    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }
    public int getRequired(){
        return required;
    }

    public void setRequired(int required){
        this.required = required;
    }




}