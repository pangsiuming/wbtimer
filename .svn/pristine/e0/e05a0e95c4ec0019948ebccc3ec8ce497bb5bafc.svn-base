package com.eshore.wbtimer.executor.common.code.sms;

import com.eshore.wbtimer.common.utils.SpringContextUtil;
import com.eshore.wbtimer.executor.mapper.MessageTemplateMapper;
import com.eshore.wbtimer.executor.mapper.SendServiceMapper;
import com.eshore.wbtimer.executor.mapper.bean.MessageTemplate;
import com.eshore.wbtimer.executor.mapper.bean.WsbsSbBean;
import com.eshore.wbtimer.executor.service.bean.MessageTemplateParamBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 描述:短信模板
 *
 * @author Yangjinming
 * @create 2018/1/25 9:30
 */
public class SmsTemplate {
    @Autowired
    private MessageTemplateMapper messageTemplateMapper;
    @Autowired
    private SendServiceMapper sendServiceMapper;
    public SmsTemplate(){
        init();
    }

    private void init() {
        this.messageTemplateMapper = (MessageTemplateMapper) SpringContextUtil.getBean("messageTemplateMapper");
        this.sendServiceMapper = (SendServiceMapper) SpringContextUtil.getBean("sendServiceMapper");
    }

    /**
     * 取出短信模板内容
     *
     * @param templateCode
     * @return
     */
    public  MessageTemplate get(String templateCode, String orgCode) {
        MessageTemplate result = null;
        MessageTemplateParamBean templateParam = new MessageTemplateParamBean();
        templateParam.setTemplateCode(templateCode);
        templateParam.setTemplateCodeEQ(templateCode);
        //优先使用个性化配置短信模板
        templateParam.setExtraCondition(" a.org_code in ('"+orgCode+"','0')");
        templateParam.setExtraOrderColumns("decode(A.org_code, '0', '', A.org_code)");
        PageHelper.startPage(1, 10);
        List<MessageTemplate> template = messageTemplateMapper.selectByParamsSelective(templateParam);
        if (CollectionUtils.isNotEmpty(template)) {
            result = template.get(0);
        }
        //非必须发送
        if(!"1".equals(result.getIsMust())){
            //查询是否有个性化配置,查找该部门是否配置该短信是否发送


            Long orgId = sendServiceMapper.selectOrgMessageConfigIdByCode(orgCode,templateCode);
            //短信提醒配置为空
            if (orgId==null) {
                return null;
            }
            //取配置的网上申办提醒短信接收人，这里取出org_message_config的Id
             result.setMsgConfId(orgId);

        }
        return result;
    }

    public  String filter(MessageTemplate messageTemplate, WsbsSbBean wsbsSbBean) {
        String smsContent = messageTemplate.getContent();
        // 申办项目名称
        if (smsContent.contains("@@serviceName@@")) {
            smsContent = smsContent.replace("@@serviceName@@", StringUtils.isEmpty(wsbsSbBean.getSxmc())?"":wsbsSbBean.getSxmc());
        }
        // 申请人名称
        if (smsContent.contains("@@applyer@@")) {
            smsContent = smsContent.replace("@@applyer@@",StringUtils.isEmpty( wsbsSbBean.getSqrmc())?"":wsbsSbBean.getSqrmc());
        }
        // 申办流水号
        if (smsContent.contains("@@sblsh@@")) {
            smsContent = smsContent.replace("@@sblsh@@",StringUtils.isEmpty( wsbsSbBean.getSblsh())?"":wsbsSbBean.getSblsh());
        }
        // 受理号
        if (smsContent.contains("@@slh10Last@@")) {
            smsContent = smsContent.replace("@@slh10Last@@",StringUtils.isEmpty( wsbsSbBean.getSlh())?"":wsbsSbBean.getSlh());
        }

        return smsContent;
    }
}
