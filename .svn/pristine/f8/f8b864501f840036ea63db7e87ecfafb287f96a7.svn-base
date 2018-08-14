package com.eshore.wbtimer.executor.common.code.dataplatform;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eshore.emall.pub.util.DateUtil;
import com.eshore.emall.pub.util.StringUtil;
import com.eshore.wbtimer.common.utils.SpringContextUtil;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.code.dataplatform.bean.*;
import com.eshore.wbtimer.executor.common.net.FtpManager;
import com.eshore.wbtimer.executor.common.utils.CryptUtil;
import com.eshore.wbtimer.executor.common.utils.StringHelperUtil;
import com.eshore.wbtimer.executor.enums.ExTableNameEnum;
import com.eshore.wbtimer.executor.enums.XmlEleEnum;
import com.eshore.wbtimer.executor.mapper.DataPlatformXmlMapper;
import com.eshore.wbtimer.executor.mapper.bean.*;
import com.eshore.wbtimer.executor.service.CfgContentService;
import com.eshore.wbtimer.executor.service.bean.*;
import org.apache.commons.collections4.CollectionUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.*;

/**
 * 描述:该类改造于DataPlatformXmlHelper 处理半交换数据类型的ExInfo节点处理
 *
 * @author Yangjinming
 * @create 2018/2/1 9:11
 */
public class DataPlatformXmlHelperNew {
    private static Map<String, ExInfoBean> exTempFileMap = new HashMap<>();
    private DataPlatformXmlMapper dataPlatformXmlMapper;
    private CfgContentService cfgContentService;

    public DataPlatformXmlHelperNew() {
        init();
    }

    private void init() {
        this.cfgContentService = (CfgContentService) SpringContextUtil.getBean("cfgContentServiceImpl");
        this.dataPlatformXmlMapper = (DataPlatformXmlMapper) SpringContextUtil.getBean("dataPlatformXmlMapper");
    }

    public ExInfoBean getExBean(String tableName, boolean isHalfExchange, String serviceCode) {
        if (exTempFileMap.size() == 0) {
            ExTableNameEnum[] exTables = ExTableNameEnum.values();
            for (ExTableNameEnum exTableName : exTables) {
                try {
                    ExInfoBean exInfoBean = parseXml(exTableName.getValue().toLowerCase(), isHalfExchange, serviceCode);
                    System.out.println(exInfoBean);
                    exTempFileMap.put(exTableName.getValue(), exInfoBean);
                } catch (Exception e) {
                    WbtimerJobLogger.log(e);
                }
            }
        }
        ExInfoBean exBean=exTempFileMap.get(tableName);
        exBean.setItemInfoBean(null);
        exBean.setSbInfoBean(null);
        exBean.setExFileInfo(null);
        return exBean;
    }
    /**
     * 组装半交换所需的ItemInfo节点
     *
     * @param exInfoBean
     * @param rootElement
     */
    public void setItemInfoBeanEle(ExInfoBean exInfoBean, Element rootElement, String orgCode, String sblsh, String sxbm) {
        ItemInfoBean itemInfoBean = new ItemInfoBean();
        itemInfoBean.setDeptCode(orgCode); // 部门编码
        itemInfoBean.setWinCode(sblsh); // 申办流水号
        itemInfoBean.setItemCode(sxbm);
        itemInfoBean.setAction("1");
        try {
            //EX_HALF_COLS里的配置数据
            ExHalfColsParam exHalfColsParam = new ExHalfColsParam();
            exHalfColsParam.setExtraOrderColumns("resourcetype");
            exHalfColsParam.setServiceCode(sxbm);
            //获取数据库表单字段映射关系表  ex_half_cols
            List<ExHalfColsBean> exHalfCols = dataPlatformXmlMapper.getExHalfCols(exHalfColsParam);


            ExItemHalfParam exItemHalfParam = new ExItemHalfParam();
            exItemHalfParam.setServiceCode(sxbm);
            ExItemHalfBean eh = dataPlatformXmlMapper.getExItemHalf(exItemHalfParam);
            if ("YUNZHENG".equals(eh.getBusinessSystemCode())) {
                // 对于交通局（运政系统）的事项，xml格式要单独组装

                //对交通局混合表单单独处理
                List<ExHalfColsBean> exHalfColsHandled = preHandleExHalfCols(exHalfCols,sblsh,sxbm);

                DocBean docBean = buildDocData(exHalfColsHandled,sblsh);
                itemInfoBean.setDocBean(docBean);
                exInfoBean.setItemInfoBean(itemInfoBean);
            } else {
                // @2 处理已确认好的itemInfo下一级节点BaseInfo节点信息,通过DynamicObject读取ex_half_cols
                // 设置ItemInfo子元素
                List<ItemSonBean> itemSonBeans = new ArrayList<>();
                itemSonBeans = buildBaseInfoData(exHalfCols, sblsh);
                itemInfoBean.setItemSonBeans(itemSonBeans);
                exInfoBean.setItemInfoBean(itemInfoBean);
            }
        } catch (Exception e) {
            WbtimerJobLogger.log(e);
        }

    }
    /**
     * 组装附件信息
     */
     public void setExFileEle(ExInfoBean exInfoBean, Element rootElement, String orgCode, String sblsh, String sxbm, Long hjslbs) {
        ExFileInfo exFileInfo = new ExFileInfo();
        List<Files> filesList = new ArrayList<>();
        WsbsSbFilesBean param = new WsbsSbFilesBean();
        param.setSblsh(sblsh);
        param.setDataSouce("1");
        List<WsbsSbFilesBean> list = dataPlatformXmlMapper.getWsbsSbFiles(param);
        if (list != null && list.size() > 0) {
            for (WsbsSbFilesBean file : list) {
                Files files = new Files();
                files.setFileId(StringUtil.handleNULL(file.getWsbsSbFilesCode()));
                files.setFileName(StringUtil.handleNULL(file.getFileName())+"."+StringUtil.handleNULL(file.getFileType()));
                files.setCertNo("");
                files.setCertPeriod("");
                files.setCertType("");
                files.setGiveDate("");
                files.setCheckFlag("");
                filesList.add(files);
            }
        }
        exFileInfo.setFiles(filesList);
        exInfoBean.setExFileInfo(exFileInfo);
    }
    private ExInfoBean parseXml(String fileName, boolean isHalfExchange, String serviceCode) throws Exception {
        ExInfoBean exInfoBean = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/conf/intf/" + fileName + ".xml");
            // 创建SAXReader读取器，专门用于读取xml
            SAXReader saxReader = new SAXReader();
            // 根据saxReader的read重写方法可知，既可以通过inputStream输入流来读取，也可以通过file对象来读取
            Document document = saxReader.read(inputStream);
            exInfoBean = new ExInfoBean();
            Element rootElement = document.getRootElement();
            setStandardInfoEle(exInfoBean, rootElement);
        } catch (DocumentException e) {
            throw new Exception("xml文件格式有误：" + e.getMessage());
        }
        return exInfoBean;
    }
    /**
     * 设置元素：standardInfo 全/半交换都需要发送StandardInfo数据
     *
     * @param exInfoBean
     * @param rootElement
     */
    private void setStandardInfoEle(ExInfoBean exInfoBean, Element rootElement) {
        StandardInfoBean standardInfoBean = new StandardInfoBean();
        Element _element = rootElement.element(XmlEleEnum.STANDARDINFO.getValue());
        if (null == _element) {
            return;
        }
        standardInfoBean.setProcess(StringHelperUtil.handleNull(_element.attributeValue(XmlEleEnum.STANDARDINFO_PROCESS.getValue())));
        /*
         * // 字段初始化设置为空(_ele_Field.getText()) 赋值在ReflectUtil.setBeanFields中处理 fieldBean.setFieldValue("");
         */
        standardInfoBean.setFields(getFieldsList(_element));

        exInfoBean.setStandardInfoBean(standardInfoBean);
    }

    /**
     * 拿出ex_gdbs_***配置文件中相应的itemInfo节点集合 value默认空
     *
     * @param _element
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<FieldBean> getFieldsList(Element _element) {
        List<FieldBean> fields = new ArrayList<FieldBean>();
        if (null != _element) {
            Iterator<Element> _itr_Field = _element.elementIterator(XmlEleEnum.FIELD.getValue());
            Element _ele_Field;
            FieldBean fieldBean;
            while (_itr_Field.hasNext()) {
                _ele_Field = _itr_Field.next();
                fieldBean = new FieldBean();
                fieldBean.setFieldName(_ele_Field.attributeValue(XmlEleEnum.FIELD_FIELDNAME.getValue()));
                fieldBean.setTargetName(_ele_Field.attributeValue(XmlEleEnum.TARGET_NAME.getValue()));
                // 字段初始化设置为空(_ele_Field.getText())
                fieldBean.setFieldValue("");
                fields.add(fieldBean);
            }
        }
        return fields;
    }
    /** 组装BaseInfo，非运政系统半交换事项用，组装的映射关系在EX_HALF_COLS表配置 **/
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
    private List<ItemSonBean> buildBaseInfoData(List<ExHalfColsBean> exHalfCols, String sblsh) {
        List<ItemSonBean> itemSonBeans = new ArrayList<>();

        if (exHalfCols != null && exHalfCols.size() > 0) {
            Map<String, ArrayList> exHalfColsSort = sort(exHalfCols);
            Iterator it = exHalfColsSort.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                System.out.print("\n" + key + ":");
                ArrayList list1 = exHalfColsSort.get(key);
                List<FieldBean> result = new ArrayList<FieldBean>();
                ItemSonBean itemSonBean = new ItemSonBean();
                for (int i = 0; i < list1.size(); i++) {
                    // baseInfoBean.setFields(fields);
                    ExHalfColsBean colsBean = (ExHalfColsBean) list1.get(i);
                    itemSonBean.setNodeName(colsBean.getNodecode());
                    itemSonBean.setName(colsBean.getNodecode());
                    String rTarget = colsBean.getRtarget(); // 要取值的字段名
                    String llTarget = colsBean.getLtarget(); // 要取值的字段名
                    FieldBean field = new FieldBean();
                    field.setFieldName(rTarget);
                    WsbsSbBean param = new WsbsSbBean();
                    param.setSxbm(colsBean.getServiceCode());
                    param.setSblsh(sblsh);
                    List<WsbsSbBean> list = dataPlatformXmlMapper.getWsbsSbInfo(param);
                    WsbsSbBean data = list.get(0);

                    WsbsSbExtendBean extendParam = new WsbsSbExtendBean();
                    extendParam.setHjslbs(data.getHjslbs());
                    List<WsbsSbExtendBean> extend =  dataPlatformXmlMapper.getWsbsSbExtEndInfo(extendParam);
                    if("0".equals(colsBean.getResourcetype())){
                        //0设置默认值,取ltarget
                        field.setFieldValue(llTarget);
                        result.add(field);
                    }else if (colsBean.getResourcetype().equals("1")) { // 取主表数据value
                        if (colsBean.getLtarget().toLowerCase().toString().equals("sxmb")) {
                            field.setFieldValue(colsBean.getServiceCode());
                        } else {

                            String sourceValue = "";
                            if (data != null) {
                                // 根据serviceCode得到结果,依次通过右目标字段判断wsbs_sb_extend对应字段取出value
                                if (colsBean.getLtarget().toLowerCase().toString().equals("sbxmmc")) {
                                    sourceValue = data.getSbxmmc();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("sxmc")) {
                                    sourceValue = data.getSxmc();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("sbclqd")) {
                                    sourceValue = data.getSbclqd();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("sqrlx")) {
                                    sourceValue = data.getSqrlx();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("sqrmc")) {
                                    sourceValue = data.getSqrmc();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("sqrzjlx")) {
                                    sourceValue = data.getSqrzjlx();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("sqrzjhm")) {
                                    sourceValue = data.getSqrzjhm();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("lxrxm")) {
                                    sourceValue = data.getLxrxm();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("lxrzjlx")) {
                                    sourceValue = data.getLxrzjlx();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("lxrsfzjhm")) {
                                    sourceValue = data.getLxrsfzjhm();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("lxrsj")) {
                                    sourceValue = data.getLxrsj();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("lxryx")) {
                                    sourceValue = data.getLxryx();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("submit_status")) {
                                    sourceValue = data.getSubmitStatus();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("zzjgdm")) {
                                    sourceValue = data.getZzjgdm();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("tjfs")) {
                                    sourceValue = data.getTjfs();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("ysblsh")) {
                                    sourceValue = String.valueOf(data.getYsblsh());
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("sbjtwd")) {
                                    sourceValue = data.getSbjtwd();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("xzqhdm")) {
                                    sourceValue = data.getXzqhdm();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("loginname")) {
                                    sourceValue = data.getLoginname();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("last_modify_time")) {
                                    sourceValue = data.getLastModifyTime().toGMTString();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("alert_status")) {
                                    sourceValue = data.getAlertStatus();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("rest_day")) {
                                    sourceValue = data.getRestDay().toString();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("staff_id")) {
                                    sourceValue = data.getStaffId();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("bz")) {
                                    sourceValue = data.getBz();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("byzd")) {
                                    sourceValue = data.getByzd();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("sbsj")) {
                                    sourceValue = data.getSbsj().toGMTString();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("sblsh")) {
                                    sourceValue = data.getSblsh();
                                } else if (colsBean.getLtarget().toLowerCase().toString().equals("blbmcode")) {
                                    sourceValue = data.getBlbmCode();
                                }
                            }
                            field.setFieldValue(StringUtil.handleNULL(sourceValue));
                        }
                        result.add(field);
                    } else if (colsBean.getResourcetype().equals("2")) { // 取从表数据value
                        // 拿colsBean.getLtarget()读取wsbs_sb_extend.field_id得到field_value
                        field.setFieldValue("");
                        if (extend != null && extend.size() > 0) { // 如果扩展表有该属性配置则取出field_value
                            for (WsbsSbExtendBean e : extend) {
                                if (e.getFieldId().equals(colsBean.getLtarget())) {
                                    field.setFieldValue(StringUtil.handleNULL(e.getFieldValue()));
                                }
                            }
                        }
                        result.add(field);
                    } else if (colsBean.getResourcetype().equals("7")) { // 取从表数据value 拆分
                        String lTarget = colsBean.getLtarget();
                        field.setFieldValue("");
                        try {
                            if (lTarget.indexOf(".") > 0) {
                                String[] strSplit = lTarget.split("\\.");
                                String l = strSplit[0];
                                int index = Integer.valueOf(strSplit[1]);
                                // 拿colsBean.getLtarget()读取wsbs_sb_extend.field_id得到field_value
                                if (extend != null && extend.size() > 0) { // 如果扩展表有该属性配置则取出field_value
                                    for (WsbsSbExtendBean e : extend) {
                                        if (e.getFieldId().equals(l)) {
                                            String value = e.getFieldValue();
                                            String[] valueSplit = value.split(",");
                                            field.setFieldValue(StringUtil.handleNULL(valueSplit[index]));
                                        }
                                    }
                                }

                            } else {
                                // 如果没有.分隔符，取完整的值去除逗号
                                String l = lTarget;
                                // 拿colsBean.getLtarget()读取wsbs_sb_extend.field_id得到field_value
                                if (extend != null && extend.size() > 0) { // 如果扩展表有该属性配置则取出field_value
                                    for (WsbsSbExtendBean e : extend) {
                                        if (e.getFieldId().equals(l)) {
                                            String value = e.getFieldValue();
                                            value = value.replaceAll(",", "");
                                            field.setFieldValue(StringUtil.handleNULL(value));
                                        }
                                    }
                                }

                            }
                        } catch (Exception e) {
                            WbtimerJobLogger.log(e);
                        }
                        result.add(field);
                    } else if (colsBean.getResourcetype().equals("3")) {
                        // 根据NodeCode和工单申办环节实例标识查询表FORMFILEUPLOADDATA
                        // @1 根据sblsh得到申办表的环节实例标识 WSBS_SB.HJSLBS

//						String businessid = String.valueOf(data.getHjslbs()); // 申办表的环节实例标识 WSBS_SB.HJSLBS
                        String businessid =  data.getSblsh() ; // 申办表的环节实例标识 WSBS_SB.HJSLBS
                        String tablecode = colsBean.getLtarget(); // 对应ex_half_cols.getLtarget
                        String nodeName = colsBean.getRtarget(); // 对应ex_half_cols.rTarget
                        FormfileuploaddataBean paramF = new FormfileuploaddataBean();
                        paramF.setBusinessid(businessid);
                        paramF.setTablecode(tablecode);
                        List<FormfileuploaddataBean> trsequenceGroup = dataPlatformXmlMapper.getGroupFormFileUpLoadData(paramF);
                        if (trsequenceGroup != null && trsequenceGroup.size() > 0) {
                            for (Object object : trsequenceGroup) {
                                FormfileuploaddataBean formFileData = (FormfileuploaddataBean) object;
                                String trsequence = formFileData.getTrsequence();
                                 // @2
                                paramF.setBusinessid(businessid);
                                paramF.setTablecode(tablecode);
                                paramF.setTrsequence(trsequence);
                                List<FormfileuploaddataBean> listF = dataPlatformXmlMapper.selectList(new EntityWrapper<FormfileuploaddataBean>(paramF));//mp通用mapper


                                if (listF != null && listF.size() > 0) {
                                    ItemSonBean itemSon = new ItemSonBean();
                                    itemSon.setNodeName(nodeName);
                                    itemSon.setName(nodeName);
                                    List<FieldBean> result3 = new ArrayList<FieldBean>();
                                    for (Object formfiles : listF) {
                                        FormfileuploaddataBean source = (FormfileuploaddataBean) formfiles;
                                        FieldBean field3 = new FieldBean();
                                        field3.setFieldName(source.getElementid());
                                        String value=source.getElementvalue();
                                        //投资者信息的证件类型做特殊处理，替换A_,B_
                                        if((tablecode.equals("tzzxx")||tablecode.equals("gdfqr"))&&source.getElementid().equals("zjlx")){
                                            if(value.indexOf("A_")>=0){
                                                value=value.replace("A_", "");
                                            }
                                            if(value.indexOf("B_")>=0){
                                                value=value.replace("B_", "");
                                            }
                                        }

                                        field3.setFieldValue( value== null ? "" : value);

                                        result3.add(field3);
                                    }
                                    itemSon.setFields(result3);
                                    itemSonBeans.add(itemSon);
                                }
                            }

                        }

                    } // end of sourcetype=3
                }
                if(result!=null && result.size()>0){
                    itemSonBean.setFields(result);
                    itemSonBeans.add(itemSonBean);
                }
            }
        }
        return itemSonBeans;
    }
    /** 归类半交换字段映射关系列表 **/
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map<String, ArrayList> sort(List<ExHalfColsBean> exHalfCols) {
        TreeMap tm = new TreeMap();
        if(exHalfCols!=null&&exHalfCols.size()>0){
            for (int i = 0; i < exHalfCols.size(); i++) {
                ExHalfColsBean s = (ExHalfColsBean) exHalfCols.get(i);
                if (tm.containsKey(s.getNodecode())) {//如果tm已存储过此nodecode类型的节点，
                    ArrayList l11 = (ArrayList) tm.get(s.getNodecode()); //则获取此节点
                    l11.add(s);   //向此节点添加叶子
                } else {  //从未获取过此节点，则向节点向根节点添加二层节点
                    ArrayList tem = new ArrayList();
                    tem.add(s);
                    tm.put(s.getNodecode(), tem);
                }

            }
        }
        return tm;
    }

    private List<ExHalfColsBean> preHandleExHalfCols(List<ExHalfColsBean> exHalfCols,String sblsh,String sxbm) throws Exception{
        /** 此处 按原方案 针对市厅一个事项 对应自有系统多个表单/或多种流程的处理
         * 暂时 只对交通局七张混合表单对应的数据进行处理
         * 如果需要支持别的局事项，此处需要相应调整
         * 在这里处理exHalfCols使交通局的七个表单的样式符合普通表单的数据
         * 如果是交通局七张混合表单，则 映射表里必有一条记录的 resourcetype 列值为  8
         */
        int transDepartMark = 0;//0:不是交通局七张混合表单，1：是交通局七张混合表单 , >1 有错误
        String radioOnOffRtarget="";
        String radioOnOffLtarget="";
        for(int i=0;i<exHalfCols.size();i++){
            ExHalfColsBean exhalfexample = exHalfCols.get(i);
            String resourcetype = exhalfexample.getResourcetype();
            if("8".equals(resourcetype)){
                transDepartMark++;
                radioOnOffLtarget = exhalfexample.getLtarget();
                radioOnOffRtarget = exhalfexample.getRtarget();
            }
        }
        if(transDepartMark==0){ //普通表单，不处理

        }else if(transDepartMark == 1){//交通局七张混合表单
            List<ExHalfColsBean> exHalfCols_jt = new ArrayList<ExHalfColsBean>();
            String[] radios = radioOnOffRtarget.split(",");//获取radio数值组
            String   radioOnOffValue = "";
            int      radioIndex;  //表单中混合表单的radio值所对应子表单
            String   prefixStr="";  //子表标示 例如 ：0_,1_

            // 取扩展表数据
            WsbsSbExtendBean extendParam_jt = new WsbsSbExtendBean();
            extendParam_jt.setSblsh(sblsh);
            List<WsbsSbExtendBean> extend_jt = dataPlatformXmlMapper.getWsbsSbExtEndInfo(extendParam_jt);
            String tempRadioOnOffLtarget = radioOnOffLtarget.substring(0,radioOnOffLtarget.indexOf('_'));
            for (WsbsSbExtendBean wse : extend_jt) {
                if (wse.getFieldId().equals(tempRadioOnOffLtarget)) {
                    radioOnOffValue = wse.getFieldValue();    //获取radio字段的值
                    break;
                }
            }
            for(int radioi=0;radioi<radios.length;radioi++){
                if(radios[radioi].equals(radioOnOffValue)){
                    radioIndex = radioi;  //获取所对应的子表编号 0，1，2 ......
                    prefixStr = radioIndex+"_";
                    break;
                }
            }
            for(int i=0;i<exHalfCols.size();i++){
                ExHalfColsBean exhalfexample = exHalfCols.get(i);
                String ltarget = exhalfexample.getLtarget();
                if(ltarget.startsWith(prefixStr)||ltarget.startsWith("x_")){
                    String tempitarget = ltarget.substring(ltarget.indexOf("_")+1,ltarget.length());
                    exhalfexample.setLtarget(tempitarget);
                    exHalfCols_jt.add(exhalfexample);
                }
            }
            exHalfCols=exHalfCols_jt;
        }else{  //大于1的话，错误，暂不处理
            throw new Exception("交换事项"+sxbm+"的EX_HALF_COLS映射关系配置错误....");
        }
        return exHalfCols;
    }
    /**
     * 组装Doc节点，按省运政系统接口规范 运政系统半交换事项专用
     * **/
     private DocBean buildDocData(List<ExHalfColsBean> exHalfCols, String sblsh) {
        DocBean docBean = new DocBean();
        // 取申办主表数据
        WsbsSbBean param = new WsbsSbBean();
        param.setSblsh(sblsh);
        List<WsbsSbBean> list = dataPlatformXmlMapper.getWsbsSbInfo(param);
        WsbsSbBean data = list.get(0);

        // 取扩展表数据
        WsbsSbExtendBean extendParam = new WsbsSbExtendBean();
        extendParam.setHjslbs(data.getHjslbs());
        List<WsbsSbExtendBean> extend = dataPlatformXmlMapper.getWsbsSbExtEndInfo(extendParam);
        for (WsbsSbExtendBean wse : extend) {
            if (wse.getFieldId().indexOf("comboarea")>-1 && !StringUtil.isEmpty(wse.getFieldValue())) {
                String address = wse.getFieldValue(); //获取字段值
                String address1 = address.replaceAll(",", ""); //去除地址字段值中的“，”
                wse.setFieldValue(address1);
            }
        }
        // 取多行列表数据
        FormfileuploaddataBean paramF = new FormfileuploaddataBean();
        paramF.setBusinessid(sblsh);
        // 取出所有
        List<FormfileuploaddataBean> listF = dataPlatformXmlMapper.selectList(new EntityWrapper<FormfileuploaddataBean>(paramF));//mp通用mapper切换

        WsbsSbFilesBean wsbsSbFilesParam = new WsbsSbFilesBean();
        // 先以tablecode进行分类
        Map<String, ArrayList> ffuMap = sortMutiCode(listF);

        List<MutiRow> mutiRows = new ArrayList<>();
        List<SingerField> fieldBeans = new ArrayList<>();

        if (exHalfCols != null && exHalfCols.size() > 0) {
            // 按nodecode分组 key为：nodecode
            Map<String, ArrayList> exHalfColsSort = sort(exHalfCols);
            Iterator it = exHalfColsSort.keySet().iterator();
            while (it.hasNext()) { //基本为 BaseInfo ,子表名称 等
                String key = (String) it.next();
                ArrayList list1 = exHalfColsSort.get(key);
                List<FieldBean> result = new ArrayList<FieldBean>();
                for (int i = 0; i < list1.size(); i++) {
                    ExHalfColsBean colsBean = (ExHalfColsBean) list1.get(i);
                    String nodecode = colsBean.getNodecode(); // 节点名称 如 BaseInfo 或者部门事项所需要的额外节点
                    String ltarget = colsBean.getLtarget(); // 左目标表字段，来源表字段标识
                    String rtarget = colsBean.getRtarget(); // 右目标表字段（目标FieldName，resource=3时为部门事项所需要的额外节点的名称）
                    String resourcetype = colsBean.getResourcetype(); // 取值来源：

                    if("0".equals(colsBean.getResourcetype())){
                        //0设置默认值,取ltarget
                        SingerField field = new SingerField();
                        field.setFieldName(rtarget);
                        field.setFieldValue(ltarget);
                        fieldBeans.add(field);
                    }else if ("1".equals(colsBean.getResourcetype())) {
                        SingerField field = new SingerField();
                        field.setFieldName(rtarget);
                        // 1从WSBS_SB取
                        if ("sblsh".equals(ltarget)) {
                            field.setFieldValue(data.getSblsh());
                        } else if ("sxbm".equals(ltarget)) {
                            field.setFieldValue(data.getSxbm());
                        } else if ("sxmc".equals(ltarget)) {
                            field.setFieldValue(data.getSxmc());
                        } else if ("sqrmc".equals(ltarget)) {
                            field.setFieldValue(data.getSqrmc());
                        } else if ("sbsj".equals(ltarget)) {
                            field.setFieldValue(DateUtil.convertDateToString(data.getSbsj()));
                        }

                        if("网办ID".equals(rtarget)){
                            field.setFieldValue("ZHWBEXT" + sblsh);
                        }
                        fieldBeans.add(field);
                    } else if ("2".equals(colsBean.getResourcetype())) {
                        // 2从扩展表WSBS_SB_EXTEND取,根据fieldName字段和ltarget匹配
                        // 1，取扩展表数据组装成单行列表
                        SingerField field = new SingerField();
                        field.setFieldName(rtarget);
                        field.setFieldValue("");
                        for (WsbsSbExtendBean wse : extend) {
                            if (wse.getFieldName().equals(ltarget)) {
                                if (wse.getFieldName().indexOf("日期") >= 0 && !StringUtil.isEmpty(wse.getFieldValue())) {
                                    field.setFieldValue(wse.getFieldValue().substring(0, 10));
                                }else if(wse.getFieldName().equals("拟投入运营时间") && !StringUtil.isEmpty(wse.getFieldValue())){
                                    //特殊处理
                                    //拟投入运营时间
                                    field.setFieldValue(wse.getFieldValue().substring(0, 10));
                                } else {
                                    field.setFieldValue(wse.getFieldValue());
                                }
                            }
                        }
                        fieldBeans.add(field);
                    } else if ("4".equals(colsBean.getResourcetype())) {
                        // 4从多行列表取单个附件
                        ArrayList<FormfileuploaddataBean> listFC = ffuMap.get(nodecode);
                        // 按序号分组
                        Map<String, ArrayList> ffuMap2 = sortMutiSq(listFC);
                        SingerField field = new SingerField();
                        field.setFieldValue("");
                        field.setFieldName(rtarget);

                        // <保证使用低硫清洁柴油或汽油等清洁能源的承诺书/>
                        Iterator it2 = ffuMap2.keySet().iterator();
                        while (it2.hasNext()) {
                            // 按顺序组装
                            String key2 = (String) it2.next();
                            ArrayList<FormfileuploaddataBean> list2 = ffuMap2.get(key2);
                            String name="";
                            String fileId="";
                            for (FormfileuploaddataBean f : list2) {
                                if ("fileName".equals(f.getElementid())) {
                                    name = f.getElementvalue();
                                }else if ("fileId".equals(f.getElementid())) {
                                    // 附件表读取内容Crypt
                                    fileId = f.getElementvalue();
                                }
                            }
                            if (ltarget.equals(name)) {
                                if (!StringUtil.isEmpty(fileId)) {
                                    wsbsSbFilesParam.setWsbsSbFilesId(Long.valueOf(fileId));
                                    List<WsbsSbFilesBean> wsbsSbFilesBeanList= dataPlatformXmlMapper.getWsbsSbFiles(wsbsSbFilesParam);
                                    if(CollectionUtils.isNotEmpty(wsbsSbFilesBeanList)){
                                    WsbsSbFilesBean wsbsSbFilesBean =  wsbsSbFilesBeanList.get(0);
                                    try {
										wsbsSbFilesBean.setFileData(FtpManager.getFileFromFTP(cfgContentService,wsbsSbFilesBean.getSaveRoute()));
									} catch (Exception e) {
										WbtimerJobLogger.log(e);
										continue;
									}
                                     byte[] file = wsbsSbFilesBean.getFileData();
                                    String fileContent = CryptUtil.base64Encode(file);
                                    field.setFieldValue(fileContent);
                                    }
                                }
                            }

                        }
                        fieldBeans.add(field);
                    } else if ("6".equals(colsBean.getResourcetype())) {
                        // 6多行动态上传列表(含附件)

                        // <附件信息>
                        // <记录>
                        // <附件名称>身份证复印件</附件名称>
                        // <附件类型>JPG</附件类型>
                        // <附件内容></附件内容>
                        // </记录>
                        // </附件信息>

                        MutiRow mutiRowAtt = new MutiRow();
                        mutiRowAtt.setName(rtarget);
                        ArrayList<FormfileuploaddataBean> listFC = ffuMap.get(nodecode);
                        // 按序号分组
                        Map<String, ArrayList> ffuMap2 = sortMutiSq(listFC);
                        List<Row> rows = new ArrayList<Row>();
                        Iterator it2 = ffuMap2.keySet().iterator();
                        while (it2.hasNext()) {
                            // 按顺序组装
                            String key2 = (String) it2.next();
                            ArrayList<FormfileuploaddataBean> list2 = ffuMap2.get(key2);

                            Row row = new Row();
                            row.setNodeName("记录");
                            List<SingerField> fields = new ArrayList<>();
                            for (FormfileuploaddataBean f : list2) {

                                if ("fileName".equals(f.getElementid())) {
                                    String name = f.getElementname();
                                    String value = f.getElementvalue();
                                    // 将括号转为
                                    name = replaceStr(name);
                                    SingerField fieldBean = new SingerField();
                                    fieldBean.setFieldName(name);
                                    fieldBean.setFieldValue(value);
                                    fields.add(fieldBean);
                                } else if ("fileType".equals(f.getElementid())) {
                                    String value = f.getElementvalue();
                                    SingerField fieldBean = new SingerField();
                                    fieldBean.setFieldName("附件类型");
                                    fieldBean.setFieldValue(value);
                                    fields.add(fieldBean);
                                } else if ("fileId".equals(f.getElementid())) {
                                    // 附件表读取内容Crypt
                                    String fileId = f.getElementvalue();
                                    if (!StringUtil.isEmpty(fileId)) {
                                        wsbsSbFilesParam.setWsbsSbFilesId(Long.valueOf(fileId));
                                        List<WsbsSbFilesBean> wsbsSbFilesBeanList= dataPlatformXmlMapper.getWsbsSbFiles(wsbsSbFilesParam);
                                        if(CollectionUtils.isNotEmpty(wsbsSbFilesBeanList)){
                                            WsbsSbFilesBean wsbsSbFilesBean =  wsbsSbFilesBeanList.get(0);
                                            try {
												wsbsSbFilesBean.setFileData(FtpManager.getFileFromFTP(cfgContentService,wsbsSbFilesBean.getSaveRoute()));
											} catch (Exception e) {
												WbtimerJobLogger.log(e);
												continue;
											}
                                            byte[] file = wsbsSbFilesBean.getFileData();
                                            String fileContent = CryptUtil.base64Encode(file);
                                            SingerField fieldBean = new SingerField();
                                            fieldBean.setFieldName("附件内容");
                                            fieldBean.setFieldValue(fileContent);
                                            fields.add(fieldBean);
                                        }
                                    }
                                }

                            }
                            row.setFields(fields);
                            rows.add(row);
                        }
                        mutiRowAtt.setRows(rows);
                        mutiRows.add(mutiRowAtt);
                    } else if ("5".equals(colsBean.getResourcetype())) {
                        // 5多行子表(不含附件)
                        // <出资列表>
                        // <记录>
                        // <股东机构代码>0101010</股东机构代码>
                        // <股东名称>JPG</股东名称>
                        // <出资额>1000</出资额>
                        // </记录>
                        // </出资列表>
                        ArrayList<FormfileuploaddataBean> listFC = ffuMap.get(nodecode);
                        // 按序号分组
                        Map<String, ArrayList> ffuMap2 = sortMutiSq(listFC);
                        MutiRow mutiRow = new MutiRow();
                        mutiRow.setName(rtarget);
                        List<Row> rows = new ArrayList<Row>();
                        Iterator it2 = ffuMap2.keySet().iterator();
                        while (it2.hasNext()) {
                            // 按顺序组装
                            String key2 = (String) it2.next();
                            ArrayList<FormfileuploaddataBean> list2 = ffuMap2.get(key2);

                            Row row = new Row();
                            List<SingerField> fields = new ArrayList<SingerField>();
                            for (FormfileuploaddataBean f : list2) {
                                row.setNodeName("记录");
                                SingerField fieldBean = new SingerField();
                                String name = f.getElementname();
                                if (name.indexOf("（") >= 0) {
                                    name = name.substring(0, name.indexOf("（"));
                                }
                                if (name.indexOf("(") >= 0) {
                                    name = name.substring(0, name.indexOf("("));
                                }
                                fieldBean.setFieldName(name);
                                if(f.getElementid().startsWith("file_")){   //表明为 单列上传，值需要根据文件iD去

                                    String elementValue = f.getElementvalue();  // 数据格式为 '文件名'+'_文件ID' ,如：行驶证.png_108011
                                    String fileId = "";
                                    if(!StringUtil.isEmpty(elementValue)){
                                        fileId =elementValue.substring(elementValue.lastIndexOf("_")+1);
                                    }
                                    if (!StringUtil.isEmpty(fileId)) {
                                        wsbsSbFilesParam.setWsbsSbFilesId(Long.valueOf(fileId));
                                        List<WsbsSbFilesBean> wsbsSbFilesBeanList= dataPlatformXmlMapper.getWsbsSbFiles(wsbsSbFilesParam);
                                        if(CollectionUtils.isNotEmpty(wsbsSbFilesBeanList)){
                                            WsbsSbFilesBean wsbsSbFilesBean =  wsbsSbFilesBeanList.get(0);
                                            try {
												wsbsSbFilesBean.setFileData(FtpManager.getFileFromFTP(cfgContentService,wsbsSbFilesBean.getSaveRoute()));
											} catch (Exception e) {
												WbtimerJobLogger.log(e);
												continue;
											}
                                            byte[] file = wsbsSbFilesBean.getFileData();
                                            String fileContent = CryptUtil.base64Encode(file);
                                            fieldBean.setFieldValue(fileContent);
                                        }
                                    }else{
                                        fieldBean.setFieldValue("");
                                    }

                                }else{
                                    fieldBean.setFieldValue(f.getElementvalue());
                                }
                                fields.add(fieldBean);
                            }
                            row.setFields(fields);
                            rows.add(row);
                        }
                        mutiRow.setRows(rows);
                        mutiRows.add(mutiRow);
                    }
                }
            }

        }
        docBean.setFields(fieldBeans);
        docBean.setMutiRows(mutiRows);
        return docBean;
    }
    /** 归类多行子表数据，按tableCode **/
     public Map<String, ArrayList> sortMutiCode(List<FormfileuploaddataBean> formfileuploaddataBean) {
        TreeMap tm = new TreeMap();
        if(formfileuploaddataBean!=null&&formfileuploaddataBean.size()>0){
            for (int i = 0; i < formfileuploaddataBean.size(); i++) {
                FormfileuploaddataBean s =  formfileuploaddataBean.get(i);
                if (tm.containsKey(s.getTablecode())) {//
                    ArrayList l11 = (ArrayList) tm.get(s.getTablecode());
                    l11.add(s);
                } else {
                    ArrayList tem = new ArrayList();
                    tem.add(s);
                    tm.put(s.getTablecode(), tem);
                }

            }
        }
        return tm;
    }
    /** 归类多行子表数据，按Trsequence **/
     public Map<String, ArrayList> sortMutiSq(List<FormfileuploaddataBean> formfileuploaddataBean) {
        TreeMap tm = new TreeMap();
        if(formfileuploaddataBean!=null&&formfileuploaddataBean.size()>0){
            for (int i = 0; i < formfileuploaddataBean.size(); i++) {
                FormfileuploaddataBean s = (FormfileuploaddataBean) formfileuploaddataBean.get(i);
                if (tm.containsKey(s.getTrsequence())) {//
                    ArrayList l11 = (ArrayList) tm.get(s.getTrsequence());
                    l11.add(s);
                } else {
                    ArrayList tem = new ArrayList();
                    tem.add(s);
                    tm.put(s.getTrsequence(), tem);
                }

            }
        }
        return tm;
    }
    private String replaceStr(String str) {
        str = str.replace("（", "_");
        str = str.replace("）", "");
        str = str.replace("(", "_");
        str = str.replace(")", "");
        return str;
    }
}
