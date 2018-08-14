package com.eshore.wbtimer.executor.mapper.bean;

import com.eshore.wbtimer.executor.service.bean.DBTableParamBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 14:40
 */
public class SendStepBean extends DBTableParamBean implements Serializable {
    private Long missionId;      // 任务ID, 环节记录的主键
    private String stepType;     // 环节类型，字典编码：SB_STEP_TYPE
    private Date sendDate;       // 外送时间
    private String sendXml;       // 发送xml

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSendXml() {
        return sendXml;
    }

    public void setSendXml(String sendXml) {
        this.sendXml = sendXml;
    }
}
