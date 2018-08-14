package com.eshore.wbtimer.core.biz;

import com.eshore.wbtimer.core.biz.model.LogResult;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.biz.model.TriggerParam;

/**
 * 描述: 执行器 处理类
 *
 * @author Yangjinming
 * @create 2018-01-10 19:08
 */
public interface ExecutorBiz  {

    /**
     * beat
     * @return
     */
    public ReturnT<String> beat();

    /**
     * idle beat
     *
     * @param jobId
     * @return
     */
    public ReturnT<String> idleBeat(int jobId);

    /**
     * kill
     * @param jobId
     * @return
     */
    public ReturnT<String> kill(int jobId);

    /**
     * log
     * @param logDateTim
     * @param logId
     * @param fromLineNum
     * @return
     */
    public ReturnT<LogResult> log(long logDateTim, int logId, int fromLineNum);

    /**
     * run
     * @param triggerParam
     * @return
     */
    public ReturnT<String> run(TriggerParam triggerParam);

}

