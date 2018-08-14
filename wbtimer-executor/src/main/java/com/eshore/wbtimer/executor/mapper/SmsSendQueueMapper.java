package com.eshore.wbtimer.executor.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.eshore.wbtimer.executor.mapper.bean.SmsSendQueue;
import com.eshore.wbtimer.executor.service.bean.SmsSendQueueHistParamBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsSendQueueMapper extends BaseMapper<SmsSendQueue>{

    List<SmsSendQueue> findAll(@Param("rownum") Long rownum, @Param("extraCondition") String extraCondition);

    int addSmsSendQueueHist(SmsSendQueueHistParamBean smsSendQueueHistParamBean);
}