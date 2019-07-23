package com.js.cms.ishop.ormex;

/**
 * last update time:"18-06-08 17:40:48"
 * last update user:pku
 */
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/***
 * 注意，这个类修改较大
 */
public class ItemAttrEx{


    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @AutoIncrement
    @TableField(len = 11)
    private int itemAttrId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int itemId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 100)
    private String itemName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int attrId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String attrName;


//    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
//    @TableField(len = 11)
//    private int languageId;

    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String text;

    Map<String,Object> map=null;


    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }



}