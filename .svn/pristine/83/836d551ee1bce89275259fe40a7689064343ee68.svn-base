package com.eshore.wbtimer.common.net;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.common.net.bean.FormResult;
import com.eshore.wbtimer.core.utils.PropertiesUtil;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 描述:
 *
 * @author Yangjinming
 * @date 2018/1/24 15:28
 */
public class HttpCall {
    /*
     * 普通HTTP调用
     */
    public static String httpInvoke(String url, String methodm, String data) throws IOException
    {
        StringBuilder response = new StringBuilder();
        URL httpurl = new URL(null,url,new sun.net.www.protocol.http.Handler());
        // 指定了handler后openConnection()返回了HttpsURLConnection类型对象
        HttpURLConnection hc = (HttpURLConnection) httpurl.openConnection();
        OutputStream ops=null;
        InputStreamReader isr = null;
        InputStream ins = null;
        try {
            String Method = methodm.toUpperCase();
            hc.setRequestMethod(Method);
            hc.setDoInput(true);
            if ("POST".equals(Method)) {
                hc.setDoOutput(true);
                if (data != null) {
                    hc.setRequestProperty("Content-Length", String.valueOf(data
                            .length()));
                }
            }
            hc.setRequestProperty("Content-Type", "application/json");
            hc.setRequestProperty("Charset", "UTF-8");

            hc.connect();
            if ("POST".equals(Method)) {
                ops = hc.getOutputStream();
                byte[] buff;
                if (data != null) {
                    buff = data.getBytes("UTF-8");
                    ops.write(buff);
                }
                ops.flush();
                ops.close();
            }
            int code = hc.getResponseCode();
            if (code == 200) {
                ins = hc.getInputStream();
                isr = new InputStreamReader(ins, "UTF-8");
                char[] cbuf = new char[1024];
                int i = isr.read(cbuf);
                while (i > 0) {
                    response.append(new String(cbuf, 0, i));
                    i = isr.read(cbuf);
                }
                ins.close();
            } else {
                ins = hc.getErrorStream();
                isr = new InputStreamReader(ins, "UTF-8");
                char[] cbuf = new char[1024];
                int i = isr.read(cbuf);
                while (i > 0) {
                    response.append(new String(cbuf, 0, i));
                    i = isr.read(cbuf);
                }
                ins.close();
            }
            hc.disconnect();
            return response.toString();
        } catch (Exception e) {
            WbtimerJobLogger.log(e);
            return response.toString();
        }finally{
            try{
                if(ops!=null){
                    ops.close();
                }
                if(isr!=null ){
                    isr.close();
                }
                if(ins!=null){
                    ins.close();
                }
                if(hc !=null){
                    hc.disconnect();
                }
            }catch(IOException e){
                WbtimerJobLogger.log(e.getMessage());
            }
        }
    }

    /*
     * https调用
     */
    public static String httpsInvoke(String url, String methodm, String data) throws IOException, NoSuchAlgorithmException, KeyManagementException
    {
//		invokeResult = null;
        StringBuilder response = new StringBuilder();
//		java.net.URL httpurl = new java.net.URL(url);
//		URL httpurl = new URL(null,url,new com.sun.net.ssl.internal.www.protocol.https.Handler());
        URL httpurl = new URL(null,url,new sun.net.www.protocol.https.Handler());
        // 指定了handler后openConnection()返回了HttpsURLConnection类型对象
        HttpsURLConnection hc = (HttpsURLConnection) httpurl.openConnection();
        SSLSocketFactory sslf = hc.getSSLSocketFactory();
        // 自定义的管理器
        X509TrustManager xtm = new MyX509TrustManager();
        TrustManager mytm[] = new X509TrustManager[]{ xtm };

        //获取信任上下文
        SSLContext ctx = SSLContext.getInstance("SSL");
        ctx.init(null, mytm, null);
        //自定义是否信任证书
        MyHostnameVerifier hostnameverifier = new MyHostnameVerifier();
        hc.setHostnameVerifier(hostnameverifier);
        hc.setSSLSocketFactory(ctx.getSocketFactory());
        String Method = methodm.toUpperCase();
        hc.setRequestMethod(Method);
        hc.setDoInput(true);
        if ("POST".equals(Method)) {
            hc.setDoOutput(true);
            if (data != null) {
                hc.setRequestProperty("Content-Length", String.valueOf(data
                        .length()));
            }
        }
        hc.setRequestProperty("Content-Type", "application/json");
        hc.setRequestProperty("Charset", "UTF-8");

        hc.connect();
        if ("POST".equals(Method)) {
            OutputStream ops = hc.getOutputStream();
            byte[] buff;
            if (data != null) {
                buff = data.getBytes("UTF-8");
                ops.write(buff);
            }
            ops.flush();
            ops.close();
        }
        int code = hc.getResponseCode();
        if (code == 200) {
            InputStream ins;
            ins = hc.getInputStream();
            InputStreamReader isr = new InputStreamReader(ins, "UTF-8");
            char[] cbuf = new char[1024];
            int i = isr.read(cbuf);
            while (i > 0) {
                response.append(new String(cbuf, 0, i));
                i = isr.read(cbuf);
            }
            ins.close();
        } else {
            InputStream ins;
            ins = hc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(ins, "UTF-8");
            char[] cbuf = new char[1024];
            int i = isr.read(cbuf);
            while (i > 0) {
                response.append(new String(cbuf, 0, i));
                i = isr.read(cbuf);
            }
            ins.close();
        }
        hc.disconnect();
        return response.toString();
    }

    public static String httpInvoke(String url, String methodm, Map<String,String> head, String data)
            throws IOException
    {

        StringBuilder response = new StringBuilder();

        URL httpurl = new URL(null,url,new sun.net.www.protocol.http.Handler());
        // 指定了handler后openConnection()返回了HttpsURLConnection类型对象
        HttpURLConnection hc = (HttpURLConnection) httpurl.openConnection();
        String Method = methodm.toUpperCase();

        hc.setRequestMethod(Method);
        hc.setDoInput(true);
        //赋值头参数
        if(head!=null){
            for(String key : head.keySet()){
                hc.setRequestProperty(key, head.get(key));
            }
        }

        if ("POST".equals(Method)) {
            hc.setDoOutput(true);
            if (data != null) {
                hc.setRequestProperty("Content-Length", String.valueOf(data.length()));
            }
        }
        hc.setRequestProperty("Content-Type", "application/json");
        hc.setRequestProperty("Charset", "UTF-8");

        hc.connect();
        if ("POST".equals(Method)) {
            OutputStream ops = hc.getOutputStream();
            byte[] buff;
            if (data != null) {
                buff = data.getBytes("UTF-8");
                ops.write(buff);
            }
            ops.flush();
            ops.close();
        }
        int code = hc.getResponseCode();
        if (code == 200) {
            InputStream ins;
            ins = hc.getInputStream();
            InputStreamReader isr = new InputStreamReader(ins, "UTF-8");
            char[] cbuf = new char[1024];
            int i = isr.read(cbuf);
            while (i > 0) {
                response.append(new String(cbuf, 0, i));
                i = isr.read(cbuf);
            }
            ins.close();
        } else {
            InputStream ins;
            ins = hc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(ins, "UTF-8");
            char[] cbuf = new char[1024];
            int i = isr.read(cbuf);
            while (i > 0) {
                response.append(new String(cbuf, 0, i));
                i = isr.read(cbuf);
            }
            ins.close();
        }
        hc.disconnect();
        return response.toString();
    }

    /**
     * 获取公共url
     * @return
     */
    public static String getComUrl(String propertiesPath){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            String timestamp  = formatter.format(new Date());
            String nonce = UUID.randomUUID().toString();
            //String clientSystemId=new BaseUrl().getClientSystemId();
            String clientSystemId = PropertiesUtil.getString(propertiesPath,"clientSystemId");

            String signature =getSignature(clientSystemId,timestamp,nonce);
            //编码
            timestamp = URLEncoder.encode(timestamp, "UTF-8");
            nonce = URLEncoder.encode(nonce, "UTF-8");
            clientSystemId = URLEncoder.encode(clientSystemId, "UTF-8");
            signature = URLEncoder.encode(signature, "UTF-8");
            String url = "signature="+signature+"&timestamp="+timestamp+"&nonce="+nonce+"&clientSystemId="+clientSystemId;
            return url;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    /**
     * 加密签名
     * @param clientSystemId
     * @param timestamp
     * @param nonce
     * @return
     */
    public static String getSignature(String clientSystemId,String timestamp,String nonce){

        String[] arr = {clientSystemId,timestamp,nonce};
        Arrays.sort(arr);
        //按排序后的前后顺序连成串
        StringBuffer buf = new StringBuffer();
        buf.append(arr[0]).append(arr[1]).append(arr[2]);
        String befStr = buf.toString();
        //SHA1加密
        String mySignature = DigestUtils.shaHex(befStr.getBytes());
        return mySignature==null?"flase":mySignature;
    }

    public static FormResult doPost(String params, String action, String successMsg, String errMsg){
        FormResult rs = new FormResult();
        try {
            URL url = new URL(action);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("contentType", "UTF-8");
            conn.setConnectTimeout(Integer.valueOf("180000"));
            conn.setReadTimeout(Integer.valueOf("180000"));
            conn.connect();
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.write(params.getBytes("UTF-8"));
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line = reader.readLine();
            reader.close();
            conn.disconnect();

            JSONObject jsonObject = JSONObject.fromObject(line);

            if(jsonObject == null || "fail".equals(jsonObject.get("status"))){
                throw new Exception(errMsg);
            }
            rs.setSuccess(true);
            rs.setStatus("1");
            rs.setMessage(successMsg);
            rs.setFlowId(jsonObject.get("processInstId").toString());
        } catch (Exception e) {
            e.printStackTrace();
            rs.setSuccess(false);
            rs.setStatus("0");
            rs.setMessage(e.getMessage());
        }
        return rs;
    }
}
