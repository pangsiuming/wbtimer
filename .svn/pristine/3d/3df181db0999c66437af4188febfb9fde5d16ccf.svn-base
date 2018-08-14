package com.eshore.wbtimer.core.biz;

import com.eshore.wbtimer.core.biz.model.HandleCallbackParam;
import com.eshore.wbtimer.core.biz.model.RegistryParam;
import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.biz.model.RegistryParam;

import java.util.List;

/**
 * 描述: 调度中心业务类
 *
 * @author Yangjinming
 * @create 2018-01-10 17:43
 */
public interface AdminBiz {
    public static final String MAPPING = "/api";

    /**
     * callback
     *
     * @param callbackParamList
     * @return
     */
    public ReturnT<String> callback(List<HandleCallbackParam> callbackParamList);

    /**
     * registry
     *
     * @param registryParam
     * @return
     */
    public ReturnT<String> registry(RegistryParam registryParam);

    /**
     * registry remove
     *
     * @param registryParam
     * @return
     */
    public ReturnT<String> registryRemove(RegistryParam registryParam);


    /**
     * trigger handler for once
     *
     * @param jobId
     * @return
     */
    public ReturnT<String> triggerJob(int jobId);

}
