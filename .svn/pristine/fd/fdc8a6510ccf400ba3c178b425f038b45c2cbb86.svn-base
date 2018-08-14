package com.eshore.wbtimer.executor.common.sxsp.constants;

import java.util.HashMap;
import java.util.Map;

public class CommConstants {
	 
	
	 

	/**
	 * 配置类型
	 * @author amingliao
	 *
	 */
	public static class CONTENT_TYPE {
		public static final String SP_SETTING="SP_SETTING"; //审批系统公共设置
		
	}
	
	public static class SP_SETTING {
		public static final String DEFAULT_ALERT="DEFAULT_ALERT"; //默认告警天数
		public static final String DEFAULT_YELLOW_ALERT="DEFAULT_YELLOW_ALERT"; //红色默认告警比例
		public static final String DEFAULT_RED_ALERT="DEFAULT_RED_ALERT"; //黄色默认告警比例
		public static final String INFO_HOTLINE="INFO_HOTLINE"; //服务中心电话
		
	}
	
	/**
	 * 字典类型
	 * @author amingliao
	 *
	 */
	public static class DICT_TYPE {
		public static final String ALERT_STATUS="ALERT_STATE";      // 告警状态类型
		public static final String EFFECT_STATE="EFFECT_STATE";   // 有效状态类型
		public static final String HOLIDAY_TYPE="HOLIDAY_TYPE";   // 假期类型
		public static final String PROCESSDAY_TYPE="PROCESSDAY_TYPE";   // 日期单位（自然日，工作日）
		public static final String SB_STEP_TYPE="SB_STEP_TYPE";   // 申办单环节类型
		public static final String RECEIPT_TYPE="RECEIPT_TYPE";   // 通知单类型
		public static final String SUBMIT_RECIVE_TYPE="SUBMIT_RECIVE_TYPE";   // 提交领取方式
		public static final String APPLICANT_TYPE="APPLICANT_TYPE";   // 申请人类型
	}
	
	
	/**
	 * 申请人类型
	 * @author amingliao
	 *
	 */
	public static class APPLICANT_TYPE {
		public static final String PERSONAL = "1";      // 跟人
		public static final String COMPANY = "2";   // 企业
		public static final String OTHER = "9";   // 其他
	}
	
	/**
	 * 提交领取方式
	 * @author amingliao
	 *
	 */
	public static class SUBMIT_RECIVE_TYPE {
		public static final String WINDOW = "0";      // 实体窗口
		public static final String WEB = "1";   // 网上
		public static final String EXPRESS = "8";   // 快递 
	}
	
	/**
	 * 通知单类型
	 * @author amingliao
	 *
	 */
	public static class RECEIPT_TYPE {
		public static final String ACCEPT = "ACP";      // 项目受理单
		public static final String RECEIVE = "REC";   // 接收凭证
		public static final String REACH = "RCH";   // 送达回执
		public static final String SUPPLEMENT = "SUP";   // 材料补交通知书
		public static final String SETTLE = "STL";   // 办结通知
		public static final String CHARGE = "CHG";   // 缴费通知 
		public static final String NOT_APPLY = "NAC";  //不受理通知单
		public static final String NOT_GRANT_APPLY = "NGA";  //不预受理通知单
		public static final String NOT_SETTLE = "NST"; //办结不通过
		public static final String SETTLE_XZXK = "SAL"; //办结通过-行政许可
		public static final String NOT_SETTLE_XZXKJDS = "NSA";//办结不通过-行政许可决定书
		public static final String SUPPLEMENT_GZ = "SGZ";//补齐补正通知书
		public static final String SPECIAL_APPLY = "SPE";//特别程序通知书
		public static final String ACCEPT_SEN = "SEN";      // 综合窗口受理交接单
		public static final String SETTLE_TRA = "TRA";      // 办结证件交接单
		//添加一个新的通知单类型，邮递地址确认单 2017/9/23
		public static final String EMS = "EMS";      // 邮递地址确认单

	}
	
	public static class NOTICE_RETURN_STATUS{
		public static final String WRITE_JSON = "WRITE_JSON";//返回状态:直接用json形式返回到页面
		public static final String SAVE_FILE = "SAVE_FILE";//返回状态:直接存储在表wsbs_sb_file里，dataSour=4,
	}
	
	/**
	 * 申请单环节编码
	 * @author amingliao
	 *
	 */
	public static class SB_STEP_TYPE {
		public static final String key ="SB_STEP_TYPE";
		public static final String APPLY = "APPLY";      // 申请环节
		public static final String PREACCEPT = "PREACCEPT";   // 预受理
		public static final String ACCEPT = "ACCEPT";   // 受理
		public static final String SUPPLEMENT = "SUPPLEMENT";   // 补正资料
		public static final String SPECIAL = "SPECIAL";   // 特别程序
		public static final String APPROVE_CB = "APPROVE_CB";   // 承办
		public static final String APPROVE_SH = "APPROVE_SH";   // 审核
		public static final String APPROVE_PZ = "APPROVE_PZ";   // 批准
		public static final String SETTLE = "SETTLE";   // 办结
		public static final String LICENSE = "LICENSE";   // 领证
		public static final String DEL_SETTLE = "DEL_SETTLE";   // 删除办结

	}

	public static class SUB_STEP_TYPE {
		public static final String SPECIAL_APPLY = "SPECIAL_APPLY";   	// 特别程序申请
		public static final String SPECIAL_SP = "SPECIAL_SP";   		// 特别程序审批
		public static final String SPECIAL = "SPECIAL";   				// 特别程序结果
		public static final String APPLY = "APPLY";			//申办
		public static final String SUPPLEMENT_GZ = "SUPPLEMENT_GZ";   	// 补齐补正告知
		public static final String SUPPLEMENT = "SUPPLEMENT";   		// 补齐补正受理
	} 
	
	//进程发送短信的类型
	public static class SMS_SEND_TYPE {
		public static final String APPLY_0 = "APPLY_0";   	// 网上申请成功提醒（个人）
		public static final String ALERT_4 = "ALERT_4";   		// 网上申请成功提醒（科室负责人）
		public static final String ALERT_2 = "ALERT_2";   				// 即将到期科室负责人提醒
		public static final String ALERT_3 = "ALERT_3";			//即将到期分管领导提醒
		public static final String ALERT_5 = "ALERT_5";   	// 特别程序到期提醒
		public static final String ALERT_1 = "ALERT_1";   		// 即将到期个人提醒
		public static final String ALERT_GZ_0 = "ALERT_GZ_0";   		// 补交告知到期提醒短信-申请人
		public static final String ALERT_GZ_1 = "ALERT_GZ_1";   		// 补交告知到期提醒短信-发起补正告知的处理人
		public static final String SPECIAL_A_LEADER = "SPECIAL_A_LEADER";
		
	}
	
	/**
	 *审批环节代码
	 * @author 
	 *
	 */
	public static class APPROVE_STEP {
		public static final String key="APPROVE_STEP";
		public static final String APPROVE_CB="1";
		public static final String APPROVE_SH="2";
		public static final String APPROVE_PZ="3";
	}
	
	public static class SB_STPE_NAME{
		public static final Map<String,String> stepNameMap=new HashMap<String,String>();
		static {
			stepNameMap.put("APPLY", "申请");
			stepNameMap.put("PREACCEPT", "预受理");
			stepNameMap.put("ACCEPT", "受理");
			stepNameMap.put("SUPPLEMENT", "资料补正");
			stepNameMap.put("SPECIAL", "特别程序");
			stepNameMap.put("APPROVE_CB", "承办");
			stepNameMap.put("APPROVE_SH", "审核");
			stepNameMap.put("APPROVE_PZ", "批准");
			stepNameMap.put("SETTLE", "办结");
			stepNameMap.put("LICENSE", "领证");
			
			
		}
		
		public static final Map<String,String> stepCodeMap=new HashMap<String,String>();
		static {
//			stepNameMap.put("APPLY", "申请");
//			stepNameMap.put("PREACCEPT", "预受理");
//			stepNameMap.put("ACCEPT", "受理");
//			stepNameMap.put("SUPPLEMENT", "资料补正");
//			stepNameMap.put("SPECIAL", "特别程序");
			stepCodeMap.put("APPROVE_CB", "1");
			stepCodeMap.put("APPROVE_SH", "2");
			stepCodeMap.put("APPROVE_PZ", "3");
//			stepNameMap.put("SETTLE", "办结");
//			stepNameMap.put("LICENSE", "领证");
			
		}
		
		
	}
	
	/**
	 * 环节操作类型
	 * @author aming
	 *
	 */
	public static class STEP_ACTION {
		public static final String INI = "INI";      // 发起
		public static final String REJ = "REJ";   // 否决
		public static final String AGR = "AGR";   // 同意
	}
	
	
	/**
	 * 告警状态
	 * @author aming
	 *
	 */
	public static class ALERT_STATE {
		public static final String NORMAL="0";      // 正常
		public static final String WARNING_YELLOW="1";   // 黄色
		public static final String DELAY="2";   // 超期
		public static final String WARNING_RED="3";   // 红色 
		public static final String NONE="4";      // 无状态
	}
	
	/**
	 * 有效状态
	 * @author aming
	 *
	 */
	public static class EFFECT_STATE {
		public static final String EFFECTIVE = "S0A";      // 正常
		public static final String INEFFECTIVE = "S0X";   // 无效
	}
	
	/**
	 * 假期类型
	 * @author aming
	 *
	 */
	public static class HOLIDAY_TYPE {
		public static final String HOLIDAY = "0";      // 假期
		public static final String WORKDAY= "1";   // 工作
	}
	
	/**
	 * 日期单位（自然日，工作日）
	 * @author aming
	 *
	 */
	public static class PROCESSDAY_TYPE {
		public static final String WORKING_DAY = "G";      // 工作日
		public static final String NATURE_DAY = "Z";   // 自然日
	}
	
	/**
	 * 业务流程的当前状态（CURRENTSTATE）
	 * @author liuguofu
	 *
	 */
	public static class PROC_STATE {
		public static final Long NOT_PUBLISH=1L;      // 未发布        业务流程的该版本未发布。
		public static final Long HAS_PUBLISHED=3L;   // 已发布        业务流程的该版本已发布。
	}
	/**
	 * 流程实例的当前状态（CURRENTSTATE）
	 * @author liuguofu
	 *
	 */
	public static class PROC_INST_STATE {
		
		public static final Long NOTSTARTED=1L;// 未启动         流程实例被创建，包括与流程状态相关的日期、流程相关数据，但是流程还没有满足条件，不能执行。
		public static final Long RUNNING=2L; //  运行         流程实例已经执行，流程中的活动如果条件满足就可以执行。
		public static final Long SUSPENDED=3L; // 挂起         流程实例被禁止，并且流程中的活动不能执行，直到流程返回到running状态。
		public static final Long COMPLETED=7L; // 完成         流程实例满足结束条件。
		public static final Long TERMINATED=8L;  // 终止         流程实例在正常结束前被停止。
	}
	/**
	 * 活动实例的当前状态（CURRENTSTATE）
	 * @author liuguofu
	 *
	 */
	public static class ACT_INST_STATE {
		public static final Long NOTSTARTED=1L;// 未启动         流程实例中的活动已经被创建，但是还没有激活，并且没有任务需要处理。
		public static final Long RUNNING=2L;// 运行         活动实例已经执行，创建好的任务以可以处理。
		public static final Long SUSPENDED=3L;//挂起         活动实例被禁止。
		public static final Long COMPLETED=7L;// 完成         活动实例满足结束条件，执行完成。
		public static final Long TERMINATED=8L;// 终止         活动实例在正常结束前被停止。
		public static final Long WAIT_ACTIVATE=10L;// 待激活         活动实例等待激活。
		public static final Long APP_EXCEPTION=-1L;//应用异常         应用发生异常
	}
	/**
	 * 工作项的当前状态（CURRENTSTATE）
	 * @author liuguofu
	 *
	 */
	public static class WORKITEM_STATE {
		public static final Long WAITING_RECEIVE=4L;//         待领取
		public static final Long SUSPENDED=8L;//         挂起
		public static final Long RUNNING=10L;//         运行
		public static final Long ONCOMPLETED=12L;//         完成
		public static final Long TERMINATED=13L;//         终止
	}
	/**
	 * 工作项的业务状态（BIZSTATE）
	 * @author liuguofu
	 *
	 */
	public static class WORKITEM_BIZSTATE_STATE {
		public static final Long COMMON=0L;//   正常
		public static final Long AGENT=1L;//     代理
		public static final Long DELGATE=2L;//    代办
		public static final Long HELP=3L;//       协办
		public static final Long HELP_WAITAFFIRM=4L;//  待确认
		public static final Long HELP_REDO=6L;//     修改
	}
	
	public static class MISSION_MGR_URL{
		public static final String key="MISSION_MGR_URL";
		public static final String VIEW_MISSION_URL="VIEW_MISSION_URL";//查看任务链接
		public static final String HANDLE_MISSION_URL="HANDLE_MISSION_URL";//处理任务链接
		public static final String APPLY_MISSION_URL="APPLY_MISSION_URL";//处理任务链接
		public static final String APPLY_WW_URL="APPLY_WW_URL";//处理任务链接
		
		public static final String VIEW_MISSION_BY_PROC_URL="VIEW_MISSION_BY_PROC_URL";//通过各环节查看表单链接
	}  
 
	//运政系统事项和流程映射关系
	public static class JTYZ_FLOW_NAME{
		public static final Map<String,String> flowIdName=new HashMap<String,String>();
		static {
			flowIdName.put("10065500369814815313440400", "0301&&班车旅客运输企业经营许可流程");
			flowIdName.put("10065900269814815313440400", "0601&&道路危险货物运输企业经营许可流程");
			flowIdName.put("10066300069814815313440400", "0601&&道路危险货物运输企业经营许可流程");
			flowIdName.put("10066400069814815313440400", "0601&&道路危险货物运输企业经营许可流程");
			flowIdName.put("10065900169814815313440400", "0601&&道路危险货物运输企业经营许可流程");
			flowIdName.put("10065900369814815313440400", "0701&&普通货运企业开业流程");
			flowIdName.put("10066000069814815313440400", "0701&&普通货运企业开业流程");
			flowIdName.put("10066600269814815313440400", "0801&&汽车客运站经营业户开业流程");
			flowIdName.put("10066200069814815313440400", "3104&&外商投资道路运输企业立项流程");
			flowIdName.put("10066600469814815313440400", "3104&&外商投资道路运输企业立项流程");
			flowIdName.put("10066100069814815313440400", "3104&&外商投资道路运输企业立项流程"); 			
			
		}
	}
	
	/**
	 * dzzz告警状态
	 * @author aming
	 *
	 */
	public static class dzzzyj {
		public static final int QX=5;      // （自然日）期限
		public static final int ALERTDAY =1;   // 提前预警天数
		
	}
}
