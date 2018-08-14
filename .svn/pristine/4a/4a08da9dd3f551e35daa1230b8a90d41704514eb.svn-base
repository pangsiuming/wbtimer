package com.eshore.wbtimer.admin.controller.resolver;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述: 统一exception处理
 *
 * @author Yangjinming
 * @create 2018-01-10 16:26
 */
public class WebExceptionResolver implements HandlerExceptionResolver {
    private static transient Logger logger = LoggerFactory.getLogger(WebExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        logger.error("WebExceptionResolver:{}", ex);

        ModelAndView mv = new ModelAndView();
        HandlerMethod method = (HandlerMethod)handler;
        ResponseBody responseBody = method.getMethodAnnotation(ResponseBody.class);
        if (responseBody != null) {
            //返回是json串的
            response.setContentType("application/json;charset=UTF-8");
            mv.addObject("result", JacksonUtil.writeValueAsString(new ReturnT<String>(500, ex.toString().replaceAll("\n", "<br/>"))));
            mv.setViewName("/common/common.result");
        } else {
            mv.addObject("exceptionMsg", ex.toString().replaceAll("\n", "<br/>"));
            mv.setViewName("/common/common.exception");
        }
        return mv;
    }

}
