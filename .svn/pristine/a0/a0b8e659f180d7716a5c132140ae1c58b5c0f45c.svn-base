package com.eshore.wbtimer.executor.service.bean;

import java.util.Date;

/**
 * 描述:此实体用于短信发送成功后记录返回的的参数
 *
 * @author Yangjinming
 * @create 2018/1/30 14:58
 */
public class SmsReceiptParamBean {
    private String sessionId;  //短信发送成功返回的sessionId
    private String smsstat; //短信是否发送成功 是指短信平台向用户发送是否成功
    private String   errCode;    //短信平台发送失败时，此值不为空，当短信平台向用户发送短信成功是为空
    private boolean  isSuccess;  //短信是否成功发送至短信服务器
    private Date receiptDate; //短信回执日期
    private String sendNum;//发送号码
    private String recvNum;//接收号码

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSmsstat() {
        return smsstat;
    }

    public void setSmsstat(String smsstat) {
        this.smsstat = smsstat;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getSendNum() {
        return sendNum;
    }

    public void setSendNum(String sendNum) {
        this.sendNum = sendNum;
    }

    public String getRecvNum() {
        return recvNum;
    }

    public void setRecvNum(String recvNum) {
        this.recvNum = recvNum;
    }
}
