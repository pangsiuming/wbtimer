package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.DzzzYjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * dzzz预警任务
 */
@JobHandler("dzzzYjHandler")
@Component
public class DzzzYjHandler extends IJobHandler {

	@Autowired
	private DzzzYjService dzzzYjService;
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		dzzzYjService.startExecute();
		return ReturnT.SUCCESS;
	}

}
