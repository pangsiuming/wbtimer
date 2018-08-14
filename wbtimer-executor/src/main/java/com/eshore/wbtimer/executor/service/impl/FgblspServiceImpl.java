package com.eshore.wbtimer.executor.service.impl;

import com.eshore.wbtimer.common.net.HttpCall;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.core.utils.PropertiesUtil;
import com.eshore.wbtimer.executor.common.utils.DateUtils;
import com.eshore.wbtimer.executor.mapper.CommonMapper;
import com.eshore.wbtimer.executor.mapper.FgblServiceMapper;
import com.eshore.wbtimer.executor.service.FgblspService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/31 9:39
 */
@Service
public class FgblspServiceImpl implements FgblspService {
    private static Logger logger = LoggerFactory.getLogger(FgblspServiceImpl.class);
    @Autowired
    private FgblServiceMapper fgblServiceMapper;
    @Autowired
    private CommonMapper commonMapper;
    /**
     * 申请单查询接口
     * 调用次数	每天最多调用200次
     * {startTime:,endTime:,pageSize:,pageNum:}
     * startTime	是	查询的申请单起始时间，长整型
     * endTime	是	查询的申请单结束时间，长整型
     * pageSize	否	返回的记录数，整型，取值范围：1-10
     * pageNum	否	页码，取第几页，整型，取值范围：1至总页数
     *
     * 成功返回{
     "page": {
     "currPageNum": 0,
     "pageSize": 0,
     "rowCount": 0,
     "pageCount": 0
     },
     "resultCode": "",
     "errmsg": "",
     "applyFormInfos": [{
     "baseInfo": {

     },
     "itemFormInfo": [{
     "name": "属性名",
     "value": "属性值"
     }],
     "subForms": [{
     "fields": [{
     "name": "子表单字段名",
     "values": ["子表单字段1",
     "子表单字段2"]
     }]
     }],
     "attas": [{
     "id": 1,
     "name": "材料1",
     "ftpUrl": "FTP材料存放相对地址",
     "meterialCode": "两库上的材料编号",
     "newAdd": false,
     "suffixName": "后缀名（文件拓展名）"
     }]
     }]
     }中的applyFormInfos
     失败 返回 1
     */
    @Override
    public String queryItemApply(String startTime, String endTime, String pageSize, String pageNum){
        //String url = http://host/projMg/itf/itemApply/query.do?signature=&timestamp=&nonce=&clientSystemId=；
        try {
            String baseUrl = PropertiesUtil.getString("wsconfig.properties","fgblAddress");
            String method = PropertiesUtil.getString("wsconfig.properties","itemApplyUrl");
            String ComUrl = getComUrl();
            if(ComUrl.equals("flase")){
                logger.debug("ComUrl===" + ComUrl);
                return "1";
            }
            String url = baseUrl + method+ComUrl;
            JSONObject json = new JSONObject();
            json.put("startTime", startTime);
            json.put("endTime", endTime);
            if(StringUtils.isNotEmpty(pageSize)){
                json.put("pageSize", pageSize);
            }
            if(StringUtils.isNotEmpty(pageNum)){
                json.put("pageNum", pageNum);
            }
            String param = json.toString();

            logger.debug("param===" + param);
            String response = "";
            if (url.toUpperCase().indexOf("HTTPS://") != 0) {
                response = HttpCall.httpInvoke(url, "POST", param);
            } else {
                response = HttpCall.httpsInvoke(url, "POST", param);
            }
            //String jsonr = getApplyid(response);
            //WbtimerJobLogger.log("xxxxxxxxx"+jsonr+"xxxxxxxxxxx");
            logger.debug("response：" + response);
            if("".equals(response)){
                fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "queryItemApply", "FGJK", "返回空字符串","1" ));
                return "1";
            }
            //记录日记
            fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "queryItemApply", "FGJK", response, "0"));
            return response;
        } catch (Exception e) {
            logger.debug("查询的申请单：" +"失败");
            WbtimerJobLogger.log("查询的申请单：" +"失败"+e.getMessage());
            fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "queryItemApply", "FGJK", e.getMessage().length()>1000?e.getMessage().substring(0, 1000):e.getMessage(), "1"));
            return "1";
        }


    }


    /**
     * 申办材料获取接口
     * attaId	是	项目管理平台附件ID
     *
     * PM0000	处理成功
     PM0001	签权失败，无权限
     PM0002	缺必填项
     PM0003	内部处理出错
     成功返回      response 失败返回null
     */
    @Override
    public String getAttas(String attaId){

        //String url =http://host/projMg/itf/itemApply/attas.do?signature=&timestamp=&nonce=&clientSystemId=&attaId=
        try {
            if (StringUtils.isEmpty(attaId) ) {
                logger.debug("attaId===" + attaId);
                return "1";
            }
            String baseUrl = PropertiesUtil.getString("wsconfig.properties","fgblAddress");
            String method = PropertiesUtil.getString("wsconfig.properties","getAttasUrl");
            String ComUrl = getComUrl();
            if(ComUrl.equals("flase")){
                logger.debug("ComUrl===" + ComUrl);
                return "1";
            }
            String url = baseUrl + method+ComUrl+"&attaId="+attaId;
            logger.debug("url===" + url);
            String response="";
            if (url.toUpperCase().indexOf("HTTPS://") != 0) {
                response = HttpCall.httpInvoke(url, "POST", null);
            } else {
                response = HttpCall.httpsInvoke(url, "POST", null);
            }
            String isSuccess ="";
            if("".equals(response)){
                fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "getAttas", "FGJK", "返回空字符串","1" ));
                return "1";
            }
            //记录日记
            fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "getAttas", "FGJK", response, isSuccess));
            return response;
        } catch (Exception e) {
           WbtimerJobLogger.log("申办材料获取：" + "失败"+e.getMessage());
            logger.debug("申办材料获取：" + "失败");
            fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "getAttas", "FGJK", e.getMessage().length()>1000?e.getMessage().substring(0, 1000):e.getMessage(), "1"));
            return "1";
        }


    }
    /**
     * 申请单流水号回报接口
     * {size:,backCodes:[{“applyId”:,”sblsh”:””}]}
     * size	是	回报的流水号个数
     * backCodes	是	回报的流水号列表
     * applyId	是	项目管理平台获取的申请单号
     * sblsh	是	业务系统获取申请单成功后回报给平台的申请流水号
     * return 0 表示成功，1表示失败
     */
    @Override
    public String backCode(String json){
        //String url = http://host/projMg/itf/itemApply/backCode.do?signature=&timestamp=&nonce=&clientSystemId=
        try {
            if (StringUtils.isEmpty(json) || "null".equals(json)) {
                logger.debug("json===" + json);
                return "1";
            }
            String baseUrl = PropertiesUtil.getString("wsconfig.properties","fgblAddress");
            String method = PropertiesUtil.getString("wsconfig.properties","backCodeUrl");
            String ComUrl = getComUrl();
            if(ComUrl.equals("flase")){
                logger.debug("ComUrl===" + ComUrl);
                return "1";
            }
            String url = baseUrl + method+ComUrl;
            String param = json;
            logger.debug("param===" + param);
            String response = "";
            if (url.toUpperCase().indexOf("HTTPS://") != 0) {
                response = HttpCall.httpInvoke(url, "POST", param);
            } else {
                response = HttpCall.httpsInvoke(url, "POST", param);
            }
            logger.debug("response===" + response);
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(response);
            logger.debug("response：" + response);
            String resultCode = jsonObject.getString("resultCode");
            String isSuccess ="";
            if ("PM0000".equals(resultCode)) {
                logger.debug("申请单流水号回报 SUCCESS：" + jsonObject.getString("errmsg"));
                resultCode = "0";
                isSuccess="0";
            } else {
                logger.debug("申请单流水号回报 失败：" + jsonObject.getString("errmsg"));
                resultCode = "1";
                isSuccess="1";
            }
            //记录日记
            fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "backCode", "FGJK", jsonObject.toString(), isSuccess));
            return resultCode;
        } catch (Exception e) {
            WbtimerJobLogger.log("申请单流水号回报：" + "失败 :"+e.getMessage());
            logger.debug("申请单流水号回报：" + "失败");
            fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "backCode", "FGJK", e.getMessage().length()>1000?e.getMessage().substring(0, 1000):e.getMessage(), "1"));
            return "1";
        }


    }

    /**
     * 申办单流水号与项目编号上报接口
     *{size:,codeRefes:[{“projCode”:,”sblsh”:””,”adminOrg”:””}]}
     * size	是	流水号关系个数
     * codeRefes	是	流水号关系列表
     * projCode	是	项目统一编号
     * sblsh	是	申办流水号
     * adminOrg	是	处理部门组织机构代码
     *
     * PM0000	处理成功
     PM0001	签权失败，无权限
     PM0002	缺必填项
     PM0003	内部处理出错
     返回参数      0表示成功，1失败
     */
    @Override
    public String saveItemAndProjCode(String json){
        http://132.122.235.227:8093/wb_interface_receive/
        //String url =http://host/projMg/itf/itemApply/saveItemAndProjCode.do?signature=&timestamp=&nonce=&clientSystemId=
        try {
            if (StringUtils.isEmpty(json) || "null".equals(json)||null == json) {
                logger.debug("json===" + json);
                return "1";
            }
            String baseUrl = PropertiesUtil.getString("wsconfig.properties","fgblAddress");
            String method = PropertiesUtil.getString("wsconfig.properties","saveItemAndProjCodeUrl");
            String ComUrl = getComUrl();
            if(ComUrl.equals("flase")){
                logger.debug("ComUrl===" + ComUrl);
                return "1";
            }
            String url = baseUrl + method+ComUrl;

            logger.debug("url===" + url);
            String response = "";
            String param = json;

            logger.debug("param===" + param);
            if (url.toUpperCase().indexOf("HTTPS://") != 0) {
                response = HttpCall.httpInvoke(url, "POST", param);
            } else {
                response = HttpCall.httpsInvoke(url, "POST", param);
            }
            logger.debug("response===" + response);

            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(response);

            logger.debug("response：" + response);
            String resultCode = jsonObject.getString("resultCode");
            if ("PM0000".equals(resultCode)) {
                logger.debug("申办单流水号与项目编号上报 SUCCESS：" + jsonObject.getString("errmsg"));
                resultCode = "0";
            } else {
                logger.debug("申办单流水号与项目编号上报失败:" + jsonObject.getString("errmsg"));
                resultCode = "1";
            }
            //记录日记
            fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "saveItemAndProjCode", "FGJK", jsonObject.toString(), resultCode));
            return resultCode;
        } catch (Exception e) {
            logger.debug("申办单流水号与项目编号上报：" + "失败");
            fgblServiceMapper.insertBLJKLog(getParam( "FgblspServiceImpl",  "saveItemAndProjCode", "FGJK", e.getMessage().length()>1000?e.getMessage().substring(0, 1000):e.getMessage(), "1"));
            return "1";
        }


    }
    /**
     * 获取公共url
     * @return
     */
    private String getComUrl(){
        try {
            String timestamp  = DateUtils.formatDate(new Date(),"yyyyMMdd");
            String nonce = UUID.randomUUID().toString();
            //String clientSystemId=new BaseUrl().getClientSystemId();
            String clientSystemId = PropertiesUtil.getString("wsconfig.properties","clientSystemId");

            String signature = HttpCall.getSignature(clientSystemId,timestamp,nonce);
            //编码
            timestamp = URLEncoder.encode(timestamp, "UTF-8");
            nonce = URLEncoder.encode(nonce, "UTF-8");
            clientSystemId = URLEncoder.encode(clientSystemId, "UTF-8");
            signature = URLEncoder.encode(signature, "UTF-8");
            String url = "signature="+signature+"&timestamp="+timestamp+"&nonce="+nonce+"&clientSystemId="+clientSystemId;
            return url;
        } catch (UnsupportedEncodingException e) {
            WbtimerJobLogger.log(e);
            throw new RuntimeException();

        }
    }
    private Map<String,Object> getParam(String jkClassName, String jkClassMethod, String source, String data, String isSuccess){
        Map<String,Object> params = new HashMap<>();
        params.put("bljkLogId",commonMapper.selectSeqId("SEQ_BLJK_LOG"));
        params.put("jkClassName",jkClassName);
        params.put("jkClassMethod",jkClassMethod);
        params.put("source",source);
        params.put("data",data.getBytes());
        params.put("isSuccess",isSuccess);
        params.put("createDate",new Date());
        return params;
    }
}