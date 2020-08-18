package com.kangpei.dynamic.annotation;

import com.kangpei.dynamic.constant.DSConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description: DS <br>
 * date: 2020/8/18 11:17 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DS {

    String value() default DSConstant.MASTER;
}
