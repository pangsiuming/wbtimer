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
 * @create 2018/2/1 9:46
 */
@TableName("EX_HALF_COLS")
public class ExHalfColsBean extends DBTableParamBean implements Serializable {
    @TableId(value = "EX_HALF_COLS_ID",type = IdType.AUTO)
    private Long exHalfColsId;        // 序列：SQ_EX_HALF_COLS
    private String serviceCode;       // 事项编码
    private String nodecode;          // 节点名称 如 BaseInfo 或者部门事项所需要的额外节点
    private String ltarget;           // 左目标表字段，来源表字段标识
    private String rtarget;           // 右目标表字段（目标FieldName，resource=3时为部门事项所需要的额外节点的名称）
    private String resourcetype;      // 取值来源：
    private Date cjrq;                // 创建日期
    private String staffId;           // 工号
    private String status;            // （STATUS,S0A有效;S0B无效）

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

    public String getNodecode() {
        return nodecode;
    }

    public void setNodecode(String nodecode) {
        this.nodecode = nodecode;
    }

    public String getLtarget() {
        return ltarget;
    }

    public void setLtarget(String ltarget) {
        this.ltarget = ltarget;
    }

    public String getRtarget() {
        return rtarget;
    }

    public void setRtarget(String rtarget) {
        this.rtarget = rtarget;
    }

    public String getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype;
    }

    public Date getCjrq() {
        return cjrq;
    }

    public void setCjrq(Date cjrq) {
        this.cjrq = cjrq;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
