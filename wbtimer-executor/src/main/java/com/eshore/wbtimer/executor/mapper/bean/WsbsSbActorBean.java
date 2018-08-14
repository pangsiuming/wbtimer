package com.eshore.wbtimer.executor.mapper.bean;

/**
 * 自定义多表sql返回对象
 * 短信下行通过流水号找当前参与者,以便拿到处理人手机号码
 * @author zhangz
 *
 */
public class WsbsSbActorBean {

    public String sblsh;
    public String sxbm;
    public String sbxmmc;
    public String processinstid;
    public String workitemid;
    public String participantid;
    public String participanttype;

    public String getSblsh() {
        return sblsh;
    }

    public void setSblsh(String sblsh) {
        this.sblsh = sblsh;
    }

    public String getSxbm() {
        return sxbm;
    }

    public void setSxbm(String sxbm) {
        this.sxbm = sxbm;
    }

    public String getSbxmmc() {
        return sbxmmc;
    }

    public void setSbxmmc(String sbxmmc) {
        this.sbxmmc = sbxmmc;
    }

    public String getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(String processinstid) {
        this.processinstid = processinstid;
    }

    public String getWorkitemid() {
        return workitemid;
    }

    public void setWorkitemid(String workitemid) {
        this.workitemid = workitemid;
    }

    public String getParticipantid() {
        return participantid;
    }

    public void setParticipantid(String participantid) {
        this.participantid = participantid;
    }

    public String getParticipanttype() {
        return participanttype;
    }

    public void setParticipanttype(String participanttype) {
        this.participanttype = participanttype;
    }
}
