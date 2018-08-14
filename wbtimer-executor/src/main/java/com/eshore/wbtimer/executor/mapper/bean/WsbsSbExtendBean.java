package com.eshore.wbtimer.executor.mapper.bean;

public class WsbsSbExtendBean {
    private Long wsbsSbExtendId;

    private Long hjslbs;

    private String sblsh;

    private String fieldId;

    private String fieldName;

    private String fieldValue;

    private Long infoitemId;

    public WsbsSbExtendBean(Long wsbsSbExtendId, Long hjslbs, String sblsh, String fieldId, String fieldName, String fieldValue, Long infoitemId) {
        this.wsbsSbExtendId = wsbsSbExtendId;
        this.hjslbs = hjslbs;
        this.sblsh = sblsh;
        this.fieldId = fieldId;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.infoitemId = infoitemId;
    }

    public WsbsSbExtendBean() {
        super();
    }

    public Long getWsbsSbExtendId() {
        return wsbsSbExtendId;
    }

    public void setWsbsSbExtendId(Long wsbsSbExtendId) {
        this.wsbsSbExtendId = wsbsSbExtendId;
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

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId == null ? null : fieldId.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue == null ? null : fieldValue.trim();
    }

    public Long getInfoitemId() {
        return infoitemId;
    }

    public void setInfoitemId(Long infoitemId) {
        this.infoitemId = infoitemId;
    }
}