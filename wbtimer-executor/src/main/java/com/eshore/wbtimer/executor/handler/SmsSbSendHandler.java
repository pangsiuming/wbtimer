package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:网上申办单提醒短信
 *
 * @author Yangjinming
 * @create 2018-01-12 17:19
 */
@JobHandler("smsSbSendHandler")
@Component
public class SmsSbSendHandler extends IJobHandler {
    @Autowired
    SendService sendService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        sendService.startSbSend();
        return ReturnT.SUCCESS;
    }
}
