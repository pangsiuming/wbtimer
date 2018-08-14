package com.eshore.wbtimer.executor.handler;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.handler.IJobHandler;
import com.eshore.wbtimer.core.handler.annotation.JobHandler;
import com.eshore.wbtimer.executor.service.DzzzChangeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@JobHandler("dzzzChangeStatusHandler")
@Component
public class DzzzChangeStatusHandler extends IJobHandler {

	@Autowired
	private DzzzChangeStatusService dzzzChangeStatusService;
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		dzzzChangeStatusService.startChange();
		return ReturnT.SUCCESS;
	}

}
