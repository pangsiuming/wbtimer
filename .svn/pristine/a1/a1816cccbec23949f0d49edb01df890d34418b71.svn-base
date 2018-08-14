package com.eshore.wbtimer.executor.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:37
 */
public class StringHelperUtil {

    public static boolean isEmpty(String str) {
        return (null == str || "".equals(str)) ? true : false;
    }

    public static String trimToEmpty(String str) {
        return str != null ? str.trim() : "";
    }

    public static String handleNull(Object obj) {
        if (obj instanceof Date) return handleDate((Date)obj);
        return (null == obj) ? "" : trimToEmpty(obj.toString());
    }

    public static String handleNULL(Object input, String def) {
        if (null == input || input.toString().length() <= 0
                || input.toString().toLowerCase().equals("null")) {
            return def;
        } else {
            return input.toString();
        }
    }

    public static String handleDate(Date date) {
        return handleDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String handleDate(Date date, String dateFmtStr) {
        return (null == date) ? handleNull(date) : new SimpleDateFormat(dateFmtStr).format(date);
    }

    /**
     * 锟芥换一锟斤拷锟街凤拷锟叫碉拷某些指锟斤拷锟街凤拷
     *
     * @param strData
     *            String 原始锟街凤拷
     * @param regex
     *            String 要锟芥换锟斤拷锟街凤拷
     * @param replacement
     *            String 锟斤拷锟斤拷址锟�
     * @return String 锟芥换锟斤拷锟斤拷址锟�
     */
    public static String replaceString(String strData, String regex, String replacement) {
        if (strData == null) {
            return null;
        }
        int index;
        index = strData.indexOf(regex);
        String strNew = "";
        if (index >= 0) {
            while (index >= 0) {
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
     * 锟芥换锟街凤拷锟斤拷锟斤拷锟斤拷锟街凤拷
     */
    public static String encodeString(String strData) {
        if (strData == null) {
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
     * 锟斤拷原锟街凤拷锟斤拷锟斤拷锟斤拷锟街凤拷
     */
    public static String decodeString(String strData) {
        strData = replaceString(strData, "&lt;", "<");
        strData = replaceString(strData, "&gt;", ">");
        strData = replaceString(strData, "&apos;", "&apos;");
        strData = replaceString(strData, "&quot;", "\"");
        strData = replaceString(strData, "&amp;", "&");
        return strData;
    }
}

