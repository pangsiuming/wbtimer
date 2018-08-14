package com.eshore.wbtimer.executor.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/30 16:10
 */
public class SmsSendQueueHistParamBean extends DBTableParamBean implements Serializable {
    private Long histId;
    private Long queueId;
    private String phonenumber;
    private String phonenumberLikeRange;
    private String smsContent;
    private String smsContentLikeRange;
    private Date createDate;
    private String createDateRange1;
    private String createDateRange2;
    private String createName;
    private String createNameLikeRange;
    private Short sendTimes;
    private Date sendDate;
    private String sendDateRange1;
    private String sendDateRange2;
    private String sendFlag;
    private String sessionId;

    public Long getHistId() {
        return histId;
    }

    public void setHistId(Long histId) {
        this.histId = histId;
    }

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumberLikeRange() {
        return phonenumberLikeRange;
    }

    public void setPhonenumberLikeRange(String phonenumberLikeRange) {
        this.phonenumberLikeRange = phonenumberLikeRange;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getSmsContentLikeRange() {
        return smsContentLikeRange;
    }

    public void setSmsContentLikeRange(String smsContentLikeRange) {
        this.smsContentLikeRange = smsContentLikeRange;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateDateRange1() {
        return createDateRange1;
    }

    public void setCreateDateRange1(String createDateRange1) {
        this.createDateRange1 = createDateRange1;
    }

    public String getCreateDateRange2() {
        return createDateRange2;
    }

    public void setCreateDateRange2(String createDateRange2) {
        this.createDateRange2 = createDateRange2;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateNameLikeRange() {
        return createNameLikeRange;
    }

    public void setCreateNameLikeRange(String createNameLikeRange) {
        this.createNameLikeRange = createNameLikeRange;
    }

    public Short getSendTimes() {
        return sendTimes;
    }

    public void setSendTimes(Short sendTimes) {
        this.sendTimes = sendTimes;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSendDateRange1() {
        return sendDateRange1;
    }

    public void setSendDateRange1(String sendDateRange1) {
        this.sendDateRange1 = sendDateRange1;
    }

    public String getSendDateRange2() {
        return sendDateRange2;
    }

    public void setSendDateRange2(String sendDateRange2) {
        this.sendDateRange2 = sendDateRange2;
    }

    public String getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}