package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;

@TableName("FRAME_TB_CONFIG_CONTENT")
public class FrameTbConfigContent {
    @TableId(value = "CONTENTID",type = IdType.ID_WORKER)
    private BigDecimal contentid;

    private BigDecimal typeid;

    private String contentname;

    private String contentcode;

    private String contentvalue;

    private String bak1;

    private String bak2;

    private String bak3;

    public FrameTbConfigContent(BigDecimal contentid, BigDecimal typeid, String contentname, String contentcode, String contentvalue, String bak1, String bak2, String bak3) {
        this.contentid = contentid;
        this.typeid = typeid;
        this.contentname = contentname;
        this.contentcode = contentcode;
        this.contentvalue = contentvalue;
        this.bak1 = bak1;
        this.bak2 = bak2;
        this.bak3 = bak3;
    }

    public FrameTbConfigContent() {
        super();
    }

    public BigDecimal getContentid() {
        return contentid;
    }

    public void setContentid(BigDecimal contentid) {
        this.contentid = contentid;
    }

    public BigDecimal getTypeid() {
        return typeid;
    }

    public void setTypeid(BigDecimal typeid) {
        this.typeid = typeid;
    }

    public String getContentname() {
        return contentname;
    }

    public void setContentname(String contentname) {
        this.contentname = contentname == null ? null : contentname.trim();
    }

    public String getContentcode() {
        return contentcode;
    }

    public void setContentcode(String contentcode) {
        this.contentcode = contentcode == null ? null : contentcode.trim();
    }

    public String getContentvalue() {
        return contentvalue;
    }

    public void setContentvalue(String contentvalue) {
        this.contentvalue = contentvalue == null ? null : contentvalue.trim();
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2 == null ? null : bak2.trim();
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3 == null ? null : bak3.trim();
    }
}