package com.eshore.wbtimer.executor.handler.test;

import com.eshore.wbtimer.core.biz.ExecutorBiz;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.biz.model.TriggerParam;
import com.eshore.wbtimer.core.enums.ExecutorBlockStrategyEnum;
import com.eshore.wbtimer.core.glue.GlueTypeEnum;
import com.eshore.wbtimer.core.rpc.net.NetComClientProxy;
import org.junit.Test;

/**
 * 描述: Handler测试类
 *
 * @author Yangjinming
 * @create 2018-01-15 8:55
 */
public class HandlerTest {
    @Test
    public void runHandler() throws Exception{
        // 模拟远程调度
        String jobHandler = "updateWsbsFgblInfoHandler";
        String params = "";

        // 触发参数
        TriggerParam triggerParam = new TriggerParam();
        triggerParam.setJobId(1);
        triggerParam.setExecutorHandler(jobHandler);
        triggerParam.setExecutorParams(params);
        triggerParam.setExecutorBlockStrategy(ExecutorBlockStrategyEnum.COVER_EARLY.name());
        triggerParam.setGlueType(GlueTypeEnum.BEAN.name());
        triggerParam.setGlueSource(null);
        triggerParam.setGlueUpdatetime(System.currentTimeMillis());
        triggerParam.setLogId(1);
        triggerParam.setLogDateTim(System.currentTimeMillis());

        // 远程调度
        String accessToken = null;
        ExecutorBiz executorBiz = (ExecutorBiz) new NetComClientProxy(ExecutorBiz.class, "127.0.0.1:9993", "a3b4dc015a0a930f92312c7fc379589a").getObject();
        ReturnT<String> runResult = executorBiz.run(triggerParam);
        System.out.println(runResult.getCode());
    }

}
