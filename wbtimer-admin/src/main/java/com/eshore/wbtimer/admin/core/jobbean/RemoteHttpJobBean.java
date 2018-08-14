package com.eshore.wbtimer.admin.core.jobbean;

import com.eshore.wbtimer.admin.core.trigger.WbtimerJobTrigger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 描述: 远程调度bean
 *
 * @author Yangjinming
 * @create 2018-01-11 10:04
 */
public class RemoteHttpJobBean extends QuartzJobBean {
    private static Logger logger = LoggerFactory.getLogger(RemoteHttpJobBean.class);

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {

        // load jobId
        JobKey jobKey = context.getTrigger().getJobKey();
        Integer jobId = Integer.valueOf(jobKey.getName());

        // trigger
        WbtimerJobTrigger.trigger(jobId);
    }

}
