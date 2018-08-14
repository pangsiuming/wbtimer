package com.eshore.wbtimer.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 描述: Spring上下文工具类
 *
 * @author Yangjinming
 * @create 2018-01-02 15:05
 */
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取Spring上下文
     *
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 通过beanName获取bean对象
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    public static Object getBean(String beanName) throws BeansException{
        return applicationContext.getBean(beanName);
    }
}
