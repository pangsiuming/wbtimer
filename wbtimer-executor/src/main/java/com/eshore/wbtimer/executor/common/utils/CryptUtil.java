package com.eshore.wbtimer.executor.common.utils;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 11:51
 */
public class CryptUtil {
    public static String base64Encode(byte[] src){
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(src);
    }

    public static byte[] sha1Digest(byte[] src) throws NoSuchAlgorithmException {
        java.security.MessageDigest msg = java.security.MessageDigest.getInstance("SHA-1");
        msg.update(src);
        return msg.digest();
    }

    /**
     * @param src
     *            String
     * @return String
     */
    public static String urlEncode(String src) {
        try {
            src = java.net.URLEncoder.encode(src, "GB2312");

            return src;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return src;
    }

    public static byte[] base64Decode(String src){
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return decoder.decodeBuffer(src);
        } catch (IOException ex) {
            WbtimerJobLogger.log(ex.getMessage(),ex);
            return null;
        }
    }

}
