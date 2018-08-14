package com.eshore.wbtimer.core.thread;

import com.eshore.wbtimer.core.biz.AdminBiz;
import com.eshore.wbtimer.core.biz.model.HandleCallbackParam;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.executor.WbtimerJobExecutor;
import com.eshore.wbtimer.core.biz.AdminBiz;
import com.eshore.wbtimer.core.biz.model.HandleCallbackParam;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.executor.WbtimerJobExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 描述: 触发器回调
 *
 * @author Yangjinming
 * @create 2018-01-10 19:03
 */
public class TriggerCallbackThread {
    private static Logger logger = LoggerFactory.getLogger(TriggerCallbackThread.class);

    private static TriggerCallbackThread instance = new TriggerCallbackThread();
    public static TriggerCallbackThread getInstance(){
        return instance;
    }

    /**
     * handler results callback queue
     */
    private LinkedBlockingQueue<HandleCallbackParam> callBackQueue = new LinkedBlockingQueue<HandleCallbackParam>();
    public static void pushCallBack(HandleCallbackParam callback){
        getInstance().callBackQueue.add(callback);
        logger.debug(">>>>>>>>>>> wbtimer-handler, push callback request, logId:{}", callback.getLogId());
    }

    /**
     * callback thread
     */
    private Thread triggerCallbackThread;
    private volatile boolean toStop = false;
    public void start() {

        // valid
        if (WbtimerJobExecutor.getAdminBizList() == null) {
            logger.warn(">>>>>>>>>>> wbtimer-handler, executor callback config fail, adminAddresses is null.");
            return;
        }

        triggerCallbackThread = new Thread(new Runnable() {

            @Override
            public void run() {

                // normal callback
                while(!toStop){
                    try {
                        HandleCallbackParam callback = getInstance().callBackQueue.take();
                        if (callback != null) {

                            // callback list param
                            List<HandleCallbackParam> callbackParamList = new ArrayList<HandleCallbackParam>();
                            int drainToNum = getInstance().callBackQueue.drainTo(callbackParamList);
                            callbackParamList.add(callback);

                            // callback, will retry if error
                            if (callbackParamList!=null && callbackParamList.size()>0) {
                                doCallback(callbackParamList);
                            }
                        }
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                }

                // last callback
                try {
                    List<HandleCallbackParam> callbackParamList = new ArrayList<HandleCallbackParam>();
                    int drainToNum = getInstance().callBackQueue.drainTo(callbackParamList);
                    if (callbackParamList!=null && callbackParamList.size()>0) {
                        doCallback(callbackParamList);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
                logger.info(">>>>>>>>>>> wbtimer-handler, executor callback thread destory.");

            }
        });
        triggerCallbackThread.setDaemon(true);
        triggerCallbackThread.start();
    }
    public void toStop(){
        toStop = true;
        // interrupt and wait
        triggerCallbackThread.interrupt();
        try {
            triggerCallbackThread.join();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * do callback, will retry if error
     * @param callbackParamList
     */
    private void doCallback(List<HandleCallbackParam> callbackParamList){
        // callback, will retry if error
        for (AdminBiz adminBiz: WbtimerJobExecutor.getAdminBizList()) {
            try {
                //执行调度器callback
                ReturnT<String> callbackResult = adminBiz.callback(callbackParamList);
                if (callbackResult!=null && ReturnT.SUCCESS_CODE == callbackResult.getCode()) {
                    callbackResult = ReturnT.SUCCESS;
                    logger.info(">>>>>>>>>>> wbtimer-handler callback success, callbackParamList:{}, callbackResult:{}", new Object[]{callbackParamList, callbackResult});
                    break;
                } else {
                    logger.info(">>>>>>>>>>> wbtimer-handler callback fail, callbackParamList:{}, callbackResult:{}", new Object[]{callbackParamList, callbackResult});
                }
            } catch (Exception e) {
                logger.error(">>>>>>>>>>> wbtimer-handler callback error, callbackParamList：{}", callbackParamList, e);
                //getInstance().callBackQueue.addAll(callbackParamList);
            }
        }
    }

}
