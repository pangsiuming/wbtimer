package com.eshore.wbtimer.executor.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/25 9:40
 */
public class MessageTemplateParamBean extends DBTableParamBean implements Serializable {
    private Long templateId;
    private String templateCode;
    private String templateName;
    private String templateCodeEQ;
    private String templateNameLikeRange;
    private String templateCodeLikeRange;
    private String content;
    private String contentLikeRange;
    private String modiStaff;
    private String modiStaffLikeRange;
    private Date modiDate;
    private String modiDateRange1;
    private String modiDateRange2;
    private String extraOrderColumns;
    private String keyWord;
    private String orgCode;
    private String isMust;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateCodeEQ() {
        return templateCodeEQ;
    }

    public void setTemplateCodeEQ(String templateCodeEQ) {
        this.templateCodeEQ = templateCodeEQ;
    }

    public String getTemplateNameLikeRange() {
        return templateNameLikeRange;
    }

    public void setTemplateNameLikeRange(String templateNameLikeRange) {
        this.templateNameLikeRange = templateNameLikeRange;
    }

    public String getTemplateCodeLikeRange() {
        return templateCodeLikeRange;
    }

    public void setTemplateCodeLikeRange(String templateCodeLikeRange) {
        this.templateCodeLikeRange = templateCodeLikeRange;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentLikeRange() {
        return contentLikeRange;
    }

    public void setContentLikeRange(String contentLikeRange) {
        this.contentLikeRange = contentLikeRange;
    }

    public String getModiStaff() {
        return modiStaff;
    }

    public void setModiStaff(String modiStaff) {
        this.modiStaff = modiStaff;
    }

    public String getModiStaffLikeRange() {
        return modiStaffLikeRange;
    }

    public void setModiStaffLikeRange(String modiStaffLikeRange) {
        this.modiStaffLikeRange = modiStaffLikeRange;
    }

    public Date getModiDate() {
        return modiDate;
    }

    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }

    public String getModiDateRange1() {
        return modiDateRange1;
    }

    public void setModiDateRange1(String modiDateRange1) {
        this.modiDateRange1 = modiDateRange1;
    }

    public String getModiDateRange2() {
        return modiDateRange2;
    }

    public void setModiDateRange2(String modiDateRange2) {
        this.modiDateRange2 = modiDateRange2;
    }

    public String getExtraOrderColumns() {
        return extraOrderColumns;
    }

    public void setExtraOrderColumns(String extraOrderColumns) {
        this.extraOrderColumns = extraOrderColumns;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getIsMust() {
        return isMust;
    }

    public void setIsMust(String isMust) {
        this.isMust = isMust;
    }
}
