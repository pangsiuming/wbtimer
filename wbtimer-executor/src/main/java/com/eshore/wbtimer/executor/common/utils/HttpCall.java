package com.eshore.wbtimer.executor.common.utils;

import com.eshore.wbtimer.common.net.MyHostnameVerifier;
import com.eshore.wbtimer.common.net.MyX509TrustManager;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


public class HttpCall{
	

	/*
	 * https调用
	 */
	public static String httpsInvoke(String url, String methodm, String data)
	throws IOException, NoSuchAlgorithmException, KeyManagementException
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
	
	/*
	 * 普通HTTP调用
	 */
	public static String httpInvoke(String url, String methodm, String data)
		throws IOException
	{
//		invokeResult = null;
		StringBuilder response = new StringBuilder();
//		java.net.URL httpurl = new java.net.URL(url);
//		HttpURLConnection hc = (HttpURLConnection) httpurl.openConnection();
//		import sun.net.www.protocol.http.HttpURLConnection;
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
			WbtimerJobLogger.log(e.getMessage());
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
		//return response.toString();
		
	}
	
	/*public static String httpInvoke(String url, String methodm, String data)
			throws IOException
		{
//			invokeResult = null;
			StringBuilder response = new StringBuilder();
//			java.net.URL httpurl = new java.net.URL(url);
//			HttpURLConnection hc = (HttpURLConnection) httpurl.openConnection();
//			import sun.net.www.protocol.http.HttpURLConnection;
			URL httpurl = new URL(null,url,new sun.net.www.protocol.http.Handler());  
			// 指定了handler后openConnection()返回了HttpsURLConnection类型对象  
			HttpURLConnection hc = (HttpURLConnection) httpurl.openConnection(); 
			
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
		
	*/
	public static byte [] httpInvokeReturnByte(String url){
		BufferedInputStream in = null;
		HttpURLConnection  conn = null;
        int reCode=0;
        try {
            URL realUrl = new URL(url);
        	try {
                conn = (HttpURLConnection)realUrl.openConnection();
                // 设置通用的请求属性
                //conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                // 设置 HttpURLConnection的请求方式
                conn.setRequestMethod("POST");
                conn.setConnectTimeout(30000);
                conn.setReadTimeout(3000);
                // 发送POST请求必须设置如下两行
                conn.setDoOutput(true);
                conn.setDoInput(true);
                reCode = conn.getResponseCode();
			} catch (Exception e) {
				e.printStackTrace();
				try{
					if(conn!=null)conn.disconnect();
				}catch(Exception e4){}
				}finally{
			}
            if(reCode!=-1){
            	
            	// 定义BufferedReader输入流来读取URL的响应
                in = new BufferedInputStream(conn.getInputStream());
				ByteArrayBuffer byteArray = new ByteArrayBuffer();
                //OutputStream outputStream = new FileOutputStream("D:\\工作软件\\1.jpg");
                byte[] bytes = new byte[1024];
                int byteCount = 0;
                while ((byteCount=in.read(bytes))!=-1) {
                	byteArray.write(bytes, 0, byteCount);
                	//outputStream.write(bytes, 0, byteCount);
                }
                byte [] b=byteArray.toByteArray();
                byteArray.close();
                return b;
                //outputStream.close();
                
                //File  file = new File("G:/S60817-104758.jpg");
            	
            	//File  file = new File("G:/REPLY_INFO.20160829.20160828.D.00.DG.QC.xml");
            	
                /*FileOutputStream inputFile = new FileOutputStream(file);
                byte[] buffer = new byte[(int)file.length()];
                while(){
                	
                }
    	        inputFile.read(buffer);*/
    	        //inputFile.close();
    	        //String str=new BASE64Encoder().encode(buffer);
    	        //System.out.println(str);
    	        
            }
            return null;
        } catch (Exception e) {
        	WbtimerJobLogger.log(e.getMessage());
        	e.printStackTrace();
        }finally{
            try{
                if(in!=null){
                    in.close();
                }
                if(conn!=null )
                	conn.disconnect();
            }catch(IOException e){
            	WbtimerJobLogger.log(e.getMessage());
            }
        }
        return null;
	}
	public static InputStream getInputStream(String sourUrl){
		InputStream in =null;
		try {
		URL url = new URL(sourUrl);
	    URLConnection uc;
		
			 uc = url.openConnection();
			 uc.setConnectTimeout(3000);  
			 uc.setReadTimeout(3000);  
			 in = uc.getInputStream();  
			 return in;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
		
		
	}
	 	
	
}  