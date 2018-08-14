package com.eshore.wbtimer.executor.service.impl;

import com.eshore.wbtimer.executor.mapper.ConfigContentMapper;
import com.eshore.wbtimer.executor.mapper.bean.ConfigContentBean;
import com.eshore.wbtimer.executor.service.CfgContentService;
import com.eshore.wbtimer.executor.service.bean.SendItemInformationParam;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/25 15:47
 */
@Service
public class CfgContentServiceImpl implements CfgContentService {
    @Autowired
    ConfigContentMapper configContentMapper;
    @Override
    public Map<String, ConfigContentBean> getCfgContentHash(String typeCode) {
        List<ConfigContentBean> resultList = configContentMapper.selectByTypeCode(typeCode);
        Map<String,ConfigContentBean> resultHash = new HashMap<>();
        if (CollectionUtils.isNotEmpty(resultList)) {
            for (int i=0;i<resultList.size();i++) {
                ConfigContentBean cfgBean =  resultList.get(i);
                resultHash.put(cfgBean.getContentcode(), cfgBean);
            }
        }
        return resultHash;
    }
    @Override
    public ConfigContentBean getCfgContent(String typeCode, String contentCode) {
        Map<String, ConfigContentBean> cfgContentHash = getCfgContentHash(typeCode);
        if(cfgContentHash.containsKey(contentCode)){
            return cfgContentHash.get(contentCode);
        }
        return null;
    }
    @Override
    public String getCfgContentValue(String typeCode, String contentCode){
        ConfigContentBean configContentBean = getCfgContent(typeCode,contentCode);
        if (configContentBean==null){
            return "";
        }
        return configContentBean.getContentvalue();
    }
    @Override
    public SendItemInformationParam getItemInformation(String queueId){
        List<SendItemInformationParam> informationlist = configContentMapper.selectItemInformation(queueId);
        SendItemInformationParam itemInformation = new SendItemInformationParam();
        if(!informationlist.isEmpty()){
            itemInformation =  informationlist.get(0);
        }
        return itemInformation;
    }
}
