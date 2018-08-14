package com.eshore.wbtimer.admin.core.router.strategy;



import com.eshore.wbtimer.admin.core.router.ExecutorRouter;
import com.eshore.wbtimer.admin.core.schedule.WbtimerJobDynamicScheduler;
import com.eshore.wbtimer.admin.core.trigger.WbtimerJobTrigger;
import com.eshore.wbtimer.core.biz.ExecutorBiz;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.biz.model.TriggerParam;

import java.util.ArrayList;

/**
 *
 */
public class ExecutorRouteFailover extends ExecutorRouter {

    public String route(int jobId, ArrayList<String> addressList) {
        return addressList.get(0);
    }

    @Override
    public ReturnT<String> routeRun(TriggerParam triggerParam, ArrayList<String> addressList) {

        StringBuffer beatResultSB = new StringBuffer();
        for (String address : addressList) {
            // beat
            ReturnT<String> beatResult = null;
            try {
                ExecutorBiz executorBiz = WbtimerJobDynamicScheduler.getExecutorBiz(address);
                beatResult = executorBiz.beat();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                beatResult = new ReturnT<String>(ReturnT.FAIL_CODE, ""+e );
            }
            beatResultSB.append( (beatResultSB.length()>0)?"<br><br>":"")
                    .append("心跳检测：")
                    .append("<br>address：").append(address)
                    .append("<br>code：").append(beatResult.getCode())
                    .append("<br>msg：").append(beatResult.getMsg());

            // beat success
            if (beatResult.getCode() == ReturnT.SUCCESS_CODE) {

                ReturnT<String> runResult = WbtimerJobTrigger.runExecutor(triggerParam, address);
                beatResultSB.append("<br><br>").append(runResult.getMsg());

                // result
                runResult.setContent(address);
                runResult.setMsg(beatResultSB.toString());
                return runResult;
            }
        }
        return new ReturnT<String>(ReturnT.FAIL_CODE, beatResultSB.toString());

    }
}
