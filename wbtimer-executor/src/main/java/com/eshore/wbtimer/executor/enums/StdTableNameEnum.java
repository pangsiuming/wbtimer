package com.eshore.wbtimer.executor.enums;

/**
 * 数据平台发送表名（数据同步需要，请勿随意添加enum类型）
 */
public enum StdTableNameEnum {

	/** 数据平台接口表 - 申办 */
	EX_SB("EX_GDBS_SB"),
	/** 数据平台接口表 - 网上预受理 */
	EX_WSYSL("EX_GDBS_WSYSL"),
	/** 数据平台接口表 - 受理 */
	EX_SL("EX_GDBS_SL"),
	/** 数据平台接口表 - 审批（承办，审核，批准） */
	EX_SPCL("EX_GDBS_SPCL"),
	/** 数据平台接口表 - 补交告知 */
	EX_BJGZ("EX_GDBS_BJGZ"),
	/** 数据平台接口表 - 补交受理 */
	EX_BJSL("EX_GDBS_BJSL"),
	/** 数据平台接口表 - 特别程序申请 */
	EX_TBCXSQ("EX_GDBS_TBCXSQ"),
	/** 数据平台接口表 - 特别程序申请结果 */
	EX_TBCXJG("EX_GDBS_TBCXJG"),
	/** 数据平台接口表 - 办结 */
	EX_BJ("EX_GDBS_BJ"),
	/** 数据平台接口表 - 领证登记 */
	EX_LQDJ("EX_GDBS_LQDJ");

	private final String value;

	private StdTableNameEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
