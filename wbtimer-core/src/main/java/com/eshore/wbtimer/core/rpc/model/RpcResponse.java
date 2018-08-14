package com.eshore.wbtimer.core.rpc.model;

import java.io.Serializable;

/**
 * 描述: Rpc响应体
 *
 * @author Yangjinming
 * @create 2018-01-10 18:20
 */
public class RpcResponse  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String error;
    private Object result;

    public boolean isError() {
        return error != null;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "NettyResponse [error=" + error
                + ", result=" + result + "]";
    }

}