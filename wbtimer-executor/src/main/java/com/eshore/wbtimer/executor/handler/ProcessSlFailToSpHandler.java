package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.ProcessSlFailToSpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:自动过某环节时补齐必要的环节数据统一执行类
 * 正常流程:受理-审批-办结
 * 当受理不通过时,自动流转到办结,此时需要系统生成审批数据
 * 此任务承载具体实现
 *
 * @author Yangjinming
 * @create 2018-01-12 17:18
 */
@JobHandler("processSlFailToSpHandler")
@Component
public class ProcessSlFailToSpHandler extends IJobHandler {
    private static Logger logger = LoggerFactory.getLogger(ProcessSlFailToSpHandler.class);
    @Autowired
    ProcessSlFailToSpService processSlFailToSpService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        processSlFailToSpService.startProcessSlFailToSp();
        return ReturnT.SUCCESS;
    }
}
