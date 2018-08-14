package com.eshore.wbtimer.admin.controller;

import com.eshore.wbtimer.admin.controller.annotation.PermissionLimit;
import com.eshore.wbtimer.core.biz.AdminBiz;
import com.eshore.wbtimer.core.rpc.model.RpcRequest;
import com.eshore.wbtimer.core.rpc.model.RpcResponse;
import com.eshore.wbtimer.core.rpc.net.NetComServerFactory;
import com.eshore.wbtimer.core.rpc.serialize.HessianSerializer;
import com.eshore.wbtimer.core.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 描述:  供执行器来调用 获取反射对象
 *
 * @author Yangjinming
 * @create 2018-01-11 8:59
 */
@Controller
public class JobApiController {
    private static Logger logger = LoggerFactory.getLogger(JobApiController.class);
    @PermissionLimit(limit = false)
    @RequestMapping(AdminBiz.MAPPING)
    public void getObject(HttpServletRequest request , HttpServletResponse response) throws IOException{
        //反射获取admin对象 到rpcResponse result中
        RpcResponse rpcResponse = doInvoke(request);
        //序列化为二进制字节数据
        byte[] responseBytes = HessianSerializer.serialize(rpcResponse);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(responseBytes);
        outputStream.flush();
    }

    private RpcResponse doInvoke(HttpServletRequest request){
        try{
            //从http获取请求的二进制字节数据
            byte[] requestBytes = HttpClientUtil.readBytes(request);
            if (requestBytes==null || requestBytes.length==0) {
                RpcResponse rpcResponse = new RpcResponse();
                rpcResponse.setResult(null);
                rpcResponse.setError("RpcRequest byte[] is null");
                return rpcResponse;
            }
            //通过hessian工具类反序列化成RpcRequest对象
            RpcRequest rpcRequest = (RpcRequest) HessianSerializer.deserialize(requestBytes,RpcRequest.class);
            //通过名称获取Server工厂中serviceMap的对象（如admin在wbtimerjobdynamicscheduler初始化的时候就已经传入了）
            RpcResponse rpcResponse = NetComServerFactory.invokeService(rpcRequest,null);
            return rpcResponse;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            RpcResponse rpcResponse = new RpcResponse();
            rpcResponse.setError("JobApi invoke error:"+e.getMessage());
            return rpcResponse;
        }
    }
}
