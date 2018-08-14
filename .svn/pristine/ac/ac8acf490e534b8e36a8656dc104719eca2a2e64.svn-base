package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:13
 */
public class ExInfoBean {
    private StandardInfoBean standardInfoBean; // 标准受理交换数据
    private SbInfoBean sbInfoBean; // 申办信息
    private ItemInfoBean itemInfoBean; // 订单信息
    private ExFileInfo exFileInfo; // 附件信息



    public StandardInfoBean getStandardInfoBean() {
        return standardInfoBean;
    }

    public void setStandardInfoBean(StandardInfoBean standardInfoBean) {
        this.standardInfoBean = standardInfoBean;
    }

    public SbInfoBean getSbInfoBean() {
        return sbInfoBean;
    }

    public void setSbInfoBean(SbInfoBean sbInfoBean) {
        this.sbInfoBean = sbInfoBean;
    }

    public ItemInfoBean getItemInfoBean() {
        return itemInfoBean;
    }

    public void setItemInfoBean(ItemInfoBean itemInfoBean) {
        this.itemInfoBean = itemInfoBean;
    }



    public ExFileInfo getExFileInfo() {
        return exFileInfo;
    }

    public void setExFileInfo(ExFileInfo exFileInfo) {
        this.exFileInfo = exFileInfo;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<" + XmlEleEnum.EXINFO.getValue() + ">");
        if (null != standardInfoBean)
            sb.append(standardInfoBean.toString());
        if (null != sbInfoBean)
            sb.append(sbInfoBean.toString());
        if (null != itemInfoBean)
            sb.append(itemInfoBean.toString());
        if (null != exFileInfo)
            sb.append(exFileInfo.toString());
        sb.append("</" + XmlEleEnum.EXINFO.getValue() + ">");
        return sb.toString();
    }
}
