package com.eshore.wbtimer.admin.core.thread;

import com.eshore.wbtimer.admin.core.model.WbtimerJobGroup;
import com.eshore.wbtimer.admin.core.model.WbtimerJobInfo;
import com.eshore.wbtimer.admin.core.model.WbtimerJobLog;
import com.eshore.wbtimer.admin.core.schedule.WbtimerJobDynamicScheduler;
import com.eshore.wbtimer.admin.core.util.MailUtil;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 描述:调度器监控中心
 *
 * @author Yangjinming
 * @create 2018-01-10 18:01
 */
public class JobFailMonitorHelper {
    private static Logger logger = LoggerFactory.getLogger(JobFailMonitorHelper.class);

    private static JobFailMonitorHelper instance = new JobFailMonitorHelper();
    public static JobFailMonitorHelper getInstance(){
        return instance;
    }

    // ---------------------- monitor ----------------------

    private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(0xfff8);

    private Thread monitorThread;
    private volatile boolean toStop = false;
    public void start(){
        monitorThread = new Thread(new Runnable() {

            @Override
            public void run() {
                // monitor
                while (!toStop) {
                    try {
                        List<Integer> jobLogIdList = new ArrayList<Integer>();
                        //从队列中拿到日志表中JobList
                        int drainToNum = JobFailMonitorHelper.instance.queue.drainTo(jobLogIdList);

                        if (CollectionUtils.isNotEmpty(jobLogIdList)) {
                            for (Integer jobLogId : jobLogIdList) {
                                if (jobLogId==null || jobLogId==0) {
                                    continue;
                                }
                                WbtimerJobLog log = WbtimerJobDynamicScheduler.wbtimerJobLogDao.load(jobLogId);
                                if (log == null) {
                                    continue;
                                }
                                if (IJobHandler.SUCCESS.getCode() == log.getTriggerCode() && log.getHandleCode() == 0) {
                                    //在日志记录中运行成功的job的加入到队列中
                                    JobFailMonitorHelper.monitor(jobLogId);
                                    logger.info(">>>>>>>>>>> handler monitor, handler running, JobLogId:{}", jobLogId);
                                } else if (IJobHandler.SUCCESS.getCode() == log.getHandleCode()) {
                                    // handler success, pass
                                    logger.info(">>>>>>>>>>> handler monitor, handler success, JobLogId:{}", jobLogId);
                                } else if (IJobHandler.FAIL.getCode() == log.getTriggerCode()
                                        || IJobHandler.FAIL.getCode() == log.getHandleCode()
                                        || IJobHandler.FAIL_RETRY.getCode() == log.getHandleCode() ) {
                                    // handler fail,
                                    failAlarm(log);
                                    logger.info(">>>>>>>>>>> handler monitor, handler fail, JobLogId:{}", jobLogId);
                                } else {
                                    JobFailMonitorHelper.monitor(jobLogId);
                                    logger.info(">>>>>>>>>>> handler monitor, handler status unknown, JobLogId:{}", jobLogId);
                                }
                            }
                        }

                        TimeUnit.SECONDS.sleep(10);
                    } catch (Exception e) {
                        logger.error("handler monitor error:{}", e);
                    }
                }

                // 调度器停止
                List<Integer> jobLogIdList = new ArrayList<Integer>();
                int drainToNum = getInstance().queue.drainTo(jobLogIdList);
                if (jobLogIdList!=null && jobLogIdList.size()>0) {
                    for (Integer jobLogId: jobLogIdList) {
                        WbtimerJobLog log = WbtimerJobDynamicScheduler.wbtimerJobLogDao.load(jobLogId);
                        if (ReturnT.FAIL_CODE == log.getTriggerCode()|| ReturnT.FAIL_CODE==log.getHandleCode()) {
                            // 如果是失败导致的即发邮件
                            failAlarm(log);
                            logger.info(">>>>>>>>>>> handler monitor last, handler fail, JobLogId:{}", jobLogId);
                        }
                    }
                }

            }
        });
        monitorThread.setDaemon(true);
        monitorThread.start();
    }

    public void toStop(){
        toStop = true;
        // interrupt and wait
        monitorThread.interrupt();
        try {
            monitorThread.join();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }

    // producer
    public static void monitor(int jobLogId){
        getInstance().queue.offer(jobLogId);
    }


    // ---------------------- alarm ----------------------

    // email alarm template
    private static final String mailBodyTemplate = "<h5>监控告警明细：</span>" +
            "<table border=\"1\" cellpadding=\"3\" style=\"border-collapse:collapse; width:80%;\" >\n" +
            "   <thead style=\"font-weight: bold;color: #ffffff;background-color: #ff8c00;\" >" +
            "      <tr>\n" +
            "         <td>执行器</td>\n" +
            "         <td>任务ID</td>\n" +
            "         <td>任务描述</td>\n" +
            "         <td>告警类型</td>\n" +
            "      </tr>\n" +
            "   <thead/>\n" +
            "   <tbody>\n" +
            "      <tr>\n" +
            "         <td>{0}</td>\n" +
            "         <td>{1}</td>\n" +
            "         <td>{2}</td>\n" +
            "         <td>调度失败</td>\n" +
            "      </tr>\n" +
            "   <tbody>\n" +
            "</table>";

    /**
     * fail alarm
     *
     * @param jobLog
     */
    private void failAlarm(WbtimerJobLog jobLog){

        // 发送调度邮件
        WbtimerJobInfo info = WbtimerJobDynamicScheduler.wbtimerJobInfoDao.loadById(jobLog.getJobId());
        if (info!=null && info.getAlarmEmail()!=null && info.getAlarmEmail().trim().length()>0) {

            Set<String> emailSet = new HashSet<String>(Arrays.asList(info.getAlarmEmail().split(",")));
            for (String email: emailSet) {
               WbtimerJobGroup group =WbtimerJobDynamicScheduler.wbtimerJobGroupDao.load(Integer.valueOf(info.getJobGroup()));

                String title = "调度中心监控报警";
                String content = MessageFormat.format(mailBodyTemplate, group!=null?group.getTitle():"null", info.getId(), info.getJobDesc());

                MailUtil.sendMail(email, title, content);
            }
        }
    }

}
