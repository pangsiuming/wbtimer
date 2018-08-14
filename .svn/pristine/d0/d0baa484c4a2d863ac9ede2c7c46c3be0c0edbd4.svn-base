package com.eshore.wbtimer.admin.core.router;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.biz.model.TriggerParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * 描述: 路由策略
 * 由于同一执行器可以部署在不同服务器中 可以根据路由策略来决定任务在哪台服务器上运行
 * @author Yangjinming
 * @create 2018-01-11 10:08
 */
public abstract class ExecutorRouter {
    protected static Logger logger = LoggerFactory.getLogger(ExecutorRouter.class);

    /**
     * route run executor
     *
     * @param triggerParam
     * @param addressList
     * @return  ReturnT.content: final address
     */
    public abstract ReturnT<String> routeRun(TriggerParam triggerParam, ArrayList<String> addressList);

}
