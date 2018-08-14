package com.eshore.wbtimer.executor.service;

import com.eshore.wbtimer.executor.mapper.bean.ConfigContentBean;
import com.eshore.wbtimer.executor.service.bean.SendItemInformationParam;

import java.util.Map;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/25 15:47
 */
public interface CfgContentService {
    Map<String, ConfigContentBean> getCfgContentHash(String typeCode);

    ConfigContentBean getCfgContent(String typeCode, String contentCode);

    String getCfgContentValue(String typeCode, String contentCode);

    SendItemInformationParam getItemInformation(String queueId);
}
