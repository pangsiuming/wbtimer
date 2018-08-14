package com.eshore.wbtimer.admin.controller.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述:权限限制
 *
 * @author Yangjinming
 * @create 2018-01-10 16:30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionLimit {

    /**
     * 登录拦截
     *
     * @return
     */
    boolean limit() default true;
}
