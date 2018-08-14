package com.eshore.wbtimer.executor.mapper;

import com.eshore.wbtimer.executor.mapper.bean.WsbsTbcxjgBean;

public interface WsbsTbcxjgBeanMapper {
    int deleteByPrimaryKey(Long hjslbs);

    int insert(WsbsTbcxjgBean record);

    int insertSelective(WsbsTbcxjgBean record);

    WsbsTbcxjgBean selectByPrimaryKey(Long hjslbs);

    int updateByPrimaryKeySelective(WsbsTbcxjgBean record);

    int updateByPrimaryKey(WsbsTbcxjgBean record);
}