package com.js.cms.ishop.ormex;

/**
* last update time:"18-07-16 16:34:51"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class CategoryDescriptionEx{


    @AutoIncrement
    @PrimaryKey
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int categoryLanguageId;



@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int categoryId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int languageId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String name;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String description;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String metaTitle;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String metaDescription;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String metaKeyword;


Map<String,Object> map=null;

public CategoryDescriptionEx(){}

public int getCategoryId(){
return categoryId;
}

public void setCategoryId(int categoryId){
this.categoryId = categoryId;
}
public int getLanguageId(){
return languageId;
}

public void setLanguageId(int languageId){
this.languageId = languageId;
}
public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}
public String getDescription(){
return description;
}

public void setDescription(String description){
this.description = description;
}
public String getMetaTitle(){
return metaTitle;
}

public void setMetaTitle(String metaTitle){
this.metaTitle = metaTitle;
}
public String getMetaDescription(){
return metaDescription;
}

public void setMetaDescription(String metaDescription){
this.metaDescription = metaDescription;
}
public String getMetaKeyword(){
return metaKeyword;
}

public void setMetaKeyword(String metaKeyword){
this.metaKeyword = metaKeyword;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("category_id",this.getCategoryId());
        map.put("language_id",this.getLanguageId());
        map.put("name",this.getName());
        map.put("description",this.getDescription());
        map.put("meta_title",this.getMetaTitle());
        map.put("meta_description",this.getMetaDescription());
        map.put("meta_keyword",this.getMetaKeyword());
    }
return map;
}


}