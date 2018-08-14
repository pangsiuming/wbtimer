package com.eshore.wbtimer.executor.handler;


import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.DzzzCshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wangyifan on 2018/4/8.
 */

@JobHandler("dzzzCshHandler")
@Component
public class DzzzCshHandler extends IJobHandler {

    @Autowired
    private DzzzCshService dzzzCshService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        dzzzCshService.startExecute();
        return ReturnT.SUCCESS;
    }
}
