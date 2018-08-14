package com.eshore.wbtimer.executor.common.net;

import com.eshore.gov.util.NfsUtil;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.constants.CommConstants;
import com.eshore.wbtimer.executor.service.CfgContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
* <p>Title: NFS工具类</p>
* <p>Description: 统一NFS工具类</p>
* @author Yangjinming
* @date  2017-11-14
*/
public class FtpManager { 
	private static final Logger logger = LoggerFactory.getLogger(FtpManager.class);
	private static final String NFS_PATH="/home/nfs_zhwbFtp";
	/**
	 * 上传文件
	 * 
	 * @param cfgContentService
	 * @param root
	 * @param fileName
	 * @param fileInputStream 需要转换为inputstream
	 * @return 返回路径
	 */
	public static String upload(CfgContentService cfgContentService, String root, String fileName, InputStream fileInputStream) throws Exception{
		String isUpload = "";
		String nfsFileName="";
		isUpload =  uploadByInputStream(root,fileName, fileInputStream);
		if("SUCCESS".equals(isUpload)){
			nfsFileName = root+fileName;
			return nfsFileName;
		}
		throw new RuntimeException("NFS上传文件失败！");
	}
	
	/**
	 * 从FTP服务器获取  byte  默认
	 * 
	 * @param cfgContentService
	 * @param fileUrl
	 * @return
	 * @throws Exception
	 */
	public static byte[] getFileFromFTP(CfgContentService cfgContentService, String fileUrl) throws Exception{
		return getFileFromFTP(cfgContentService, fileUrl, CommConstants.DOC_SUBMIT_SET);
	}
	
 
	
   /**
	 * 从FTP服务器获取  byte
	 * @param cfgContentService
	 * @param fileUrl
	 * @param typeCode
	* @return
	 * @throws Exception
	 */
	public static byte[] getFileFromFTP(CfgContentService cfgContentService, String fileUrl, String typeCode) throws Exception{
        //全路径
		File file= download(fileUrl);
		byte buffer[] =null;
		String out="";
		if(file!=null&&file.isFile()){
			out="从NFS下载";
			buffer= getBytes(file);
		}
		else{
			out="下载数据为空";
	    }
		if(buffer==null||buffer.length<=1){
			WbtimerJobLogger.log(String.format(out+"附件下载失败。,typeCode为:%s,附件路径为:%s",typeCode,fileUrl));
			return new byte[0];
		}
		return buffer;
	} 
	
	
	/**
	 * 上传到Ftp（通过inputStream）
	 * 
	 * @param basePath
	 * @param fileName
	 * @param inputStream
	 * @return
	 */
	public static String uploadByInputStream(String basePath,String fileName,InputStream inputStream){
		String result ="";
		try{
			NfsUtil nfsUtil = new NfsUtil(NFS_PATH);
			fileName =new String(fileName.getBytes("GBK"),"iso-8859-1");
			result = nfsUtil.uploadFile4InputSteam(inputStream,basePath, fileName);
 		}catch(Exception e){
			logger.error("failed!",e);
		    result = "";
		}finally{
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
		
	} 	 
	
	
	/**
	 * 从Ftp下载file
	 * 
	 * @param fileName
	 * @return
	 */
	public static File download(String fileName){
		File file = null;
		try{
			fileName=new String(fileName.getBytes("GBK"),"iso-8859-1");
			NfsUtil nfsUtil = new NfsUtil(NFS_PATH);
			file = nfsUtil.loadDownFile(fileName);
		}catch (Exception e) {
			logger.error("failed",e);
		}
		return file;
	}
	
	/**
	 * 从Ftp删除
	 * 
	 * @param cfgContentService
	 * @param fileName
	 * @return
	 */
	public static boolean delete(CfgContentService cfgContentService, String fileName){
		boolean result =false; 
	    try{
	        NfsUtil nfsUtil = new NfsUtil(NFS_PATH);
			fileName=new String(fileName.getBytes("GBK"),"iso-8859-1");
	        result=nfsUtil.deleteFile(fileName);
	    }catch(Exception e){
	    	logger.error("failed",e);
	    	result = false;
	    }
		return result;
	}
	
	
	public static byte[] getBytes(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		// 获取文件大小
		long length = file.length();
		WbtimerJobLogger.log("下载文件大小:"+length);
		if (length > Integer.MAX_VALUE) {
			// 文件太大，无法读取
			throw new IOException("File is to large " + file.getName());
		}
		// 创建一个数据来保存文件数据
		byte[] bytes = new byte[(int) length];
		// 读取数据到byte数组中
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		// 确保所有数据均被读取
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}
		// Close the input stream and return bytes
		is.close();
		return bytes;
	}
}