package com.eshore.wbtimer.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-10 16:38
 */
public class PropertiesUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
    private static final String file_name = "wbtimer-admin.properties";
    public static String getString(String key){
        Properties properties = null;
        try{
            Resource resource = new ClassPathResource(file_name);
            EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
            properties = PropertiesLoaderUtils.loadProperties(encodedResource);
        }catch (IOException e){
            logger.error(e.getMessage(),e);
        }
        if (properties!=null){
            return properties.getProperty(key);
        }
        return "";
    }
    public static String getString(String fileName,String key){
        Properties properties = null;
        try{
            Resource resource = new ClassPathResource("properties/dev/"+fileName);
            EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
            properties = PropertiesLoaderUtils.loadProperties(encodedResource);
        }catch (IOException e){
            logger.error(e.getMessage(),e);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        if (properties!=null){
            return properties.getProperty(key);
        }
        return "";
    }
    
    public static Properties getStringByFileName(String fileName){
        Properties properties = null;
        try{
            Resource resource = new ClassPathResource("properties/dev/"+fileName);
            EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
            properties = PropertiesLoaderUtils.loadProperties(encodedResource);
        }catch (IOException e){
            logger.error(e.getMessage(),e);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        if (properties!=null){
            return properties;
        }
        return null;
    }
}
