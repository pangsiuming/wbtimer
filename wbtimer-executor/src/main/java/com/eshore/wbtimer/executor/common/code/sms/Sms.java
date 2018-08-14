package com.eshore.wbtimer.executor.common.code.sms;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eshore.wbtimer.common.utils.SpringContextUtil;
import com.eshore.wbtimer.executor.mapper.CommonMapper;
import com.eshore.wbtimer.executor.mapper.MissionMessageMapper;
import com.eshore.wbtimer.executor.mapper.SmsSendQueueMapper;
import com.eshore.wbtimer.executor.mapper.bean.MissionMessage;
import com.eshore.wbtimer.executor.mapper.bean.SmsSendQueue;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 描述:短信对象
 *
 * @author Yangjinming
 * @create 2018/1/25 11:32
 */
public class Sms {
    @Autowired
    private MissionMessageMapper missionMessageMapper;
    @Autowired
    private SmsSendQueueMapper smsSendQueueMapper;
    @Autowired
    CommonMapper commonMapper;
    private final Short init =0;

    public Sms() {
        init();
    }

    private void init() {
        this.missionMessageMapper = (MissionMessageMapper) SpringContextUtil.getBean("missionMessageMapper");
        this.smsSendQueueMapper = (SmsSendQueueMapper) SpringContextUtil.getBean("smsSendQueueMapper");
        this.commonMapper = (CommonMapper) SpringContextUtil.getBean("commonMapper");
    }

    /* 检查是否发送过短信 */
    public  boolean check(String telephone, String createName, Long missionId, Object... objects) {
        MissionMessage param = new MissionMessage();
        param.setPhonenumber(telephone);
        param.setCreateName(createName);
        // param.setSbStepType("APPLY");
        param.setMissionId(missionId);
        List<MissionMessage> check = missionMessageMapper.selectList(new EntityWrapper<MissionMessage>(param));//mp通用mapper切换
        if (CollectionUtils.isEmpty(check)) {
            return true;
        }
        return false;
    }

    /* 生成一条新短信 */
    public  void save(String telephone, String smsContent, Long missionId, String sbStepType, String createName) throws Exception {

        Long smsSendQueueId = commonMapper.selectSeqId("SEQ_SMS_SEND_QUEUE");//  this.publicDAO
        SmsSendQueue sendQueueParam = new SmsSendQueue();
        sendQueueParam.setQueueId(smsSendQueueId);
        sendQueueParam.setPhonenumber(telephone);
        sendQueueParam.setSmsContent(smsContent);
        sendQueueParam.setCreateDate(new Date());
        sendQueueParam.setCreateName(createName);
        sendQueueParam.setSendTimes(init);
        smsSendQueueMapper.insert(sendQueueParam); // ,this.publicDAO//mp通用mapper切换

        MissionMessage missionMessageParam = new MissionMessage();
        missionMessageParam.setMessageId(smsSendQueueId);
        missionMessageParam.setMessageType("0");
        missionMessageParam.setPhonenumber(telephone);
        missionMessageParam.setSmsContent(smsContent);
        missionMessageParam.setCreateName(createName);
        missionMessageParam.setCreateDate(new Date());
        missionMessageParam.setMissionId(missionId);
        missionMessageParam.setSbStepType(sbStepType);
        missionMessageMapper.insert(missionMessageParam);//mp通用mapper切换
    }

}