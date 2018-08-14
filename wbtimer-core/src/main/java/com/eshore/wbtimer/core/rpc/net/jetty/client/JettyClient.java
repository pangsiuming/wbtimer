package com.eshore.wbtimer.core.rpc.net.jetty.client;

import com.eshore.wbtimer.core.rpc.model.RpcRequest;
import com.eshore.wbtimer.core.rpc.model.RpcResponse;
import com.eshore.wbtimer.core.rpc.serialize.HessianSerializer;
import com.eshore.wbtimer.core.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 描述: 客户端访问（可以访问server端不限于jettyserver）
 * 用http连接
 *
 * @author Yangjinming
 * @create 2018-01-10 18:19
 */
public class JettyClient {

    private static Logger logger = LoggerFactory.getLogger(JettyClient.class);

    public RpcResponse send(RpcRequest request) throws Exception {
        try {
            // serialize request
            byte[] requestBytes = HessianSerializer.serialize(request);

            // reqURL
            String reqURL = request.getServerAddress();
            if (reqURL!=null && reqURL.toLowerCase().indexOf("http")==-1) {
                reqURL = "http://" + request.getServerAddress() + "/";	// IP:PORT, need parse to url
            }

            // remote invoke
            byte[] responseBytes = HttpClientUtil.postRequest(reqURL, requestBytes);
            if (responseBytes == null || responseBytes.length==0) {
                RpcResponse rpcResponse = new RpcResponse();
                rpcResponse.setError("RpcResponse byte[] is null");
                return rpcResponse;
            }

            if(HessianSerializer.deserialize(responseBytes, RpcResponse.class) instanceof Map){
                return new RpcResponse();
            }

            // deserialize response
            RpcResponse rpcResponse = (RpcResponse) HessianSerializer.deserialize(responseBytes, RpcResponse.class);
            return rpcResponse;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            RpcResponse rpcResponse = new RpcResponse();
            rpcResponse.setError("Client-error:" + e.getMessage());
            return rpcResponse;
        }
    }

}
