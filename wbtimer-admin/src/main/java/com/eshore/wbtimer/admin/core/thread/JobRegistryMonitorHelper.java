package com.eshore.wbtimer.admin.core.thread;

import com.eshore.wbtimer.admin.core.model.WbtimerJobGroup;
import com.eshore.wbtimer.admin.core.model.WbtimerJobRegistry;
import com.eshore.wbtimer.admin.core.schedule.WbtimerJobDynamicScheduler;
import com.eshore.wbtimer.core.enums.RegistryConfig;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 描述: 调度器注册中心
 *
 * @author Yangjinming
 * @create 2018-01-10 17:51
 */
public class JobRegistryMonitorHelper {
    private static Logger logger = LoggerFactory.getLogger(JobRegistryMonitorHelper.class);

    private static JobRegistryMonitorHelper instance = new JobRegistryMonitorHelper();
    public static JobRegistryMonitorHelper getInstance(){
        return instance;
    }

    private Thread registryThread;
    private volatile boolean toStop = false;
    public void start(){
        registryThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!toStop) {
                    try {
                        // 自动注册
                        List<WbtimerJobGroup> groupList = WbtimerJobDynamicScheduler.wbtimerJobGroupDao.findByAddressType(0);
                        if (CollectionUtils.isNotEmpty(groupList)) {

                            // 移除dead任务(超时)
                            WbtimerJobDynamicScheduler.wbtimerJobRegistryDao.removeDead(RegistryConfig.DEAD_TIMEOUT);

                            // 获取已经注册过在线执行器地址到addressMap中（没超时的任务）
                            HashMap<String, List<String>> appAddressMap = new HashMap<String, List<String>>();
                            List<WbtimerJobRegistry> list = WbtimerJobDynamicScheduler.wbtimerJobRegistryDao.findAll(RegistryConfig.DEAD_TIMEOUT);
                            if (list != null) {
                                for (WbtimerJobRegistry item: list) {
                                    if (RegistryConfig.RegistType.EXECUTOR.name().equals(item.getRegistryGroup())) {
                                        String appName = item.getRegistryKey();
                                        List<String> registryList = appAddressMap.get(appName);
                                        if (registryList == null) {
                                            registryList = new ArrayList<String>();
                                        }

                                        if (!registryList.contains(item.getRegistryValue())) {
                                            registryList.add(item.getRegistryValue());
                                        }
                                        appAddressMap.put(appName, registryList);
                                    }
                                }
                            }

                            // 更新注册group
                            for (WbtimerJobGroup group: groupList) {
                                List<String> registryList = appAddressMap.get(group.getAppName());
                                String addressListStr = null;
                                if (CollectionUtils.isNotEmpty(registryList)) {
                                    Collections.sort(registryList);
                                    addressListStr = StringUtils.join(registryList, ",");
                                }
                                group.setAddressList(addressListStr);
                                WbtimerJobDynamicScheduler.wbtimerJobGroupDao.update(group);
                            }
                        }
                    } catch (Exception e) {
                        logger.error("handler registry instance error:{}", e);
                    }
                    try {
                        TimeUnit.SECONDS.sleep(RegistryConfig.BEAT_TIMEOUT);
                    } catch (InterruptedException e) {
                        logger.error("handler registry instance error:{}", e);
                    }
                }
            }
        });
        registryThread.setDaemon(true);
        registryThread.start();
    }

    public void toStop(){
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
