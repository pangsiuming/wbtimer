/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.eshore.wbtimer.executor.common.net.bean;

import java.util.List;
import java.util.Map;

public final class Result {
	private boolean successful;
	private List resultList;
	private Map resultMap;
	private Object result;
	private String message;

	public Result() {
		setSuccessful(false);
	}

	public Result(boolean successful, String message) {
		this(successful, message, null);
	}

	public Result(boolean successful, StringBuffer message) {
		setSuccessful(successful);
		setMessage(message);
	}

	public Result(boolean successful, String message, Object result) {
		setSuccessful(successful);
		setMessage(message);
		setResult(result);
	}

	public boolean isSuccessful() {
		return this.successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public List getResultList() {
		return this.resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(StringBuffer message) {
		this.message = message.toString();
	}

	public Object getResult() {
		return this.result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Map getResultMap() {
		return this.resultMap;
	}

	public void setResultMap(Map resultMap) {
		this.resultMap = resultMap;
	}

	public String toString() {
		String TAB = "    ";

		String retValue = "";

		retValue = "Result ( " + super.toString() + "    " + "successful = "
				+ this.successful + "    " + "resultList = " + this.resultList
				+ "    " + "resultMap = " + this.resultMap + "    "
				+ "result = " + this.result + "    " + "message = "
				+ this.message + "    " + " )";

		return retValue;
	}
}