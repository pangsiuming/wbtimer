package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:19
 */

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

import java.util.List;

/**半交换表单事项，交通局专用节点**/
public class DocBean {

    private String version;
    //单行
    private List<SingerField> fields;
    //多行列表
    private List<MutiRow> mutiRows;



    public List<SingerField> getFields() {
        return fields;
    }

    public void setFields(List<SingerField> fields) {
        this.fields = fields;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<MutiRow> getMutiRows() {
        return mutiRows;
    }

    public void setMutiRows(List<MutiRow> mutiRows) {
        this.mutiRows = mutiRows;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("<" + XmlEleEnum.DOC.getValue() + " " + XmlEleEnum.DOC_VERSION.getValue() + "=\"" + version + "\">");
        for (SingerField singerField : fields) {
            sb.append(singerField.toString());
        }
        for (MutiRow mutiRow : mutiRows) {
            sb.append(mutiRow.toString());
        }
        sb.append("</" + XmlEleEnum.DOC.getValue() + ">");
        return sb.toString();
    }

}

