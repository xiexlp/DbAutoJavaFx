package com.js.common.anno;

import java.lang.annotation.*;

/**
 * 水果名称注解
 * @author peida
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrimaryKey {
    boolean value() default true;
}