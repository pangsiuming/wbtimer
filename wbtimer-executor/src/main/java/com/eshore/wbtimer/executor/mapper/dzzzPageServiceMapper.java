package com.eshore.wbtimer.executor.mapper;

import com.eshore.wbtimer.executor.mapper.bean.DzzzItemsBean;

import java.util.List;
import java.util.Map;

/**
 * Created by zoe on 2018/4/11
 */
public interface dzzzPageServiceMapper {

    public List<Map<String,String>> queryCodeList();

    public List<DzzzItemsBean>  queryInfoByCode(String dzzzCode);



}
