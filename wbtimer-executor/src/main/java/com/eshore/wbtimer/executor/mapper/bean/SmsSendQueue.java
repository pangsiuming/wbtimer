package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("SMS_SEND_QUEUE")
public class SmsSendQueue {
    @TableId(value = "QUEUE_ID")
    private Long queueId;

    private String phonenumber;

    private String smsContent;

    private Date createDate;

    private String createName;

    private Short sendTimes;

    public SmsSendQueue(Long queueId, String phonenumber, String smsContent, Date createDate, String createName, Short sendTimes) {
        this.queueId = queueId;
        this.phonenumber = phonenumber;
        this.smsContent = smsContent;
        this.createDate = createDate;
        this.createName = createName;
        this.sendTimes = sendTimes;
    }

    public SmsSendQueue() {

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
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent == null ? null : smsContent.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Short getSendTimes() {
        return sendTimes;
    }

    public void setSendTimes(Short sendTimes) {
        this.sendTimes = sendTimes;
    }
}