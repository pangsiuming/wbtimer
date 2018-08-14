package com.eshore.wbtimer.executor.handler;


import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wangyifan on 2018/4/8.
 * handler作用描述
 */

@JobHandler("demoHandler")
@Component
public class DemoHandler extends IJobHandler {

    @Autowired
    private DemoService demoService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        demoService.start();
        return ReturnT.SUCCESS;
    }
}
