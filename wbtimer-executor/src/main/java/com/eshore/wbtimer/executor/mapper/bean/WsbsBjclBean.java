package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.util.Date;

@TableName("WSBS_BJCL")
public class WsbsBjclBean {
    @TableId(value = "HJSLBS")//默认type为input
    private String hjslbs;

    private String sblsh;

    private String sbid;

    private String sxbm;

    private String bjbmmc;

    private String bjbmzzjddm;

    private String xzqhdm;

    private String bjjgdm;

    private String bjjgms;

    private String zfhthyy;

    private String zjgzmc;

    private String zjbh;

    private String zjyxqx;

    private String fzgzdw;

    private BigDecimal sfje;

    private String jedwdm;

    private Date bjsj;

    private String bz;

    private String byzd;

    private Date logDate;

    private String status;

    public WsbsBjclBean(String hjslbs, String sblsh, String sbid, String sxbm, String bjbmmc, String bjbmzzjddm, String xzqhdm, String bjjgdm, String bjjgms, String zfhthyy, String zjgzmc, String zjbh, String zjyxqx, String fzgzdw, BigDecimal sfje, String jedwdm, Date bjsj, String bz, String byzd, Date logDate, String status) {
        this.hjslbs = hjslbs;
        this.sblsh = sblsh;
        this.sbid = sbid;
        this.sxbm = sxbm;
        this.bjbmmc = bjbmmc;
        this.bjbmzzjddm = bjbmzzjddm;
        this.xzqhdm = xzqhdm;
        this.bjjgdm = bjjgdm;
        this.bjjgms = bjjgms;
        this.zfhthyy = zfhthyy;
        this.zjgzmc = zjgzmc;
        this.zjbh = zjbh;
        this.zjyxqx = zjyxqx;
        this.fzgzdw = fzgzdw;
        this.sfje = sfje;
        this.jedwdm = jedwdm;
        this.bjsj = bjsj;
        this.bz = bz;
        this.byzd = byzd;
        this.logDate = logDate;
        this.status = status;
    }

    public WsbsBjclBean() {
        super();
    }

    public String getHjslbs() {
        return hjslbs;
    }

    public void setHjslbs(String hjslbs) {
        this.hjslbs = hjslbs == null ? null : hjslbs.trim();
    }

    public String getSblsh() {
        return sblsh;
    }

    public void setSblsh(String sblsh) {
        this.sblsh = sblsh == null ? null : sblsh.trim();
    }

    public String getSbid() {
        return sbid;
    }

    public void setSbid(String sbid) {
        this.sbid = sbid == null ? null : sbid.trim();
    }

    public String getSxbm() {
        return sxbm;
    }

    public void setSxbm(String sxbm) {
        this.sxbm = sxbm == null ? null : sxbm.trim();
    }

    public String getBjbmmc() {
        return bjbmmc;
    }

    public void setBjbmmc(String bjbmmc) {
        this.bjbmmc = bjbmmc == null ? null : bjbmmc.trim();
    }

    public String getBjbmzzjddm() {
        return bjbmzzjddm;
    }

    public void setBjbmzzjddm(String bjbmzzjddm) {
        this.bjbmzzjddm = bjbmzzjddm == null ? null : bjbmzzjddm.trim();
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm == null ? null : xzqhdm.trim();
    }

    public String getBjjgdm() {
        return bjjgdm;
    }

    public void setBjjgdm(String bjjgdm) {
        this.bjjgdm = bjjgdm == null ? null : bjjgdm.trim();
    }

    public String getBjjgms() {
        return bjjgms;
    }

    public void setBjjgms(String bjjgms) {
        this.bjjgms = bjjgms == null ? null : bjjgms.trim();
    }

    public String getZfhthyy() {
        return zfhthyy;
    }

    public void setZfhthyy(String zfhthyy) {
        this.zfhthyy = zfhthyy == null ? null : zfhthyy.trim();
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

    public Date getBjsj() {
        return bjsj;
    }

    public void setBjsj(Date bjsj) {
        this.bjsj = bjsj;
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

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}