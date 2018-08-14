package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

@TableName("WSBS_FGBL_INFO")
public class WsbsFgblInfoBean {
    @TableId(value = "WSBS_FGBL_INFO_ID",type = IdType.AUTO)
    private Long wsbsFgblInfoId;

    private String sblsh;

    private String sxbm;

    private String projcode;

    private String projname;

    private String applyid;

    private Date createTime;

    private String adminOrg;

    private String backApplyidSblsh;

    private String tjfs;

    private String backProjcodeSblsh;

    private String source;

    public WsbsFgblInfoBean(Long wsbsFgblInfoId, String sblsh, String sxbm, String projcode, String projname, String applyid, Date createTime, String adminOrg, String backApplyidSblsh, String tjfs, String backProjcodeSblsh, String source) {
        this.wsbsFgblInfoId = wsbsFgblInfoId;
        this.sblsh = sblsh;
        this.sxbm = sxbm;
        this.projcode = projcode;
        this.projname = projname;
        this.applyid = applyid;
        this.createTime = createTime;
        this.adminOrg = adminOrg;
        this.backApplyidSblsh = backApplyidSblsh;
        this.tjfs = tjfs;
        this.backProjcodeSblsh = backProjcodeSblsh;
        this.source = source;
    }

    public WsbsFgblInfoBean() {
        super();
    }

    public Long getWsbsFgblInfoId() {
        return wsbsFgblInfoId;
    }

    public void setWsbsFgblInfoId(Long wsbsFgblInfoId) {
        this.wsbsFgblInfoId = wsbsFgblInfoId;
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

    public String getProjcode() {
        return projcode;
    }

    public void setProjcode(String projcode) {
        this.projcode = projcode == null ? null : projcode.trim();
    }

    public String getProjname() {
        return projname;
    }

    public void setProjname(String projname) {
        this.projname = projname == null ? null : projname.trim();
    }

    public String getApplyid() {
        return applyid;
    }

    public void setApplyid(String applyid) {
        this.applyid = applyid == null ? null : applyid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAdminOrg() {
        return adminOrg;
    }

    public void setAdminOrg(String adminOrg) {
        this.adminOrg = adminOrg == null ? null : adminOrg.trim();
    }

    public String getBackApplyidSblsh() {
        return backApplyidSblsh;
    }

    public void setBackApplyidSblsh(String backApplyidSblsh) {
        this.backApplyidSblsh = backApplyidSblsh == null ? null : backApplyidSblsh.trim();
    }

    public String getTjfs() {
        return tjfs;
    }

    public void setTjfs(String tjfs) {
        this.tjfs = tjfs == null ? null : tjfs.trim();
    }

    public String getBackProjcodeSblsh() {
        return backProjcodeSblsh;
    }

    public void setBackProjcodeSblsh(String backProjcodeSblsh) {
        this.backProjcodeSblsh = backProjcodeSblsh == null ? null : backProjcodeSblsh.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
}