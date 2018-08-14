package com.eshore.wbtimer.executor.service.impl;

import com.eshore.wbtimer.common.utils.SpringContextUtil;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.mapper.bean.DzzzItemsBean;
import com.eshore.wbtimer.executor.service.dzzzPageService;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zoe on 2018/4/11
 */
@Service
public class dzzzPageServiceImpl implements dzzzPageService {
   private final Logger logger = LoggerFactory.getLogger(dzzzPageServiceImpl.class);

    @Autowired
    com.eshore.wbtimer.executor.mapper.dzzzPageServiceMapper dzzzPageServiceMapper;

    @Override
    public void pageHandle() {

        String path= SpringContextUtil.getApplicationContext().getClassLoader().getResource("").getPath();
        File all=new File(path+"dzzz/html/");
        all.mkdirs();
        Configuration cfg = new Configuration();
        List<Map<String,String>> codeList=dzzzPageServiceMapper.queryCodeList();
        if(codeList != null){
            for(int i = 0;i < codeList.size();i++){
                Map<String,Object> infoList = new HashMap<String,Object>();
                List<DzzzItemsBean> info=dzzzPageServiceMapper.queryInfoByCode(codeList.get(i).get("DZZZ_CODE"));
                Map<String,Map<String,String>> optionList = querySelectOption(info);
                infoList.put("infoList", info);
                infoList.put("optionList", optionList);
                try{
                    cfg.setClassForTemplateLoading(this.getClass(),"/dzzz");
                    cfg.setObjectWrapper(new DefaultObjectWrapper());
                    cfg.setDefaultEncoding("UTF-8");
                    Template t=cfg.getTemplate("index.ftl");
                    File file=new File(path+"dzzz/html/"+codeList.get(i).get("DZZZ_CODE")+".jsp");
                    t.process(infoList, new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
                    WbtimerJobLogger.log("******"+codeList.get(i).get("DZZZ_CODE")+".jsp生成*******");
                }catch(Exception e){
                    WbtimerJobLogger.log(e);
                }
            }
        }


    }



    public Map<String,Map<String,String>> querySelectOption(List<DzzzItemsBean> info){
        Map<String,Map<String,String>> optionList = new HashMap<String,Map<String,String>>();
        for(int i = 0;i < info.size();i++){
            if("checkbox".equals(info.get(i).getTypeCode())){
                if(info.get(i).getOptions() != null && !"".equals(info.get(i).getOptions())){
                    String []options = info.get(i).getOptions().split(",");
                    Map<String,String> optionMap = new HashMap<String,String>();
                    if(options != null){
                        for(int j = 0;j<options.length;j++){
                            String key = options[j].substring(0,options[j].indexOf("|"));
                            String value = options[j].substring(options[j].indexOf("|")+1);
                            optionMap.put(key,value);
                        }
                    }
                    optionList.put(info.get(i).getKey(), optionMap);
                }
            }
        }
        return optionList;
    }




}
