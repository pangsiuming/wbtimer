package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.CLYJService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:综合接办材料交接预警
 *
 * @author Zhangqian
 * @create 2018-01-19 9:42
 */
@JobHandler("cLYJHandler")
@Component
public class CLYJHandler extends IJobHandler {
    private static Logger logger = LoggerFactory.getLogger(CLYJHandler.class);
    @Autowired
    CLYJService clyjService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        clyjService.clyj();
        return ReturnT.SUCCESS;
    }
}
