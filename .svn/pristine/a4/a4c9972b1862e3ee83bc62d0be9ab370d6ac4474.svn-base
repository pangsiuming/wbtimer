package com.eshore.wbtimer.executor.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.eshore.wbtimer.executor.mapper.bean.FormfileuploaddataBean;
import com.eshore.wbtimer.executor.mapper.bean.FormfileuploaddatashowBean;
import com.eshore.wbtimer.executor.mapper.bean.WsbsFgblInfoBean;
import com.eshore.wbtimer.executor.mapper.bean.WsbsSbFilesBean;
import com.eshore.wbtimer.executor.service.bean.WsbsFgDataParam;
import com.eshore.wbtimer.executor.service.bean.WsbsFgErrorParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/31 9:25
 */
public interface UpdateStartPYMapper extends BaseMapper<WsbsFgblInfoBean>{
    String getMaxDate();
    String getAdminOrgByServiceCode(String serviceCode);
    String getXzqhdm(String orgCode);
    String getFormIdBySxbm(String serviceCode);
    String getFlowIdBySxbm(String serviceCode);
    String getDocumentName(String ssid);
    List<Map<String,Object>> queryFgErrorInfo(String applyId);
    List<Map<String,String>> queryFGSLInfo(Map<String, Object> params);
    String getTableGridByFormIdAndTableCode(@Param("formId") String formId, @Param("tableCode") String tableCode);
    List<Map<String,String>> getDataRelationMapping(@Param("formId") String formId, @Param("eosType") String eosType, @Param("fieldId") String fieldId);
    List<Map<String,String>> getSubFormMapping(@Param("formId") String formId, @Param("tableCode") String tableCode);
    List<Map<String,String>> getSubFormTableInfo(@Param("formId") String formId, @Param("tableCode") String tableCode);
    int saveWsbsSbFiles(WsbsSbFilesBean wsbsSbFilesBean);
    int saveFormfileuploaddata(FormfileuploaddataBean formfileuploaddataBean);
    int saveWsbsFgError(WsbsFgErrorParam wsbsFgErrorParam);
    int saveFormfileuploaddatashow(FormfileuploaddatashowBean formfileuploaddatashowBean);
    int saveFGSLInfo(WsbsFgblInfoBean wsbsFgblInfoBean);
    int saveWsbsFgData(WsbsFgDataParam wsbsFgDataParam);
}
