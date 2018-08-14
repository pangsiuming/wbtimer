package com.eshore.wbtimer.core.handler.impl;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-10 19:13
 */
public class  GlueJobHandler extends IJobHandler {

    private long glueUpdatetime;
    private IJobHandler jobHandler;
    public GlueJobHandler(IJobHandler jobHandler, long glueUpdatetime) {
        this.jobHandler = jobHandler;
        this.glueUpdatetime = glueUpdatetime;
    }
    public long getGlueUpdatetime() {
        return glueUpdatetime;
    }

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        WbtimerJobLogger.log("----------- glue.version:"+ glueUpdatetime +" -----------");
        return jobHandler.execute(param);
    }

}

