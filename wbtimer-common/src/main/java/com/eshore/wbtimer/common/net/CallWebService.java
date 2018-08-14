package com.eshore.wbtimer.common.net;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import java.util.Properties;

public class CallWebService {

	private static Logger logger = LoggerFactory.getLogger(CallWebService.class);
	private static String url = "";// 提供接口的地址
	private static String soapaction = ""; // 域名，这是在server定义的

	public CallWebService() {
		try {
			Properties prop = new Properties();
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream("wsconfig.properties"));
			url = prop.getProperty("zhSidAddr");
		} catch (Exception ex) {
			WbtimerJobLogger.log(ex);
		}
	}

	public String callQuerySqlService(String xml, String servName,
			String method, String paraName) {
		Service service = new Service();
		String returnXml = "";
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(url + servName);
			call.setOperationName(new QName(soapaction, method)); // 设置要调用哪个方法
			call.addParameter(
					new QName(soapaction, paraName), // 设置要传递的参数
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			// call.setReturnType(new QName(soapaction, "excute"),
			// Vector.class); // 要返回的数据类型（自定义类型）

			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）

			call.setUseSOAPAction(true);
			call.setSOAPActionURI(soapaction + "");

			// Vector v = (Vector) call.invoke(new Object[] { xml});// 调用方法并传递参数

			returnXml = (String) call.invoke(new Object[] { xml });// 调用方法并传递参数
			// logger.debug("returnXml==" + returnXml);

		} catch (Exception ex) {
			WbtimerJobLogger.log(ex.toString(), ex);
			return returnXml;
		}
		return returnXml;
	}

}
