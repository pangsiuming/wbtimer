package com.eshore.wbtimer.admin.controller.interceptor;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 描述: 将请求的cookie放到model中
 *
 * @author Yangjinming
 * @create 2018-01-10 16:25
 */
public class CookieInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        if (modelAndView!=null && ArrayUtils.isNotEmpty(request.getCookies())) {
            HashMap<String, Cookie> cookieMap = new HashMap<String, Cookie>();
            for (Cookie ck : request.getCookies()) {
                cookieMap.put(ck.getName(), ck);
            }
            modelAndView.addObject("cookieMap", cookieMap);
        }

        super.postHandle(request, response, handler, modelAndView);
    }

}
