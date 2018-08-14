package com.eshore.wbtimer.executor.handler;


import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.dzzzPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@JobHandler("dzzzPageHandler")
@Component
public class dzzzPageHandler extends IJobHandler {

    @Autowired
    private dzzzPageService  dzzzPageService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        dzzzPageService.pageHandle();
        return ReturnT.SUCCESS;
    }
}
