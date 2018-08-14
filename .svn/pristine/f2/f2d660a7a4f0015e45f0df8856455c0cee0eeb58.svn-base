package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("EX_HALF_PROCESS_HIST")
public class ExHalfProcessHist {
    @TableId(value = "SBLSH")//默认type为input
    private String sblsh;

    private String initStepType;

    private String currntStepType;

    private Date createDate;

    private Date lastmodifyDate;

    private String processState;

    private String processMsg;

    private Long hjslbs;

    public ExHalfProcessHist(String sblsh, String initStepType, String currntStepType, Date createDate, Date lastmodifyDate, String processState, String processMsg, Long hjslbs) {
        this.sblsh = sblsh;
        this.initStepType = initStepType;
        this.currntStepType = currntStepType;
        this.createDate = createDate;
        this.lastmodifyDate = lastmodifyDate;
        this.processState = processState;
        this.processMsg = processMsg;
        this.hjslbs = hjslbs;
    }

    public ExHalfProcessHist() {
        super();
    }

    public String getSblsh() {
        return sblsh;
    }

    public void setSblsh(String sblsh) {
        this.sblsh = sblsh == null ? null : sblsh.trim();
    }

    public String getInitStepType() {
        return initStepType;
    }

    public void setInitStepType(String initStepType) {
        this.initStepType = initStepType == null ? null : initStepType.trim();
    }

    public String getCurrntStepType() {
        return currntStepType;
    }

    public void setCurrntStepType(String currntStepType) {
        this.currntStepType = currntStepType == null ? null : currntStepType.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastmodifyDate() {
        return lastmodifyDate;
    }

    public void setLastmodifyDate(Date lastmodifyDate) {
        this.lastmodifyDate = lastmodifyDate;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getProcessMsg() {
        return processMsg;
    }

    public void setProcessMsg(String processMsg) {
        this.processMsg = processMsg == null ? null : processMsg.trim();
    }

    public Long getHjslbs() {
        return hjslbs;
    }

    public void setHjslbs(Long hjslbs) {
        this.hjslbs = hjslbs;
    }
}