package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:14
 */
public class SbInfoBean {
    private List<FieldBean> fields;

    public List<FieldBean> getFields() {
        return fields;
    }

    public void setFields(List<FieldBean> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<" + XmlEleEnum.SBINFO.getValue() + ">");
        for (FieldBean fieldBean : fields) {
            sb.append(fieldBean.toString());
        }
        sb.append("</" + XmlEleEnum.SBINFO.getValue() + ">");
        return sb.toString();
    }

}
