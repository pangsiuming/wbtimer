package com.eshore.wbtimer.executor.mapper;

import com.eshore.wbtimer.executor.mapper.bean.WsbsTbcxsqBean;

import java.util.List;

public interface WsbsTbcxsqBeanMapper {
    int deleteByPrimaryKey(Long hjslbs);

    int insert(WsbsTbcxsqBean record);

    int insertSelective(WsbsTbcxsqBean record);

    WsbsTbcxsqBean selectByPrimaryKey(Long hjslbs);

    int updateByPrimaryKeySelective(WsbsTbcxsqBean record);

    int updateByPrimaryKey(WsbsTbcxsqBean record);

    List<WsbsTbcxsqBean> selectBySblah(WsbsTbcxsqBean record);
}