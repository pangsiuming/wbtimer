package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:13
 */
public class StandardInfoBean {
    private String process;
    private List<FieldBean> fields;

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public List<FieldBean> getFields() {
        return fields;
    }

    public void setFields(List<FieldBean> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<" + XmlEleEnum.STANDARDINFO.getValue() + " " + XmlEleEnum.STANDARDINFO_PROCESS.getValue() + "=\"" + process + "\">");
        for (FieldBean fieldBean : fields) {
            sb.append(fieldBean.toString());
        }
        sb.append("</" + XmlEleEnum.STANDARDINFO.getValue() + ">");
        return sb.toString();
    }

}
