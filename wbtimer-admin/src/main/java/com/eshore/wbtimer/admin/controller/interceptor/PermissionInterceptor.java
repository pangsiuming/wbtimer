package com.eshore.wbtimer.admin.controller.interceptor;

import com.eshore.wbtimer.admin.controller.annotation.PermissionLimit;
import com.eshore.wbtimer.admin.core.util.CookieUtil;
import com.eshore.wbtimer.core.utils.PropertiesUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

/**
 * 描述: 权限控制 拦截器
 * 目前只在配置文件配置用户名和密码  后面接入权限控制
 * @author Yangjinming
 * @create 2018-01-10 16:25
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter{
    public static final String LOGIN_IDENTITY_KEY ="WBTIMER_LOGIN_IDENTITY";
    public static final String LOGIN_IDENTITY_TOKEN;
    static{
        String username = PropertiesUtil.getString("wbtimer.admin.login.username");
        String password = PropertiesUtil.getString("wbtimer.admin.login.password");
        // login token
        String tokenTmp = DigestUtils.md5Hex(username + "_" + password);
        tokenTmp = new BigInteger(1, tokenTmp.getBytes()).toString(16);
        LOGIN_IDENTITY_TOKEN = tokenTmp;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            //不是controller方法 不拦截
            return super.preHandle(request, response, handler);
        }
        if (!ifLogin(request)) {
            //没登录
            HandlerMethod method = (HandlerMethod)handler;
            PermissionLimit permission = method.getMethodAnnotation(PermissionLimit.class);
            if (permission == null || permission.limit()) {
                //没用permission注解或注解值为false的方法 跳到tologin接口
                response.sendRedirect(request.getContextPath() + "/toLogin");
                return false;
            }
        }

        return super.preHandle(request, response, handler);
    }

    public static boolean login(HttpServletResponse response, String username, String password, boolean ifRemember){

        // login token
        String tokenTmp = DigestUtils.md5Hex(username + "_" + password);
        tokenTmp = new BigInteger(1, tokenTmp.getBytes()).toString(16);

        if (!LOGIN_IDENTITY_TOKEN.equals(tokenTmp)){
            return false;
        }

        // do login
        CookieUtil.set(response, LOGIN_IDENTITY_KEY, LOGIN_IDENTITY_TOKEN, ifRemember);
        return true;
    }

    public static void logout(HttpServletRequest request, HttpServletResponse response){
        CookieUtil.remove(request, response, LOGIN_IDENTITY_KEY);
    }
    public static boolean ifLogin(HttpServletRequest request){
        String indentityInfo = CookieUtil.getValue(request, LOGIN_IDENTITY_KEY);
        if (indentityInfo==null || !LOGIN_IDENTITY_TOKEN.equals(indentityInfo.trim())) {
            return false;
        }
        return true;
    }

}
