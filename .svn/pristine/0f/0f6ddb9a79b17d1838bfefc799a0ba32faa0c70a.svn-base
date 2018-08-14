package com.eshore.wbtimer.common.exception;

import com.eshore.wbtimer.common.enums.ResponseCode;

/**
 * 描述: 全局exception
 *
 * @author Yangjinming
 * @create 2018-01-03 11:13
 */
public class GlobalException extends Exception{
    private int code;
    public GlobalException(){

    }

    public GlobalException(ResponseCode responseCode){
        super(responseCode.getMsg());
        this.code = responseCode.getCode();
    }
    public GlobalException(ResponseCode responseCode,String msg){
        super(msg);
        this.code = responseCode.getCode();
    }

    public int getCode(){
        return  code;
    }
}
