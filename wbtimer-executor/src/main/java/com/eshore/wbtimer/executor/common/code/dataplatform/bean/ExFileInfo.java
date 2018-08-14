package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:14
 */
public class ExFileInfo {
    private List<Files> files;


    public List<Files> getFiles() {
        return files;
    }


    public void setFiles(List<Files> files) {
        this.files = files;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<" + XmlEleEnum.EXFILE.getValue()+ ">");

        if (null != files) {
            for (Files file : files) {
                sb.append(file.toString());
            }
        }
        sb.append("</" + XmlEleEnum.EXFILE.getValue() +  ">");
        return sb.toString();
    }
}
