package com.eshore.wbtimer.core.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-10 18:04
 */
public abstract class IJobHandler {

    /** success */
    public static final ReturnT<String> SUCCESS = new ReturnT<String>(200, null);
    /** fail */
    public static final ReturnT<String> FAIL = new ReturnT<String>(500, null);
    /** fail retry */
    public static final ReturnT<String> FAIL_RETRY = new ReturnT<String>(501, null);


    /**
     * 当调度计划请求的是反射并执行handler
     *
     * @param param
     * @return
     * @throws Exception
     */
    public abstract ReturnT<String> execute(String param) throws Exception;


    /**
     * JobThread初始化时初始化Handler
     */
    public void init() {
        // TODO
    }


    /**
     * JobThread销毁时销毁Handler
     */
    public void destroy() {
        // TODO
    }

}
