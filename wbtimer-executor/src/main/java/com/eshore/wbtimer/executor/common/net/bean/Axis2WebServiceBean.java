package com.eshore.wbtimer.executor.common.net.bean;

/**
 * web Service调用参数
 */
public class Axis2WebServiceBean {

	private String wsdlURI; // web service地址
	private String methodName; // 调用方法
	private String namespaceURI = ""; // 命名空间
	private Object[] methodParams; // 方法参数

	public Axis2WebServiceBean(String wsdlURI, String methodName, String namespaceURI, Object[] methodParams) {
		this.wsdlURI = wsdlURI;
		this.methodName = methodName;
		this.namespaceURI = namespaceURI;
		this.methodParams = methodParams;
	}

	public String getWsdlURI() {
		return wsdlURI;
	}

	public void setWsdlURI(String wsdlURI) {
		this.wsdlURI = wsdlURI;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}

	public Object[] getMethodParams() {
		return methodParams;
	}

	public void setMethodParams(Object[] methodParams) {
		this.methodParams = methodParams;
	}

}
