package com.eshore.wbtimer.executor.common.exception;

import com.poson.ibsspub.util.MessageFormatter;

/**
 * 描述:
 *
 * @author Yjm
 * @create 2018/5/24 12:31
 */
public class CRMException extends RuntimeException
{

    public CRMException(String expCode, String expDesc)
    {
        super(String.format("\u3010\u5F02\u5E38\u7F16\u7801\u662F\uFF1A%s\uFF1B\u5F02\u5E38\u63D0\u793A\u662F\uFF1A%s\u3011", new Object[] {
                expCode != null ? expCode : "-10000", expDesc
        }));
        this.expCode = expCode != null ? expCode : "-10000";
        this.expDesc = expDesc;
    }

    public  CRMException(String expCode, String expDesc, Object objs[])
    {
        this(expCode, expDesc);
        this.expDesc = MessageFormatter.arrayFormat(expDesc, objs);
    }

    public CRMException(String expCode, String expDesc, Throwable cause)
    {
        this(expCode, expDesc);
        super.initCause(cause);
    }

    public String getExpCode()
    {
        return expCode;
    }

    public void setExpCode(String expCode)
    {
        this.expCode = expCode;
    }

    public String getExpDesc()
    {
        return expDesc;
    }

    public void setExpDesc(String expDesc)
    {
        this.expDesc = expDesc;
    }

    private static final long serialVersionUID = 4627701914295612919L;
    public static final String UNKNOWN_EXCEPTION = "-10000";
    private String expCode;
    private String expDesc;
}

