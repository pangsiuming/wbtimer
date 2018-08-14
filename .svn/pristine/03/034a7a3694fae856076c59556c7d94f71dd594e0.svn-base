package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.SendSmsQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:短信队列发送到短信平台
 *
 * @author Yjm
 * @create 2018/5/24 9:44
 */
@Component
@JobHandler("smsSendQueueHandler")
public class SmsSendQueueHandler extends IJobHandler {
    @Autowired
    SendSmsQueueService sendSmsQueueService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        sendSmsQueueService.startSend();
        return ReturnT.SUCCESS;
    }
}
