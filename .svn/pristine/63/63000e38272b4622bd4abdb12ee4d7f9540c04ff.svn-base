package com.eshore.wbtimer.executor.common.utils;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:04
 */
public class RepalceSpecialCharUtil {
   private  static Logger logger = LoggerFactory.getLogger(RepalceSpecialCharUtil.class);
    private static final Map<String,String> map = setMap();
    private static Map setMap(){
        Map<String,String> map = new HashMap();
        map.put("&", "&amp;");
        map.put("<", "&lt;");
        map.put(">", "&gt;");
        map.put("'", "&apos;");
        return map;
    }


    public static Object replace(Object object) {
        Class<?> clz = object.getClass();
        Field[] fields = clz.getDeclaredFields();
        try{
            for (Field field : fields) {// --for() begin
                // 如果类型是String
                if (field.getGenericType().toString().equals(
                        "class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                    // 拿到该属性的gettet方法
                    Method get = (Method) object.getClass().getMethod(
                            "get" + methodName(field.getName()));
                    String val = (String) get.invoke(object);//
                    if (val != null) {
                        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<String, String> entry = it.next();
                            val = val.replace(entry.getKey(), entry.getValue());
                        }
                    }
                    Method set = (Method) object.getClass().getMethod(
                            "set" + methodName(field.getName()),String.class);//
                    set.invoke(object, val);
                }

            }//for() --end
        }catch (Exception e) {
            // TODO: handle exception
            WbtimerJobLogger.log(e);
        }
        return object;
    }
    // 把一个字符串的第一个字母大写、效率是最高的、
    private static String methodName(String fildeName) throws Exception{
        byte[] items = fildeName.getBytes();
        if((char)items[0]>=97&&(char)items[0]<=122)//a-z对应ACSII码,即第一个字母为小写
        {
            items[0] = (byte) ((char) items[0] - 'a' + 'A');
        }
        return new String(items);
    }
}
