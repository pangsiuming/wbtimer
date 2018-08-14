package com.eshore.wbtimer.admin.dao;

import com.eshore.wbtimer.admin.core.model.WbtimerJobInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface WbtimerJobInfoDao {

	public List<WbtimerJobInfo> pageList(@Param("offset") int offset,
										 @Param("pagesize") int pagesize,
										 @Param("jobGroup") int jobGroup,
										 @Param("jobDesc") String jobDesc,
										 @Param("executorHandler") String executorHandler);
	public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize,
                             @Param("jobGroup") int jobGroup,
                             @Param("jobDesc") String jobDesc,
                             @Param("executorHandler") String executorHandler);
	
	public int save(WbtimerJobInfo info);

	public WbtimerJobInfo loadById(@Param("id") int id);
	
	public int update(WbtimerJobInfo item);
	
	public int delete(@Param("id") int id);

	public List<WbtimerJobInfo> getJobsByGroup(@Param("jobGroup") int jobGroup);

	public int findAllCount();

}
