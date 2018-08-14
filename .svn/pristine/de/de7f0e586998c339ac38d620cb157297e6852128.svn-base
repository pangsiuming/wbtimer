package com.eshore.wbtimer.admin.controller;

import com.eshore.wbtimer.admin.core.model.WbtimerJobInfo;
import com.eshore.wbtimer.admin.core.model.WbtimerJobLogGlue;
import com.eshore.wbtimer.admin.dao.WbtimerJobInfoDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobLogGlueDao;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.glue.GlueTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 描述: 在线编辑定时任务controller
 *
 * @author Yangjinming
 * @create 2018-01-11 10:54
 */
@Controller
@RequestMapping("/jobcode")
public class JobCodeController {

    @Resource
    private WbtimerJobInfoDao wbtimerJobInfoDao;
    @Resource
    private WbtimerJobLogGlueDao wbtimerJobLogGlueDao;

    @RequestMapping
    public String index(Model model, int jobId) {
        WbtimerJobInfo jobInfo = wbtimerJobInfoDao.loadById(jobId);
        List<WbtimerJobLogGlue> jobLogGlues = wbtimerJobLogGlueDao.findByJobId(jobId);

        if (jobInfo == null) {
            throw new RuntimeException("抱歉，任务不存在.");
        }
        if (GlueTypeEnum.BEAN == GlueTypeEnum.match(jobInfo.getGlueType())) {
            throw new RuntimeException("该任务非GLUE模式.");
        }

        // Glue类型-字典
        model.addAttribute("GlueTypeEnum", GlueTypeEnum.values());

        model.addAttribute("jobInfo", jobInfo);
        model.addAttribute("jobLogGlues", jobLogGlues);
        return "jobcode/jobcode.index";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ReturnT<String> save(Model model, int id, String glueSource, String glueRemark) {
        // valid
        if (glueRemark==null) {
            return new ReturnT<String>(500, "请输入备注");
        }
        if (glueRemark.length()<4 || glueRemark.length()>100) {
            return new ReturnT<String>(500, "备注长度应该在4至100之间");
        }
        WbtimerJobInfo exists_jobInfo = wbtimerJobInfoDao.loadById(id);
        if (exists_jobInfo == null) {
            return new ReturnT<String>(500, "参数异常");
        }

        // update new code
        exists_jobInfo.setGlueSource(glueSource);
        exists_jobInfo.setGlueRemark(glueRemark);
        exists_jobInfo.setGlueUpdatetime(new Date());
        wbtimerJobInfoDao.update(exists_jobInfo);

        // log old code
        WbtimerJobLogGlue wbtimerJobLogGlue = new WbtimerJobLogGlue();
        wbtimerJobLogGlue.setJobId(exists_jobInfo.getId());
        wbtimerJobLogGlue.setGlueType(exists_jobInfo.getGlueType());
        wbtimerJobLogGlue.setGlueSource(glueSource);
        wbtimerJobLogGlue.setGlueRemark(glueRemark);
        wbtimerJobLogGlueDao.save(wbtimerJobLogGlue);

        // remove code backup more than 30
        wbtimerJobLogGlueDao.removeOld(exists_jobInfo.getId(), 30);

        return ReturnT.SUCCESS;
    }

}

