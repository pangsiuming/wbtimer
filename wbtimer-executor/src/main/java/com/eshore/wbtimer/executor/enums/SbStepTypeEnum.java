package com.eshore.wbtimer.executor.enums;

/**
 * 描述:环节类型，字典编码：SB_STEP_TYPE
 *
 * @author Yangjinming
 * @create 2018/1/31 17:00
 */
public enum SbStepTypeEnum {

    /** 申请 */
    SB("APPLY"),
    /** 预受理 */
    YSL("PREACCEPT"),
    /** 受理 */
    SL("ACCEPT"),
    /** 补正告知 */
    BZGZ("SUPPLEMENT_GZ"),
    /** 补正资料 */
    BZSL("SUPPLEMENT"),
    /** 特别程序 申请*/
    TBCXSQ("SPECIAL_APPLY"),
    /** 特别程序 */
    TBCXJG("SPECIAL"),
    /** 承办 */
    CB("APPROVE_CB"),
    /** 审核 */
    SH("APPROVE_SH"),
    /** 批准 */
    PZ("APPROVE_PZ"),
    /** 办结 */
    BJ("SETTLE"),
    /** 领证 */
    LZ("LICENSE");

    private final String value;

    private SbStepTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
