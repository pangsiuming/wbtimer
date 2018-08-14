package com.eshore.wbtimer.admin.controller;

import com.eshore.wbtimer.admin.controller.annotation.PermissionLimit;
import com.eshore.wbtimer.admin.controller.interceptor.PermissionInterceptor;
import com.eshore.wbtimer.admin.service.WbtimerJobService;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 描述: 主页
 *
 * @author Yangjinming
 * @create 2018-01-11 9:31
 */
@Controller
public class IndexController {
    @Resource
    WbtimerJobService wbtimerJobService;

    @RequestMapping("/")
    public String index(Model model){
        //首页数据
        Map<String, Object> dashboardInfo = wbtimerJobService.dashboardInfo();
        model.addAllAttributes(dashboardInfo);
        return "index";
    }

    @RequestMapping("/triggerChartDate")
    @ResponseBody
    public ReturnT<Map<String, Object>> triggerChartDate(Date startDate, Date endDate) {
        //图表数据
        ReturnT<Map<String, Object>> triggerChartDate = wbtimerJobService.triggerChartDate(startDate, endDate);
        return triggerChartDate;
    }
    @RequestMapping("/toLogin")
    @PermissionLimit(limit=false)
    public String toLogin(Model model, HttpServletRequest request) {
        if (PermissionInterceptor.ifLogin(request)) {
            return "redirect:/";
        }
        return "login";
    }


    @RequestMapping(value="login", method= RequestMethod.POST)
    @ResponseBody
    @PermissionLimit(limit=false)
    public ReturnT<String> loginDo(HttpServletRequest request, HttpServletResponse response, String userName, String password, String ifRemember){
        // valid
        if (PermissionInterceptor.ifLogin(request)) {
            return ReturnT.SUCCESS;
        }

        // param
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            return new ReturnT<String>(500, "账号或密码为空");
        }
        boolean ifRem = (StringUtils.isNotBlank(ifRemember) && "on".equals(ifRemember))?true:false;

        // do login
        boolean loginRet = PermissionInterceptor.login(response, userName, password, ifRem);
        if (!loginRet) {
            return new ReturnT<String>(500, "账号或密码错误");
        }
        return ReturnT.SUCCESS;
    }

    @RequestMapping(value="logout", method=RequestMethod.POST)
    @ResponseBody
    @PermissionLimit(limit=false)
    public ReturnT<String> logout(HttpServletRequest request, HttpServletResponse response){
        if (PermissionInterceptor.ifLogin(request)) {
            PermissionInterceptor.logout(request, response);
        }
        return ReturnT.SUCCESS;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
