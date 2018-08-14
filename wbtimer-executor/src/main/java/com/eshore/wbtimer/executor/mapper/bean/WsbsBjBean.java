package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.eshore.wbtimer.executor.service.bean.DBTableParamBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("WSBS_BJ")
public class WsbsBjBean extends DBTableParamBean implements Serializable {
    @TableId(value = "HJSLBS",type = IdType.AUTO)
    private Long hjslbs;

    private String sblsh;

    private String sxbm;

    private String bmmc;

    private String zzjgdm;

    private String xzqhdm;

    private String cljgdm;

    private String cljgms;

    private String zjgzmc;

    private String zjbh;

    private String zjyxqx;

    private String fzgzdw;

    private BigDecimal sfje;

    private String jedwdm;

    private String staffId;

    private String staffName;

    private String sbid;

    private String bz;

    private String byzd;

    private Date bjsj;

    private String dataSource;

    private String exLqFlag;

    private Date exLqTime;

    private BigDecimal processinstid;

    private Date createTime;

    private String clrgh;

    private String clrxm;

    private String sbxmmc;

    private String needsendmsg;

    private String smscontent;

    private String bjclrxm;

    private String bjclrgh;

    public WsbsBjBean(Long hjslbs, String sblsh, String sxbm, String bmmc, String zzjgdm, String xzqhdm, String cljgdm, String cljgms, String zjgzmc, String zjbh, String zjyxqx, String fzgzdw, BigDecimal sfje, String jedwdm, String staffId, String staffName, String sbid, String bz, String byzd, Date bjsj, String dataSource, String exLqFlag, Date exLqTime, BigDecimal processinstid, Date createTime, String clrgh, String clrxm, String sbxmmc, String needsendmsg, String smscontent, String bjclrxm, String bjclrgh) {
        this.hjslbs = hjslbs;
        this.sblsh = sblsh;
        this.sxbm = sxbm;
        this.bmmc = bmmc;
        this.zzjgdm = zzjgdm;
        this.xzqhdm = xzqhdm;
        this.cljgdm = cljgdm;
        this.cljgms = cljgms;
        this.zjgzmc = zjgzmc;
        this.zjbh = zjbh;
        this.zjyxqx = zjyxqx;
        this.fzgzdw = fzgzdw;
        this.sfje = sfje;
        this.jedwdm = jedwdm;
        this.staffId = staffId;
        this.staffName = staffName;
        this.sbid = sbid;
        this.bz = bz;
        this.byzd = byzd;
        this.bjsj = bjsj;
        this.dataSource = dataSource;
        this.exLqFlag = exLqFlag;
        this.exLqTime = exLqTime;
        this.processinstid = processinstid;
        this.createTime = createTime;
        this.clrgh = clrgh;
        this.clrxm = clrxm;
        this.sbxmmc = sbxmmc;
        this.needsendmsg = needsendmsg;
        this.smscontent = smscontent;
        this.bjclrxm = bjclrxm;
        this.bjclrgh = bjclrgh;
    }

    public WsbsBjBean() {
        super();
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
        this.sblsh = sblsh == null ? null : sblsh.trim();
    }

    public String getSxbm() {
        return sxbm;
    }

    public void setSxbm(String sxbm) {
        this.sxbm = sxbm == null ? null : sxbm.trim();
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc == null ? null : bmmc.trim();
    }

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm == null ? null : zzjgdm.trim();
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm == null ? null : xzqhdm.trim();
    }

    public String getCljgdm() {
        return cljgdm;
    }

    public void setCljgdm(String cljgdm) {
        this.cljgdm = cljgdm == null ? null : cljgdm.trim();
    }

    public String getCljgms() {
        return cljgms;
    }

    public void setCljgms(String cljgms) {
        this.cljgms = cljgms == null ? null : cljgms.trim();
    }

    public String getZjgzmc() {
        return zjgzmc;
    }

    public void setZjgzmc(String zjgzmc) {
        this.zjgzmc = zjgzmc == null ? null : zjgzmc.trim();
    }

    public String getZjbh() {
        return zjbh;
    }

    public void setZjbh(String zjbh) {
        this.zjbh = zjbh == null ? null : zjbh.trim();
    }

    public String getZjyxqx() {
        return zjyxqx;
    }

    public void setZjyxqx(String zjyxqx) {
        this.zjyxqx = zjyxqx == null ? null : zjyxqx.trim();
    }

    public String getFzgzdw() {
        return fzgzdw;
    }

    public void setFzgzdw(String fzgzdw) {
        this.fzgzdw = fzgzdw == null ? null : fzgzdw.trim();
    }

    public BigDecimal getSfje() {
        return sfje;
    }

    public void setSfje(BigDecimal sfje) {
        this.sfje = sfje;
    }

    public String getJedwdm() {
        return jedwdm;
    }

    public void setJedwdm(String jedwdm) {
        this.jedwdm = jedwdm == null ? null : jedwdm.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getSbid() {
        return sbid;
    }

    public void setSbid(String sbid) {
        this.sbid = sbid == null ? null : sbid.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getByzd() {
        return byzd;
    }

    public void setByzd(String byzd) {
        this.byzd = byzd == null ? null : byzd.trim();
    }

    public Date getBjsj() {
        return bjsj;
    }

    public void setBjsj(Date bjsj) {
        this.bjsj = bjsj;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public String getExLqFlag() {
        return exLqFlag;
    }

    public void setExLqFlag(String exLqFlag) {
        this.exLqFlag = exLqFlag == null ? null : exLqFlag.trim();
    }

    public Date getExLqTime() {
        return exLqTime;
    }

    public void setExLqTime(Date exLqTime) {
        this.exLqTime = exLqTime;
    }

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getClrgh() {
        return clrgh;
    }

    public void setClrgh(String clrgh) {
        this.clrgh = clrgh == null ? null : clrgh.trim();
    }

    public String getClrxm() {
        return clrxm;
    }

    public void setClrxm(String clrxm) {
        this.clrxm = clrxm == null ? null : clrxm.trim();
    }

    public String getSbxmmc() {
        return sbxmmc;
    }

    public void setSbxmmc(String sbxmmc) {
        this.sbxmmc = sbxmmc == null ? null : sbxmmc.trim();
    }

    public String getNeedsendmsg() {
        return needsendmsg;
    }

    public void setNeedsendmsg(String needsendmsg) {
        this.needsendmsg = needsendmsg == null ? null : needsendmsg.trim();
    }

    public String getSmscontent() {
        return smscontent;
    }

    public void setSmscontent(String smscontent) {
        this.smscontent = smscontent == null ? null : smscontent.trim();
    }

    public String getBjclrxm() {
        return bjclrxm;
    }

    public void setBjclrxm(String bjclrxm) {
        this.bjclrxm = bjclrxm == null ? null : bjclrxm.trim();
    }

    public String getBjclrgh() {
        return bjclrgh;
    }

    public void setBjclrgh(String bjclrgh) {
        this.bjclrgh = bjclrgh == null ? null : bjclrgh.trim();
    }
}