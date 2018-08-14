package com.eshore.wbtimer.common.vo;

import com.eshore.wbtimer.common.enums.ResponseCode;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.io.Serializable;

/**
 * 描述:统一返回类(返回json串)
 *
 * @author Yangjinming
 * @create 2017-12-29 11:21
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)在mvc-driven里面配置了 这个就不用配了
//保证序列化json的时候,如果是null的对象,返回的json无该属性
public class ResponseBean<T>  implements Serializable{
    private int code;
    private String msg;
    private T data;

    private ResponseBean(int code){
        this.code = code;
    }
    private ResponseBean(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private ResponseBean(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseBean<T> createSuccess(){
        return new ResponseBean(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ResponseBean<T> createSuccess(String msg,T data){
        return new ResponseBean(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    public static <T> ResponseBean<T> createSuccessByMsg(String msg) {
        return new ResponseBean(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> ResponseBean<T> createSuccessByData(T data){
        return new ResponseBean(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg(),data);
    }
    public static  ResponseBean createError(){
        return new ResponseBean(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMsg());
    }
    public static ResponseBean createErrorByCode(int code){
        return new ResponseBean(code,ResponseCode.ERROR.getMsg());
    }
    public static ResponseBean createErrorByMsg(String msg){
        return new ResponseBean(ResponseCode.ERROR.getCode(),msg);
    }
    public static ResponseBean createErrorByCodeMsg(int code,String msg){
        return new ResponseBean(code,msg);
    }

    @JsonIgnore
    public String getString() {
        return "{\"code\": "+code+",\"msg\": \""+msg+"\" }";
    }
    //在序列化时由于该方法调用了code属性会影响 顾需要使之不在json序列化结果当中
    @JsonIgnore
    public boolean isSuccess(){
        return this.code==ResponseCode.SUCCESS.getCode();
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
