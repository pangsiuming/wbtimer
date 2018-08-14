package com.eshore.wbtimer.executor.service;

/**
 * 描述:发送短信service处理
 *
 * @author Yangjinming
 * @create 2018/1/25 9:19
 */
public interface SendService {

    /* 申办成功和其他流程短信下行定时不同,所以定义2个task任务 */
    void startSbSend() throws Exception;

    void startSend() throws Exception;

    void sendRemindPreAcceptSMS() throws Exception;

    void sendReceiveWaitDealSms()throws Exception;

    void startTszxSms() throws Exception;
}
