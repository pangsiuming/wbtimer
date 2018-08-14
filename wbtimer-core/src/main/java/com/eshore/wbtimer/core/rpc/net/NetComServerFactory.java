package com.eshore.wbtimer.core.rpc.net;

import com.eshore.wbtimer.core.biz.model.ReturnT;
import com.eshore.wbtimer.core.rpc.model.RpcRequest;
import com.eshore.wbtimer.core.rpc.model.RpcResponse;
import com.eshore.wbtimer.core.rpc.net.jetty.server.JettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.reflect.FastClass;
import org.springframework.cglib.reflect.FastMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 通讯服务器工厂类
 *
 * @author Yangjinming
 * @create 2018-01-10 18:17
 */
public class NetComServerFactory {
    private static final Logger logger = LoggerFactory.getLogger(NetComServerFactory.class);

    // ---------------------- server start ----------------------
    JettyServer server = new JettyServer();
    public void start(int port, String ip, String appName) throws Exception {
        server.start(port, ip, appName);
    }

    // ---------------------- server destroy ----------------------
    public void destroy(){
        server.destroy();
    }

    // ---------------------- server instance ----------------------
    /**
     * init local rpc service map
     */
    private static Map<String, Object> serviceMap = new HashMap<String, Object>();
    private static String accessToken;
    public static void putService(Class<?> iface, Object serviceBean){
        serviceMap.put(iface.getName(), serviceBean);
    }
    public static void setAccessToken(String accessToken) {
        NetComServerFactory.accessToken = accessToken;
    }

    /**
     * 将传入的request反射成对象后输出到RpcResponse result中
     * @param request
     * @param serviceBean
     * @return
     */
    public static RpcResponse invokeService(RpcRequest request, Object serviceBean) {
        if (serviceBean==null) {
            serviceBean = serviceMap.get(request.getClassName());
        }
        if (serviceBean == null) {
            // TODO
        }

        RpcResponse response = new RpcResponse();

        if (System.currentTimeMillis() - request.getCreateMillisTime() > 180000) {
            response.setResult(new ReturnT<String>(ReturnT.FAIL_CODE, "The timestamp difference between admin and executor exceeds the limit."));
            return response;
        }
        if (accessToken!=null && accessToken.trim().length()>0 && !accessToken.trim().equals(request.getAccessToken())) {
            response.setResult(new ReturnT<String>(ReturnT.FAIL_CODE, "The access token[" + request.getAccessToken() + "] is wrong."));
            return response;
        }

        try {
            Class<?> serviceClass = serviceBean.getClass();
            String methodName = request.getMethodName();
            Class<?>[] parameterTypes = request.getParameterTypes();
            Object[] parameters = request.getParameters();

            FastClass serviceFastClass = FastClass.create(serviceClass);
            FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, parameterTypes);

            Object result = serviceFastMethod.invoke(serviceBean, parameters);

            response.setResult(result);
        } catch (Throwable t) {
            t.printStackTrace();
            response.setError(t.getMessage());
        }

        return response;
    }

}
