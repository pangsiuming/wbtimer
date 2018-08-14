package com.eshore.wbtimer.admin.core.router.strategy;



import com.eshore.wbtimer.admin.core.router.ExecutorRouter;
import com.eshore.wbtimer.admin.core.trigger.WbtimerJobTrigger;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.biz.model.TriggerParam;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class ExecutorRouteRandom extends ExecutorRouter {

    private static Random localRandom = new Random();

    public String route(int jobId, ArrayList<String> addressList) {
        // Collections.shuffle(addressList);
        return addressList.get(localRandom.nextInt(addressList.size()));
    }

    @Override
    public ReturnT<String> routeRun(TriggerParam triggerParam, ArrayList<String> addressList) {
        // address
        String address = route(triggerParam.getJobId(), addressList);

        // run executor
        ReturnT<String> runResult = WbtimerJobTrigger.runExecutor(triggerParam, address);
        runResult.setContent(address);
        return runResult;
    }

}
