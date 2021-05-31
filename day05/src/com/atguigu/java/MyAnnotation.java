package com.atguigu.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * 自定义注解:
 *  类声明为：@interface 注解类名
 *  内部定义成员通常使用value表示
 *
 *  自定义的注解必须配上注解的信息处理流程(使用反射)才有意义
 *
 * @author Meiko
 * @create 2021-05-31 20:10
 */
@Inherited
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {

    String value() default "hello";
}
