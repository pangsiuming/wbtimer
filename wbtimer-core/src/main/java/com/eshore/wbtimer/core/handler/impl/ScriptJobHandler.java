package com.eshore.wbtimer.core.handler.impl;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.glue.GlueTypeEnum;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.log.WbtimerJobFileAppender;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.core.utils.ScriptUtil;
import com.eshore.wbtimer.core.utils.ShardingUtil;
import com.eshore.wbtimer.core.log.WbtimerJobFileAppender;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-10 19:15
 */
public class  ScriptJobHandler extends IJobHandler {

    private int jobId;
    private long glueUpdatetime;
    private String gluesource;
    private GlueTypeEnum glueType;

    public ScriptJobHandler(int jobId, long glueUpdatetime, String gluesource, GlueTypeEnum glueType){
        this.jobId = jobId;
        this.glueUpdatetime = glueUpdatetime;
        this.gluesource = gluesource;
        this.glueType = glueType;
    }

    public long getGlueUpdatetime() {
        return glueUpdatetime;
    }

    @Override
    public ReturnT<String> execute(String param) throws Exception {

        if (!glueType.isScript()) {
            return new ReturnT<String>(IJobHandler.FAIL.getCode(), "glueType["+ glueType +"] invalid.");
        }

        // cmd
        String cmd = glueType.getCmd();

        // make script file
        String scriptFileName = WbtimerJobFileAppender.getGlueSrcPath()
                .concat("/")
                .concat(String.valueOf(jobId))
                .concat("_")
                .concat(String.valueOf(glueUpdatetime))
                .concat(glueType.getSuffix());
        ScriptUtil.markScriptFile(scriptFileName, gluesource);

        // log file
        String logFileName = WbtimerJobFileAppender.contextHolder.get();

        // script params：0=param、1=分片序号、2=分片总数
        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
        String[] scriptParams = new String[3];
        scriptParams[0] = param;
        scriptParams[1] = String.valueOf(shardingVO.getIndex());
        scriptParams[2] = String.valueOf(shardingVO.getTotal());

        // invoke
        WbtimerJobLogger.log("----------- script file:"+ scriptFileName +" -----------");
        int exitValue = ScriptUtil.execToFile(cmd, scriptFileName, logFileName, scriptParams);
        ReturnT<String> result = (exitValue==0)?IJobHandler.SUCCESS:new ReturnT<String>(IJobHandler.FAIL.getCode(), "script exit value("+exitValue+") is failed");
        return result;
    }

}
