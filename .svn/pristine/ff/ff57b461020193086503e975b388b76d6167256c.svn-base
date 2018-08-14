package com.eshore.wbtimer.executor.service.impl;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.utils.Axis2WebServiceUtil;
import com.eshore.wbtimer.executor.common.utils.DataFormatXmlUtil;
import com.eshore.wbtimer.executor.enums.SbStepTypeEnum;
import com.eshore.wbtimer.executor.enums.StdTableNameEnum;
import com.eshore.wbtimer.executor.mapper.DataSendToStdMapper;
import com.eshore.wbtimer.executor.mapper.bean.SendStepBean;
import com.eshore.wbtimer.executor.mapper.bean.SendStepErrorBean;
import com.eshore.wbtimer.executor.service.DataSendToStdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DataSendToStdServiceImpl implements DataSendToStdService {

    @Autowired
    DataSendToStdMapper dataSendToStdMapper;

    @Override
    public void sendStdDataHandle() throws Exception {
        StdTableNameEnum[] exTables = StdTableNameEnum.values();
        for (StdTableNameEnum exTableName : exTables) {
            sendIntfDataHandle(exTableName);
        }
    }
    private void sendIntfDataHandle(StdTableNameEnum exTableName) {
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
                case EX_BJGZ: // 补正告知
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

    private void sbCallIntf(StdTableNameEnum exTableName, String methodName) {
        String stepType = SbStepTypeEnum.SB.getValue();
        // 已发送，失败的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.querySbData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.querySbData(),stepType,false);
    }

    private void wsyslCallIntf(StdTableNameEnum exTableName, String methodName) {
        String stepType = SbStepTypeEnum.YSL.getValue();
        // 已发送，未成功的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryYslData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryYslData(),stepType,false);
    }


    private void slCallIntf(StdTableNameEnum exTableName, String methodName) throws Exception {
        String stepType = SbStepTypeEnum.SL.getValue();
        // 已发送，未成功的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.querySlData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.querySlData(),stepType,false);
    }


    private void spclCallIntf(StdTableNameEnum exTableName, String methodName) {
        String stepType = SbStepTypeEnum.SH.getValue();
        // 已发送，未成功的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.querySpclData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.querySpclData(),stepType,false);
    }


    private void bzgzCallIntf(StdTableNameEnum exTableName, String methodName) throws Exception {
        String stepType = SbStepTypeEnum.BZGZ.getValue();
        // 已发送，未成功的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryBzgzData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryBzgzData(),stepType,false);
    }

    private void bzslCallIntf(StdTableNameEnum exTableName, String methodName) {
        String stepType = SbStepTypeEnum.BZSL.getValue();
        // 已发送，未成功的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryBzslData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryBzslData(),stepType,false);
    }

    private void tbcxsqCallIntf(StdTableNameEnum exTableName, String methodName) {
        String stepType = SbStepTypeEnum.TBCXSQ.getValue();
        // 已发送，未成功的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryTbcxsqData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryTbcxsqData(),stepType,false);
    }

    private void tbcxjgCallIntf(StdTableNameEnum exTableName, String methodName) {
        String stepType = SbStepTypeEnum.TBCXJG.getValue();
        // 已发送，未成功的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryTbcxjgData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryTbcxjgData(),stepType,false);
    }

    private void bjCallIntf(StdTableNameEnum exTableName, String methodName) {
        String stepType = SbStepTypeEnum.BJ.getValue();
        // 已发送，未成功的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryBjData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryBjData(),stepType,false);
    }

    private void lqdjCallIntf(StdTableNameEnum exTableName, String methodName) {
        String stepType = SbStepTypeEnum.LZ.getValue();
        // 已发送，未成功的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryLqdjData_error(),stepType,true);
        // 未发送的记录同步
        sendDataToStd(exTableName, methodName, dataSendToStdMapper.queryLqdjData(),stepType,false);
    }

    private void sendDataToStd(StdTableNameEnum exTableName, String methodName, List<Map<String,Object>> list,String stepType,boolean isError){

        if(list==null || list.size()==0){
            return;
        }
        for(Map<String,Object> m : list){
            Long hjslbs=Long.parseLong(m.get("HJSLBS").toString());
            String sblsh=m.get("SBLSH").toString();

            String xml= DataFormatXmlUtil.dataFormatXml(exTableName.getValue(),m);
            try{
                String result = Axis2WebServiceUtil.callDataPlatformForStd(exTableName.getValue(), methodName, xml);
                if(checkOK(result)) {
                    saveSuccessHalfExchange(hjslbs, sblsh, stepType,xml);
                }else{
                    saveFailHalfExchange(hjslbs, sblsh, stepType, result, xml, isError);
                }
            }catch(Exception e){
                saveFailHalfExchange(hjslbs, sblsh, stepType, e.getMessage().toString().length() > 2000 ? e.getMessage().toString().substring(0, 2000) : e
                        .getMessage().toString(), xml, isError);
            }
        }
    }

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


    /**
     * 交换成功日志方法,去掉了是否半交换的判断
     *
     * @param missionId
     *            wsbs_*** 每一个环节表的主键标示hjslbs
     * @param stepType
     * @param serviceCode
     *            当前事项编码
     * @throws Exception
     */
    private void saveSuccessHalfExchange(Long hjslbs, String sblsh, String stepType,String sendXml) throws Exception {
        // @1 保存发送成功日志到send_sb表
        SendStepBean success = new SendStepBean();
        success.setMissionId(hjslbs);
        success.setStepType(stepType);
        success.setSendDate(new Date());
        success.setSendXml(sendXml);
        dataSendToStdMapper.SEND_STEP_STD_insert(success);

        // @3 对于当前数据存在有历史发生失败记录,更新状态
        SendStepErrorBean errorUpdate = new SendStepErrorBean();
        // errorUpdate.setMissionId( missionId != null ? missionId : sblsh); TODO zhangz
        errorUpdate.setMissionId(hjslbs);
        errorUpdate.setSendFlag("0");
        dataSendToStdMapper.updateById(errorUpdate);//mp通用mapper切换
    }

    /**
     * 发送失败日志记录
     *
     * @param missionId
     * @param stepType
     * @param result
     * @throws Exception
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
                dataSendToStdMapper.insert(error);//mp通用mapper切换
                return;
            } else {
                dataSendToStdMapper.updateById(error);//mp通用mapper切换

            }
        } catch (Exception e) {
            // logger.error(e.getMessage());
        }
    }

}
