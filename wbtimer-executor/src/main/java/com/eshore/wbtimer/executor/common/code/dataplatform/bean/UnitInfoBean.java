package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:18
 */
public class UnitInfoBean {
    private String unitName; //
    private String unitID;
    private List<FieldBean> fields;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitID() {
        return unitID;
    }

    public void setUnitID(String unitID) {
        this.unitID = unitID;
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
        sb.append("<" + XmlEleEnum.UNITINFO.getValue() + " " + XmlEleEnum.UNITINFO_UNITNAME.getValue() + "=\"" + unitName + "\" "
                + XmlEleEnum.UNITINFO_UNITID.getValue() + "=\"" + unitID + "\" >");
        if(fields!=null){
            for (FieldBean fieldBean : fields) {
                sb.append(fieldBean.toString());
            }
        }
        sb.append("</" + XmlEleEnum.UNITINFO.getValue() + ">");
        return sb.toString();
    }

}
