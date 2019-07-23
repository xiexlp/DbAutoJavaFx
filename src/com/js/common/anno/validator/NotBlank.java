package com.js.common.anno.validator;

import java.lang.annotation.*;

@Documented
@Repeatable(NotBlankArray.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface NotBlank {
    String value();
    String message() default "数据必须有内容";
}