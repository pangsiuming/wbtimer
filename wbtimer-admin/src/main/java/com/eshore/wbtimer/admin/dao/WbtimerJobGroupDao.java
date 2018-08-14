package com.eshore.wbtimer.admin.dao;

import com.eshore.wbtimer.admin.core.model.WbtimerJobGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface WbtimerJobGroupDao {

    public List<WbtimerJobGroup> findAll();

    public List<WbtimerJobGroup> findByAddressType(@Param("addressType") int addressType);

    public int save(WbtimerJobGroup xxlJobGroup);

    public int update(WbtimerJobGroup xxlJobGroup);

    public int remove(@Param("id") int id);

    public WbtimerJobGroup load(@Param("id") int id);
}
