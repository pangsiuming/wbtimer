package com.eshore.wbtimer.admin.dao;

import com.eshore.wbtimer.admin.core.model.WbtimerJobLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface WbtimerJobLogDao {
	
	public List<WbtimerJobLog> pageList(@Param("offset") int offset,
										@Param("pagesize") int pagesize,
										@Param("jobGroup") int jobGroup,
										@Param("jobId") int jobId,
										@Param("triggerTimeStart") Date triggerTimeStart,
										@Param("triggerTimeEnd") Date triggerTimeEnd,
										@Param("logStatus") int logStatus);
	public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize,
                             @Param("jobGroup") int jobGroup,
                             @Param("jobId") int jobId,
                             @Param("triggerTimeStart") Date triggerTimeStart,
                             @Param("triggerTimeEnd") Date triggerTimeEnd,
                             @Param("logStatus") int logStatus);

	public WbtimerJobLog load(@Param("id") int id);

	public int save(WbtimerJobLog xxlJobLog);

	public int updateTriggerInfo(WbtimerJobLog xxlJobLog);

	public int updateHandleInfo(WbtimerJobLog xxlJobLog);

	public int delete(@Param("jobId") int jobId);

	public int triggerCountByHandleCode(@Param("handleCode") int handleCode);

	public List<Map<String, Object>> triggerCountByDay(@Param("from") Date from,
                                                       @Param("to") Date to,
                                                       @Param("handleCode") int handleCode);

	public int clearLog(@Param("jobGroup") int jobGroup,
                        @Param("jobId") int jobId,
                        @Param("clearBeforeTime") Date clearBeforeTime,
                        @Param("clearBeforeNum") int clearBeforeNum);

}
