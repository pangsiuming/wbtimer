package com.eshore.wbtimer.common.enums;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-03 10:26
 */
public enum ResponseCode {
    SUCCESS(200,"成功"),ERROR(500,"失败");

    private int code;
    private String msg;
    ResponseCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}