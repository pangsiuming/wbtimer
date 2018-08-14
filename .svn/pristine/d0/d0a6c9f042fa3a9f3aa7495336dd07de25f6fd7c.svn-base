package com.eshore.wbtimer.core.utils;

import java.io.PrintStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


public class EncryptWorker {

    protected static String getDecodeString(String strMi)
    {
        return getDecodeString(strMi, mainKey);
    }

    protected static String getEncodeString(String strMi)
    {
        return getEncodeString(strMi, mainKey);
    }

    protected static String getEncodeString(String strMi, Key key)
    {
        String strMing = null;
        try
        {
            byte[] byteMi = getEnsCode(strMi.getBytes(), key);
            byte[] byteMing = Base64.encodeBase64(byteMi);
            strMing = new String(byteMing, "UTF8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error when decoding. please check your jdbc configuration.");
        }
        return strMing;
    }

    protected static String getDecodeString(String strMi, byte[] bytesKey)
    {
        return getDecodeString(strMi, getKey(bytesKey));
    }

    protected static String getDecodeString(String strMi, Key key)
    {
        String strMing = null;
        try
        {
            byte[] byteMi = Base64.decodeBase64(strMi.getBytes());
            byte[] byteMing = getDesCode(byteMi, key);
            strMing = new String(byteMing, "UTF8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error when decoding. please check your jdbc configuration.");
        }
        return strMing;
    }

    protected static String deCodePasswd(String encyptedPasswd)
    {
        if (encyptedPasswd == null)
        {
            System.out.println("The argument[encyptedPasswd] is null. please check your code call method deCodePasswd().");
            return null;
        }
        String password;
        try
        {
            password = getDecodeString(encyptedPasswd.substring(5));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error when decrypted password. please check your code call method deCodePasswd().");
            return null;
        }
        return password;
    }

    private static byte[] getDesCode(byte[] byteD, Key key)
    {
        byte[] byteFina = null;
        try
        {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(2, key);
            byteFina = cipher.doFinal(byteD);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return byteFina;
    }

    private static byte[] getEnsCode(byte[] byteD, Key key)
    {
        byte[] byteFina = null;
        try
        {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(1, key);
            byteFina = cipher.doFinal(byteD);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return byteFina;
    }

    private static Key getKey(byte[] bytesKey)
    {
        byte[] kb = { 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < bytesKey.length; i++) {
            kb[(i % 8)] = ((byte)(kb[(i % 8)] + bytesKey[i]));
        }
        Key key = new SecretKeySpec(kb, "DES");
        return key;
    }

    private static Key initKey(byte[] keyBytes)
    {
        Key key = null;
        try
        {
            key = getKey(keyBytes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Attention!! The main key is not properly initialized.");
            return null;
        }
        return key;
    }

    private EncryptWorker()
    {
        throw new RuntimeException("This class is not allowed to be instantialize.");
    }

    public static void main(String[] args)
    {
        String strEncode = "hB+xPJIIyac=";
        System.out.println(getDecodeString(strEncode));
        System.out.println(getEncodeString("ecss"));
    }

    private static final Key mainKey = initKey(new byte[] { -46, -38, -47, -72, 53, 48, 53, -71, -85, -71, -78, -80, -4, 53, 48, 53, -57, -21, -50, -16, -73, -76, -79, -32, -46, -21 });
}
