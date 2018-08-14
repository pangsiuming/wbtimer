package com.eshore.wbtimer.executor.mapper;

import com.eshore.wbtimer.executor.mapper.bean.ConfigContentBean;
import com.eshore.wbtimer.executor.service.bean.SendItemInformationParam;

import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/25 15:54
 */
public interface ConfigContentMapper {
    List<ConfigContentBean> selectByTypeCode(String typecode);
    List<SendItemInformationParam> selectItemInformation(String queueId);
}
