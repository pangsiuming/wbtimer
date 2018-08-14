package com.eshore.wbtimer.executor.service;

import com.eshore.wbtimer.executor.service.bean.SmsReceiptParamBean;

/**
 * 描述:短信处理接口
 *
 * @author Yangjinming
 * @create 2018/1/30 15:28
 */
public interface SendSmsHandlerService {
    /**
     * 发送短信
     * @param phoneNumber
     * @param content
     * @return
     */
    SmsReceiptParamBean send(String phoneNumber, String content);
    /**
     * 评议短信
     * @param queueId
     */
    SmsReceiptParamBean pySend(String queueId);
}
