package com.eshore.wbtimer.core.rpc.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 描述: Rpc请求bean
 *
 * @author Yangjinming
 * @create 2018-01-10 18:20
 */
public class RpcRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String serverAddress;
    private long createMillisTime;
    private String accessToken;

    private String className;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;


    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public long getCreateMillisTime() {
        return createMillisTime;
    }

    public void setCreateMillisTime(long createMillisTime) {
        this.createMillisTime = createMillisTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "serverAddress='" + serverAddress + '\'' +
                ", createMillisTime=" + createMillisTime +
                ", accessToken='" + accessToken + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }

}

