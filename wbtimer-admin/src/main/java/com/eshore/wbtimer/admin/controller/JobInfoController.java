package com.eshore.wbtimer.admin.controller;

import com.eshore.wbtimer.admin.core.enums.ExecutorFailStrategyEnum;
import com.eshore.wbtimer.admin.core.model.WbtimerJobGroup;
import com.eshore.wbtimer.admin.core.model.WbtimerJobInfo;
import com.eshore.wbtimer.admin.core.router.ExecutorRouteStrategyEnum;
import com.eshore.wbtimer.admin.dao.WbtimerJobGroupDao;
import com.eshore.wbtimer.admin.service.WbtimerJobService;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.enums.ExecutorBlockStrategyEnum;
import com.eshore.wbtimer.core.glue.GlueTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 描述: 任务controller
 *
 * @author Yangjinming
 * @create 2018-01-10 16:23
 */
@Controller
@RequestMapping("/jobinfo")
public class JobInfoController {
    @Resource
    private WbtimerJobGroupDao wbtimerJobGroupDao;
    @Resource
    private WbtimerJobService wbtimerJobService;

    @RequestMapping
    public String index(Model model, @RequestParam(required = false, defaultValue = "-1") int jobGroup) {

        // 枚举-字典
        model.addAttribute("ExecutorRouteStrategyEnum", ExecutorRouteStrategyEnum.values());	// 路由策略-列表
        model.addAttribute("GlueTypeEnum", GlueTypeEnum.values());								// Glue类型-字典
        model.addAttribute("ExecutorBlockStrategyEnum", ExecutorBlockStrategyEnum.values());	// 阻塞处理策略-字典
        model.addAttribute("ExecutorFailStrategyEnum", ExecutorFailStrategyEnum.values());		// 失败处理策略-字典

        // 任务组
        List<WbtimerJobGroup> jobGroupList =  wbtimerJobGroupDao.findAll();
        model.addAttribute("JobGroupList", jobGroupList);
        model.addAttribute("jobGroup", jobGroup);

        return "jobinfo/jobinfo.index";
    }

    @RequestMapping("/pageList")
    @ResponseBody
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
                                        @RequestParam(required = false, defaultValue = "10") int length,
                                        int jobGroup, String jobDesc, String executorHandler, String filterTime) {

        return wbtimerJobService.pageList(start, length, jobGroup, jobDesc, executorHandler, filterTime);
    }

    @RequestMapping("/add")
    @ResponseBody
    public ReturnT<String> add(WbtimerJobInfo jobInfo) {
        return wbtimerJobService.add(jobInfo);
    }

    @RequestMapping("/reschedule")
    @ResponseBody
    public ReturnT<String> reschedule(WbtimerJobInfo jobInfo) {
        return wbtimerJobService.reschedule(jobInfo);
    }

    @RequestMapping("/remove")
    @ResponseBody
    public ReturnT<String> remove(int id) {
        return wbtimerJobService.remove(id);
    }

    @RequestMapping("/pause")
    @ResponseBody
    public ReturnT<String> pause(int id) {
        return wbtimerJobService.pause(id);
    }

    @RequestMapping("/resume")
    @ResponseBody
    public ReturnT<String> resume(int id) {
        return wbtimerJobService.resume(id);
    }

    @RequestMapping("/trigger")
    @ResponseBody
    public ReturnT<String> triggerJob(int id) {
        return wbtimerJobService.triggerJob(id);
    }

}
