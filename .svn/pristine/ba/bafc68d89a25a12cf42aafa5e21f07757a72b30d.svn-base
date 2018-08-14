package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:19
 */

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

import java.util.List;

/**
 * ItemInfo下的子节点*/
public class ItemSonBean {

    private String nodeName;
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



    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("<" + nodeName + " " + XmlEleEnum.BASEINFO_NAME.getValue() + "=\"" + name + "\">");
        for (FieldBean fieldBean : fields) {
            sb.append(fieldBean.toString());
        }
        sb.append("</" + nodeName + ">");
        return sb.toString();
    }

}

