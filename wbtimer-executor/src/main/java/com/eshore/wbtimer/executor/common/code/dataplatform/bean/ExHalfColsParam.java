package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import com.eshore.wbtimer.executor.service.bean.DBTableParamBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:45
 */
public class ExHalfColsParam extends DBTableParamBean implements Serializable {
    private Long exHalfColsId;
    private String serviceCode;
    private String serviceCodeLikeRange;
    private String nodecode;
    private String nodecodeLikeRange;
    private String ltarget;
    private String ltargetLikeRange;
    private String rtarget;
    private String rtargetLikeRange;
    private String resourcetype;
    private String resourcetypeLikeRange;
    private Date cjrq;
    private String cjrqRange1;
    private String cjrqRange2;
    private String staffId;
    private String staffIdLikeRange;
    private String status;
    private String statusLikeRange;

    public Long getExHalfColsId() {
        return exHalfColsId;
    }

    public void setExHalfColsId(Long exHalfColsId) {
        this.exHalfColsId = exHalfColsId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceCodeLikeRange() {
        return serviceCodeLikeRange;
    }

    public void setServiceCodeLikeRange(String serviceCodeLikeRange) {
        this.serviceCodeLikeRange = serviceCodeLikeRange;
    }

    public String getNodecode() {
        return nodecode;
    }

    public void setNodecode(String nodecode) {
        this.nodecode = nodecode;
    }

    public String getNodecodeLikeRange() {
        return nodecodeLikeRange;
    }

    public void setNodecodeLikeRange(String nodecodeLikeRange) {
        this.nodecodeLikeRange = nodecodeLikeRange;
    }

    public String getLtarget() {
        return ltarget;
    }

    public void setLtarget(String ltarget) {
        this.ltarget = ltarget;
    }

    public String getLtargetLikeRange() {
        return ltargetLikeRange;
    }

    public void setLtargetLikeRange(String ltargetLikeRange) {
        this.ltargetLikeRange = ltargetLikeRange;
    }

    public String getRtarget() {
        return rtarget;
    }

    public void setRtarget(String rtarget) {
        this.rtarget = rtarget;
    }

    public String getRtargetLikeRange() {
        return rtargetLikeRange;
    }

    public void setRtargetLikeRange(String rtargetLikeRange) {
        this.rtargetLikeRange = rtargetLikeRange;
    }

    public String getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype;
    }

    public String getResourcetypeLikeRange() {
        return resourcetypeLikeRange;
    }

    public void setResourcetypeLikeRange(String resourcetypeLikeRange) {
        this.resourcetypeLikeRange = resourcetypeLikeRange;
    }

    public Date getCjrq() {
        return cjrq;
    }

    public void setCjrq(Date cjrq) {
        this.cjrq = cjrq;
    }

    public String getCjrqRange1() {
        return cjrqRange1;
    }

    public void setCjrqRange1(String cjrqRange1) {
        this.cjrqRange1 = cjrqRange1;
    }

    public String getCjrqRange2() {
        return cjrqRange2;
    }

    public void setCjrqRange2(String cjrqRange2) {
        this.cjrqRange2 = cjrqRange2;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffIdLikeRange() {
        return staffIdLikeRange;
    }

    public void setStaffIdLikeRange(String staffIdLikeRange) {
        this.staffIdLikeRange = staffIdLikeRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusLikeRange() {
        return statusLikeRange;
    }

    public void setStatusLikeRange(String statusLikeRange) {
        this.statusLikeRange = statusLikeRange;
    }
}
