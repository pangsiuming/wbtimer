package com.eshore.wbtimer.admin.core.trigger;

import com.eshore.wbtimer.admin.core.enums.ExecutorFailStrategyEnum;
import com.eshore.wbtimer.admin.core.model.WbtimerJobGroup;
import com.eshore.wbtimer.admin.core.model.WbtimerJobInfo;
import com.eshore.wbtimer.admin.core.model.WbtimerJobLog;
import com.eshore.wbtimer.admin.core.router.ExecutorRouteStrategyEnum;
import com.eshore.wbtimer.admin.core.schedule.WbtimerJobDynamicScheduler;
import com.eshore.wbtimer.admin.core.thread.JobFailMonitorHelper;
import com.eshore.wbtimer.core.biz.ExecutorBiz;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.biz.model.TriggerParam;
import com.eshore.wbtimer.core.enums.ExecutorBlockStrategyEnum;
import com.eshore.wbtimer.core.utils.IpUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;

/**
 * 描述: 调度器调用执行器handler的主要方法类
 *
 * @author Yangjinming
 * @create 2018-01-11 10:05
 */
public class WbtimerJobTrigger {
    private static Logger logger = LoggerFactory.getLogger(WbtimerJobTrigger.class);

    /**
     * trigger handler
     *
     * @param jobId
     */
    public static void trigger(int jobId) {

        // load data
        WbtimerJobInfo jobInfo = WbtimerJobDynamicScheduler.wbtimerJobInfoDao.loadById(jobId);              // handler info
        if (jobInfo == null) {
            logger.warn(">>>>>>>>>>>> trigger fail, jobId invalid，jobId={}", jobId);
            return;
        }
        WbtimerJobGroup group = WbtimerJobDynamicScheduler.wbtimerJobGroupDao.load(jobInfo.getJobGroup());  // group info

        ExecutorBlockStrategyEnum blockStrategy = ExecutorBlockStrategyEnum.match(jobInfo.getExecutorBlockStrategy(), ExecutorBlockStrategyEnum.SERIAL_EXECUTION);  // block strategy
        ExecutorFailStrategyEnum failStrategy = ExecutorFailStrategyEnum.match(jobInfo.getExecutorFailStrategy(), ExecutorFailStrategyEnum.FAIL_ALARM);    // fail strategy
        ExecutorRouteStrategyEnum executorRouteStrategyEnum = ExecutorRouteStrategyEnum.match(jobInfo.getExecutorRouteStrategy(), null);    // route strategy
        ArrayList<String> addressList = (ArrayList<String>) group.getRegistryList();

        // 路由策略为分片
        if (ExecutorRouteStrategyEnum.SHARDING_BROADCAST == executorRouteStrategyEnum && CollectionUtils.isNotEmpty(addressList)) {
            for (int i = 0; i < addressList.size(); i++) {
                String address = addressList.get(i);

                // 1、save log-id
                WbtimerJobLog jobLog = new WbtimerJobLog();
                jobLog.setJobGroup(jobInfo.getJobGroup());
                jobLog.setJobId(jobInfo.getId());
                WbtimerJobDynamicScheduler.wbtimerJobLogDao.save(jobLog);
                logger.debug(">>>>>>>>>>> wbtimer-handler trigger start, jobId:{}", jobLog.getId());

                // 2、prepare trigger-info
                //jobLog.setExecutorAddress(executorAddress);
                jobLog.setGlueType(jobInfo.getGlueType());
                jobLog.setExecutorHandler(jobInfo.getExecutorHandler());
                jobLog.setExecutorParam(jobInfo.getExecutorParam());
                jobLog.setTriggerTime(new Date());

                ReturnT<String> triggerResult = new ReturnT<String>(null);
                StringBuffer triggerMsgSb = new StringBuffer();
                triggerMsgSb.append("调度机器：").append(IpUtil.getIp());
                triggerMsgSb.append("<br>执行器-注册方式：").append( (group.getAddressType() == 0)?"自动注册":"手动录入" );
                triggerMsgSb.append("<br>执行器-地址列表：").append(group.getRegistryList());
                triggerMsgSb.append("<br>路由策略：").append(executorRouteStrategyEnum.getTitle()).append("("+i+"/"+addressList.size()+")"); // update01
                triggerMsgSb.append("<br>阻塞处理策略：").append(blockStrategy.getTitle());
                triggerMsgSb.append("<br>失败处理策略：").append(failStrategy.getTitle());

                // 3、trigger-valid
                if (triggerResult.getCode()==ReturnT.SUCCESS_CODE && CollectionUtils.isEmpty(addressList)) {
                    triggerResult.setCode(ReturnT.FAIL_CODE);
                    triggerMsgSb.append("<br>----------------------<br>").append("调度失败：").append("执行器地址为空");
                }

                if (triggerResult.getCode() == ReturnT.SUCCESS_CODE) {
                    // 4.1、trigger-param
                    TriggerParam triggerParam = new TriggerParam();
                    triggerParam.setJobId(jobInfo.getId());
                    triggerParam.setExecutorHandler(jobInfo.getExecutorHandler());
                    triggerParam.setExecutorParams(jobInfo.getExecutorParam());
                    triggerParam.setExecutorBlockStrategy(jobInfo.getExecutorBlockStrategy());
                    triggerParam.setLogId(jobLog.getId());
                    triggerParam.setLogDateTim(jobLog.getTriggerTime().getTime());
                    triggerParam.setGlueType(jobInfo.getGlueType());
                    triggerParam.setGlueSource(jobInfo.getGlueSource());
                    triggerParam.setGlueUpdatetime(jobInfo.getGlueUpdatetime().getTime());
                    triggerParam.setBroadcastIndex(i);
                    triggerParam.setBroadcastTotal(addressList.size()); // update02

                    // 4.2、trigger-run (route run / trigger remote executor)
                    triggerResult = runExecutor(triggerParam, address);     // update03
                    triggerMsgSb.append("<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>").append(triggerResult.getMsg());

                    // 4.3、trigger (fail retry)
                    if (triggerResult.getCode()!=ReturnT.SUCCESS_CODE && failStrategy == ExecutorFailStrategyEnum.FAIL_RETRY) {
                        triggerResult = runExecutor(triggerParam, address);  // update04
                        triggerMsgSb.append("<br><br><span style=\"color:#F39C12;\" > >>>>>>>>>>>失败重试<<<<<<<<<<< </span><br>").append(triggerResult.getMsg());
                    }
                }

                // 5、save trigger-info
                jobLog.setExecutorAddress(triggerResult.getContent());
                jobLog.setTriggerCode(triggerResult.getCode());
                jobLog.setTriggerMsg(triggerMsgSb.toString());
                WbtimerJobDynamicScheduler.wbtimerJobLogDao.updateTriggerInfo(jobLog);

                // 6、monitor triger 反馈到监控中心
                JobFailMonitorHelper.monitor(jobLog.getId());
                logger.debug(">>>>>>>>>>> wbtimer-handler trigger end, jobId:{}", jobLog.getId());

            }
        } else {
            // 1、save log-id
            WbtimerJobLog jobLog = new WbtimerJobLog();
            jobLog.setJobGroup(jobInfo.getJobGroup());
            jobLog.setJobId(jobInfo.getId());
            WbtimerJobDynamicScheduler.wbtimerJobLogDao.save(jobLog);
            logger.debug(">>>>>>>>>>> wbtimer-handler trigger start, jobId:{}", jobLog.getId());

            // 2、prepare trigger-info
            //jobLog.setExecutorAddress(executorAddress);
            jobLog.setGlueType(jobInfo.getGlueType());
            jobLog.setExecutorHandler(jobInfo.getExecutorHandler());
            jobLog.setExecutorParam(jobInfo.getExecutorParam());
            jobLog.setTriggerTime(new Date());

            ReturnT<String> triggerResult = new ReturnT<String>(null);
            StringBuffer triggerMsgSb = new StringBuffer();
            triggerMsgSb.append("调度机器：").append(IpUtil.getIp());
            triggerMsgSb.append("<br>执行器-注册方式：").append( (group.getAddressType() == 0)?"自动注册":"手动录入" );
            triggerMsgSb.append("<br>执行器-地址列表：").append(group.getRegistryList());
            triggerMsgSb.append("<br>路由策略：").append(executorRouteStrategyEnum.getTitle());
            triggerMsgSb.append("<br>阻塞处理策略：").append(blockStrategy.getTitle());
            triggerMsgSb.append("<br>失败处理策略：").append(failStrategy.getTitle());

            // 3、trigger-valid
            if (triggerResult.getCode()==ReturnT.SUCCESS_CODE && CollectionUtils.isEmpty(addressList)) {
                triggerResult.setCode(ReturnT.FAIL_CODE);
                triggerMsgSb.append("<br>----------------------<br>").append("调度失败：").append("执行器地址为空");
            }

            if (triggerResult.getCode() == ReturnT.SUCCESS_CODE) {
                // 4.1、trigger-param
                TriggerParam triggerParam = new TriggerParam();
                triggerParam.setJobId(jobInfo.getId());
                triggerParam.setExecutorHandler(jobInfo.getExecutorHandler());
                triggerParam.setExecutorParams(jobInfo.getExecutorParam());
                triggerParam.setExecutorBlockStrategy(jobInfo.getExecutorBlockStrategy());
                triggerParam.setLogId(jobLog.getId());
                triggerParam.setLogDateTim(jobLog.getTriggerTime().getTime());
                triggerParam.setGlueType(jobInfo.getGlueType());
                triggerParam.setGlueSource(jobInfo.getGlueSource());
                triggerParam.setGlueUpdatetime(jobInfo.getGlueUpdatetime().getTime());
                triggerParam.setBroadcastIndex(0);
                triggerParam.setBroadcastTotal(1);

                // 4.2、trigger-run (route run / trigger remote executor)
                triggerResult = executorRouteStrategyEnum.getRouter().routeRun(triggerParam, addressList);
                triggerMsgSb.append("<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>").append(triggerResult.getMsg());

                // 4.3、trigger (fail retry)
                if (triggerResult.getCode()!=ReturnT.SUCCESS_CODE && failStrategy == ExecutorFailStrategyEnum.FAIL_RETRY) {
                    triggerResult = executorRouteStrategyEnum.getRouter().routeRun(triggerParam, addressList);
                    triggerMsgSb.append("<br><br><span style=\"color:#F39C12;\" > >>>>>>>>>>>调度失败重试<<<<<<<<<<< </span><br>").append(triggerResult.getMsg());
                }
            }

            // 5、save trigger-info
            jobLog.setExecutorAddress(triggerResult.getContent());
            jobLog.setTriggerCode(triggerResult.getCode());
            jobLog.setTriggerMsg(triggerMsgSb.toString());
            WbtimerJobDynamicScheduler.wbtimerJobLogDao.updateTriggerInfo(jobLog);

            // 6、monitor triger
            JobFailMonitorHelper.monitor(jobLog.getId());
            logger.debug(">>>>>>>>>>> wbtimer-handler trigger end, jobId:{}", jobLog.getId());
        }

    }

    /**
     * run executor
     * @param triggerParam
     * @param address
     * @return  ReturnT.content: final address
     */
    public static ReturnT<String> runExecutor(TriggerParam triggerParam, String address){
        ReturnT<String> runResult = null;
        try {
            ExecutorBiz executorBiz = WbtimerJobDynamicScheduler.getExecutorBiz(address);
            runResult = executorBiz.run(triggerParam);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>> wbtimer-handler trigger error, please check if the executor[{}] is running.", address, e);
            runResult = new ReturnT<String>(ReturnT.FAIL_CODE, ""+e );
        }

        StringBuffer runResultSB = new StringBuffer("触发调度：");
        runResultSB.append("<br>address：").append(address);
        runResultSB.append("<br>code：").append(runResult.getCode());
        runResultSB.append("<br>msg：").append(runResult.getMsg());

        runResult.setMsg(runResultSB.toString());
        runResult.setContent(address);
        return runResult;
    }

}
