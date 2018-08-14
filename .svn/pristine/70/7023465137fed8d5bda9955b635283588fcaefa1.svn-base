package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:15
 */
public class FieldBean {
    private String fieldName;
    private String fieldValue;

    private String targetName;

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "<" + XmlEleEnum.FIELD.getValue() + " " + XmlEleEnum.FIELD_FIELDNAME.getValue() + "=\"" + fieldName + "\">" + fieldValue + "</"
                + XmlEleEnum.FIELD.getValue() + ">";
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

}
