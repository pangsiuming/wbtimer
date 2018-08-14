package com.eshore.wbtimer.executor.service.impl;

import com.eshore.emall.pub.util.DateUtil;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.sxsp.constants.CommConstants;
import com.eshore.wbtimer.executor.common.sxsp.constants.CommConstants.dzzzyj;
import com.eshore.wbtimer.executor.mapper.DzzzMapper;
import com.eshore.wbtimer.executor.mapper.bean.DzzzRWsbsBjBean;
import com.eshore.wbtimer.executor.mapper.bean.DzzzRWsbsBjParam;
import com.eshore.wbtimer.executor.service.DzzzYjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * dzzz预警任务
 */
@Service
public class DzzzYjServiceImpl implements DzzzYjService {

	@Autowired
	private DzzzMapper dzzzMapper;
	@Override
	public void startExecute() throws Exception {
		WbtimerJobLogger.log("dzzz预警任务启动");
		//获取要更新的dzzz信息
		DzzzRWsbsBjParam param=new DzzzRWsbsBjParam();
		List<DzzzRWsbsBjBean> beans=dzzzMapper.find_DZZZ_R_WSBS_BJ_lIST_YJ();//获取预警数据
		WbtimerJobLogger.log("xxxxxxxxxxxbeans.size()"+beans.size()+"xxxxxxxxxxxxxxx");
		//循环修改
		if(null!=beans&&beans.size()>0){
			
			for (DzzzRWsbsBjBean bean:beans){
				//出证办结当天不算，从第二起5个自然日必须进行证照登记，超过5个自然日未登记证照信息的为超时。
				//先提前一天预警吧
				//签发。
				Date bjTime =bean.getBjTime();
				if(null==bjTime){
					WbtimerJobLogger.log("办结时间为空！数据错误");
					continue;
				}
				int passDays = 0;
				String bjrq="";   
				String dqrq="";
			    SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd");  
			    bjrq=formatter.format(bjTime);
				  
			    SimpleDateFormat formatter2=new SimpleDateFormat("yyyyMMdd");  
			    dqrq=formatter2.format(new Date());
				if( Long.valueOf(bjrq) < Long.valueOf(dqrq)){ 
					passDays=calPassedDays(bjTime,new Date() );
				}
				//告警状态 剩余时间和告警提前天数的比较
			    //默认提前1天预警
				String alertStatus="";
				int restDay = dzzzyj.QX- passDays;
				int alertDay= dzzzyj.ALERTDAY;
				if(restDay> dzzzyj.ALERTDAY){
					alertStatus= CommConstants.ALERT_STATE.NORMAL;
				}else if(alertDay>=restDay && restDay>=0){
					alertStatus= CommConstants.ALERT_STATE.WARNING_YELLOW;
				}else if(restDay<0){
					alertStatus= CommConstants.ALERT_STATE.DELAY;
				}

				//修改预警信息
				DzzzRWsbsBjParam p=new DzzzRWsbsBjParam();
				p.setId(bean.getId());
				//预警状态:0正常，2预警，3超时
				p.setAlertStatus(alertStatus);
				p.setRestDate(restDay+0L);
				update(p);
				
			}
		}
		WbtimerJobLogger.log("dzzz预警任务结束");
	}
	
	/**
	 * 计算到当天为止，已经过去的时间
	 * @return
	 */
	public int calPassedDays(Date startDate, Date endDate) {
		int passDays=0;
		if (endDate == null)
			endDate = new Date();
	    try {
		    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");  
		    String sd=formatter.format(startDate);
			startDate=formatter.parse(sd);  
		    String ed=formatter.format(endDate);
		    endDate=formatter.parse(ed);
			
		    passDays = this.getDayBetween(startDate, endDate);
		    return passDays;

	    }catch (Exception e) {
			WbtimerJobLogger.log(e);
			
		}
		return passDays;
	}
	
	private static int getDayBetween(Date startDate, Date endDate) {
		Calendar d1 = Calendar.getInstance();
		d1.setTime(startDate);
		Calendar d2 = Calendar.getInstance();
		d2.setTime(endDate);
		int a = DateUtil.getDaysBetween(d1, d2);
		return a;
	}
	
	/**
     *  修改制证信息
     * （1）license_code可用于后续的制证接口操作
     * （2）用auth_code调用“获取证照访问令牌”接口可获得token，token可用于“查看电子证照页面”和“按对象查看电子证照页面”；
	 * @param dzzzRWsbsBjParam
	 * @return
	 */
	private boolean update(DzzzRWsbsBjParam dzzzRWsbsBjParam) {
		boolean flag=true;
		try {
			/*DzzzRWsbsBjParam param =new DzzzRWsbsBjParam();
			param.setSblsh(dzzzRWsbsBjParam.getSblsh());
			DzzzRWsbsBjBean bean=find_DZZZ_R_WSBS_BJ(param);
			if(null==bean){
				WbtimerJobLogger.log("证照日志信息没找到！");
				return false;
			}
			dzzzRWsbsBjParam.setId(bean.getId());*/
			//保存信息
			dzzzMapper.updateById(dzzzRWsbsBjParam);
		} catch (Exception e) {
			WbtimerJobLogger.log(e);
			flag=false;
		}
		
		return flag;
		
	}

}
