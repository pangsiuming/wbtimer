package com.eshore.wbtimer.executor.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;


public class DataFormatXmlUtil {
	
	static Logger logger=Logger.getLogger(DataFormatXmlUtil.class);
	
	public static String dataFormatXml(String tableName,Map<String,Object> map){ 
		StringBuffer sb=new StringBuffer("<?xml version='1.0' encoding='utf-8'?>");
		sb.append("<ExInfo><standardInfo process='");
		sb.append(tableName);
		sb.append("'>");
		
		for(String key : map.keySet()){
			if("HJSLBS".equals(key)){
				continue;
			}
			Object obj=map.get(key);
			String str="";
			if(obj==null){
			    str="";
			}else{
				str=obj.toString();
			}
			sb.append("<Field FieldName='");
			sb.append(key);
			sb.append("'>");
			sb.append(str);
			sb.append("</Field>");
						
		}
		sb.append("</standardInfo></ExInfo>");
		return sb.toString();
	}

}
