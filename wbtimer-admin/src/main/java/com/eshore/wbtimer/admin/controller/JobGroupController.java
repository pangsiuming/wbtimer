package com.eshore.wbtimer.admin.controller;

import com.eshore.wbtimer.admin.core.model.WbtimerJobGroup;
import com.eshore.wbtimer.admin.dao.WbtimerJobGroupDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobInfoDao;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述: 执行器页面
 *
 * @author Yangjinming
 * @create 2018-01-11 10:43
 */
@Controller
@RequestMapping("/jobgroup")
public class JobGroupController {

    @Resource
    public WbtimerJobInfoDao wbtimerJobInfoDao;
    @Resource
    public WbtimerJobGroupDao wbtimerJobGroupDao;

    @RequestMapping
    public String index(Model model) {

        // handler group (executor)
        List<WbtimerJobGroup> list = wbtimerJobGroupDao.findAll();

        model.addAttribute("list", list);
        return "jobgroup/jobgroup.index";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ReturnT<String> save(WbtimerJobGroup wbtimerJobGroup){

        // valid
        if (wbtimerJobGroup.getAppName()==null || StringUtils.isBlank(wbtimerJobGroup.getAppName())) {
            return new ReturnT<String>(500, "请输入AppName");
        }
        if (wbtimerJobGroup.getAppName().length()>64) {
            return new ReturnT<String>(500, "AppName长度限制为4~64");
        }
        if (wbtimerJobGroup.getTitle()==null || StringUtils.isBlank(wbtimerJobGroup.getTitle())) {
            return new ReturnT<String>(500, "请输入名称");
        }
        if (wbtimerJobGroup.getAddressType()!=0) {
            if (StringUtils.isBlank(wbtimerJobGroup.getAddressList())) {
                return new ReturnT<String>(500, "手动录入注册方式，机器地址不可为空");
            }
            String[] addresss = wbtimerJobGroup.getAddressList().split(",");
            for (String item: addresss) {
                if (StringUtils.isBlank(item)) {
                    return new ReturnT<String>(500, "机器地址非法");
                }
            }
        }

        int ret = wbtimerJobGroupDao.save(wbtimerJobGroup);
        return (ret>0)?ReturnT.SUCCESS:ReturnT.FAIL;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ReturnT<String> update(WbtimerJobGroup wbtimerJobGroup){
        // valid
        if (wbtimerJobGroup.getAppName()==null || StringUtils.isBlank(wbtimerJobGroup.getAppName())) {
            return new ReturnT<String>(500, "请输入AppName");
        }
        if (wbtimerJobGroup.getAppName().length()>64) {
            return new ReturnT<String>(500, "AppName长度限制为4~64");
        }
        if (wbtimerJobGroup.getTitle()==null || StringUtils.isBlank(wbtimerJobGroup.getTitle())) {
            return new ReturnT<String>(500, "请输入名称");
        }
        if (wbtimerJobGroup.getAddressType()!=0) {
            if (StringUtils.isBlank(wbtimerJobGroup.getAddressList())) {
                return new ReturnT<String>(500, "手动录入注册方式，机器地址不可为空");
            }
            String[] addresss = wbtimerJobGroup.getAddressList().split(",");
            for (String item: addresss) {
                if (StringUtils.isBlank(item)) {
                    return new ReturnT<String>(500, "机器地址非法");
                }
            }
        }

        int ret = wbtimerJobGroupDao.update(wbtimerJobGroup);
        return (ret>0)?ReturnT.SUCCESS:ReturnT.FAIL;
    }

    @RequestMapping("/remove")
    @ResponseBody
    public ReturnT<String> remove(int id){

        // valid
        int count = wbtimerJobInfoDao.pageListCount(0, 10, id, null, null);
        if (count > 0) {
            return new ReturnT<String>(500, "该分组使用中, 不可删除");
        }

        List<WbtimerJobGroup> allList = wbtimerJobGroupDao.findAll();
        if (allList.size() == 1) {
            return new ReturnT<String>(500, "删除失败, 系统需要至少预留一个默认分组");
        }

        int ret = wbtimerJobGroupDao.remove(id);
        return (ret>0)?ReturnT.SUCCESS:ReturnT.FAIL;
    }

}
