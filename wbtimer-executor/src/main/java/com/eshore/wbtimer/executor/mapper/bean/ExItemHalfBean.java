package com.eshore.wbtimer.executor.mapper.bean;

import com.eshore.wbtimer.executor.service.bean.DBTableParamBean;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/31 17:02
 */
public class ExItemHalfBean extends DBTableParamBean implements Serializable{
    private Long exItemId;                 // 主键
    private String orgName;                // 部门名称，如珠海市发改局
    private String orgCode;                // 部门组织机构代码
    private String serviceCode;            // 事项编码
    private String serviceName;            // 事项名称
    private String businessSystemName;     // 承接的业务系统名称
    private Long interfaceType;            // 接口方式，1 webservice接口，2 数据库前置机，3 其他
    private Long hjSb;                     // 定义环节数据是否交换，以下同，0不交换，1需要交换回，2推送到业务系统
    private Long hjWsysl;                  // 0不交换，1需要交换回，2推送到业务系统
    private Long hjSl;                     // 0不交换，1需要交换回，2推送到业务系统
    private Long hjBjgz;                   // 0不交换，1需要交换回，2推送到业务系统
    private Long hjBjsl;                   // 0不交换，1需要交换回，2推送到业务系统
    private Long hjSpcl;                   // 0不交换，1需要交换回，2推送到业务系统
    private Long hjTbcxsq;                 // 0不交换，1需要交换回，2推送到业务系统
    private Long hjTbcxjg;                 // 0不交换，1需要交换回，2推送到业务系统
    private Long hjBjcl;                   // 0不交换，1需要交换回，2推送到业务系统
    private Long hjBj;                     // 0不交换，1需要交换回，2推送到业务系统
    private Long hjLqdj;                   // 0不交换，1需要交换回，2推送到业务系统
    private Long dataflowType;             // 0不交换，1需要交换回，2推送到业务系统
    private String businessSystemCode;     // 业务部门系统编码

    public Long getExItemId() {
        return exItemId;
    }

    public void setExItemId(Long exItemId) {
        this.exItemId = exItemId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getBusinessSystemName() {
        return businessSystemName;
    }

    public void setBusinessSystemName(String businessSystemName) {
        this.businessSystemName = businessSystemName;
    }

    public Long getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Long interfaceType) {
        this.interfaceType = interfaceType;
    }

    public Long getHjSb() {
        return hjSb;
    }

    public void setHjSb(Long hjSb) {
        this.hjSb = hjSb;
    }

    public Long getHjWsysl() {
        return hjWsysl;
    }

    public void setHjWsysl(Long hjWsysl) {
        this.hjWsysl = hjWsysl;
    }

    public Long getHjSl() {
        return hjSl;
    }

    public void setHjSl(Long hjSl) {
        this.hjSl = hjSl;
    }

    public Long getHjBjgz() {
        return hjBjgz;
    }

    public void setHjBjgz(Long hjBjgz) {
        this.hjBjgz = hjBjgz;
    }

    public Long getHjBjsl() {
        return hjBjsl;
    }

    public void setHjBjsl(Long hjBjsl) {
        this.hjBjsl = hjBjsl;
    }

    public Long getHjSpcl() {
        return hjSpcl;
    }

    public void setHjSpcl(Long hjSpcl) {
        this.hjSpcl = hjSpcl;
    }

    public Long getHjTbcxsq() {
        return hjTbcxsq;
    }

    public void setHjTbcxsq(Long hjTbcxsq) {
        this.hjTbcxsq = hjTbcxsq;
    }

    public Long getHjTbcxjg() {
        return hjTbcxjg;
    }

    public void setHjTbcxjg(Long hjTbcxjg) {
        this.hjTbcxjg = hjTbcxjg;
    }

    public Long getHjBjcl() {
        return hjBjcl;
    }

    public void setHjBjcl(Long hjBjcl) {
        this.hjBjcl = hjBjcl;
    }

    public Long getHjBj() {
        return hjBj;
    }

    public void setHjBj(Long hjBj) {
        this.hjBj = hjBj;
    }

    public Long getHjLqdj() {
        return hjLqdj;
    }

    public void setHjLqdj(Long hjLqdj) {
        this.hjLqdj = hjLqdj;
    }

    public Long getDataflowType() {
        return dataflowType;
    }

    public void setDataflowType(Long dataflowType) {
        this.dataflowType = dataflowType;
    }

    public String getBusinessSystemCode() {
        return businessSystemCode;
    }

    public void setBusinessSystemCode(String businessSystemCode) {
        this.businessSystemCode = businessSystemCode;
    }
}
