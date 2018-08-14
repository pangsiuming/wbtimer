package com.eshore.wbtimer.core.thread;

import com.eshore.wbtimer.core.biz.AdminBiz;
import com.eshore.wbtimer.core.biz.model.RegistryParam;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.enums.RegistryConfig;
import com.eshore.wbtimer.core.executor.WbtimerJobExecutor;
import com.eshore.wbtimer.core.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 描述:执行器注册线程
 *
 * @author Yangjinming
 * @create 2018-01-10 18:37
 */
public class ExecutorRegistryThread extends Thread {
    private static Logger logger = LoggerFactory.getLogger(ExecutorRegistryThread.class);

    private static ExecutorRegistryThread instance = new ExecutorRegistryThread();
    public static ExecutorRegistryThread getInstance(){
        return instance;
    }

    private Thread registryThread;
    private volatile boolean toStop = false;
    public void start(final int port, final String ip, final String appName){

        // valid
        if (appName==null || appName.trim().length()==0) {
            logger.warn(">>>>>>>>>>> wbtimer-handler, executor registry config fail, appName is null.");
            return;
        }
        if (WbtimerJobExecutor.getAdminBizList() == null) {
            logger.warn(">>>>>>>>>>> wbtimer-handler, executor registry config fail, adminAddresses is null.");
            return;
        }

        // executor address (generate addredd = ip:port)
        final String executorAddress;
        if (ip != null && ip.trim().length()>0) {
            executorAddress = ip.trim().concat(":").concat(String.valueOf(port));
        } else {
            executorAddress = IpUtil.getIpPort(port);
        }

        registryThread = new Thread(new Runnable() {
            @Override
            public void run() {

                // registry
                while (!toStop) {
                    try {
                        RegistryParam registryParam = new RegistryParam(RegistryConfig.RegistType.EXECUTOR.name(), appName, executorAddress);
                        for (AdminBiz adminBiz: WbtimerJobExecutor.getAdminBizList()) {
                            try {
                                ReturnT<String> registryResult = adminBiz.registry(registryParam);
                                if (registryResult!=null && ReturnT.SUCCESS_CODE == registryResult.getCode()) {
                                    registryResult = ReturnT.SUCCESS;
                                    logger.info(">>>>>>>>>>> wbtimer-handler registry success, registryParam:{}, registryResult:{}", new Object[]{registryParam, registryResult});
                                    break;
                                } else {
                                    logger.info(">>>>>>>>>>> wbtimer-handler registry fail, registryParam:{}, registryResult:{}", new Object[]{registryParam, registryResult});
                                }
                            } catch (Exception e) {
                                logger.info(">>>>>>>>>>> wbimer-handler registry error, registryParam:{}", registryParam, e);
                            }

                        }
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }

                    try {
                        TimeUnit.SECONDS.sleep(RegistryConfig.BEAT_TIMEOUT);
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);
                    }
                }

                // registry remove
                try {
                    RegistryParam registryParam = new RegistryParam(RegistryConfig.RegistType.EXECUTOR.name(), appName, executorAddress);
                    for (AdminBiz adminBiz: WbtimerJobExecutor.getAdminBizList()) {
                        try {
                            ReturnT<String> registryResult = adminBiz.registryRemove(registryParam);
                            if (registryResult!=null && ReturnT.SUCCESS_CODE == registryResult.getCode()) {
                                registryResult = ReturnT.SUCCESS;
                                logger.info(">>>>>>>>>>> wbtimer-handler registry-remove success, registryParam:{}, registryResult:{}", new Object[]{registryParam, registryResult});
                                break;
                            } else {
                                logger.info(">>>>>>>>>>> wbtimer-handler registry-remove fail, registryParam:{}, registryResult:{}", new Object[]{registryParam, registryResult});
                            }
                        } catch (Exception e) {
                            logger.info(">>>>>>>>>>> wbtimer-handler registry-remove error, registryParam:{}", registryParam, e);
                        }

                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
                logger.info(">>>>>>>>>>> wbtimer-handler, executor registry thread destory.");

            }
        });
        registryThread.setDaemon(true);
        registryThread.start();
    }

    public void toStop() {
        toStop = true;
        // interrupt and wait
        registryThread.interrupt();
        try {
            registryThread.join();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }

}
