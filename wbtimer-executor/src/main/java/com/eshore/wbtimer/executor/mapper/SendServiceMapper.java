package com.eshore.wbtimer.executor.mapper;

import com.eshore.wbtimer.executor.mapper.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述:数据交换-发送审批过程环节数据到数据管理平台
 *
 * @author Yangjinming
 * @create 2018/1/25 9:23
 */
public interface SendServiceMapper {
    List<Map<String,Object>> selectFgSendRemindPreAcceptSMS();
    Long selectOrgMessageConfigIdByCode(@Param("orgCode") String orgCode, @Param("templateCode") String templateCode);
    List<Map<String,Object>> receiveWaitDealSmsSendTask();
    List<WsbsSbBean> selectWsbsSbSmsNoticeSbSuccess(String createName);
    List<String> getMobileFromOrgMsg(Long msgConfId);
    List<WsbsTbcxsqBean> getWsbsTbcxsqSpecailALeader();
    List<String> getSpecailALeaderTelephone(Long hjslbs);
    WsbsSbBean getWsbsSbInfo(Map<String, Object> params);
    List<WsbsSbBean> getSmsNoticeSb(Map<String, Object> params);
    SysstaffBean getSysStaffById(String staffId);
    List<SysstaffBean> getSysStaffActorForemp(Long dutyOrgid);
    SysstaffBean  getSysStaffActorForemp2(String sblsh);
    List<SysstaffBean> getSysStaffActorForposition(Long dutyOrgid);
    List<WsbsBzgzBean> getSmsNoticeBzgz(String bz);
    List<WsbsSbActorBean> getSmsNoticeActor(@Param("sblsh") String sblsh);
    List<WsbsTbcxsqBean> getSmsNoticeTbcx();
}
