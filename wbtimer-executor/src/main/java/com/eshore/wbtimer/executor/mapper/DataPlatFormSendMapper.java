package com.eshore.wbtimer.executor.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.eshore.wbtimer.executor.mapper.bean.*;
import com.eshore.wbtimer.executor.service.bean.ExItemHalfParam;

import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @date 2018/1/24 11:31
 */
public interface DataPlatFormSendMapper extends BaseMapper<SendStepErrorBean>{
    List<ExItemHalfBean> getExItemHalfInfo(ExItemHalfParam params);
    List<WsbsSbBean> getExSendSBERROR();
    List<WsbsSbBean> getExSendSB();
    List<WsbsWsyslBean> getExSendWsyslError();
    List<WsbsWsyslBean> getExSendWsysl();
    List<WsbsSlBean> getExSendSlError();
    List<WsbsSlBean> getExSendSl();
    List<WsbsSpclBean> getExSendSpcl();
    List<WsbsSpclBean> getExSendSpclError();
    List<WsbsBzgzBean> getExSendBzgzError();
    List<WsbsBzgzBean> getExSendBzgz();
    List<WsbsBzslBean> getExSendBzslError();
    List<WsbsBzslBean> getExSendBzsl();
    List<WsbsTbcxsqBean> getExSendTbcxsqError();
    List<WsbsTbcxsqBean> getExSendTbcxsq();
    List<WsbsTbcxjgBean> getExSendTbcxjg();
    List<WsbsTbcxjgBean> getExSendTbcxjgError();
    List<WsbsBjBean> getExSendBJ();
    List<WsbsBjBean> getExSendBJError();
    List<WsbsLqdjBean> getExSendLqdj();
    List<WsbsLqdjBean> getExSendLqdjError();
    int insertSendStep(SendStepBean SendStepBean);

}
