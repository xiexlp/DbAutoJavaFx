package com.js.common.anno.validator;

import java.lang.annotation.*;

@Documented
//@Repeatable(LengthArray.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface Pattern {
    String value();
    String message() default "字段不符合规则";
    String regexp();
}