package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("EX_HALF_PROCESS")
public class ExHalfProcess {
    @TableId(value = "SBLSH")//默认type为input
    private String sblsh;              // 申办流水号，唯一
    private Long hjslbs;              // 环节实例标识，唯一
    private String initStepType;       // 初始环节类型，字典编码：SB_STEP_TYPE，为外送时的环节类型编码
    private String currntStepType;     // 当前环节类型，字典编码：SB_STEP_TYPE，初始值为外送时的环节类型编码
    private Date createDate;           // 创建时间（外送时间）
    private Date lastmodifyDate;       // 最后处理时间，记录最后一次处理的时间
    private String processState;       // 处理状态，0为已全部处理成功，1处理失败，初始为未处理，全部处理成功后移入历史表
    private String processMsg;         // Y  处理信息：成功或失败信息

    public ExHalfProcess(String sblsh, String initStepType, String currntStepType, Date createDate, Date lastmodifyDate, String processState, String processMsg, Long hjslbs) {
        this.sblsh = sblsh;
        this.initStepType = initStepType;
        this.currntStepType = currntStepType;
        this.createDate = createDate;
        this.lastmodifyDate = lastmodifyDate;
        this.processState = processState;
        this.processMsg = processMsg;
        this.hjslbs = hjslbs;
    }

    public ExHalfProcess() {
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