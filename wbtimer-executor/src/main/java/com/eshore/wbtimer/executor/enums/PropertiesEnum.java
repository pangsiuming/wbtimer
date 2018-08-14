package com.eshore.wbtimer.executor.enums;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 14:23
 */
public enum  PropertiesEnum {

    /** 数据平台接口验证参数-接口地址 */
    DATAPLATFORM_WSDLURI("wsdlUrl"),
    /** 数据平台接口验证参数-命名空间 */
    DATAPLATFORM_NAMESPACE("targetNamespace"),
    /** 数据平台接口验证参数-身份验证 */
    DATAPLATFORM_SIDENTIFY("sIdentify"),
    /** 数据平台接口通用查询参数-接口地址 */
    DATAPLATFORM_WSDLURIQUERY("wsdlUrlQuery"),

    /** 普元接口验证参数-接口地址 */
    PY_WSDLURL("py_wsdlUrl");

    private String value;

    PropertiesEnum(String v) {
        this.value = v;
    }

    public String getValue() {
        return value;
    }
}
