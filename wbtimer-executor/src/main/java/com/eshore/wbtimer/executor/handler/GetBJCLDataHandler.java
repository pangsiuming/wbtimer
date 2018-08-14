package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.GetBJCLDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:半交换事项需要回审批系统办结
 * 半交换事项-办结
 * 对于半交换到外系统需要回来办结的申请单，外系统将反馈待办结信息到数据管理平台
 * 此任务将从数据管理平台获取半交换工单的待办结数据，并结束在审批系统的审批环节
 * 审批环节应当配置参与者为sysadmin
 *
 * @author Yangjinming
 * @create 2018-01-12 17:40
 */
@JobHandler("getBJCLDataHandler")
@Component
public class GetBJCLDataHandler extends IJobHandler {
    private static Logger logger = LoggerFactory.getLogger(GetBJCLDataHandler.class);
    @Autowired
    GetBJCLDataService getBJCLDataService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        getBJCLDataService.startBjclData();
        return ReturnT.SUCCESS;
    }
}
