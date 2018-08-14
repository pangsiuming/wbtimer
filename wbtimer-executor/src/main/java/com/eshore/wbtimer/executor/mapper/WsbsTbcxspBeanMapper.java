package com.eshore.wbtimer.executor.mapper;

import com.eshore.wbtimer.executor.mapper.bean.WsbsTbcxspBean;

import java.util.List;

public interface WsbsTbcxspBeanMapper {
    int insert(WsbsTbcxspBean record);

    int insertSelective(WsbsTbcxspBean record);

    List<WsbsTbcxspBean> selectNotPassList(WsbsTbcxspBean record);
}