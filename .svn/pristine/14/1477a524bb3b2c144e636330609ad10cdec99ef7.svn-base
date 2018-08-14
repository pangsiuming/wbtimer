package com.eshore.wbtimer.executor.common.net;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.constants.EosWsConst;
import com.eshore.wbtimer.executor.common.net.bean.Result;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.rpc.ParameterMode;


public class WorkflowService {

	private static String endpoint;
	private static Service service;
	private static Call call;

	static { 
		service = new Service();

	}
 
	public String createAndStart(String processDefName, String userId)
			throws Exception {
		call = (Call) service.createCall();
		call.setTargetEndpointAddress(endpoint);
		call.setOperationName("createAndStart");// WSDL里面描述的接口名称

		call.addParameter("processDefName", XMLType.XSD_STRING,
				ParameterMode.IN);// 接口的参数
		call.addParameter("userId", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数

		call.setReturnType(XMLType.XSD_STRING);// 设置返回类型

		String procDefName = processDefName;
		String usId = userId;
		String result = (String) call
				.invoke(new Object[] { procDefName, usId });
		// 给方法传递参数，并且调用方法
		return result;
	}

	public Result finishWorkItem(String endpoint,String workitemId, String userId)
			throws Exception {
		call = (Call) service.createCall();
		call.setTargetEndpointAddress(endpoint);
		call.setOperationName("finishWorkItem");// WSDL里面描述的接口名称

		call.addParameter("workitemId", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
		call.addParameter("userId", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数

		call.setReturnType(XMLType.XSD_STRING);// 设置返回类型

		String tmp_workitemId = workitemId;
		String tmp_userId = userId;
		String resultCode = (String) call.invoke(new Object[] { tmp_workitemId,
				tmp_userId });
		Result result=new Result();
		if(resultCode.equals("0")){
			result.setSuccessful(true);
		}else{
			result.setSuccessful(false);
		}
		result.setMessage(EosWsConst.workflowWSCodeMap.get(resultCode));
		return result;
	}

	
	
	public String setRelativeData(String processInstId, String xpath,
			String relaData, String userId) throws Exception {
		call = (Call) service.createCall();
		call.setTargetEndpointAddress(endpoint);
		call.setOperationName("setRelativeData");// WSDL里面描述的接口名称

		call.addParameter("processInstId", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
		call.addParameter("xpath", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
		call.addParameter("relaData", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
		call.addParameter("userId", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数

		call.setReturnType(XMLType.XSD_STRING);// 设置返回类型

		String tmp_processInstId = processInstId;
		String tmp_xpath = xpath;
		String tmp_relaData = relaData;
		String tmp_userId = userId;
		String result = (String) call.invoke(new Object[] { tmp_processInstId,
				tmp_xpath, tmp_relaData, tmp_userId });
		// 给方法传递参数，并且调用方法
		WbtimerJobLogger.log("result is "
				+ EosWsConst.workflowWSCodeMap.get(result));// 0
		return result;

	}

	public void backup(String workitemId, String destActDefId, String userId)
			throws Exception {
		call = (Call) service.createCall();
		call.setTargetEndpointAddress(endpoint);
		call.setOperationName("backup");// WSDL里面描述的接口名称

		call.addParameter("workitemId", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
		call.addParameter("destActDefId", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
		call.addParameter("userId", XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数

		call.setReturnType(XMLType.XSD_STRING);// 设置返回类型

		String tmp_workitemId = workitemId;
		String tmp_destActDefId = destActDefId;
		String tmp_userId = userId;
		String result = (String) call.invoke(new Object[] { tmp_workitemId,
				tmp_destActDefId, tmp_userId });
		// 给方法传递参数，并且调用方法
	}

}
