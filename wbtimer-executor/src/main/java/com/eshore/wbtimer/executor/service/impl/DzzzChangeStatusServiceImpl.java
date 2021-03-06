package com.eshore.wbtimer.executor.service.impl;

import com.eshore.wbtimer.common.utils.StringUtil;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.utils.HttpCall;
import com.eshore.wbtimer.executor.common.utils.WSConfigUtil;
import com.eshore.wbtimer.executor.mapper.DzzzMapper;
import com.eshore.wbtimer.executor.mapper.bean.DzzzRWsbsBjBean;
import com.eshore.wbtimer.executor.mapper.bean.DzzzRWsbsBjParam;
import com.eshore.wbtimer.executor.service.DzzzChangeStatusService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 修改证照状态
 * DRAFT 草案 REGISTERED 已制证（未签发） ISSUED 已签发 ABOLISHED 已废止
 * REGISTERED to ISSUED
 */
@Service
public class DzzzChangeStatusServiceImpl implements DzzzChangeStatusService {

	@Autowired
	private DzzzMapper dzzzMapper;
	@Override
	public void startChange() throws Exception {
		WbtimerJobLogger.log("dzzz修改证照状态任务启动");
		//获取要修改状态的证照数据，循环修改状态
		DzzzRWsbsBjParam param=new DzzzRWsbsBjParam();
		param.setStatus("REGISTERED");
		List<DzzzRWsbsBjBean> beans=dzzzMapper.find_DZZZ_R_WSBS_BJ_list(param);
		if(null!=beans&&beans.size()>0){
			for (DzzzRWsbsBjBean bean:beans){
				try {
					if(null!=bean){
	            	   //查询证照状态
	            		String authCode=bean.getAuthCode();
	            		if(!StringUtil.isEmpty(authCode)){
	            			DzzzRWsbsBjBean re=getDzzzStatus(authCode);
	            			if(null!=re&&!StringUtil.isEmpty(re.getStatus())&&"ISSUED".equals(re.getStatus())){
	            				DzzzRWsbsBjParam p=new DzzzRWsbsBjParam();
	            				p.setId(bean.getId());
	            				p.setStatus(re.getStatus());
	            				p.setIssueTime(re.getIssueTime());
	            				//更新状态
	            			    update(p);
	            			}
	            			
	            		}

		            }
				} catch (Exception e) {
					WbtimerJobLogger.log(e);
				}
			}
			
		}
		WbtimerJobLogger.log("dzzz修改证照状态任务结束");
	}
	
	/**
	 * 获取证照状态
	 * DRAFT 草案 REGISTERED 已制证（未签发） ISSUED 已签发 ABOLISHED 已废止
	 */
    public DzzzRWsbsBjBean getDzzzStatus(String license_auth_code) {
		//http://14.215.113.30:8098/license/use/get_licenseDirect?elName=TEST&elKey=68577158464&license_auth_code=440900116006401180206111045VDTQ
		if(null==license_auth_code||"".equals(license_auth_code)){
			WbtimerJobLogger.log("参数不能为空");
			return null;
		}
		DzzzRWsbsBjBean bean=new DzzzRWsbsBjBean();
		String license_status="";
		String issue_date="";
		String response=getDzzzxx(license_auth_code);
		if(!"".equals(response)){
			 JSONObject jsonObject =JSONObject.fromObject(response);
			 String ack_code=jsonObject.getString("ack_code");
			 if(!"".equals(ack_code)&&"SUCCESS".equals(ack_code)){
			     String data=jsonObject.getString("data");
				 if(!"".equals(data)){
					 JSONObject datajson =JSONObject.fromObject(data);
					 license_status=datajson.getString("license_status");
					 bean.setStatus(license_status);
					 //"issue_date": "2017-10-13 00:00:00",
					 issue_date=datajson.getString("issue_date");
					 if(null!=issue_date&&!"".equals(issue_date)){

						SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
						try {
							Date issueTime = formatter.parse(issue_date);
							bean.setIssueTime(issueTime);
						} catch (ParseException e) {
							WbtimerJobLogger.log(e);
						}
						
					 }

				 }
			 }
				
		 }
		
		 return bean;	
	}

    /**
	 * 获取证照信息
	 * 制证成功返回license_auth_code
	 * 根据license_auth_code获取证照信息 
	 */
	public String getDzzzxx(String license_auth_code){
		if(null==license_auth_code||"".equals(license_auth_code)){
			WbtimerJobLogger.log("参数不能为空！");
			return 	"error";
		}
		String beseUrl= WSConfigUtil.getValue("beseUrl");
		//@@
		//beseUrl="http://14.215.113.30:8098";
		String url=beseUrl+"/license/use/get_licenseDirect?&elName="+ WSConfigUtil.getValue("elName")+"&elKey="+ WSConfigUtil.getValue("elKey")+"&license_auth_code="+license_auth_code;
		String response=doService(url,"GET","");
		if(!"".equals(response)){
			return response;
		}
		return "";
	}
	
	 /**
	  * 调用接口 返回数据
	  * @param url
	  * @param POSTorGet
	  * @param param
	  * @return
	  */
		 
	public String doService(String url, String POSTorGet, String param){
		WbtimerJobLogger.log("url:"+url);
		WbtimerJobLogger.log("param:"+param);
	    String response="";
		try {
			if (url.toUpperCase().indexOf("HTTPS://") != 0) {
				response = HttpCall.httpInvoke(url, POSTorGet, param);
			} else {
				response = HttpCall.httpsInvoke(url, POSTorGet, param);
			}
			 WbtimerJobLogger.log(response);
		} catch (Exception e) {
			WbtimerJobLogger.log(e);
		}
	    return response;
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
