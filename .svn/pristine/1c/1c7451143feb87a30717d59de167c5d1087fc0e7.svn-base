package com.eshore.wbtimer.core.thread;

import com.eshore.wbtimer.core.biz.model.HandleCallbackParam;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.biz.model.TriggerParam;
import com.eshore.wbtimer.core.executor.WbtimerJobExecutor;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.log.WbtimerJobFileAppender;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.core.utils.ShardingUtil;
import com.eshore.wbtimer.core.biz.model.HandleCallbackParam;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.biz.model.TriggerParam;
import com.eshore.wbtimer.core.executor.WbtimerJobExecutor;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.log.WbtimerJobFileAppender;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 描述:执行job线程
 *
 * @author Yangjinming
 * @create 2018-01-10 18:50
 */
public class JobThread extends Thread{
    private static Logger logger = LoggerFactory.getLogger(JobThread.class);

    private int jobId;
    private IJobHandler handler;
    private LinkedBlockingQueue<TriggerParam> triggerQueue;
    private ConcurrentHashSet<Integer> triggerLogIdSet;		// avoid repeat trigger for the same TRIGGER_LOG_ID

    private boolean toStop = false;
    private String stopReason;

    private boolean running = false;    // if running handler
    private int idleTimes = 0;			// idel times


    public JobThread(int jobId, IJobHandler handler) {
        this.jobId = jobId;
        this.handler = handler;
        this.triggerQueue = new LinkedBlockingQueue<TriggerParam>();
        this.triggerLogIdSet = new ConcurrentHashSet<Integer>();
    }
    public IJobHandler getHandler() {
        return handler;
    }

    /**
     * 新增触发器参数到队列
     *
     * @param triggerParam
     * @return
     */
    public ReturnT<String> pushTriggerQueue(TriggerParam triggerParam) {
        // avoid repeat
        if (triggerLogIdSet.contains(triggerParam.getLogId())) {
            logger.info(">>>>>>>>>>> repeate trigger handler, logId:{}", triggerParam.getLogId());
            return new ReturnT<String>(ReturnT.FAIL_CODE, "repeate trigger handler, logId:" + triggerParam.getLogId());
        }

        triggerLogIdSet.add(triggerParam.getLogId());
        triggerQueue.add(triggerParam);
        return ReturnT.SUCCESS;
    }

    /**
     * kill handler thread
     *
     * @param stopReason
     */
    public void toStop(String stopReason) {
        /**
         * Thread.interrupt只支持终止线程的阻塞状态(wait、join、sleep)，
         * 在阻塞出抛出InterruptedException异常,但是并不会终止运行的线程本身；
         * 所以需要注意，此处彻底销毁本线程，需要通过共享变量方式；
         */
        this.toStop = true;
        this.stopReason = stopReason;
    }

    /**
     * is running handler
     * @return
     */
    public boolean isRunningOrHasQueue() {
        return running || triggerQueue.size()>0;
    }

    /**
     * 执行job的execute方法
     */
    @Override
    public void run() {

        // init
        try {
            handler.init();
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
        }

        // execute
        while(!toStop){
            running = false;
            idleTimes++;

            TriggerParam triggerParam = null;
            ReturnT<String> executeResult = null;
            try {
                // to check toStop signal, we need cycle, so wo cannot use queue.take(), instand of poll(timeout)
                triggerParam = triggerQueue.poll(3L, TimeUnit.SECONDS);
                if (triggerParam!=null) {
                    running = true;
                    idleTimes = 0;
                    triggerLogIdSet.remove(triggerParam.getLogId());

                    // log filename, like "logPath/yyyy-MM-dd/9999.log"
                    String logFileName = WbtimerJobFileAppender.makeLogFileName(new Date(triggerParam.getLogDateTim()), triggerParam.getLogId());
                    WbtimerJobFileAppender.contextHolder.set(logFileName);
                    ShardingUtil.setShardingVo(new ShardingUtil.ShardingVO(triggerParam.getBroadcastIndex(), triggerParam.getBroadcastTotal()));

                    // execute
                    WbtimerJobLogger.log("<br>----------- wbtimer-handler handler execute start -----------<br>----------- Param:" + triggerParam.getExecutorParams());
                    executeResult = handler.execute(triggerParam.getExecutorParams());
                    if (executeResult == null) {
                        executeResult = IJobHandler.FAIL;
                    }
                    WbtimerJobLogger.log("<br>----------- wbtimer-handler handler execute end(finish) -----------<br>----------- ReturnT:" + executeResult);

                } else {
                    if (idleTimes > 30) {
                        WbtimerJobExecutor.removeJobThread(jobId, "excutor idel times over limit.");
                    }
                }
            } catch (Throwable e) {
                if (toStop) {
                    WbtimerJobLogger.log("<br>----------- JobThread toStop, stopReason:" + stopReason);
                }

                StringWriter stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                String errorMsg = stringWriter.toString();
                executeResult = new ReturnT<String>(ReturnT.FAIL_CODE, errorMsg);

                WbtimerJobLogger.log("<br>----------- JobThread Exception:" + errorMsg + "<br>----------- wbtimer-handler handler execute end(error) -----------");
            } finally {
                if(triggerParam != null) {
                    // callback handler info
                    if (!toStop) {
                        // commonm
                        TriggerCallbackThread.pushCallBack(new HandleCallbackParam(triggerParam.getLogId(), executeResult));
                    } else {
                        // is killed
                        ReturnT<String> stopResult = new ReturnT<String>(ReturnT.FAIL_CODE, stopReason + " [业务运行中，被强制终止]");
                        TriggerCallbackThread.pushCallBack(new HandleCallbackParam(triggerParam.getLogId(), stopResult));
                    }
                }
            }
        }

        // callback trigger request in queue
        while(triggerQueue !=null && triggerQueue.size()>0){
            TriggerParam triggerParam = triggerQueue.poll();
            if (triggerParam!=null) {
                // is killed
                ReturnT<String> stopResult = new ReturnT<String>(ReturnT.FAIL_CODE, stopReason + " [任务尚未执行，在调度队列中被终止]");
                TriggerCallbackThread.pushCallBack(new HandleCallbackParam(triggerParam.getLogId(), stopResult));
            }
        }

        // destroy
        try {
            handler.destroy();
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
        }

        logger.info(">>>>>>>>>>> wbtimer-handler JobThread stoped, hashCode:{}", Thread.currentThread());
    }
}
