package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:17
 */
public class BaseInfoBean {
    private String name;
    private List<FieldBean> fields;

    public List<FieldBean> getFields() {
        return fields;
    }

    public void setFields(List<FieldBean> fields) {
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("<" + XmlEleEnum.BASEINFO.getValue() + " " + XmlEleEnum.BASEINFO_NAME.getValue() + "=\"" + name + "\">");
        for (FieldBean fieldBean : fields) {
            sb.append(fieldBean.toString());
        }
        sb.append("</" + XmlEleEnum.BASEINFO.getValue() + ">");
        return sb.toString();
    }

}
