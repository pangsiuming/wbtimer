package com.eshore.wbtimer.admin.service.impl;

import com.eshore.wbtimer.admin.core.model.WbtimerJobInfo;
import com.eshore.wbtimer.admin.core.model.WbtimerJobLog;
import com.eshore.wbtimer.admin.dao.WbtimerJobInfoDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobLogDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobRegistryDao;
import com.eshore.wbtimer.admin.service.WbtimerJobService;
import com.eshore.wbtimer.core.biz.AdminBiz;
import com.eshore.wbtimer.core.biz.model.HandleCallbackParam;
import com.eshore.wbtimer.core.biz.model.RegistryParam;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-11 9:48
 */
@Service
public class AdminBizImpl implements AdminBiz{
    private static Logger logger = LoggerFactory.getLogger(AdminBizImpl.class);

    @Resource
    public WbtimerJobLogDao wbtimerJobLogDao;
    @Resource
    private WbtimerJobInfoDao wbtimerJobInfoDao;
    @Resource
    private WbtimerJobRegistryDao wbtimerJobRegistryDao;
    @Resource
    private WbtimerJobService wbtimerJobService;


    @Override
    public ReturnT<String> callback(List<HandleCallbackParam> callbackParamList) {
        for (HandleCallbackParam handleCallbackParam: callbackParamList) {
            ReturnT<String> callbackResult = callback(handleCallbackParam);
            logger.info(">>>>>>>>> JobApiController.callback {}, handleCallbackParam={}, callbackResult={}",
                    (callbackResult.getCode()== IJobHandler.SUCCESS.getCode()?"success":"fail"), handleCallbackParam, callbackResult);
        }

        return ReturnT.SUCCESS;
    }

    /**
     * 回调
     * @param handleCallbackParam
     * @return
     */
    private ReturnT<String> callback(HandleCallbackParam handleCallbackParam) {
        // valid log item
        WbtimerJobLog log = wbtimerJobLogDao.load(handleCallbackParam.getLogId());
        if (log == null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "log item not found.");
        }
        if (log.getHandleCode() > 0) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "log repeate callback.");     // avoid repeat callback, trigger child handler etc
        }

        // trigger success, to trigger child handler
        String callbackMsg = null;
        if (IJobHandler.SUCCESS.getCode() == handleCallbackParam.getExecuteResult().getCode()) {
            WbtimerJobInfo wbtimerJobInfo = wbtimerJobInfoDao.loadById(log.getJobId());
            if (wbtimerJobInfo!=null && StringUtils.isNotBlank(wbtimerJobInfo.getChildJobId())) {
                callbackMsg = "<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发子任务<<<<<<<<<<< </span><br>";

                String[] childJobIds = wbtimerJobInfo.getChildJobId().split(",");
                for (int i = 0; i < childJobIds.length; i++) {
                    int childJobId = (StringUtils.isNotBlank(childJobIds[i]) && StringUtils.isNumeric(childJobIds[i]))?Integer.valueOf(childJobIds[i]):-1;
                    if (childJobId > 0) {
                        ReturnT<String> triggerChildResult = wbtimerJobService.triggerJob(childJobId);

                        // add msg
                        callbackMsg += MessageFormat.format("{0}/{1} [任务ID={2}], 触发{3}, 触发备注: {4} <br>",
                                (i+1), childJobIds.length, childJobIds[i], (triggerChildResult.getCode()==ReturnT.SUCCESS_CODE?"成功":"失败"), triggerChildResult.getMsg());
                    } else {
                        callbackMsg += MessageFormat.format(" {0}/{1} [任务ID={2}], 触发失败, 触发备注: 任务ID格式错误 <br>",
                                (i+1), childJobIds.length, childJobIds[i]);
                    }
                }

            }
        } else if (IJobHandler.FAIL_RETRY.getCode() == handleCallbackParam.getExecuteResult().getCode()){
            ReturnT<String> retryTriggerResult = wbtimerJobService.triggerJob(log.getJobId());
            callbackMsg = "<br><br><span style=\"color:#F39C12;\" > >>>>>>>>>>>执行失败重试<<<<<<<<<<< </span><br>";

            callbackMsg += MessageFormat.format("触发{0}, 触发备注: {1}",
                    (retryTriggerResult.getCode()==ReturnT.SUCCESS_CODE?"成功":"失败"), retryTriggerResult.getMsg());
        }

        // handle msg
        StringBuffer handleMsg = new StringBuffer();
        if (log.getHandleMsg()!=null) {
            handleMsg.append(log.getHandleMsg()).append("<br>");
        }
        if (handleCallbackParam.getExecuteResult().getMsg() != null) {
            handleMsg.append(handleCallbackParam.getExecuteResult().getMsg());
        }
        if (callbackMsg != null) {
            handleMsg.append(callbackMsg);
        }

        // success, save log
        log.setHandleTime(new Date());
        log.setHandleCode(handleCallbackParam.getExecuteResult().getCode());
        log.setHandleMsg(handleMsg.toString());
        wbtimerJobLogDao.updateHandleInfo(log);

        return ReturnT.SUCCESS;
    }

    @Override
    public ReturnT<String> registry(RegistryParam registryParam) {
        int ret = wbtimerJobRegistryDao.registryUpdate(registryParam.getRegistGroup(), registryParam.getRegistryKey(), registryParam.getRegistryValue());
        if (ret < 1) {
            wbtimerJobRegistryDao.registrySave(registryParam.getRegistGroup(), registryParam.getRegistryKey(), registryParam.getRegistryValue());
        }
        return ReturnT.SUCCESS;
    }

    @Override
    public ReturnT<String> registryRemove(RegistryParam registryParam) {
        wbtimerJobRegistryDao.registryDelete(registryParam.getRegistGroup(), registryParam.getRegistryKey(), registryParam.getRegistryValue());
        return ReturnT.SUCCESS;
    }

    @Override
    public ReturnT<String> triggerJob(int jobId) {
        return wbtimerJobService.triggerJob(jobId);
    }

}