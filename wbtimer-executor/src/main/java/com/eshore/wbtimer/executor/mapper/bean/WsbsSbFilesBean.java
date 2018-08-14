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
 * @create 2018/1/26 9:32
 */
@TableName("WSBS_SB_FILES")
public class WsbsSbFilesBean extends DBTableParamBean implements Serializable {
    @TableId(value = "WSBS_SB_FILES_ID",type = IdType.AUTO)
    private Long wsbsSbFilesId;
    private Long hjslbs;
    private Long filesId;
    private String fileName;
    private String fileType;
    private String certId;
    private String holder;
    private Date certDate;
    private String expDate;
    private String dzfjs;
    private String sblsh;
    private Date createTime;
    private String isrequire;
    private String documentName;
    private byte[] fileData;
    private String saveRoute;
    private String state;
    private String ifMustSubmit;
    private String staffId;
    private Date modDate;
    private String checkResult;
    private String ifAlreadSubmit;
    private String remark;
    private String extField1;
    private String extField2;
    private String extField3;
    private String extField4;
    private String extField5;
    private Long srvsdocSrvsimId;
    private String dataSouce;
    private String wsbsSbFilesCode;
    private String staffName;

    private String clmc;

    private String dzzlkZlbm;
    private String sxbm;
    private String sqgxcs;
    private String sqgxymzt;

    public Long getWsbsSbFilesId() {
        return wsbsSbFilesId;
    }

    public void setWsbsSbFilesId(Long wsbsSbFilesId) {
        this.wsbsSbFilesId = wsbsSbFilesId;
    }

    public Long getHjslbs() {
        return hjslbs;
    }

    public void setHjslbs(Long hjslbs) {
        this.hjslbs = hjslbs;
    }

    public Long getFilesId() {
        return filesId;
    }

    public void setFilesId(Long filesId) {
        this.filesId = filesId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Date getCertDate() {
        return certDate;
    }

    public void setCertDate(Date certDate) {
        this.certDate = certDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getDzfjs() {
        return dzfjs;
    }

    public void setDzfjs(String dzfjs) {
        this.dzfjs = dzfjs;
    }

    public String getSblsh() {
        return sblsh;
    }

    public void setSblsh(String sblsh) {
        this.sblsh = sblsh;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsrequire() {
        return isrequire;
    }

    public void setIsrequire(String isrequire) {
        this.isrequire = isrequire;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getSaveRoute() {
        return saveRoute;
    }

    public void setSaveRoute(String saveRoute) {
        this.saveRoute = saveRoute;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIfMustSubmit() {
        return ifMustSubmit;
    }

    public void setIfMustSubmit(String ifMustSubmit) {
        this.ifMustSubmit = ifMustSubmit;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getIfAlreadSubmit() {
        return ifAlreadSubmit;
    }

    public void setIfAlreadSubmit(String ifAlreadSubmit) {
        this.ifAlreadSubmit = ifAlreadSubmit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtField1() {
        return extField1;
    }

    public void setExtField1(String extField1) {
        this.extField1 = extField1;
    }

    public String getExtField2() {
        return extField2;
    }

    public void setExtField2(String extField2) {
        this.extField2 = extField2;
    }

    public String getExtField3() {
        return extField3;
    }

    public void setExtField3(String extField3) {
        this.extField3 = extField3;
    }

    public String getExtField4() {
        return extField4;
    }

    public void setExtField4(String extField4) {
        this.extField4 = extField4;
    }

    public String getExtField5() {
        return extField5;
    }

    public void setExtField5(String extField5) {
        this.extField5 = extField5;
    }

    public Long getSrvsdocSrvsimId() {
        return srvsdocSrvsimId;
    }

    public void setSrvsdocSrvsimId(Long srvsdocSrvsimId) {
        this.srvsdocSrvsimId = srvsdocSrvsimId;
    }

    public String getDataSouce() {
        return dataSouce;
    }

    public void setDataSouce(String dataSouce) {
        this.dataSouce = dataSouce;
    }

    public String getWsbsSbFilesCode() {
        return wsbsSbFilesCode;
    }

    public void setWsbsSbFilesCode(String wsbsSbFilesCode) {
        this.wsbsSbFilesCode = wsbsSbFilesCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getClmc() {
        return clmc;
    }

    public void setClmc(String clmc) {
        this.clmc = clmc;
    }

    public String getDzzlkZlbm() {
        return dzzlkZlbm;
    }

    public void setDzzlkZlbm(String dzzlkZlbm) {
        this.dzzlkZlbm = dzzlkZlbm;
    }

    public String getSxbm() {
        return sxbm;
    }

    public void setSxbm(String sxbm) {
        this.sxbm = sxbm;
    }

    public String getSqgxcs() {
        return sqgxcs;
    }

    public void setSqgxcs(String sqgxcs) {
        this.sqgxcs = sqgxcs;
    }

    public String getSqgxymzt() {
        return sqgxymzt;
    }

    public void setSqgxymzt(String sqgxymzt) {
        this.sqgxymzt = sqgxymzt;
    }
}
