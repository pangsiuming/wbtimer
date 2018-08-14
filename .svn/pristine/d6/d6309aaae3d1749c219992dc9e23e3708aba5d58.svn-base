package com.eshore.wbtimer.admin.service;

import com.eshore.wbtimer.admin.core.model.WbtimerJobInfo;
import com.eshore.wbtimer.core.biz.model.ReturnT;

import java.util.Date;
import java.util.Map;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-11 9:48
 */
public interface WbtimerJobService {
    public Map<String, Object> pageList(int start, int length, int jobGroup, String jobDesc, String executorHandler, String filterTime);

    public ReturnT<String> add(WbtimerJobInfo jobInfo);

    public ReturnT<String> reschedule(WbtimerJobInfo jobInfo);

    public ReturnT<String> remove(int id);

    public ReturnT<String> pause(int id);

    public ReturnT<String> resume(int id);

    public ReturnT<String> triggerJob(int id);

    public Map<String,Object> dashboardInfo();

    public ReturnT<Map<String,Object>> triggerChartDate(Date startDate, Date endDate);

}
