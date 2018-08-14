package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:审批过程提醒短信
 *
 * @author Yangjinming
 * @create 2018-01-12 17:43
 */
@JobHandler("smsSendHandler")
@Component
public class SmsSendHandler extends IJobHandler {
    @Autowired
    SendService sendService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        sendService.startSend();
        return ReturnT.SUCCESS;
    }
}
