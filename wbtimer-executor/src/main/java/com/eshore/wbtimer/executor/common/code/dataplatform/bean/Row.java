package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import java.util.List;

/**
 * 描述:多行列表下的子节点
 *
 * @author Yangjinming
 * @create 2018/2/1 9:21
 */

public class Row {

    private String nodeName;
    private List<SingerField> fields;


    public List<SingerField> getFields() {
        return fields;
    }

    public void setFields(List<SingerField> fields) {
        this.fields = fields;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("<" + nodeName + ">");
        for (SingerField fieldBean : fields) {
            sb.append(fieldBean.toString());
        }
        sb.append("</" + nodeName + ">");
        return sb.toString();
    }

}

