package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.UpdateWsbsFgblInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:回报申办流水号和项目编号
 *
 * @author Yangjinming
 * @create 2018-01-12 17:24
 */
@JobHandler("updateWsbsFgblInfoHandler")
@Component
public class UpdateWsbsFgblInfoHandler extends IJobHandler {
    @Autowired
    UpdateWsbsFgblInfoService updateWsbsFgblInfoService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        updateWsbsFgblInfoService.startUpdate();
        return ReturnT.SUCCESS;
    }
}
