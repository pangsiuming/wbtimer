package com.eshore.wbtimer.admin.service.impl;

import com.eshore.wbtimer.admin.core.enums.ExecutorFailStrategyEnum;
import com.eshore.wbtimer.admin.core.model.WbtimerJobGroup;
import com.eshore.wbtimer.admin.core.model.WbtimerJobInfo;
import com.eshore.wbtimer.admin.core.router.ExecutorRouteStrategyEnum;
import com.eshore.wbtimer.admin.core.util.QuartzUtil;
import com.eshore.wbtimer.admin.dao.WbtimerJobGroupDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobInfoDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobLogDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobLogGlueDao;
import com.eshore.wbtimer.admin.service.WbtimerJobService;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.enums.ExecutorBlockStrategyEnum;
import com.eshore.wbtimer.core.glue.GlueTypeEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.*;

/**
 * 描述: 调度中心业务逻辑类 (关于页面的)
 *
 * @author Yangjinming
 * @create 2018-01-11 9:47
 */
@Service
public class WbtimerJobServiceImpl implements WbtimerJobService{
    private static Logger logger = LoggerFactory.getLogger(WbtimerJobServiceImpl.class);
    @Resource
    private WbtimerJobGroupDao wbtimerJobGroupDao;
    @Resource
    private WbtimerJobInfoDao wbtimerJobInfoDao;
    @Resource
    private WbtimerJobLogDao wbtimerJobLogDao;
    @Resource
    private WbtimerJobLogGlueDao wbtimerJobLogGlueDao;

    /**
     * 获取任务列表
     *
     * @param start
     * @param length
     * @param jobGroup
     * @param jobDesc
     * @param executorHandler
     * @param filterTime
     * @return
     */
    @Override
    public Map<String, Object> pageList(int start, int length, int jobGroup, String jobDesc, String executorHandler, String filterTime) {
        // page list
        List<WbtimerJobInfo> list = wbtimerJobInfoDao.pageList(start, length, jobGroup, jobDesc, executorHandler);
        int list_count = wbtimerJobInfoDao.pageListCount(start, length, jobGroup, jobDesc, executorHandler);

        // fill handler info
        if (list!=null && list.size()>0) {
            for (WbtimerJobInfo jobInfo : list) {
                QuartzUtil.fillJobInfo(jobInfo);
            }
        }

        // package result
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("recordsTotal", list_count);		// 总记录数
        maps.put("recordsFiltered", list_count);	// 过滤后的总记录数
        maps.put("data", list);  					// 分页列表
        return maps;
    }

    @Override
    public ReturnT<String> add(WbtimerJobInfo jobInfo) {
        // valid
        WbtimerJobGroup group = wbtimerJobGroupDao.load(jobInfo.getJobGroup());
        if (group == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "请选择“执行器”");
        }
        if (!CronExpression.isValidExpression(jobInfo.getJobCron())) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "请输入格式正确的“Cron”");
        }
        if (StringUtils.isBlank(jobInfo.getJobDesc())) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "请输入“任务描述”");
        }
        if (StringUtils.isBlank(jobInfo.getAuthor())) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "请输入“负责人”");
        }
        if (ExecutorRouteStrategyEnum.match(jobInfo.getExecutorRouteStrategy(), null) == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "路由策略非法");
        }
        if (ExecutorBlockStrategyEnum.match(jobInfo.getExecutorBlockStrategy(), null) == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "阻塞处理策略非法");
        }
        if (ExecutorFailStrategyEnum.match(jobInfo.getExecutorFailStrategy(), null) == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "失败处理策略非法");
        }
        if (GlueTypeEnum.match(jobInfo.getGlueType()) == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "运行模式非法非法");
        }
        if (GlueTypeEnum.BEAN==GlueTypeEnum.match(jobInfo.getGlueType()) && StringUtils.isBlank(jobInfo.getExecutorHandler())) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "请输入“JobHandler”");
        }

        // fix "\r" in shell
        if (GlueTypeEnum.GLUE_SHELL==GlueTypeEnum.match(jobInfo.getGlueType()) && jobInfo.getGlueSource()!=null) {
            jobInfo.setGlueSource(jobInfo.getGlueSource().replaceAll("\r", ""));
        }

        // ChildJobId valid
        if (StringUtils.isNotBlank(jobInfo.getChildJobId())) {
            String[] childJobIds = StringUtils.split(jobInfo.getChildJobId(), ",");
            for (String childJobIdItem: childJobIds) {
                if (StringUtils.isNotBlank(childJobIdItem) && StringUtils.isNumeric(childJobIdItem)) {
                    WbtimerJobInfo childJobInfo = wbtimerJobInfoDao.loadById(Integer.valueOf(childJobIdItem));
                    if (childJobInfo==null) {
                        return new ReturnT<String>(ReturnT.FAIL_CODE, MessageFormat.format("子任务ID({0})无效", childJobIdItem));
                    }
                } else {
                    return new ReturnT<String>(ReturnT.FAIL_CODE, MessageFormat.format("子任务ID({0})格式错误", childJobIdItem));
                }
            }
            jobInfo.setChildJobId(StringUtils.join(childJobIds, ","));
        }

        // add in db
        wbtimerJobInfoDao.save(jobInfo);
        if (jobInfo.getId() < 1) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "新增任务失败");
        }

        // add in quartz
        String qz_group = String.valueOf(jobInfo.getJobGroup());
        String qz_name = String.valueOf(jobInfo.getId());
        try {
            QuartzUtil.addJob(qz_name, qz_group, jobInfo.getJobCron());
            return ReturnT.SUCCESS;
        } catch (SchedulerException e) {
            logger.error(e.getMessage(), e);
            try {
                wbtimerJobInfoDao.delete(jobInfo.getId());
                QuartzUtil.removeJob(qz_name, qz_group);
            } catch (SchedulerException e1) {
                logger.error(e.getMessage(), e1);
            }
            return new ReturnT<String>(ReturnT.FAIL_CODE, "新增任务失败:" + e.getMessage());
        }
    }

    @Override
    public ReturnT<String> reschedule(WbtimerJobInfo jobInfo) {

        // valid
        if (!CronExpression.isValidExpression(jobInfo.getJobCron())) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "请输入格式正确的“Cron”");
        }
        if (StringUtils.isBlank(jobInfo.getJobDesc())) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "请输入“任务描述”");
        }
        if (StringUtils.isBlank(jobInfo.getAuthor())) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "请输入“负责人”");
        }
        if (ExecutorRouteStrategyEnum.match(jobInfo.getExecutorRouteStrategy(), null) == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "路由策略非法");
        }
        if (ExecutorBlockStrategyEnum.match(jobInfo.getExecutorBlockStrategy(), null) == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "阻塞处理策略非法");
        }
        if (ExecutorFailStrategyEnum.match(jobInfo.getExecutorFailStrategy(), null) == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "失败处理策略非法");
        }

        // ChildJobId valid
        if (StringUtils.isNotBlank(jobInfo.getChildJobId())) {
            String[] childJobIds = StringUtils.split(jobInfo.getChildJobId(), ",");
            for (String childJobIdItem: childJobIds) {
                if (StringUtils.isNotBlank(childJobIdItem) && StringUtils.isNumeric(childJobIdItem)) {
                    WbtimerJobInfo childJobInfo = wbtimerJobInfoDao.loadById(Integer.valueOf(childJobIdItem));
                    if (childJobInfo==null) {
                        return new ReturnT<String>(ReturnT.FAIL_CODE, MessageFormat.format("子任务ID({0})无效", childJobIdItem));
                    }
                    // avoid cycle relate
                    if (childJobInfo.getId() == jobInfo.getId()) {
                        return new ReturnT<String>(ReturnT.FAIL_CODE, MessageFormat.format("子任务ID({0})不可与父任务重复", childJobIdItem));
                    }
                } else {
                    return new ReturnT<String>(ReturnT.FAIL_CODE, MessageFormat.format("子任务ID({0})格式错误", childJobIdItem));
                }
            }
            jobInfo.setChildJobId(StringUtils.join(childJobIds, ","));
        }

        // stage handler info
        WbtimerJobInfo exists_jobInfo = wbtimerJobInfoDao.loadById(jobInfo.getId());
        if (exists_jobInfo == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "参数异常");
        }
        //String old_cron = exists_jobInfo.getJobCron();

        exists_jobInfo.setJobCron(jobInfo.getJobCron());
        exists_jobInfo.setJobDesc(jobInfo.getJobDesc());
        exists_jobInfo.setAuthor(jobInfo.getAuthor());
        exists_jobInfo.setAlarmEmail(jobInfo.getAlarmEmail());
        exists_jobInfo.setExecutorRouteStrategy(jobInfo.getExecutorRouteStrategy());
        exists_jobInfo.setExecutorHandler(jobInfo.getExecutorHandler());
        exists_jobInfo.setExecutorParam(jobInfo.getExecutorParam());
        exists_jobInfo.setExecutorBlockStrategy(jobInfo.getExecutorBlockStrategy());
        exists_jobInfo.setExecutorFailStrategy(jobInfo.getExecutorFailStrategy());
        exists_jobInfo.setChildJobId(jobInfo.getChildJobId());
        wbtimerJobInfoDao.update(exists_jobInfo);

        // fresh quartz
        String qz_group = String.valueOf(exists_jobInfo.getJobGroup());
        String qz_name = String.valueOf(exists_jobInfo.getId());
        try {
            boolean ret = QuartzUtil.rescheduleJob(qz_group, qz_name, exists_jobInfo.getJobCron());
            return ret?ReturnT.SUCCESS:ReturnT.FAIL;
        } catch (SchedulerException e) {
            logger.error(e.getMessage(), e);
        }

        return ReturnT.FAIL;
    }

    @Override
    public ReturnT<String> remove(int id) {
        WbtimerJobInfo xxlJobInfo = wbtimerJobInfoDao.loadById(id);
        String group = String.valueOf(xxlJobInfo.getJobGroup());
        String name = String.valueOf(xxlJobInfo.getId());

        try {
            QuartzUtil.removeJob(name, group);
            wbtimerJobInfoDao.delete(id);
            wbtimerJobLogDao.delete(id);
            wbtimerJobLogGlueDao.deleteByJobId(id);
            return ReturnT.SUCCESS;
        } catch (SchedulerException e) {
            logger.error(e.getMessage(), e);
        }
        return ReturnT.FAIL;
    }

    @Override
    public ReturnT<String> pause(int id) {
        WbtimerJobInfo xxlJobInfo = wbtimerJobInfoDao.loadById(id);
        String group = String.valueOf(xxlJobInfo.getJobGroup());
        String name = String.valueOf(xxlJobInfo.getId());

        try {
            boolean ret = QuartzUtil.pauseJob(name, group);	// jobStatus do not store
            return ret?ReturnT.SUCCESS:ReturnT.FAIL;
        } catch (SchedulerException e) {
            logger.error(e.getMessage(), e);
            return ReturnT.FAIL;
        }
    }

    @Override
    public ReturnT<String> resume(int id) {
        WbtimerJobInfo xxlJobInfo = wbtimerJobInfoDao.loadById(id);
        String group = String.valueOf(xxlJobInfo.getJobGroup());
        String name = String.valueOf(xxlJobInfo.getId());

        try {
            boolean ret = QuartzUtil.resumeJob(name, group);
            return ret?ReturnT.SUCCESS:ReturnT.FAIL;
        } catch (SchedulerException e) {
            logger.error(e.getMessage(), e);
            return ReturnT.FAIL;
        }
    }

    @Override
    public ReturnT<String> triggerJob(int id) {
        WbtimerJobInfo xxlJobInfo = wbtimerJobInfoDao.loadById(id);
        if (xxlJobInfo == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "任务ID非法");
        }

        String group = String.valueOf(xxlJobInfo.getJobGroup());
        String name = String.valueOf(xxlJobInfo.getId());

        try {
            QuartzUtil.triggerJob(name, group);
            return ReturnT.SUCCESS;
        } catch (SchedulerException e) {
            logger.error(e.getMessage(), e);
            return new ReturnT<String>(ReturnT.FAIL_CODE, e.getMessage());
        }
    }

    @Override
    public Map<String, Object> dashboardInfo() {

        int jobInfoCount = wbtimerJobInfoDao.findAllCount();
        int jobLogCount = wbtimerJobLogDao.triggerCountByHandleCode(-1);
        int jobLogSuccessCount = wbtimerJobLogDao.triggerCountByHandleCode(ReturnT.SUCCESS_CODE);

        // executor count
        Set<String> executerAddressSet = new HashSet<String>();
        List<WbtimerJobGroup> groupList = wbtimerJobGroupDao.findAll();

        if (CollectionUtils.isNotEmpty(groupList)) {
            for (WbtimerJobGroup group: groupList) {
                if (CollectionUtils.isNotEmpty(group.getRegistryList())) {
                    executerAddressSet.addAll(group.getRegistryList());
                }
            }
        }

        int executorCount = executerAddressSet.size();

        Map<String, Object> dashboardMap = new HashMap<String, Object>();
        dashboardMap.put("jobInfoCount", jobInfoCount);
        dashboardMap.put("jobLogCount", jobLogCount);
        dashboardMap.put("jobLogSuccessCount", jobLogSuccessCount);
        dashboardMap.put("executorCount", executorCount);
        return dashboardMap;
    }

    @Override
    public ReturnT<Map<String, Object>> triggerChartDate(Date startDate, Date endDate) {
        List<String> triggerDayList = new ArrayList<String>();
        List<Integer> triggerDayCountSucList = new ArrayList<Integer>();
        List<Integer> triggerDayCountFailList = new ArrayList<Integer>();
        int triggerCountSucTotal = 0;
        int triggerCountFailTotal = 0;

        List<Map<String, Object>> triggerCountMapAll = wbtimerJobLogDao.triggerCountByDay(startDate, endDate, -1);
        List<Map<String, Object>> triggerCountMapSuc = wbtimerJobLogDao.triggerCountByDay(startDate, endDate, ReturnT.SUCCESS_CODE);
        if (CollectionUtils.isNotEmpty(triggerCountMapAll)) {
            for (Map<String, Object> item: triggerCountMapAll) {
                String day = String.valueOf(item.get("triggerDay"));
                int dayAllCount = Integer.valueOf(String.valueOf(item.get("triggerCount")));
                int daySucCount = 0;
                int dayFailCount = dayAllCount - daySucCount;

                if (CollectionUtils.isNotEmpty(triggerCountMapSuc)) {
                    for (Map<String, Object> sucItem: triggerCountMapSuc) {
                        String daySuc = String.valueOf(sucItem.get("triggerDay"));
                        if (day.equals(daySuc)) {
                            daySucCount = Integer.valueOf(String.valueOf(sucItem.get("triggerCount")));
                            dayFailCount = dayAllCount - daySucCount;
                        }
                    }
                }

                triggerDayList.add(day);
                triggerDayCountSucList.add(daySucCount);
                triggerDayCountFailList.add(dayFailCount);
                triggerCountSucTotal += daySucCount;
                triggerCountFailTotal += dayFailCount;
            }
        } else {
            for (int i = 4; i > -1; i--) {
                triggerDayList.add(FastDateFormat.getInstance("yyyy-MM-dd").format(DateUtils.addDays(new Date(), -i)));
                triggerDayCountSucList.add(0);
                triggerDayCountFailList.add(0);
            }
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("triggerDayList", triggerDayList);
        result.put("triggerDayCountSucList", triggerDayCountSucList);
        result.put("triggerDayCountFailList", triggerDayCountFailList);
        result.put("triggerCountSucTotal", triggerCountSucTotal);
        result.put("triggerCountFailTotal", triggerCountFailTotal);
        return new ReturnT<Map<String, Object>>(result);
    }
}
