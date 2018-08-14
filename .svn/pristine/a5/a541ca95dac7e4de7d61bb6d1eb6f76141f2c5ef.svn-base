package com.eshore.wbtimer.admin.dao;

import com.eshore.wbtimer.admin.core.model.WbtimerJobRegistry;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface WbtimerJobRegistryDao {

    public int removeDead(@Param("timeout") int timeout);

    public List<WbtimerJobRegistry> findAll(@Param("timeout") int timeout);

    public int registryUpdate(@Param("registryGroup") String registryGroup,
                              @Param("registryKey") String registryKey,
                              @Param("registryValue") String registryValue);

    public int registrySave(@Param("registryGroup") String registryGroup,
                            @Param("registryKey") String registryKey,
                            @Param("registryValue") String registryValue);

    public int registryDelete(@Param("registryGroup") String registGroup,
                              @Param("registryKey") String registryKey,
                              @Param("registryValue") String registryValue);

}
