package com.js.cms.itransaction.ormex;

/**
* last update time:"19-04-08 11:20:25"
* last update user:pku
*/

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

public class ArticleEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int articleId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 32)
    private int positionId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 64)
    private String title;


@TableFieldType(fieldType = TableFieldType.TYPE.MEDIUMTEXT)
private String content;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String addTime;


@TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
        @TableField(len = 4)
    private int status;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
        @TableField(len = 32)
    private String type;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
        @TableField(len = 4)
    private int sign;


Map<String,Object> map=null;

public ArticleEx(){}

public int getArticleId(){
return articleId;
}

public void setArticleId(int articleId){
this.articleId = articleId;
}
public int getPositionId(){
return positionId;
}

public void setPositionId(int positionId){
this.positionId = positionId;
}
public String getTitle(){
return title;
}

public void setTitle(String title){
this.title = title;
}
public String getContent(){
return content;
}

public void setContent(String content){
this.content = content;
}
public String getAddTime(){
return addTime;
}

public void setAddTime(String addTime){
this.addTime = addTime;
}
public int getStatus(){
return status;
}

public void setStatus(int status){
this.status = status;
}
public String getType(){
return type;
}

public void setType(String type){
this.type = type;
}
public int getSign(){
return sign;
}

public void setSign(int sign){
this.sign = sign;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("article_id",this.getArticleId());
        map.put("position_id",this.getPositionId());
        map.put("title",this.getTitle());
        map.put("content",this.getContent());
        map.put("add_time",this.getAddTime());
        map.put("status",this.getStatus());
        map.put("type",this.getType());
        map.put("sign",this.getSign());
    }
return map;
}


}