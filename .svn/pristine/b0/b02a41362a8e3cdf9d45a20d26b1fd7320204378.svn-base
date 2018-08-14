package com.eshore.wbtimer.core.utils;

import org.springframework.beans.factory.FactoryBean;

public class EncryptDBPasswordFactory implements FactoryBean {
    private String encryptedPasswd;

    public Object getObject()
            throws Exception
    {
        return EncryptWorker.getDecodeString(this.encryptedPasswd);
    }

    public Class getObjectType()
    {
        return String.class;
    }

    public boolean isSingleton()
    {
        return true;
    }

    public void setEncryptedPasswd(String encryptedPasswd)
    {
        this.encryptedPasswd = encryptedPasswd;
    }
}
