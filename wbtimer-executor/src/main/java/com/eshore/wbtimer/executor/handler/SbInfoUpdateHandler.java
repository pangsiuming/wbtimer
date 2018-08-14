package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.SbInfoUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:申办表字段剩余天数、预警状态、承诺应办结时间更新进程
 *
 * @author Yangjinming
 * @create 2018-01-12 17:26
 */
@JobHandler("sbInfoUpdateHandler")
@Component
public class SbInfoUpdateHandler extends IJobHandler {
    @Autowired
    private SbInfoUpdateService sbInfoUpdateService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        sbInfoUpdateService.startUpdate();
        return ReturnT.SUCCESS;
    }
}