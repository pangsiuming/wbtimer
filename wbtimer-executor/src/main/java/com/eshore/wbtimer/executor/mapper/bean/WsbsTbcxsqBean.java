package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.eshore.wbtimer.executor.service.bean.DBTableParamBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/30 8:53
 */
@TableName("WSBS_TBCXSQ")
public class WsbsTbcxsqBean extends DBTableParamBean implements Serializable
{
    @TableId(value = "HJSLBS",type = IdType.AUTO)
    private Long hjslbs;
    private String sblsh;
    private String sxbm;
    private String xh;
    private String tbcxzl;
    private String tbcxzlmc;
    private String tbcxpzr;
    private String tbcxqdly;
    private String sqnr;
    private Long tbcxsx;
    private String tbcxsxdw;
    private String xzqhdm;
    private String sqrxm;
    private String staffId;
    private String bz;
    private String byzd;
    private Date createTime;
    private String dataSource;
    private Long processinstid;
    private String clrgh;
    private String clrxm;
    private Date alertDate;
    private Date endDate;
    private String sbxmmc;

    private String needsendmsg;

    private String smscontent;

    private Long restDay;

    private Long restNatureDay;

    public String getSbxmmc() {
        return sbxmmc;
    }

    public void setSbxmmc(String sbxmmc) {
        this.sbxmmc = sbxmmc;
    }

    public String getNeedsendmsg() {
        return needsendmsg;
    }

    public void setNeedsendmsg(String needsendmsg) {
        this.needsendmsg = needsendmsg;
    }

    public String getSmscontent() {
        return smscontent;
    }

    public void setSmscontent(String smscontent) {
        this.smscontent = smscontent;
    }

    public Long getRestDay() {
        return restDay;
    }

    public void setRestDay(Long restDay) {
        this.restDay = restDay;
    }

    public Long getRestNatureDay() {
        return restNatureDay;
    }

    public void setRestNatureDay(Long restNatureDay) {
        this.restNatureDay = restNatureDay;
    }

    public Long getHjslbs() {
        return hjslbs;
    }

    public void setHjslbs(Long hjslbs) {
        this.hjslbs = hjslbs;
    }

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

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getTbcxzl() {
        return tbcxzl;
    }

    public void setTbcxzl(String tbcxzl) {
        this.tbcxzl = tbcxzl;
    }

    public String getTbcxzlmc() {
        return tbcxzlmc;
    }

    public void setTbcxzlmc(String tbcxzlmc) {
        this.tbcxzlmc = tbcxzlmc;
    }

    public String getTbcxpzr() {
        return tbcxpzr;
    }

    public void setTbcxpzr(String tbcxpzr) {
        this.tbcxpzr = tbcxpzr;
    }

    public String getTbcxqdly() {
        return tbcxqdly;
    }

    public void setTbcxqdly(String tbcxqdly) {
        this.tbcxqdly = tbcxqdly;
    }

    public String getSqnr() {
        return sqnr;
    }

    public void setSqnr(String sqnr) {
        this.sqnr = sqnr;
    }

    public Long getTbcxsx() {
        return tbcxsx;
    }

    public void setTbcxsx(Long tbcxsx) {
        this.tbcxsx = tbcxsx;
    }

    public String getTbcxsxdw() {
        return tbcxsxdw;
    }

    public void setTbcxsxdw(String tbcxsxdw) {
        this.tbcxsxdw = tbcxsxdw;
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getSqrxm() {
        return sqrxm;
    }

    public void setSqrxm(String sqrxm) {
        this.sqrxm = sqrxm;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getByzd() {
        return byzd;
    }

    public void setByzd(String byzd) {
        this.byzd = byzd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Long getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(Long processinstid) {
        this.processinstid = processinstid;
    }

    public String getClrgh() {
        return clrgh;
    }

    public void setClrgh(String clrgh) {
        this.clrgh = clrgh;
    }

    public String getClrxm() {
        return clrxm;
    }

    public void setClrxm(String clrxm) {
        this.clrxm = clrxm;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
