package com.eshore.wbtimer.executor.common.utils;

import com.eshore.wbtimer.core.utils.PropertiesUtil;

import java.util.Properties;

public class WSConfigUtil {
	private Properties prop;
	private static WSConfigUtil config = new WSConfigUtil();;
	
	private WSConfigUtil(){
		init();
	}
	
	public static WSConfigUtil getConfig(){
		return config;
	}
	
	public Properties getProp(){
		return prop;
	}
	
	private void init(){
		try{
			prop = new Properties();
			prop= PropertiesUtil.getStringByFileName("wsconfig.properties");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public static String getValue(String key){
		if(getConfig().getProp() == null){
			return "";
		}
		String value = getConfig().getProp().getProperty(key);
		return value == null?"":value;
	}

}
