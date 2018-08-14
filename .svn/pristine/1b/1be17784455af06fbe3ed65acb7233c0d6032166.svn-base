package com.eshore.wbtimer.executor.common.net.bean;
import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 14:26
 */

public class DealResult {
    public static final String SUCCESS = "0";
    public static final String FAIL_CHECK = "1";
    public static final String FAIL_NOT_FILE = "2";
    public static final String FAIL_EXCEPTION = "3";
    public static final String FAIL_VALIDATE = "4";
    private String code;
    private String desc;
    private List<String> reasonList;

    public DealResult(){ }

    public String toString() {
        String str = "编码：" + code + ",原因：" + desc;
        if (reasonList != null && reasonList.size() > 0) {
            str += "缺少文件列表：";
            for (int i = 0; i < reasonList.size(); i++) {
                str += reasonList.get(i);
            }
        }
        return str;
    }

    public DealResult(String code, String desc) {
        super();
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getReasonList() {
        return reasonList;
    }

    public void setReasonList(List<String> reasonList) {
        this.reasonList = reasonList;
    }

}

