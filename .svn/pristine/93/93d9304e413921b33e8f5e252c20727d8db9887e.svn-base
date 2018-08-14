package com.eshore.wbtimer.admin.core.schedule;

import com.eshore.wbtimer.admin.core.thread.JobFailMonitorHelper;
import com.eshore.wbtimer.admin.core.thread.JobRegistryMonitorHelper;
import com.eshore.wbtimer.admin.dao.WbtimerJobGroupDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobInfoDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobLogDao;
import com.eshore.wbtimer.admin.dao.WbtimerJobRegistryDao;
import com.eshore.wbtimer.core.biz.AdminBiz;
import com.eshore.wbtimer.core.biz.ExecutorBiz;
import com.eshore.wbtimer.core.rpc.net.NetComClientProxy;
import com.eshore.wbtimer.core.rpc.net.NetComServerFactory;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:  核心调度器
 *
 * @author Yangjinming
 * @create 2018-01-10 17:39
 */
public class WbtimerJobDynamicScheduler implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(WbtimerJobDynamicScheduler.class);

    // ---------------------- param ----------------------

    // scheduler
    private static Scheduler scheduler;
    public void setScheduler(Scheduler scheduler) {
        WbtimerJobDynamicScheduler.scheduler = scheduler;
    }
    public static Scheduler getScheduler(){
        return scheduler;
    }
    // accessToken
    private static String accessToken;
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // dao
    public static WbtimerJobLogDao wbtimerJobLogDao;
    public static WbtimerJobInfoDao wbtimerJobInfoDao;
    public static WbtimerJobRegistryDao wbtimerJobRegistryDao;
    public static WbtimerJobGroupDao wbtimerJobGroupDao;
    public static AdminBiz adminBiz;

    /**
     * 启动时注入bean
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        WbtimerJobDynamicScheduler.wbtimerJobLogDao = applicationContext.getBean(WbtimerJobLogDao.class);
        WbtimerJobDynamicScheduler.wbtimerJobInfoDao = applicationContext.getBean(WbtimerJobInfoDao.class);
        WbtimerJobDynamicScheduler.wbtimerJobRegistryDao = applicationContext.getBean(WbtimerJobRegistryDao.class);
        WbtimerJobDynamicScheduler.wbtimerJobGroupDao = applicationContext.getBean(WbtimerJobGroupDao.class);
        WbtimerJobDynamicScheduler.adminBiz = applicationContext.getBean(AdminBiz.class);
    }

    /**
     * 初始化
     *
     * @throws Exception
     */
    // ---------------------- init + destroy ----------------------
    public void init() throws Exception {
        // 调度器注册中心启动
        JobRegistryMonitorHelper.getInstance().start();

        // 调度器监控中心
        JobFailMonitorHelper.getInstance().start();

        // 调度器服务中注入调度器业务类 （供执行器反射使用）
        NetComServerFactory.putService(AdminBiz.class, WbtimerJobDynamicScheduler.adminBiz);
        NetComServerFactory.setAccessToken(accessToken);

        // valid
        Assert.notNull(scheduler, "quartz scheduler is null");
        logger.info(">>>>>>>>> init wbtimer-handler admin success.");
    }

    public void destroy(){
        // admin registry stop
        JobRegistryMonitorHelper.getInstance().toStop();

        // admin monitor stop
        JobFailMonitorHelper.getInstance().toStop();
    }

    // ---------------------- executor-client ----------------------
    private static ConcurrentHashMap<String, ExecutorBiz> executorBizRepository = new ConcurrentHashMap<String, ExecutorBiz>();
    public static ExecutorBiz getExecutorBiz(String address) throws Exception {
        // valid
        if (address==null || address.trim().length()==0) {
            return null;
        }

        // load-cache
        address = address.trim();
        ExecutorBiz executorBiz = executorBizRepository.get(address);
        if (executorBiz != null) {
            return executorBiz;
        }

        // set-cache
        executorBiz = (ExecutorBiz) new NetComClientProxy(ExecutorBiz.class, address, accessToken).getObject();
        executorBizRepository.put(address, executorBiz);
        return executorBiz;
    }

}
