package com.eshore.wbtimer.executor.service.bean;

import java.util.Date;

/**
 * 评议短信功能发送短信时需要的参数实体
 * @author songmq
 */
public class SendItemInformationParam {
    private String sblsh;    //申办流水号
    private String sxbm;     //事项编码
    private String sxmc;     //事项名称
    private String bmmc;     //部门名称
    private String sqrmc;    //申请人名称
    private String lxrmc;    //联系人名称
    private String lxrsj;    //联系人手机
    private Date   hjsj;     //环节时间
    private String hjmc;     //环节名称
    private String hjzt;     //环节状态
    private String content;  //短信内容
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
    public String getSxmc() {
        return sxmc;
    }
    public void setSxmc(String sxmc) {
        this.sxmc = sxmc;
    }
    public String getBmmc() {
        return bmmc;
    }
    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }
    public String getSqrmc() {
        return sqrmc;
    }
    public void setSqrmc(String sqrmc) {
        this.sqrmc = sqrmc;
    }
    public String getLxrmc() {
        return lxrmc;
    }
    public void setLxrmc(String lxrmc) {
        this.lxrmc = lxrmc;
    }
    public String getLxrsj() {
        return lxrsj;
    }
    public void setLxrsj(String lxrsj) {
        this.lxrsj = lxrsj;
    }
    public Date getHjsj() {
        return hjsj;
    }
    public void setHjsj(Date hjsj) {
        this.hjsj = hjsj;
    }
    public String getHjmc() {
        return hjmc;
    }
    public void setHjmc(String hjmc) {
        this.hjmc = hjmc;
    }
    public String getHjzt() {
        return hjzt;
    }
    public void setHjzt(String hjzt) {
        this.hjzt = hjzt;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}