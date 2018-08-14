package com.eshore.wbtimer.executor.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.eshore.wbtimer.executor.mapper.bean.MessageTemplate;
import com.eshore.wbtimer.executor.service.bean.MessageTemplateParamBean;

import java.util.List;

public interface MessageTemplateMapper extends BaseMapper<MessageTemplate>{
    List<MessageTemplate>  queryByTemplateCode(String templateCode);
    List<MessageTemplate> selectByParamsSelective(MessageTemplateParamBean messageTemplateParamBean);
}