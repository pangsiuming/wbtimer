package com.eshore.wbtimer.executor.service.impl;

import com.eshore.wbtimer.common.utils.BeanUtil;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.utils.Axis2WebServiceUtil;
import com.eshore.wbtimer.executor.common.utils.DataPlatformXmlUtil;
import com.eshore.wbtimer.executor.enums.ExTableNameEnum;
import com.eshore.wbtimer.executor.enums.SbStepTypeEnum;
import com.eshore.wbtimer.executor.mapper.DataPlatFormSendMapper;
import com.eshore.wbtimer.executor.mapper.ExHalfProcessMapper;
import com.eshore.wbtimer.executor.mapper.bean.*;
import com.eshore.wbtimer.executor.service.DataPlatFormSendService;
import com.eshore.wbtimer.executor.service.bean.ExItemHalfParam;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 描述:数据交换-发送审批过程环节数据到数据管理平台
 *
 * @author Yangjinming
 * @date 2018/1/24 11:31
 */
@Service
public class DataPlatFormSendServiceImpl implements DataPlatFormSendService {
    @Autowired
    private DataPlatFormSendMapper dataPlatFormSendMapper;
    @Autowired
    private ExHalfProcessMapper exHalfProcessMapper;
    @Override
    public void startSendIntfData() throws Exception{
        ExTableNameEnum[] exTables = ExTableNameEnum.values();
        for (ExTableNameEnum exTableName : exTables) {
             sendIntfDataHandle(exTableName);
        }
    }

   /**
     * 推送环节数据到数据管理平台 包括半交换事项的表单数据
     * **/
    private void sendIntfDataHandle(ExTableNameEnum exTableName) throws Exception {
        String methodName; // 数据平台接口方法
        methodName = "setDataXmlToFocus";
        try {
            switch (exTableName) {
                case EX_SB: // 申办交换数据
                    sbCallIntf(exTableName, methodName);
                    break;
                case EX_WSYSL: // 网上预受理
                    wsyslCallIntf(exTableName, methodName);
                    break;
                case EX_SL: // 受理
                    slCallIntf(exTableName, methodName);
                    break;
                case EX_SPCL: // 审批
                    spclCallIntf(exTableName, methodName);
                    break;
                case EX_BJGZ: // 补证告知
                    bzgzCallIntf(exTableName, methodName);
                    break;
                case EX_BJSL: // 补证受理
                    bzslCallIntf(exTableName, methodName);
                    break;
                case EX_TBCXSQ: // 特别程序申请
                    tbcxsqCallIntf(exTableName, methodName);
                    break;
                case EX_TBCXJG: // 特别程序申请结果
                    tbcxjgCallIntf(exTableName, methodName);
                    break;
                case EX_BJ: // 办结(必要)
                    bjCallIntf(exTableName, methodName);
                    break;
                case EX_LQDJ: // 领证登记
                    lqdjCallIntf(exTableName, methodName);
                    break;
            }
        } catch (Exception e) {
            WbtimerJobLogger.log(e);
        }
    }
    private void sbCallIntf(ExTableNameEnum exTableName, String methodName) {
        // 已发送，失败的记录同步
        sendSbData(exTableName, methodName,dataPlatFormSendMapper.getExSendSBERROR(),true);
        // 未发送的记录同步
        sendSbData(exTableName, methodName, dataPlatFormSendMapper.getExSendSB(),false);
    }

    private void wsyslCallIntf(ExTableNameEnum exTableName, String methodName) throws Exception {
        // 已发送，未成功的记录同步
        sendWsyslData(exTableName, methodName, dataPlatFormSendMapper.getExSendWsyslError(),true);
        // 未发送的记录同步
        sendWsyslData(exTableName, methodName, dataPlatFormSendMapper.getExSendWsysl(),false);
    }

    private void slCallIntf(ExTableNameEnum exTableName, String methodName) throws Exception {
        // 已发送，未成功的记录同步
        sendSlData(exTableName, methodName, dataPlatFormSendMapper.getExSendSlError(),true);
        // 未发送的记录同步
        sendSlData(exTableName, methodName, dataPlatFormSendMapper.getExSendSl(),false);
    }

    private void spclCallIntf(ExTableNameEnum exTableName, String methodName) throws Exception {
        // 已发送，未成功的记录同步
        sendSpclData(exTableName, methodName, dataPlatFormSendMapper.getExSendSpclError(),true);
        // 未发送的记录同步
        sendSpclData(exTableName, methodName, dataPlatFormSendMapper.getExSendSpcl(),false);
    }
    private void bzgzCallIntf(ExTableNameEnum exTableName, String methodName) throws Exception {
        // 已发送，未成功的记录同步
        sendBzgzData(exTableName, methodName, dataPlatFormSendMapper.getExSendBzgzError(),true);
        // 未发送的记录同步
        sendBzgzData(exTableName, methodName, dataPlatFormSendMapper.getExSendBzgz(),false);
    }

    private void bzslCallIntf(ExTableNameEnum exTableName, String methodName) throws Exception {
        // 已发送，未成功的记录同步
        sendBzslData(exTableName, methodName, dataPlatFormSendMapper.getExSendBzslError(),true);
        // 未发送的记录同步
        sendBzslData(exTableName, methodName, dataPlatFormSendMapper.getExSendBzsl(),false);
    }
    private void tbcxsqCallIntf(ExTableNameEnum exTableName, String methodName) throws Exception {
        // 已发送，未成功的记录同步
        sendTbcxsqData(exTableName, methodName, dataPlatFormSendMapper.getExSendTbcxsqError(),true);
        // 未发送的记录同步
        sendTbcxsqData(exTableName, methodName, dataPlatFormSendMapper.getExSendTbcxsq(),false);
    }
    private void tbcxjgCallIntf(ExTableNameEnum exTableName, String methodName) throws Exception {
        // 已发送，未成功的记录同步
        sendTbcxjgData(exTableName, methodName, dataPlatFormSendMapper.getExSendTbcxjgError(),true);
        // 未发送的记录同步
        sendTbcxjgData(exTableName, methodName, dataPlatFormSendMapper.getExSendTbcxjg(),false);
    }

    private void bjCallIntf(ExTableNameEnum exTableName, String methodName) throws Exception {
        // 已发送，失败的记录同步
        sendBjData(exTableName, methodName, dataPlatFormSendMapper.getExSendBJError(),true);
        // 未发送的记录同步
        sendBjData(exTableName, methodName, dataPlatFormSendMapper.getExSendBJ(),false);
    }
    private void lqdjCallIntf(ExTableNameEnum exTableName, String methodName) throws Exception {
        // 已发送，未成功的记录同步
        sendLqdjData(exTableName, methodName, dataPlatFormSendMapper.getExSendLqdjError(),true);
        // 未发送的记录同步
        sendLqdjData(exTableName, methodName, dataPlatFormSendMapper.getExSendLqdj(),false);
    }
    private void sendLqdjData(ExTableNameEnum exTableName, String methodName, List<WsbsLqdjBean> wsbsSbList, boolean isError) {
        for (WsbsLqdjBean wsbsBean : wsbsSbList) {
            String stepType = SbStepTypeEnum.LZ.getValue();
            Long hjslbs = wsbsBean.getHjslbs();
            String sblsh = wsbsBean.getSblsh();
            String sendXml = null; // 发送的xml
            try {
                // 1.发送到数据平台
                WsbsLqdjBean dbTableDataBean = new WsbsLqdjBean();
                BeanUtil.copyProperties(dbTableDataBean, wsbsBean);
                boolean check = this.checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);
                sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                // 2.返回结果
                if (checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else { // 失败信息
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
            }
        }
    }

    private void sendTbcxjgData(ExTableNameEnum exTableName, String methodName, List<WsbsTbcxjgBean> wsbsSbList, boolean isError) {
        for (WsbsTbcxjgBean wsbsBean : wsbsSbList) {
            String stepType = SbStepTypeEnum.TBCXJG.getValue();
            Long hjslbs = wsbsBean.getHjslbs();
            String sblsh = wsbsBean.getSblsh();
            String sendXml = null; // 发送的xml
            try {
                // 1.发送到数据平台
                WsbsTbcxjgBean dbTableDataBean = new WsbsTbcxjgBean();
                BeanUtil.copyProperties(dbTableDataBean, wsbsBean);
                boolean check = this.checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);
                sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                // 2.返回结果
                if (checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else { // 失败信息
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
            }
        }
    }

    private void sendTbcxsqData(ExTableNameEnum exTableName, String methodName, List<WsbsTbcxsqBean> wsbsSbList, boolean isError) {
        for (WsbsTbcxsqBean wsbsBean : wsbsSbList) {
            String stepType = SbStepTypeEnum.TBCXSQ.getValue();
            Long hjslbs = wsbsBean.getHjslbs();
            String sblsh = wsbsBean.getSblsh();
            String sendXml = null; // 发送的xml
            try {
                // 1.发送到数据平台
                WsbsTbcxsqBean dbTableDataBean = new WsbsTbcxsqBean();
                BeanUtil.copyProperties(dbTableDataBean, wsbsBean);
                boolean check = this.checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);

                sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                // 2.返回结果
                if (checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else { // 失败信息
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
            }
        }
    }
    private void sendBjData(ExTableNameEnum exTableName, String methodName, List<WsbsBjBean> wsbsSbList, boolean isError) {
        for (WsbsBjBean wsbsBean : wsbsSbList) {
            String stepType = SbStepTypeEnum.BJ.getValue();
            Long hjslbs = wsbsBean.getHjslbs();
            String sblsh = wsbsBean.getSblsh();
            String sendXml = null; // 发送的xml

            try {
                // 1.发送到数据平台
                WsbsBjBean dbTableDataBean = new WsbsBjBean();
                ConvertUtils.register(new DateConverter(null), Date.class);
                BeanUtil.copyProperties(dbTableDataBean, wsbsBean);
                boolean check = this.checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);

                sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                // 2.返回结果
                if (checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else { // 失败信息
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                    //continue;
                }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
                //continue;
            }
        }


    }
    private void sendBzslData(ExTableNameEnum exTableName, String methodName, List<WsbsBzslBean> wsbsSbList, boolean isError) {
        for (WsbsBzslBean wsbsBean : wsbsSbList) {
            String stepType;
            Long hjslbs = wsbsBean.getHjslbs();
            String sblsh = wsbsBean.getSblsh();
            stepType = SbStepTypeEnum.BZSL.getValue();
            String sendXml = null; // 发送的xml
            try {
                // 1.发送到数据平台
                WsbsBzslBean dbTableDataBean = new WsbsBzslBean();
                BeanUtil.copyProperties(dbTableDataBean, wsbsBean);
                boolean check = this.checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);

                sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                // 2.返回结果
                if (checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else { // 失败信息
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
            }
        }
    }

    private void sendBzgzData(ExTableNameEnum exTableName, String methodName, List<WsbsBzgzBean> wsbsSbList, boolean isError) {
        for (WsbsBzgzBean wsbsBean : wsbsSbList) {
            String stepType;
            Long hjslbs = wsbsBean.getHjslbs();
            String sblsh = wsbsBean.getSblsh();
            stepType = SbStepTypeEnum.BZGZ.getValue();
            String sendXml = null; // 发送的xml
            try {
                // 1.发送到数据平台
                WsbsBzgzBean dbTableDataBean = new WsbsBzgzBean();
                BeanUtil.copyProperties(dbTableDataBean, wsbsBean);
                boolean check = this.checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);

                sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                // 2.返回结果
                if (checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else { // 失败信息
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
            }
        }
    }


    private void sendSpclData(ExTableNameEnum exTableName, String methodName, List<WsbsSpclBean> wsbsSbList, boolean isError) {
        for (WsbsSpclBean wsbsBean : wsbsSbList) {
            String stepType;
            Long hjslbs = wsbsBean.getHjslbs();
            String sblsh = wsbsBean.getSblsh();
            stepType = SbStepTypeEnum.SH.getValue();
            String sendXml = null; // 发送的xml
            try {
                // 1.发送到数据平台
                WsbsSpclBean dbTableDataBean = new WsbsSpclBean();
                BeanUtil.copyProperties(dbTableDataBean, wsbsBean);
                boolean check = this.checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);

                //查询是否是发改的特殊半交换事项(添加预承办环节交换出去)，审批环节配置是否为3
                ExItemHalfParam exItemHalfParam = new ExItemHalfParam();
                exItemHalfParam.setServiceCode(dbTableDataBean.getSxbm());
                exItemHalfParam.setHjSpcl(Long.valueOf(3));
                List<ExItemHalfBean> exItemHalfBeanList = dataPlatFormSendMapper.getExItemHalfInfo(exItemHalfParam);
                boolean retBool =false;
                if (CollectionUtils.isNotEmpty(exItemHalfBeanList)){
                    retBool =true;
                }
                 if(retBool) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else {
                    sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                    String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                    // 2.返回结果
                    if (checkOK(result)) {
                        saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                    } else { // 失败信息
                        saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                    }
                }

                // }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
            }
        }
    }
    private void sendSlData(ExTableNameEnum exTableName, String methodName, List<WsbsSlBean> wsbsSbList, boolean isError) {
        // 半交换未发送的申请单
        for (WsbsSlBean wsbsBean : wsbsSbList) {
            String stepType;
            Long hjslbs = wsbsBean.getHjslbs();
            String sblsh = wsbsBean.getSblsh();
            stepType = SbStepTypeEnum.SL.getValue();
            String sendXml = null; // 发送的xml
            try {
                // 1.发送到数据平台
                WsbsSlBean dbTableDataBean = new WsbsSlBean();
                BeanUtil.copyProperties(dbTableDataBean, wsbsBean);
                boolean check = this.checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);

                sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                // 2.返回结果
                if (checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else { // 失败信息
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
            }
        }
    }

    /**
     * 网上预受理环节数据推送
     *
     * @param exTableName
     *            = ex_gdbs_wsysl
     * @param methodName
     * @param wsbsSbList
     * @param isError
     */
     private void sendWsyslData(ExTableNameEnum exTableName, String methodName, List<WsbsWsyslBean> wsbsSbList, boolean isError) {
        for (WsbsWsyslBean wsbsBean : wsbsSbList) {
            String stepType;
            Long hjslbs = wsbsBean.getHjslbs();
            String sblsh = wsbsBean.getSblsh();
            stepType = SbStepTypeEnum.YSL.getValue();
            String sendXml = null; // 发送的xml
            try {
                // 1.发送到数据平台
                WsbsWsyslBean dbTableDataBean = new WsbsWsyslBean();
                BeanUtil.copyProperties(dbTableDataBean, wsbsBean);
                boolean check = this.checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);

                sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                // 2.返回结果
                if (checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else { // 失败信息
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
            }
        }
    }

    /**
     * List<WsbsSbSubBean> 和WsbsSbBean 实体不对一个 TODO
     *
     * @param exTableName
     * @param methodName
     * @param halfWaitWsbsSbList 半交换未发送的申请单
     */
     private void sendSbData(ExTableNameEnum exTableName, String methodName, List<WsbsSbBean> halfWaitWsbsSbList, boolean isError) {
         if (CollectionUtils.isEmpty(halfWaitWsbsSbList)) {
            return;
        }
        for (WsbsSbBean wsbsSbSubBean : halfWaitWsbsSbList) {
            String stepType;
            Long hjslbs = wsbsSbSubBean.getHjslbs();
            String sblsh = wsbsSbSubBean.getSblsh();
            stepType = SbStepTypeEnum.SB.getValue();
            String sendXml="";
            try {
                //1.发送到数据平台
                WsbsSbBean dbTableDataBean = new WsbsSbBean();
                BeanUtil.copyProperties(dbTableDataBean, wsbsSbSubBean);
                boolean check =  checkIsHalfExchange(dbTableDataBean.getSxbm(), stepType);

                sendXml = DataPlatformXmlUtil.getSendTableXml(exTableName, dbTableDataBean, check, dbTableDataBean.getSxbm());
                String result = Axis2WebServiceUtil.callDataPlatformIntf(exTableName.getValue(), methodName, sendXml);
                //String result="2";
                // 2.返回结果
                if (checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType, check, sendXml);
                } else { // 失败信息
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, sendXml, isError);
                    //continue;
                }
            } catch (Exception e) {
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), sendXml, isError);
            }
        }
    }
    /**
     * 发送失败日志记录
     *
     * @param hjslbs
     * @param sblsh
     * @param stepType
     * @param result
     * @param sendXml
     * @param isError
     */

    private void saveFailHalfExchange(Long hjslbs, String sblsh, String stepType, String result, String sendXml, boolean isError) {
        try {
            // @1 发送失败的环节数据记录 hjslsb：各环节实例表主键
            SendStepErrorBean error = new SendStepErrorBean();
            error.setMissionId(hjslbs);
            error.setStepType(stepType);
            error.setSendDate(new Date());
            error.setSendFlag("1");
            error.setSendXml(sendXml);
            if (result.length() >= 3000) {
                result = result.substring(0, 2999);
            }
            error.setRemark(result);
            if (!isError) {
                dataPlatFormSendMapper.insert(error);//mp通用mapper切换
                return;
            }
            dataPlatFormSendMapper.updateById(error);//mp通用mapper切换
            WbtimerJobLogger.log(result);
        } catch (Exception e) {
           WbtimerJobLogger.log(e);
        }
    }

    /**
     * 交换成功日志方法
     *
     * @param hjslbs
     * @param sblsh
     * @param stepType
     * @param isHalfExchange
     * @param sendXml
     * @throws Exception
     */
    private void saveSuccessHalfExchange(Long hjslbs, String sblsh, String stepType, boolean isHalfExchange, String sendXml) throws Exception {
        // @1 保存发送成功日志到send_sb表
        SendStepBean success = new SendStepBean();
        success.setMissionId(hjslbs);
        success.setStepType(stepType);
        success.setSendDate(new Date());
        success.setSendXml(sendXml);
        dataPlatFormSendMapper.insertSendStep(success);

        // @2 serviceCode检测是否存在办交换规则表EX_ITEM_HALF==isHalfExchange
        if (isHalfExchange) { // insert data into EX_HALF_PROCESS...
            ExHalfProcess exHalfProcessBean = new ExHalfProcess();
            // /exHalfProcessBean.setSblsh( String.valueOf( missionId != null ? missionId : sblsh) ); TODO zhangz
            exHalfProcessBean.setSblsh(sblsh);
            exHalfProcessBean.setInitStepType(stepType);
            exHalfProcessBean.setCurrntStepType(stepType);
            exHalfProcessBean.setCreateDate(new Date());
            exHalfProcessBean.setHjslbs(hjslbs);
            exHalfProcessMapper.insert(exHalfProcessBean);//mp通用mapper切换
        }
        // @3 对于当前数据存在有历史发生失败记录,更新状态
        SendStepErrorBean errorUpdate = new SendStepErrorBean();
        errorUpdate.setMissionId(hjslbs);
        errorUpdate.setSendFlag("0");
        dataPlatFormSendMapper.updateById(errorUpdate);//mp通用mapper切换
    }

    /**
     * 发送数据成功后，检测当前事项是否在办交换规则表EX_ITEM_HALF中，若存在，需要再次记录数据到EX_HALF_PROCESS表
     *
     * @param serviceCode
     * @param stepType
     * @return
     * @throws Exception
     */
     private boolean checkIsHalfExchange(String serviceCode, String stepType) throws Exception {
        boolean result = false;
        ExItemHalfParam exItemHalfParam = new ExItemHalfParam();
        exItemHalfParam.setServiceCode(serviceCode);
        List<ExItemHalfBean> list = dataPlatFormSendMapper.getExItemHalfInfo(exItemHalfParam);
        if (list != null && list.size() > 0) {
            ExItemHalfBean data = list.get(0);
            if (stepType.equals("PREACCEPT")) { // 预受理
                if (data.getHjWsysl() != null && data.getHjWsysl() == 2) {
                    result = true;
                }
            }
            if (stepType.equals("APPLY")) { // 申办
                if (data.getHjSb() != null && data.getHjSb() == 2) {
                    result = true;
                }
            }
            if (stepType.equals("ACCEPT")) { // 受理
                if (data.getHjSl() != null && data.getHjSl() == 2) {
                    result = true;
                }
            }
            //添加预承办环节，发改半交换事项特殊配置，审批环节配置为3，20170120ls
            if (stepType.equals("APPROVE_SH")) { // 预承办
                if (data.getHjSpcl() != null && data.getHjSpcl() == 3) {
                    result = true;
                }
            }
        } else {
            result = false;
        }
        return result;

    }
    /**
     * 验证返回结果
     *
     * @param result
     * @return
     */
    private boolean checkOK(String result) {
        boolean flag = false;
        if (result.indexOf("编码：") != -1) {
            String msg = result.substring(result.indexOf("编码：") + 3, result.indexOf("编码：") + 4);
            if ("0".equals(msg)) {
                flag = true;
            }
        }else if (result.indexOf("success") != -1 && result.indexOf("0") != -1) {
            flag = true;
        }
        return flag;
    }
}
