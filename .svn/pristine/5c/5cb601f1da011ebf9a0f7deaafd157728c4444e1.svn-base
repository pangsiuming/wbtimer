package com.eshore.wbtimer.executor.common.utils;


import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.core.utils.PropertiesUtil;
import com.eshore.wbtimer.executor.common.net.bean.Axis2WebServiceBean;
import com.eshore.wbtimer.executor.common.net.bean.DealResult;
import com.eshore.wbtimer.executor.enums.ExTableNameEnum;
import com.eshore.wbtimer.executor.enums.PropertiesEnum;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.commons.lang3.StringUtils;

import javax.xml.namespace.QName;

/**
 * web service 接口调用入口
 */
public class Axis2WebServiceUtil {
 
	//static WsPropertiesHelper wsPropertiesHelper = new WsPropertiesHelper();
	static String intfURL="";
	static String intfNamespce="";
	static String intfDeptCode="";
	static String intfIdentify="";

	static {
		intfURL = PropertiesUtil.getString("stdWebService.properties","intfURL");
		intfNamespce = PropertiesUtil.getString("stdWebService.properties","intfNamespce");
		intfDeptCode = PropertiesUtil.getString("stdWebService.properties","intfDeptCode");
		intfIdentify = PropertiesUtil.getString("stdWebService.properties","intfIdentify");
    }
	
	public Axis2WebServiceUtil() {
		
	}

	/**
	 * 数据平台接口
	 * 
	 * @param tname
	 *            数据平台数据表名称
	 * @param methodName
	 *            调用方法名称
	 * @param sendXml
	 *            发送报文
	 * @return
	 * @throws Exception
	 */
	public static String callDataPlatformIntf(String tname, String methodName, String sendXml) throws Exception {

		String msg = "false";
		try {
			if (StringUtils.isEmpty(sendXml))
				throw new Exception("发送的报文为空，请确认发送参数！");
//			System.out.println("------- 数据平台接口发送报文：\n" + sendXml);
//			System.out.println("------- 数据平台接口发送URL：\n" + wsPropertiesHelper.getValueByKey(PropertiesEnum.DATAPLATFORM_WSDLURI.getValue()));
//			System.out.println("------- 数据平台接口发送methodName：\n" + wsPropertiesHelper.getValueByKey(PropertiesEnum.DATAPLATFORM_NAMESPACE.getValue()));
			msg = callBack(
					new Axis2WebServiceBean(PropertiesUtil.getString("wsconfig.properties",PropertiesEnum.DATAPLATFORM_WSDLURI.getValue()),
							methodName, PropertiesUtil.getString("wsconfig.properties", PropertiesEnum.DATAPLATFORM_NAMESPACE.getValue()),
							new Object[] { "123456789", sendXml, tname,
									PropertiesUtil.getString("wsconfig.properties",PropertiesEnum.DATAPLATFORM_SIDENTIFY.getValue()) }),
					DealResult.class).toString(); 
//			 System.out.println("------- 数据平台接口返回结果：\n" + msg);
		} catch (Exception e) {
			throw e;
		}
		return msg;
	}
	
	
	/**
	 * 数据平台接口
	 * 
	 * @param tname
	 *            数据平台数据表名称
	 * @param methodName
	 *            调用方法名称
	 * @param sendXml
	 *            发送报文
	 * @return
	 * @throws Exception
	 */
	public static String callDataPlatformIntforFj(String tname, String methodName, String sendXml) throws Exception {

		String msg = "false";
		try {
			if (StringUtils.isEmpty(sendXml))
				throw new Exception("发送的报文为空，请确认发送参数！");
//			System.out.println("------- 数据平台接口发送报文：\n" + sendXml);
//			System.out.println("------- 数据平台接口发送URL：\n" + wsPropertiesHelper.getValueByKey(PropertiesEnum.DATAPLATFORM_WSDLURI.getValue()));
//
//			System.out.println("------- 数据平台接口发送methodName：\n" + wsPropertiesHelper.getValueByKey(PropertiesEnum.DATAPLATFORM_NAMESPACE.getValue()));
			msg = callBack(
					new Axis2WebServiceBean(PropertiesUtil.getString("wsconfig.properties",PropertiesEnum.DATAPLATFORM_WSDLURI.getValue()),
							methodName, PropertiesUtil.getString("wsconfig.properties",PropertiesEnum.DATAPLATFORM_NAMESPACE.getValue()),
							new Object[] { "440404", sendXml, tname,"cn2PD2hXvDzn2EPK"
									//wsPropertiesHelper.getValueByKey(PropertiesEnum.DATAPLATFORM_SIDENTIFY.getValue())
						}),
					DealResult.class).toString();
//			 System.out.println("------- 数据平台接口返回结果：\n" + msg);
		} catch (Exception e) {
			throw e;
		}
		return msg;
	}
	/**
	 * 数据平台接口—通用查询服务
	 * 
	 * @param methodName
	 *            调用方法名称
	 * @param sendXml
	 *            发送报文
	 * @return
	 * @throws Exception
	 */
	public static String callDataPlatformQueryIntf(String methodName, String sendXml) throws Exception {

		String msg = "false";
		try {
			if (StringUtils.isEmpty(sendXml))
				throw new Exception("发送的报文为空，请确认发送参数！");
//			System.out.println("------- 数据平台接口（通用查询服务）发送报文：\n" + sendXml);
//			System.out.println("------- 数据平台接口（通用查询服务）发送URL：\n" + wsPropertiesHelper.getValueByKey(PropertiesEnum.DATAPLATFORM_WSDLURIQUERY.getValue()));
//
//			System.out.println("------- 数据平台接口（通用查询服务）发送methodName：\n" + wsPropertiesHelper.getValueByKey(PropertiesEnum.DATAPLATFORM_NAMESPACE.getValue()));
			msg = callBack(
					new Axis2WebServiceBean(PropertiesUtil.getString("wsconfig.properties",PropertiesEnum.DATAPLATFORM_WSDLURIQUERY.getValue()),
							methodName, PropertiesUtil.getString("wsconfig.properties",PropertiesEnum.DATAPLATFORM_NAMESPACE.getValue()),
							new Object[] {sendXml}),
							String.class).toString(); 
//			 System.out.println("------- 数据平台接口（通用查询服务）返回结果：\n" + msg);
		} catch (Exception e) {
			throw e;
		}
		return msg;
	}

	/**
	 * 普元接口调用
	 * 
	 * @param methodName
	 *            调用方法名称
	 * @param methodParams
	 *            方法参数
	 * @return
	 * @throws Exception
	 */
	public static String callPyIntf(String methodName, Object[] methodParams) throws Exception {

		String namespaceURI = "";
		String msg = "false";
		try {
			msg = callBack(
					new Axis2WebServiceBean(PropertiesUtil.getString("wsconfig.properties",PropertiesEnum.PY_WSDLURL.getValue()), methodName,
							namespaceURI, methodParams), String.class).toString();
//			 System.out.println("------- 普元接口调用结果：\n" + msg);
		} catch (Exception e) {
			throw e;
		}
		return msg;
	}

	/**
	 * 接口调用
	 * 
	 * @param axis2WebServiceBean
	 *            参数
	 * @param resultClassType
	 *            方法返回类型
	 * @return
	 * @throws Exception
	 */
	private static Object callBack(Axis2WebServiceBean axis2WebServiceBean, Class<?> resultClassType) throws Exception {

		try {
			RPCServiceClient serviceClient = new RPCServiceClient();
			// 可以在该对象中设置服务端的验证信息
			Options options = serviceClient.getOptions();
			EndpointReference targetEPR = new EndpointReference(axis2WebServiceBean.getWsdlURI());
			options.setTo(targetEPR);

			/**
			 * 返回参数类型，这个和axis1有点区别
			 * invokeBlocking方法有三个参数，其中第一个参数的类型是QName对象，表示要调用的方法名；
			 * 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；
			 * 第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。
			 * 当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}
			 * 如果被调用的WebService方法没有返回值，应使用RPCServiceClient类的invokeRobust方法，
			 * 该方法只有两个参数，它们的含义与invokeBlocking方法的前两个参数的含义相同
			 */
			QName opAddEntry = new QName(axis2WebServiceBean.getNamespaceURI(), axis2WebServiceBean.getMethodName());
			Object[] opAddEntryArgs = axis2WebServiceBean.getMethodParams();
			Object[] result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, new Class[] { resultClassType });
			serviceClient.cleanupTransport();
			serviceClient.cleanup();
			serviceClient=null;
			return result[0];
		} catch (AxisFault e) {
			throw e;
		}
	}
	

	public static void main(String[] args) {

		for(int i=0;i<3;i++){
		try {
//			// 数据平台接口调试调试
//			ExTableNameEnum tname = ExTableNameEnum.EX_SB;
//			String tableName = tname.getValue();
//			WsbsSbBean _dbTableDataBean = new WsbsSbBean();
////			_dbTableDataBean.setSblsh(241L);
////			_dbTableDataBean.setServiceItemId(682L);
//			_dbTableDataBean.setSxbm("10028400000699455214440403");
//			_dbTableDataBean.setSxmc("水土保持方案的审批");
////			_dbTableDataBean.setSbhzh("10028400000699455211402120001");
//			_dbTableDataBean.setSqrlx("1");
//			_dbTableDataBean.setSqrmc("阿斯蒂芬");
//			_dbTableDataBean.setLxrsj("13333333333");
//			_dbTableDataBean.setSbxmmc("阿法斯蒂芬");
//			_dbTableDataBean.setSbclqd("阿斯蒂芬");
//			_dbTableDataBean.setXzqhdm("gddx");
//			_dbTableDataBean.setSbsj(new Date());
//			_dbTableDataBean.setLxrsfzjhm("888888");
//			_dbTableDataBean.setSqrzjhm("1");
//			_dbTableDataBean.setProcessinstid(701L);
//			// _dbTableDataBean.setLxrxm("admin");

			// String dataXml =
			// DataPlatformXmlUtil.getSendTableXml(ExTableNameEnum.EX_SPCL,
			// _dbTableDataBean);

			String dataXml = "<?xml version='1.0' encoding='utf-8'?><ExInfo><standardInfo process=\"EX_GDBS_SP\"><Field FieldName=\"SBLSH\">10131300500698857411409161687</Field>";
			dataXml +="<Field FieldName=\"SXBM\">10131300500698857413440400</Field>";
			dataXml +="<Field FieldName=\"SPHJDM\">3</Field>";
			dataXml += "<Field FieldName=\"SPHJMC\">批准</Field>";
			dataXml += " <Field FieldName=\"SPBMMC\">珠海市工商行政管理局</Field>";
			dataXml +=" <Field FieldName=\"SPBMZZJDDM\">006988574</Field>";
        dataXml += "<Field FieldName=\"XZQHDM\">440400</Field>";
        dataXml += "<Field FieldName=\"SPRXM\">何俊兵</Field>";
        dataXml += " <Field FieldName=\"SPRZWDM\"></Field>";
        dataXml += "<Field FieldName=\"SPRZWMC\"></Field>";
        dataXml += "<Field FieldName=\"SPYJ\">接收预受理</Field>";
        dataXml += "<Field FieldName=\"SPSJ\">2014-9-19 14:10:10</Field>";
        dataXml += "<Field FieldName=\"SPHJZTDM\">3</Field>";
        dataXml += "</standardInfo>";
        dataXml +="</ExInfo>";
			System.out.println(Axis2WebServiceUtil.callDataPlatformIntf(ExTableNameEnum.EX_SPCL.getValue(), "setDataXmlToFocus", dataXml));

			// 普元接口调试
//			 new Axis2WebServiceUtil().callPyIntf("finishWorkItem", new Object[] { "3044", "yaoyaoyao" });
			
			//通用查询服务调试
			//String dataXml = "<?xml version='1.0' encoding='utf-8'?><ExInfo><standardInfo process=\"QRY_SERV\"><Field FieldName=\"QRY_CODE\">EX_GDBS_BJCL</Field><Field FieldName=\"SBLSH\">10075000169811328411401050001</Field>"+"</standardInfo></ExInfo>";
//			System.out.println(Axis2WebServiceUtil.callDataPlatformQueryIntf("excute", dataXml));
//			
//			try {
//				RPCServiceClient serviceClient = new RPCServiceClient();
//				// 可以在该对象中设置服务端的验证信息
//				Options options = serviceClient.getOptions();
//				EndpointReference targetEPR = new EndpointReference("http://19.48.17.156:99/GZWBXTService.asmx");
//				options.setTo(targetEPR);
//				Axis2WebServiceBean an=new Axis2WebServiceBean("http://19.48.17.156:99/GZWBXTService.asmx",
//								"SendRequest", "http://tempuri.org/",new Object[] {""}); 
//				serviceClient.addStringHeader(new QName("http://tempuri.org/", "field", "Ns"), "<tem:AuthorizationSoapHeader><tem:UserName>ZHSYZWBLT</tem:UserName><tem:Password>ZHWB369874</tem:Password><tem:City>222</tem:City></tem:AuthorizationSoapHeader>");
//				/**
//				 * 返回参数类型，这个和axis1有点区别
//				 * invokeBlocking方法有三个参数，其中第一个参数的类型是QName对象，表示要调用的方法名；
//				 * 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；
//				 * 第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。
//				 * 当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}
//				 * 如果被调用的WebService方法没有返回值，应使用RPCServiceClient类的invokeRobust方法，
//				 * 该方法只有两个参数，它们的含义与invokeBlocking方法的前两个参数的含义相同
//				 */
//				QName opAddEntry = new QName("http://tempuri.org/", "SendRequest");
//				Object[] opAddEntryArgs = an.getMethodParams();
//				Object[] result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, new Class[] { String.class });
//				serviceClient.cleanupTransport();
//				serviceClient.cleanup();
//				serviceClient=null;
//				System.out.println(result[0]);
//			} catch (AxisFault e) {
//				throw e;
//			}
		} catch (Exception e) {
			WbtimerJobLogger.log(e);
		}
		}
	}
	
	/**
	 * 数据平台接口
	 * 
	 * @param tname
	 *            数据平台数据表名称
	 * @param methodName
	 *            调用方法名称
	 * @param sendXml
	 *            发送报文
	 * @return
	 * @throws Exception
	 */
	public static String callDataPlatformForStd(String tname, String methodName, String sendXml) throws Exception {
        
		String msg = "false";
		try {
			if (StringUtils.isEmpty(sendXml))
				throw new Exception("发送的报文为空，请确认发送参数！");
			msg = callBack(new Axis2WebServiceBean(intfURL,methodName, intfNamespce,new Object[] { intfDeptCode, sendXml, tname,intfIdentify }),
				DealResult.class).toString(); 
		} catch (Exception e) {
			throw e;
		}
		return msg;
	}
}
