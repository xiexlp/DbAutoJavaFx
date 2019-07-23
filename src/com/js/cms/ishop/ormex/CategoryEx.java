package com.js.cms.ishop.ormex;

/**
 * last update time:"18-06-08 17:44:25"
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CategoryEx{


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int categoryId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String image;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int parentId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String parentName;

    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int top;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 3)
    private int column;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 3)
    private int sortOrder;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 20)
    private int sellerId;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int status;


    @TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
    private Timestamp dateAdded;


    @TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
    private Timestamp dateModified;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String name;

    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    @TableField(len = 0)
    private String cateDesc;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String metaTitle;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String metaKeyword;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String path;





    Map<String,Object> map=null;

    public CategoryEx(){}

    public int getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }
    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }
    public int getParentId(){
        return parentId;
    }

    public void setParentId(int parentId){
        this.parentId = parentId;
    }
    public int getTop(){
        return top;
    }

    public void setTop(int top){
        this.top = top;
    }
    public int getColumn(){
        return column;
    }

    public void setColumn(int column){
        this.column = column;
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
    public Timestamp getDateAdded(){
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded){
        this.dateAdded = dateAdded;
    }
    public Timestamp getDateModified(){
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified){
        this.dateModified = dateModified;
    }

    public Map toMap(){
        if(map==null){
            map = new HashMap();
            map.put("category_id",this.getCategoryId());
            map.put("image",this.getImage());
            map.put("parent_id",this.getParentId());
            map.put("top",this.getTop());
            map.put("column",this.getColumn());
            map.put("sort_order",this.getSortOrder());
            map.put("status",this.getStatus());
            map.put("date_added",this.getDateAdded());
            map.put("date_modified",this.getDateModified());
        }
        return map;
    }


}