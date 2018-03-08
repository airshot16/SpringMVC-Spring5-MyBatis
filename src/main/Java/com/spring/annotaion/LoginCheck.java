package com.spring.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 检查接口权限与用户权限是否匹配
 */
// 注解保留到运行时
@Retention(RetentionPolicy.RUNTIME)
// 对方法生效
@Target(ElementType.METHOD)
public @interface LoginCheck {
    // api的名字
    String apiName() default "default";
}
