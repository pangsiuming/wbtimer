package com.eshore.wbtimer.admin.dao;

import com.eshore.wbtimer.admin.core.model.WbtimerJobLogGlue;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface WbtimerJobLogGlueDao {
	
	public int save(WbtimerJobLogGlue xxlJobLogGlue);
	
	public List<WbtimerJobLogGlue> findByJobId(@Param("jobId") int jobId);

	public int removeOld(@Param("jobId") int jobId, @Param("limit") int limit);

	public int deleteByJobId(@Param("jobId") int jobId);
	
}
