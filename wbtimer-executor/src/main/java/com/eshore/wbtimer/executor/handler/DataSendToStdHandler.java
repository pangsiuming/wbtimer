package com.eshore.wbtimer.executor.handler;


import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.DataSendToStdService;
import com.eshore.wbtimer.executor.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@JobHandler("dataSendToStdHandler")
@Component
public class DataSendToStdHandler extends IJobHandler {
    @Autowired
    private DataSendToStdService dataSendToStdService;
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        dataSendToStdService.sendStdDataHandle();
        return ReturnT.SUCCESS;
    }

}
