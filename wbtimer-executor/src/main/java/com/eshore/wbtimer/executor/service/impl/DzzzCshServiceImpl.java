package com.eshore.wbtimer.executor.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.utils.HttpCall;
import com.eshore.wbtimer.executor.common.utils.WSConfigUtil;
import com.eshore.wbtimer.executor.mapper.CommonMapper;
import com.eshore.wbtimer.executor.mapper.DZZZBASICDIRMapper;
import com.eshore.wbtimer.executor.mapper.DZZZITEMSMapper;
import com.eshore.wbtimer.executor.mapper.DzzzRServiceitemMapper;
import com.eshore.wbtimer.executor.mapper.bean.DzzzBasicDirBean;
import com.eshore.wbtimer.executor.mapper.bean.DzzzItemsBean;
import com.eshore.wbtimer.executor.mapper.bean.DzzzRServiceitemBean;
import com.eshore.wbtimer.executor.mapper.bean.ServiceItemBean;
import com.eshore.wbtimer.executor.service.DzzzCshService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyifan on 2018/4/8.
 */
@Service
public class DzzzCshServiceImpl implements DzzzCshService {

    @Autowired
    private DZZZBASICDIRMapper dZZZBASICDIRMapper;

    @Autowired
    private DZZZITEMSMapper dZZZITEMSMapper;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private DzzzRServiceitemMapper dzzzRServiceitemMapper;

    @Override
    public void startExecute() throws Exception {
        try {

            WbtimerJobLogger.log("电子证照目录初始化开始....");
            if(isNull()){
                int page_index=1;
                do {
                    try {
                        boolean re=init_Dzzz_dir("440400",page_index,1);
                        if(re){
                            break;
                        }
                        page_index++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //保存数据
                } while (true);
            }else{
                WbtimerJobLogger.log("重新初始化,要清空DZZZ_BASIC_DIR,DZZZ_ITEMS表数据！清空前先备份数据");
            }
            WbtimerJobLogger.log("电子证照目录初始化结束....");
            WbtimerJobLogger.log("初始化事项和证照的关系初始化开始....");
            init_service_license();
            WbtimerJobLogger.log("初始化事项和证照的关系初始化结束....");



        }catch (Exception e) {
            WbtimerJobLogger.log(e);
        }
    }

    public boolean init_Dzzz_dir(String divsionCode,int page_index,int page_size) {
        //保存数据
        return saveDzzzDir(dzzzlist4Divsion(divsionCode,page_index+"",page_size+""));
    }

    /**
     * 获取每个市的事项目录
     * @param divsionCode 市代码，珠海的440400
     * @param page_index 默认值 返回第几页数据。默认值 1
     * @param page_size 默认值 返回数据的每页大小。默认值 10 ， 最大值 150
     * @return
     */
    //http://14.215.115.247:8099/license_item/440400?elName=TEST&
    //elKey=68577158464&page_index=1&page_size=150&keyword=&is_service=true
    public String dzzzlist4Divsion(String divsionCode,String page_index,String page_size) {
        String beseUrl= WSConfigUtil.getValue("beseUrl");
        String url=beseUrl+"/license_item/"+divsionCode+"?&elName="+ WSConfigUtil.getValue("elName")+"&elKey="+ WSConfigUtil.getValue("elKey")+"&page_index="+page_index+"&page_size="+page_size+"&is_service=true" ;
        String response=doService(url,"get","");
        return response;
    }

    public boolean isNull() {
        int bir=dZZZBASICDIRMapper.selectCount(new EntityWrapper<DzzzBasicDirBean>());//mp通用mapper切换
        int items=dZZZITEMSMapper.selectCount(new EntityWrapper<DzzzItemsBean>());//mp通用mapper切换
        if(bir>0||items>0){
            return false;
        }else{
            return true;
        }

    }


    /**
     * 调用接口 返回数据
     * @param url
     * @param POSTorGet
     * @param param
     * @return
     */

    public String doService(String url, String POSTorGet, String param){
        WbtimerJobLogger.log("url:"+url+" POSTorGet:"+POSTorGet+"--param:"+param);
        String response="";
        try {
            if (url.toUpperCase().indexOf("HTTPS://") != 0) {
                response = HttpCall.httpInvoke(url, POSTorGet, param);
            } else {
                response = HttpCall.httpsInvoke(url, POSTorGet, param);
            }
            WbtimerJobLogger.log(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }

    /**
     * 保存事项目录信息
     * @param response
     *
     */
    private boolean saveDzzzDir(String response) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        boolean re=false;//默认还有数据
        if(!"".equals(response)){
            JSONObject jsonObject =JSONObject.fromObject(response);
            String ack_code=jsonObject.getString("ack_code");
            if(!"".equals(ack_code)&&"SUCCESS".equals(ack_code)){
                String data=jsonObject.getString("data");
                if(!"".equals(data)&&!"[]".equals(data)){
                    //JSONObject jsonObj = JSONObject.fromObject(data);
                    JSONArray jsonArr = jsonObject.getJSONArray("data");
                    for (Object object:jsonArr){
                        try {

                            //基本信息
                            //"name": "关于进入林业系统国家级自然保护区从事科学研究、教学实习、参观考察、拍摄影片、登山、录制视频、科学保护、等活动行政审批决定书",
								     /*
						            "version": "V1",
						            "status": "PUBLISH",
						            "type": "CERTIFICATE",
						            "description": null,
						            "remark": null,
						            "division": "广东省",
						            "creator": "4f070706-c30c-481c-a837-9f39136c62de",
						            "license_item_code": "100257601",
						            "short_name": null,
						            "use_constraint_type": "",
						            "icon_image": null,
						            "issue_rank": "PROVINCE,CITY,COUNTRY",
						            "admin_org": "省民政厅",
						            "admin_org_code": "006940175",
						            "division_code": "440000",
						            "publish_date": "2018-01-24 15:46:43",
						            "data_items": "{'columns':'2','items':[{'item_id':'1','key':'ZZMC','label':'证照名称','type_code':'textbox','index':'ZZMC','colspan':'all','placeholder':'请输入...','data_type':'STRING','length':'100','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'选项值1|选项中文1,选项值2|选项中文2','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'2','key':'ZZHM','label':'证照号码','type_code':'textbox','index':'ZZHM','colspan':'all','placeholder':'请输入...','data_type':'STRING','length':'100','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'选项值1|选项中文1,选项值2|选项中文2','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'3','key':'CYRMC','label':'持有人名称','type_code':'textbox','index':'CYRMC','colspan':'all','placeholder':'请输入...','data_type':'STRING','length':'100','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'选项值1|选项中文1,选项值2|选项中文2','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'61','key':'CYRSFZJLX','label':'持有人身份证件类型','type_code':'checkbox','index':'CYRSFZZLX','colspan':'all','placeholder':'请输入...','data_type':'STRING','length':'200','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'50|组织机构代码证,51|营业执照,52|事业单位登记证书,53|社团登记证书,54|民办非企业单位登记证书,55|工会法人资格证书,60|税务登记证,70|统一社会信用代码,80|其他有效机构身份证件','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'611','key':'CYRSFZJHM','label':'持有人身份证件号码','type_code':'textbox','index':'CYRSFZJHM','colspan':'all','placeholder':'请输入...','data_type':'STRING','length':'100','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'选项值1|选项中文1,选项值2|选项中文2','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'4','key':'FZJGMC','label':'发证机构名称','type_code':'textbox','index':'FZJGMC','colspan':'all','placeholder':'请输入...','data_type':'STRING','length':'100','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'选项值1|选项中文1,选项值2|选项中文2','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'6111','key':'FZJGZZJGDM','label':'发证机构组织机构代码','type_code':'textbox','index':'FZJGZZJGDM','colspan':'all','placeholder':'请输入...','data_type':'STRING','length':'100','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'选项值1|选项中文1,选项值2|选项中文2','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'61111','key':'FZJGSSXZQHDM','label':'发证机构所属行政区划代码','type_code':'textbox','index':'FZJGXZQH','colspan':'all','placeholder':'请输入...','data_type':'STRING','length':'100','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'选项值1|选项中文1,选项值2|选项中文2','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'5','key':'FZRQ','label':'发证日期','type_code':'date_picker','index':'FZRQ','colspan':'all','placeholder':'请输入...','data_type':'DATETIME','length':'14','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'选项值1|选项中文1,选项值2|选项中文2','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'6','key':'YXQJSRQ','label':'有效期结束日期','type_code':'date_picker','index':'YXQJSRQ','colspan':'all','placeholder':'请输入...','data_type':'DATETIME','length':'14','precision':'0','is_allow_null':'true','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'选项值1|选项中文1,选项值2|选项中文2','head':'列1,列2,列3','is_init_item':true,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'611111','key':'YXQ','label':'有效期','type_code':'textbox','index':'','colspan':'1','placeholder':'请输入...','data_type':'STRING','length':'100','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'','options':'','head':'','is_init_item':false,'cols':'','date_view_format':'','is_show':'true'},{'item_id':'6111111','key':'DTBGY','label':'动态表格1','type_code':'dynamic_table','index':'','colspan':'4','placeholder':'请输入...','data_type':'RECOMBINATION','length':'1000','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'','options':'','head':'列1,列2,列3,列4','is_init_item':false,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'61111111','key':'DTBGE','label':'动态表格2','type_code':'dynamic_table','index':'','colspan':'4','placeholder':'请输入...','data_type':'RECOMBINATION','length':'1000','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'','options':'','head':'列1,列2,列3,列4','is_init_item':false,'cols':'4','date_view_format':'','is_show':'true'},{'item_id':'611111111','key':'BG','label':'表格','type_code':'table','index':'','colspan':'all','placeholder':'请输入...','data_type':'RECOMBINATION','length':'0','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'','head':'列1,列2,列3','is_init_item':false,'cols':'','date_view_format':'','is_show':'true'},{'item_id':'6111111111','key':'TP','label':'图片','type_code':'image','index':'','colspan':'1','placeholder':'请输入...','data_type':'BINARY','length':'0','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'','options':'','head':'','is_init_item':false,'cols':'','date_view_format':'','is_show':'true'},{'item_id':'61111111111','key':'LL','label':'下拉','type_code':'checkbox','index':'','colspan':'1','placeholder':'请输入...','data_type':'STRING','length':'200','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'','options':'选项值1|选项中文1,选项值2|选项中文2','head':'','is_init_item':false,'cols':'','date_view_format':'','is_show':'true'},{'item_id':'611111111111','key':'FXK','label':'复选框','type_code':'checkbox','index':'','colspan':'1','placeholder':'请输入...','data_type':'STRING','length':'200','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'','options':'选项值1|是,选项值2|否','head':'','is_init_item':false,'cols':'','date_view_format':'','is_show':'true'},{'item_id':'6111111111111','key':'BGKJ','label':'表格控件','type_code':'table','index':'','colspan':'all','placeholder':'请输入...','data_type':'RECOMBINATION','length':'1000','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'4','options':'','head':'列1,列2,列3','is_init_item':false,'cols':'','date_view_format':'','is_show':'true'},{'item_id':'61111111111111','key':'QT','label':'其他','type_code':'textbox','index':'','colspan':'1','placeholder':'请输入...','data_type':'STRING','length':'100','precision':'0','is_allow_null':'false','example':'','file_suffix':'','file_data':'','addon':'','rows':'','options':'','head':'','is_init_item':false,'cols':'','date_view_format':'','is_show':'true'}],'form_prefix':''}",
						            "holder_type": "PERSON",
						            "resp_org": "民政部门",
						            "creation_time": "2018-01-24 15:44:13",
						            "last_modificator": "*SYSADM*",
						            "last_modification_time": "2018-03-15 17:02:17"
								    */
                            JSONObject json = JSONObject.fromObject(object);
                            String name=json.getString("name").trim();
                            String version=json.getString("version").trim();
                            String status=json.getString("status").trim();
                            String type=json.getString("type").trim();
                            String description=json.getString("description").trim();
                            String remark=json.getString("remark").trim();
                            String division=json.getString("division").trim();
                            String creator=json.getString("creator").trim();
                            String licenseItemCode=json.getString("license_item_code").trim();
                            String shortName=json.getString("short_name").trim();
                            String useConstraintType=json.getString("use_constraint_type").trim();
                            //太大先屏蔽
                            //String iconImage=json.getString("icon_image").trim();
                            String iconImage="";
                            String issueRank=json.getString("issue_rank").trim();
                            String adminOrg=json.getString("admin_org").trim();
                            String adminOrgCode=json.getString("admin_org_code").trim();
                            String divisionCode=json.getString("division_code").trim();
                            String publishDate=json.getString("publish_date")==null?"":json.getString("publish_date").trim();
                            String holderType=json.getString("holder_type").trim();
                            String respOrg=json.getString("resp_org").trim();
                            String creationTime=json.getString("creation_time")==null?"":json.getString("creation_time").trim();
                            String lastModificator=json.getString("last_modificator").trim();
                            String lastModificationTime=json.getString("last_modification_time")==null?"":json.getString("last_modification_time").trim();
                            //保存基本信息
                            DzzzBasicDirBean bir=new DzzzBasicDirBean();
                            bir.setName(name);
                            bir.setVersion(version);
                            bir.setStatus(status);
                            bir.setType(type);
                            bir.setDescription(description);
                            bir.setRemark(remark);
                            bir.setDivision(division);
                            bir.setCreator(creator);
                            bir.setLicenseItemCode(licenseItemCode);
                            bir.setShortName(shortName);
                            bir.setUseConstraintType(useConstraintType);
                            bir.setIconImage(iconImage);
                            bir.setIssueRank(issueRank);
                            bir.setAdminOrg(adminOrg);
                            bir.setAdminOrgCode(adminOrgCode);
                            bir.setDivisionCode(divisionCode);
                            bir.setHolderType(holderType);
                            bir.setRespOrg(respOrg);
                            bir.setLastModificator(lastModificator);
                            if(!"".equals(publishDate)){
                                bir.setPublishDate(simpleDateFormat.parse(publishDate));
                            }
                            if(!"".equals(lastModificationTime)){
                                bir.setLastModificationTime(simpleDateFormat.parse(lastModificationTime));
                            }
                            if(!"".equals(creationTime)){
                                bir.setCreationTime(simpleDateFormat.parse(creationTime));
                            }
                            bir.setLrTime(new Date());
                            bir.setId(commonMapper.selectSeqId("seq_dzzz_basic_dir"));
                            dZZZBASICDIRMapper.insert(bir);//mp通用mapper切换

                            String data_items=json.getString("data_items");
                            if("".equals(data_items)){
                                continue;
                            }

                            JSONObject data_items_json =JSONObject.fromObject(data_items);
                            //项目信息
                            JSONArray items = data_items_json.getJSONArray("items");
                            for(Object item:items){
/*
											'item_id': '3',
											'key': 'CYRMC',
											'label': '持有人名称',
											'type_code': 'textbox',
											'index': 'CYRMC',
											'colspan': '1',
											'placeholder': '请输入...',
											'data_type': 'STRING',
											'length': '100',
											'precision': '0',
											'description': '',
											'is_allow_null': 'false',
											'example': '',
											'file_suffix': '',
											'file_data': '',
											'addon': '',
											'rows': '',
											'options': '',
											'head': '',
											'is_init_item': true,
											'cols': ''*/
                                JSONObject itemJson = JSONObject.fromObject(item);
                                String itemId=itemJson.getString("item_id").trim();
                                String key=itemJson.getString("key").trim();
                                String label=itemJson.getString("label").trim();
                                String typeCode=itemJson.getString("type_code").trim();
                                String itemIndex=itemJson.getString("index").trim();
                                String colspan=itemJson.getString("colspan").trim();
                                String placeholder=itemJson.getString("placeholder").trim();
                                String dataType=itemJson.getString("data_type").trim();
                                String length=itemJson.getString("length").trim();
                                String precision=itemJson.getString("precision").trim();
                                //String description2=itemJson.getString("description");
                                String isAllowNull=itemJson.getString("is_allow_null").trim();
                                String example=itemJson.getString("example").trim();
                                String fileSuffix=itemJson.getString("file_suffix").trim();
                                String fileData=itemJson.getString("file_data").trim();
                                String addon=itemJson.getString("addon").trim();
                                // String rows=itemJson.getString("rows");
                                String options=itemJson.getString("options").trim();
                                String head=itemJson.getString("head").trim();
                                String isInitItem=itemJson.getString("is_init_item").trim();
                                String itemCols=itemJson.getString("cols").trim();
                                //保存项目信息
                                DzzzItemsBean bean =new DzzzItemsBean();
                                bean.setLabel(label);
                                bean.setItemCols(itemCols);
                                bean.setKey(key);
                                bean.setTypeCode(typeCode);
                                bean.setItemIndex(itemIndex);
                                bean.setColspan(colspan);
                                bean.setPlaceholder(placeholder);
                                bean.setDataType(dataType);
                                bean.setLength(length);
                                bean.setPrecision(precision);
                                bean.setIsAllowNull(isAllowNull);
                                bean.setExample(example);
                                bean.setFileSuffix(fileSuffix);
                                bean.setFileData(fileData);
                                bean.setAddon(addon);
                                bean.setOptions(options);
                                bean.setHead(head);
                                bean.setIsInitItem(isInitItem);
                                bean.setIsShow("1");
                                bean.setDzzzCode(licenseItemCode);
                                bean.setItemId(commonMapper.selectSeqId("seq_dzzz_items"));
                                dZZZITEMSMapper.insert(bean);//mp通用mapper切换
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    WbtimerJobLogger.log("数据data为空！");
                    re=true;
                }

            }else{
                WbtimerJobLogger.log("查询数据错误："+response);
                re=true;
            }


        }else{

            WbtimerJobLogger.log("接口返回空！");
            re=true;
        }
        return re;


    }

    /**
     * 初始化事项和证照的关系
     */
    public void init_service_license(){

        //已经发布的事项，不在DZZZ_R_SERVICEITEM上的。。
        ServiceItemBean p = new ServiceItemBean();
        p.setStatus("PUBLISHED");
        List<Map<String,String>> lists= getServiceCode(p);
        if(lists!=null&&lists.size()>0){
            for(Map<String,String> m:lists){
                String serviceCode=m.get("SERVICECODE");
                if("".equals(serviceCode)){
                    WbtimerJobLogger.log("serviceCode is null ");
                    continue;
                }
                String type="0";
                String response=list_service_license(serviceCode,type);
                if(!"".equals(response)){
                    JSONObject jsonObject =JSONObject.fromObject(response);
                    String ack_code=jsonObject.getString("ack_code");
                    if(!"".equals(ack_code)&&"SUCCESS".equals(ack_code)){
                        String data=jsonObject.getString("data");
                        if(!"".equals(data)&& !"[]".equals(data)){
                            // JSONObject datajson =JSONObject.fromObject(data);
                            JSONArray jsonArr = jsonObject.getJSONArray("data");
                            for(Object obj:jsonArr){
                                JSONObject json = JSONObject.fromObject(obj);
                                String dzzzCode=json.getString("license_item_code");
                                String dzzzName=json.getString("license_item_name");
                                DzzzRServiceitemBean bean=new DzzzRServiceitemBean();
                                //SEQ_DZZZ_R_SERVICEITEM
                                bean.setId(commonMapper.selectSeqId("SEQ_DZZZ_R_SERVICEITEM"));
                                bean.setServiceCode(serviceCode);
                                bean.setDzzzCode(dzzzCode.trim());
                                bean.setDzzzName(dzzzName.trim());
                                bean.setCreateDate(new Date());
                                bean.setStatus(0L);
//                                this.publicDAO.insertBySqlMapId("DZZZ_R_SERVICEITEM_insert", bean);
                                dzzzRServiceitemMapper.insert(bean);//mp通用mapper切换
                            }
                        }else{
                        	WbtimerJobLogger.log("查询数据data 为空");
                        }
                    }

                }else{
                	WbtimerJobLogger.log("接口查询返回空！");
                }
            }


        }

    }


    private List<Map<String, String>> getServiceCode(ServiceItemBean p) {
        Map<String, Object> parammap = new HashMap<>();
        parammap.put("status", p.getStatus());
//        StringBuilder sb = new StringBuilder();
//        sb.append("select service_code as ServiceCode from service_item t " +
//                " where t.status = '"+p.getStatus()+"'" +
//                " and not exists (select 1 from DZZZ_R_SERVICEITEM m where m.service_code=t.service_code)");
        return dzzzRServiceitemMapper.selectForServiceItem(parammap);
    }

    /**
     * 获取事项和证照的关系
     * @param serviceCode
     * @param type 关联类型（所签 关联类型（所签 0；所需 ；所需 1）
     * @return
     */
    public String list_service_license(String serviceCode,String type){

        String beseUrl= WSConfigUtil.getValue("beseUrl");
        //http://14.215.115.247:8099/service_item/list_service_license?elName=TEST&elKey=68577158464&service_item_code=20039700200698845113440400&type=0
        String url=beseUrl+"/service_item/list_service_license?elName="+ WSConfigUtil.getValue("elName")+"&elKey="+ WSConfigUtil.getValue("elKey")+"&service_item_code="+serviceCode+"&type="+type;
        String response=doService(url,"GET","");
        return response;

    }
}
