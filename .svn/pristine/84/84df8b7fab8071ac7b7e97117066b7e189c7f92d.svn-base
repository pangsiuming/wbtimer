package com.eshore.wbtimer.admin.core.util;

import com.eshore.wbtimer.core.utils.PropertiesUtil;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-10 18:09
 */
public class MailUtil {
    private static Logger logger = LoggerFactory.getLogger(MailUtil.class);

    private static String host;
    private static String port;
    private static String username;
    private static String password;
    private static String sendNick;
    static{
        host = PropertiesUtil.getString("wbtimer.admin.mail.host");
        port = PropertiesUtil.getString("wbtimer.admin.mail.port");
        username = PropertiesUtil.getString("wbtimer.admin.mail.username");
        password = PropertiesUtil.getString("wbtimer.admin.mail.password");
        sendNick = PropertiesUtil.getString("wbtimer.admin.mail.sendNick");
    }

    /**
     *
     * @param toAddress		收件人邮箱
     * @param mailSubject	邮件主题
     * @param mailBody		邮件正文
     * @return
     */
    public static boolean sendMail(String toAddress, String mailSubject, String mailBody){

        try {
            // Create the email message
            HtmlEmail email = new HtmlEmail();

            //email.setDebug(true);		// 将会打印一些log
            //email.setTLS(true);		// 是否TLS校验，，某些邮箱需要TLS安全校验，同理有SSL校验
            //email.setSSL(true);

            email.setHostName(host);
            email.setSmtpPort(Integer.valueOf(port));
            //email.setSslSmtpPort(port);
            email.setAuthenticator(new DefaultAuthenticator(username, password));
            email.setCharset(Charset.defaultCharset().name());

            email.setFrom(username, sendNick);
            email.addTo(toAddress);
            email.setSubject(mailSubject);
            email.setMsg(mailBody);

            //email.attach(attachment);	// add the attachment

            email.send();				// send the email
            return true;
        } catch (EmailException e) {
            logger.error(e.getMessage(), e);

        }
        return false;
    }

}
