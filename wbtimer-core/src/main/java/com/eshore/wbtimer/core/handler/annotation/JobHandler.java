package com.eshore.wbtimer.core.handler.annotation;

import java.lang.annotation.*;

/**
 * 描述: JobHandler注解（执行器执行任务注解）
 *
 * @author Yangjinming
 * @create 2018-01-10 18:54
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface JobHandler {

    String value() default "";

}

