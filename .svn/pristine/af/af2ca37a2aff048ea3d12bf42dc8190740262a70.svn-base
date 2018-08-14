package com.eshore.wbtimer.executor.service.impl;

import com.eshore.emall.pub.util.RandomNumericUtil;
import com.eshore.emall.pub.util.StringUtil;
import com.eshore.wbtimer.common.enums.ResponseCode;
import com.eshore.wbtimer.common.exception.GlobalException;
import com.eshore.wbtimer.common.utils.MD5Utils;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.code.sms.SMSServiceStub;
import com.eshore.wbtimer.executor.common.constants.CommConstants;
import com.eshore.wbtimer.executor.common.constants.Constants;
import com.eshore.wbtimer.executor.common.exception.GovBaseException;
import com.eshore.wbtimer.executor.common.utils.DateUtils;
import com.eshore.wbtimer.executor.mapper.bean.ConfigContentBean;
import com.eshore.wbtimer.executor.service.CfgContentService;
import com.eshore.wbtimer.executor.service.SendSmsHandlerService;
import com.eshore.wbtimer.executor.service.bean.SendItemInformationParam;
import com.eshore.wbtimer.executor.service.bean.SmsReceiptParamBean;
import org.apache.axis.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.HashMap;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/30 15:28
 */
@Service("zhSendSmsHandlerService")
public class SendSmsHandlerServiceImpl implements SendSmsHandlerService {
    @Autowired
    CfgContentService cfgContentService;
    private SmsReceiptParamBean smsReceiptParam;  //存储短信是否成功发送至服务器，sessionid
    @Override
    public SmsReceiptParamBean send(String phoneNumber, String content) {
        if(smsReceiptParam==null){
            smsReceiptParam = new SmsReceiptParamBean();
        }
        smsReceiptParam.setIsSuccess(false);  //默认为放失败
        try {
            if (StringUtil.isEmpty(phoneNumber)) {
                throw new GlobalException(ResponseCode.SUCCESS, "接收号码不能为空！");
            }
            if (StringUtil.isEmpty(content)) {
                throw new GlobalException(ResponseCode.SUCCESS, "发送内容不能为空！");
            }
            //这里返回一个String []

            Object [] ret= sendMgr(phoneNumber,content,smsReceiptParam);
            //
            //	System.out.println(((String[]) ret[0])[0]);
            String reulst1 =((String[])ret[0])[0];
            String reulst2 =((String[])ret[0])[1];
            System.out.println(reulst1);
            if("0".equals(reulst1)){
                smsReceiptParam.setIsSuccess(true);  //发送成功
                //短信发送成功返回的sessionId   private String sessionId;
                smsReceiptParam.setSessionId(reulst2);
            }
        } catch (Exception e) {
           WbtimerJobLogger.log(e.getMessage(), e);
            smsReceiptParam.setIsSuccess(false);  //发送失败
        }
        //return isSuccess;


        smsReceiptParam.setIsSuccess(true);
        return smsReceiptParam;
    }

    @Override
    public SmsReceiptParamBean pySend(String queueId) {
        //boolean isSuccess = false;
        if(smsReceiptParam==null){
            smsReceiptParam=new SmsReceiptParamBean();
        }
        smsReceiptParam.setIsSuccess(false);
        try {
            pySendMsm(queueId,smsReceiptParam);
            //isSuccess = true;
            smsReceiptParam.setIsSuccess(true);
        } catch (Exception e) {
            WbtimerJobLogger.log(e);
            //isSuccess = false;
            smsReceiptParam.setIsSuccess(false);
        }
        return smsReceiptParam;
    }

    /**
     * 评议短信的发送
     * @param queueId  短信队列号
     */
    public void pySendMsm (String queueId,SmsReceiptParamBean smsReceiptParam) throws RemoteException{
        //获取短信发送所需参数，及事项信息
        SendItemInformationParam itemInformation = cfgContentService.getItemInformation(queueId);
        try {
            //获取 短信发送配置
            ConfigContentBean cfgBean = cfgContentService.getCfgContent(Constants.CONTENT_TYPE.SEND_SMS_SETTING, Constants.SEND_SMS_SETTING.URL);
            //发送短信的总类，要此类的方法sendSurvey 发送信息
            SMSServiceStub stub = new SMSServiceStub(cfgBean.getContentvalue()); //设置短信服务器URL
            //	SMSServiceStub stub = new SMSServiceStub("http://19.48.17.148:8081/Interface/services/SMSService?wsdl"); //测试用地址
            SMSServiceStub.SendSurveyRequest SendRequest =  new SMSServiceStub.SendSurveyRequest();

            cfgBean = cfgContentService.getCfgContent(Constants.CONTENT_TYPE.SEND_SMS_SETTING,
                    Constants.SEND_SMS_SETTING.USER_NAME);
            SMSServiceStub.AccountAuth auth = new SMSServiceStub.AccountAuth();
            auth.setAccount(cfgBean.getContentvalue());
            //本地测试使用账号为 zhwsbsdt/zhwsbsdt5566
            //auth.setAccount("zhwsbsdt");
            String hashCode = String.valueOf(
                    Calendar.getInstance().getTimeInMillis()).concat(
                    RandomNumericUtil.createRNStrWithLen(5));
            cfgBean = cfgContentService.getCfgContent(Constants.CONTENT_TYPE.SEND_SMS_SETTING,
                    Constants.SEND_SMS_SETTING.PASSWORD);
            auth.setPassword(MD5Utils.getMD5(MD5Utils.getMD5(cfgBean.getContentvalue()) + hashCode));
            //auth.setPassword(MD5Utils.getMD5(MD5Utils.getMD5("zhwsbsdt5566") + hashCode));
            auth.setHashCode(hashCode);
            SendRequest.setAccountAuth(auth);
            //添加参数
            SendRequest.setSBLSH(itemInformation.getSblsh());  //申办流水号
            SendRequest.setSXBM(itemInformation.getSxbm());    //事项编码
            SendRequest.setSXMC(itemInformation.getSxmc());    //事项名称
            SendRequest.setBMMC(itemInformation.getBmmc());    //部门名称
            SendRequest.setSQRMC(itemInformation.getSqrmc());  //申请人名称
            SendRequest.setLXRXM(itemInformation.getLxrmc());  //联系人名称
            SendRequest.setLXRSJ(itemInformation.getLxrsj());  //联系人手机
            //SendRequest.setLXRSJ("18926121068");  //联系人手机
            SendRequest.setCONTENT(itemInformation.getContent()); //短信内容
            SendRequest.setHJZT(itemInformation.getHjzt());//环节状态
            //环节名称 标识--->汉字名称的转换
            String hjName = name2Chinese(itemInformation.getHjmc());
            SendRequest.setHJMC(hjName);    //环节名称
            //将数据库中 环节时间格式转化为参数所需格式
            String standardDate = DateUtils.formatDate(itemInformation.getHjsj(),"yyyyMMddHHmmss");
            SendRequest.setHJSJ(standardDate);    //环节时间
            WbtimerJobLogger.log("[Client]客户端开始调用WebService...");
            try {
                SMSServiceStub.SendSurveyResponse sendResponse = stub.sendSurvey(SendRequest);
                smsReceiptParam.setSessionId(""+sendResponse.getSessionId());
                WbtimerJobLogger.log("[Client]服务端返回结果：");
                WbtimerJobLogger.log("[Client]获取会话id：" + sendResponse.getSessionId());
                WbtimerJobLogger.log("[Client]获取结果编码：" + sendResponse.getResultCode());
                if (!"0".equals(sendResponse.getResultCode())) {
                    throw new GovBaseException("","错误编码：" + sendResponse.getResultCode());
                }
            } catch (RemoteException e) {
                e.printStackTrace();
                WbtimerJobLogger.log("[Client]发生异常：" + e.getMessage());
                throw e;
            }
        } catch (AxisFault ef) {
            ef.printStackTrace();
            WbtimerJobLogger.log("[Client]发生异常：" + ef.getMessage());
            throw ef;
        } catch (RemoteException er) {
            throw er;
        }
        WbtimerJobLogger.log("========= end of sendSMS方法 =========");
    }

    private Object[] sendMgr(String phoneNumber, String content,SmsReceiptParamBean smsReceiptParam) {
        Object[] ret = null;
        try {
            ConfigContentBean cfgBean = cfgContentService.getCfgContent(Constants.CONTENT_TYPE.SEND_SMS_SETTING,
                    Constants.SEND_SMS_SETTING.URL);
            String  URL= cfgBean.getContentvalue();

            //String  URL="http://19.53.6.3:8080/XZSMSService/services/Sendmsg?wsdl";
            String opName = "SendMsg";
            cfgBean = cfgContentService.getCfgContent(Constants.CONTENT_TYPE.SEND_SMS_SETTING,
                    Constants.SEND_SMS_SETTING.USER_NAME);
            String Account=cfgBean.getContentvalue();
            // String Account="xzspjk";
            cfgBean = cfgContentService.getCfgContent(Constants.CONTENT_TYPE.SEND_SMS_SETTING,
                    Constants.SEND_SMS_SETTING.PASSWORD);
            String Password=cfgBean.getContentvalue();
            // String Password="xzspjk";

            String DestNum = phoneNumber;
            // String DestNum ="13750098105";

            String WriteBack = "1";

            //短信末尾统一加短信签名 中国移动手机除外

            cfgBean = cfgContentService.getCfgContent(Constants.CONTENT_TYPE.SEND_SMS_SETTING,
                    Constants.SEND_SMS_SETTING.CMHEADER);
            String cmcHeader = cfgBean.getContentvalue();

            if(!isCmMobileNumber(phoneNumber,cmcHeader)){
                cfgBean = cfgContentService.getCfgContent(Constants.CONTENT_TYPE.SEND_SMS_SETTING,
                        Constants.SEND_SMS_SETTING.SIGN);
                if(StringUtil.isNotEmpty(content)&&StringUtil.isNotEmpty(cfgBean.getContentvalue())&&content.indexOf(cfgBean.getContentvalue())<0){
                    content +=cfgBean.getContentvalue();
                }
            }

            String Content =content;
            WbtimerJobLogger.log("[Client]客户端开始调用WebService...");

            Object[] opArgs = new Object[] {Account,Password,Content,DestNum,WriteBack};

            Class<?>[] opReturnType = new Class[] { String[].class };

            RPCServiceClient serviceClient;

            serviceClient = new RPCServiceClient();

            Options options = serviceClient.getOptions();
            EndpointReference targetEPR = new EndpointReference(URL);

            options.setTo(targetEPR);


            QName opQName = new QName("http://ws.apache.org/axis2",opName);


            ret = serviceClient.invokeBlocking(opQName, opArgs, opReturnType);
            // serviceClient.cleanupTransport();
            //   System.out.println(((String[]) ret[0])[0]);
            // System.out.println(( ret[0]));
            serviceClient.cleanupTransport();
        } catch (Exception e) {
            e.printStackTrace();
            WbtimerJobLogger.log("[Client]发生异常：" + e.getMessage());
        }
        WbtimerJobLogger.log("========= end of 测试sendSMS方法 =========");

        return  ret;
    }
    /**
     * 调用短信接口发布信息
     * @param phoneNumber
     * @param content
     */
    private void sendSms(String phoneNumber, String content,SmsReceiptParamBean smsReceiptParam) throws Exception,AxisFault {

        try {
            ConfigContentBean cfgBean = cfgContentService.getCfgContent(CommConstants.CONTENT_TYPE.SEND_SMS_SETTING,
                    CommConstants.SEND_SMS_SETTING.URL);
            //SMSServiceStub stub = new SMSServiceStub("http://19.48.17.148:8081/Interface/services/SMSService?wsdl"); //测试用地址
            SMSServiceStub stub = new SMSServiceStub(cfgBean.getContentvalue());
            SMSServiceStub.SendSMSRequest request = new SMSServiceStub.SendSMSRequest();

            cfgBean = cfgContentService.getCfgContent(CommConstants.CONTENT_TYPE.SEND_SMS_SETTING,
                    CommConstants.SEND_SMS_SETTING.USER_NAME);
            SMSServiceStub.AccountAuth auth = new SMSServiceStub.AccountAuth();
            auth.setAccount(cfgBean.getContentvalue());
            //本地测试使用账号为 zhwsbsdt/zhwsbsdt5566
            //auth.setAccount("zhwsbsdt");
            String hashCode = String.valueOf(
                    Calendar.getInstance().getTimeInMillis()).concat(
                    RandomNumericUtil.createRNStrWithLen(5));

            cfgBean = cfgContentService.getCfgContent(CommConstants.CONTENT_TYPE.SEND_SMS_SETTING,
                    CommConstants.SEND_SMS_SETTING.PASSWORD);
            auth.setPassword(MD5Utils.getMD5(MD5Utils.getMD5(cfgBean.getContentvalue()) + hashCode));
            //auth.setPassword(MD5Utils.getMD5(MD5Utils.getMD5("zhwsbsdt5566") + hashCode));//测试账号数据
            auth.setHashCode(hashCode);
            request.setAccountAuth(auth);

            SMSServiceStub.RecvNumArray recvNumArray = new SMSServiceStub.RecvNumArray();
            recvNumArray.addRecvNum(phoneNumber);
            //recvNumArray.addRecvNum("18926121068"); //测试数据
            request.setRecvNumArray(recvNumArray);

            // 定时发送时间，可留空
            // request.setSchdDate("20131016124900");

            WbtimerJobLogger.log("[Client]客户端开始调用WebService...");

            try {

                //短信末尾统一加短信签名 中国移动手机除外
                cfgBean = cfgContentService.getCfgContent(CommConstants.CONTENT_TYPE.SEND_SMS_SETTING,
                        CommConstants.SEND_SMS_SETTING.CMHEADER);
                String cmcHeader = cfgBean.getContentvalue();

                if(!isCmMobileNumber(phoneNumber,cmcHeader)){
                    cfgBean = cfgContentService.getCfgContent(CommConstants.CONTENT_TYPE.SEND_SMS_SETTING,
                            CommConstants.SEND_SMS_SETTING.SIGN);
                    if(StringUtil.isNotEmpty(content)&&StringUtil.isNotEmpty(cfgBean.getContentvalue())&&content.indexOf(cfgBean.getContentvalue())<0){
                        content +=cfgBean.getContentvalue();
                    }
                }
                request.setContent(content);


                SMSServiceStub.SendSMSResponse response = stub.sendSMS(request);
                smsReceiptParam.setSessionId(""+response.getSessionId());
                WbtimerJobLogger.log("[Client]服务端返回结果：");
                WbtimerJobLogger.log("[Client]获取会话id：" + response.getSessionId());
                WbtimerJobLogger.log("[Client]获取结果编码：" + response.getResultCode());
                WbtimerJobLogger.log("[Client]获取成功数：" + response.getSuccessCount());
                WbtimerJobLogger.log("[Client]获取过滤数：" + response.getFilterCount());

                if (!"0".equals(response.getResultCode())) {
                    throw new GlobalException(ResponseCode.SUCCESS,"错误编码：" + response.getResultCode());
                }

                if (response.getFilterArray() != null) {
                    SMSServiceStub.FilterResult[] result = response.getFilterArray()
                            .getFilterResult();
                    if (result != null && result.length > 0) {
                        for (int i = 0; i < result.length; i++) {
                            SMSServiceStub.FilterResult filterResult = result[i];
                            WbtimerJobLogger.log("[Client]过滤号码："
                                    + filterResult.getRecvNum() + "-->"
                                    + filterResult.getFilterCode());
                        }
                    }
                }

            } catch (RemoteException e) {
                WbtimerJobLogger.log("[Client]发生异常：" + e.getMessage());
                throw e;
            }
        } catch (AxisFault e) {
            WbtimerJobLogger.log("[Client]发生异常：" + e.getMessage());
            throw e;
        } catch (RemoteException e) {
            throw e;
        }
    }

    /**
     * 判断该手机号码是否是移动手机号段<br>
     *
     * @param phone
     * @return true or false
     * @throws Exception
     */
    private boolean isCmMobileNumber(String phone,String cmHeader) {
        boolean isExist = false;
        try{
            phone = phone.trim();
            if (phone == null || phone.length() < 7) {
                try {
                    throw new Exception("wrong phone length");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            String code = phone.substring(0, 3);

            String[] cmList=cmHeader.split(",");
            for(int i=0;i<cmList.length;i++){
                if(code.equals(cmList[i])){
                    isExist = true;
                    break;
                }

            }
        }catch (Exception ee) {
            WbtimerJobLogger.log("[isCmMobileNumber]发生异常：" + ee.getMessage());
        }
        return isExist;

    }

    //数据库中环节状态代码转换为汉字名称
    private String name2Chinese(String nameformate){
        HashMap<String,String> mark2Chinese = new HashMap<>();
        mark2Chinese.put("SPECIAL_APPLY","特别程序申请");
        mark2Chinese.put("SPECIAL_SP","特别程序批准");
        mark2Chinese.put("SUPPLEMENT_GZ","补正告知");
        mark2Chinese.put("APPLY","申请");
        mark2Chinese.put("PREACCEPT","预受理");
        mark2Chinese.put("ACCEPT","受理");
        mark2Chinese.put("SUPPLEMENT","补正受理");
        mark2Chinese.put("SPECIAL","特别程序结果");
        mark2Chinese.put("APPROVE_CB","承办");
        mark2Chinese.put("APPROVE_SH","审核");
        mark2Chinese.put("APPROVE_PZ","批准");
        mark2Chinese.put("SETTLE","办结");
        mark2Chinese.put("LICENSE","领证");
        mark2Chinese.put("DEL_SETTLE","删除办结");
        return  mark2Chinese.get(nameformate);//环节状态
    }
}
