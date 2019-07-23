package com.js.common.anno;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableFieldType {
    /**
     * 颜色枚举
     * @author peida
     *
     */
    public enum TYPE{ VARCHAR,INT,TINYINT,BIGINT,CHAR,TEXT,MEDIUMTEXT,LONGTEXT,DOUBLE,FLOAT,DATETIME,DECIMAL,DATE,SMALLINT };
    
    /**
     * 颜色属性
     * @return
     */
    TYPE fieldType() default TYPE.VARCHAR;

}