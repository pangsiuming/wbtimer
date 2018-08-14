package com.eshore.wbtimer.common.net;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * 描述:
 *
 * @author Yangjinming
 * @date 2018/1/24 15:35
 */
public class MyHostnameVerifier implements HostnameVerifier
{
    public boolean verify(String s, SSLSession sslSession)
    {
        return true;
    }
}
