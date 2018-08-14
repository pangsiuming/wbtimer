package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:接收待处理业务短信提醒
 *
 * @author Yangjinming
 * @create 2018-01-12 17:20
 */
@JobHandler("receiveWaitDealSmsSendHandler")
@Component
public class ReceiveWaitDealSmsSendHandler extends IJobHandler {
    @Autowired
    SendService sendService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        sendService.sendReceiveWaitDealSms();
        return ReturnT.SUCCESS;
    }
}