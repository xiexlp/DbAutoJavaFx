package com.js.common.anno.validator;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface Length {
	
    String value();
    int min();
    int max();
    String message() default "数据校验不合法";
 
}