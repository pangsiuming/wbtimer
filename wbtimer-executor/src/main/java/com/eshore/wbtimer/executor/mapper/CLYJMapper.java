package com.eshore.wbtimer.executor.mapper;

import com.eshore.wbtimer.executor.mapper.bean.PackageInoutProcess;

import java.util.List;
import java.util.Map;

/**
 * 描述:综合接办材料交接预警Mapper类
 *
 * @author Zhangqian
 * @create 2018/1/19 16:13
 */
public interface CLYJMapper {
    /*
    * 获取待交接列表
    * */
     List<PackageInoutProcess> queryPackageInout(Map<String, String> params);

     List<Map<String, String>> getAlertDateByWork(Map<String, String> params);
}
