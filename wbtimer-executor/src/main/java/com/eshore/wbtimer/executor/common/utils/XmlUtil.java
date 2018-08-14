package com.eshore.wbtimer.executor.common.utils;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class XmlUtil {
	public static Document createDoc(String str,String encode) throws DocumentException {
		if (str == null) {
			return null; 
		}
		try {
			str=new String(str.getBytes(),encode);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
			
		
		ByteArrayInputStream in = null;
		Document doc = null;
		try {
			
			in = new ByteArrayInputStream(str.getBytes());
			SAXReader saxReader = new SAXReader();
			saxReader.setEncoding(encode);  
			doc = saxReader.read(in);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				WbtimerJobLogger.log(e);
			}
		}
		return doc;
	}

	public static List getNode(Document doc, String xpath) {
		List list = doc.selectNodes(xpath);
		return list;
	}

	public static String getNodeText(Document doc, String xpath) {
		List list = getNode(doc, xpath);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return ((Node) list.get(0)).getText();
		}
	}
	
	/** 
	  * 替换�?��字符串中的某些指定字�?
	  * @param strData String 原始字符�?
	  * @param regex String 要替换的字符�?
	  * @param replacement String 替代字符�?
	  * @return String 替换后的字符�?
	  */  
	 public static String replaceString(String strData, String regex,  
	         String replacement)  
	 {  
	     if (strData == null)  
	     {  
	         return null;  
	     }  
	     int index;  
	     index = strData.indexOf(regex);  
	     String strNew = "";  
	     if (index >= 0)  
	     {  
	         while (index >= 0)  
	         {  
	             strNew += strData.substring(0, index) + replacement;  
	             strData = strData.substring(index + regex.length());  
	             index = strData.indexOf(regex);  
	         }  
	         strNew += strData;  
	         return strNew;  
	     }  
	     return strData;  
	 }  
	  
	 /** 
	  * 替换字符串中特殊字符 
	  */  
	public static String encodeString(String strData)  
	 {  
	     if (strData == null)  
	     {  
	         return "";  
	     }  
	     strData = replaceString(strData, "&", "&amp;");  
	     strData = replaceString(strData, "<", "&lt;");  
	     strData = replaceString(strData, ">", "&gt;");  
	     strData = replaceString(strData, "&apos;", "&apos;");  
	     strData = replaceString(strData, "\"", "&quot;");  
	     return strData;  
	 }  
	  
	 /** 
	  * 还原字符串中特殊字符 
	  */  
	public static String decodeString(String strData)  
	 {  
	     strData = replaceString(strData, "&lt;", "<");  
	     strData = replaceString(strData, "&gt;", ">");  
	     strData = replaceString(strData, "&apos;", "&apos;");  
	     strData = replaceString(strData, "&quot;", "\"");  
	     strData = replaceString(strData, "&amp;", "&");  
	     return strData;  
	 } 

	public static void main(String args[]) {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><webserviceResponse>	<result>1</result>	<info></info>	<item>		<itemId>93409f752fc244f999d5954941a3945b</itemId>		<itemName>��Ϣ����</itemName>	</item>	<item>		<itemId>a2fbdef28591458eabc672009211b62a</itemId>		<itemName>��������</itemName>	</item>	<item>		<itemId>b335b4300a174417899e2d74b2696151</itemId>		<itemName>����Ч��</itemName>	</item>	<item>		<itemId>adc55f8800504ed9a3d183ff26bed3d0</itemId>		<itemName>Ⱥ���ȵ���</itemName>	</item>	<item>		<itemId>ec823dfb833244d290189f035ea1752c</itemId>		<itemName>��������</itemName>	</item></webserviceResponse>";
		try {
			Document doc = XmlUtil.createDoc(str,"GBK");
			System.out.println(doc);
			List l = XmlUtil.getNode(doc, "/webserviceResponse/item");
			System.out.println(l.size() + l.toString());
			for (int i = 0; i < l.size(); i++) {
				System.out.println(i+":"+((Element) l.get(i)).element("itemId").asXML());
			}
			System.out.println(XmlUtil.getNodeText(doc, "/webserviceResponse/result"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			WbtimerJobLogger.log(e);
		}
	}
}
