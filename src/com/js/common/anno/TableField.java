package com.js.common.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果名称注解
 * @author peida
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableField {
    //String type();
    //如果有default值，就可以不用填写这个值
    int minLen() default 0;
    int maxLen() default 0;
    //如果为1，又是字符串的话则使用char
    int len() default 0;
    int pointLen() default 0;
    String nullable() default " not null";
    String value() default "";
}