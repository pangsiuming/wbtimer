package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("PACKAGE_INOUT_PROCESS")
public class PackageInoutProcess {
    @TableId(value = "PACKAGE_PROCESS_ID")
    private Long packageProcessId;

    private Long packageid;

    private Date inDate;

    private String inRemark;

    private String fromWorkpost;

    private String fromWorkpostname;

    private String fromStaffid;

    private String fromStaffname;

    private String fromOrgcode;

    private String fromOrgname;

    private String toWorkpost;

    private String toWorkpostname;

    private String toOrgcode;

    private String toOrgname;

    private String toStaffid;

    private String toStaffname;

    private Date outDate;

    private String outRemark;

    private String status;

    private String remark;

    private String alertStatus;

    private Long restTime;

    public PackageInoutProcess(Long packageProcessId, Long packageid, Date inDate, String inRemark, String fromWorkpost, String fromWorkpostname, String fromStaffid, String fromStaffname, String fromOrgcode, String fromOrgname, String toWorkpost, String toWorkpostname, String toOrgcode, String toOrgname, String toStaffid, String toStaffname, Date outDate, String outRemark, String status, String remark, String alertStatus, Long restTime) {
        this.packageProcessId = packageProcessId;
        this.packageid = packageid;
        this.inDate = inDate;
        this.inRemark = inRemark;
        this.fromWorkpost = fromWorkpost;
        this.fromWorkpostname = fromWorkpostname;
        this.fromStaffid = fromStaffid;
        this.fromStaffname = fromStaffname;
        this.fromOrgcode = fromOrgcode;
        this.fromOrgname = fromOrgname;
        this.toWorkpost = toWorkpost;
        this.toWorkpostname = toWorkpostname;
        this.toOrgcode = toOrgcode;
        this.toOrgname = toOrgname;
        this.toStaffid = toStaffid;
        this.toStaffname = toStaffname;
        this.outDate = outDate;
        this.outRemark = outRemark;
        this.status = status;
        this.remark = remark;
        this.alertStatus = alertStatus;
        this.restTime = restTime;
    }

    public PackageInoutProcess() {
        super();
    }

    public Long getPackageProcessId() {
        return packageProcessId;
    }

    public void setPackageProcessId(Long packageProcessId) {
        this.packageProcessId = packageProcessId;
    }

    public Long getPackageid() {
        return packageid;
    }

    public void setPackageid(Long packageid) {
        this.packageid = packageid;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getInRemark() {
        return inRemark;
    }

    public void setInRemark(String inRemark) {
        this.inRemark = inRemark == null ? null : inRemark.trim();
    }

    public String getFromWorkpost() {
        return fromWorkpost;
    }

    public void setFromWorkpost(String fromWorkpost) {
        this.fromWorkpost = fromWorkpost == null ? null : fromWorkpost.trim();
    }

    public String getFromWorkpostname() {
        return fromWorkpostname;
    }

    public void setFromWorkpostname(String fromWorkpostname) {
        this.fromWorkpostname = fromWorkpostname == null ? null : fromWorkpostname.trim();
    }

    public String getFromStaffid() {
        return fromStaffid;
    }

    public void setFromStaffid(String fromStaffid) {
        this.fromStaffid = fromStaffid == null ? null : fromStaffid.trim();
    }

    public String getFromStaffname() {
        return fromStaffname;
    }

    public void setFromStaffname(String fromStaffname) {
        this.fromStaffname = fromStaffname == null ? null : fromStaffname.trim();
    }

    public String getFromOrgcode() {
        return fromOrgcode;
    }

    public void setFromOrgcode(String fromOrgcode) {
        this.fromOrgcode = fromOrgcode == null ? null : fromOrgcode.trim();
    }

    public String getFromOrgname() {
        return fromOrgname;
    }

    public void setFromOrgname(String fromOrgname) {
        this.fromOrgname = fromOrgname == null ? null : fromOrgname.trim();
    }

    public String getToWorkpost() {
        return toWorkpost;
    }

    public void setToWorkpost(String toWorkpost) {
        this.toWorkpost = toWorkpost == null ? null : toWorkpost.trim();
    }

    public String getToWorkpostname() {
        return toWorkpostname;
    }

    public void setToWorkpostname(String toWorkpostname) {
        this.toWorkpostname = toWorkpostname == null ? null : toWorkpostname.trim();
    }

    public String getToOrgcode() {
        return toOrgcode;
    }

    public void setToOrgcode(String toOrgcode) {
        this.toOrgcode = toOrgcode == null ? null : toOrgcode.trim();
    }

    public String getToOrgname() {
        return toOrgname;
    }

    public void setToOrgname(String toOrgname) {
        this.toOrgname = toOrgname == null ? null : toOrgname.trim();
    }

    public String getToStaffid() {
        return toStaffid;
    }

    public void setToStaffid(String toStaffid) {
        this.toStaffid = toStaffid == null ? null : toStaffid.trim();
    }

    public String getToStaffname() {
        return toStaffname;
    }

    public void setToStaffname(String toStaffname) {
        this.toStaffname = toStaffname == null ? null : toStaffname.trim();
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getOutRemark() {
        return outRemark;
    }

    public void setOutRemark(String outRemark) {
        this.outRemark = outRemark == null ? null : outRemark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(String alertStatus) {
        this.alertStatus = alertStatus == null ? null : alertStatus.trim();
    }

    public Long getRestTime() {
        return restTime;
    }

    public void setRestTime(Long restTime) {
        this.restTime = restTime;
    }
}