package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import com.eshore.wbtimer.executor.enums.XmlEleEnum;

import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:14
 */
public class ItemInfoBean {
    private String deptCode; // 部门编码
    private String winCode; // 申办流水号
    private String itemCode; // 事项编码
    private String action; // 操作

    private BaseInfoBean baseInfoBean;
    private List<UnitInfoBean> unitInfos;
    private List<ItemSonBean> itemSonBeans;
    private DocBean docBean;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getWinCode() {
        return winCode;
    }

    public void setWinCode(String winCode) {
        this.winCode = winCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public BaseInfoBean getBaseInfoBean() {
        return baseInfoBean;
    }

    public List<UnitInfoBean> getUnitInfos() {
        return unitInfos;
    }

    public void setUnitInfos(List<UnitInfoBean> unitInfos) {
        this.unitInfos = unitInfos;
    }

    public void setBaseInfoBean(BaseInfoBean baseInfoBean) {
        this.baseInfoBean = baseInfoBean;
    }


    public List<ItemSonBean> getItemSonBeans() {
        return itemSonBeans;
    }

    public void setItemSonBeans(List<ItemSonBean> itemSonBeans) {
        this.itemSonBeans = itemSonBeans;
    }

    public DocBean getDocBean() {
        return docBean;
    }

    public void setDocBean(DocBean docBean) {
        this.docBean = docBean;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<" + XmlEleEnum.ITEMINFO.getValue() + " " + XmlEleEnum.ITEMINFO_DEPTCODE.getValue() + "=\"" + deptCode + "\" "
                + XmlEleEnum.ITEMINFO_WINCODE.getValue() + "=\"" + winCode + "\" " + XmlEleEnum.ITEMINFO_ITEMCODE.getValue() + "=\"" + itemCode
                + "\" " + XmlEleEnum.ITEMINFO_ACTION.getValue() + "=\"" + action + "\" >");
        if (null != baseInfoBean)
            sb.append(baseInfoBean.toString());
        if (null != unitInfos) {
            for (UnitInfoBean unitInfoBean : unitInfos) {
                sb.append(unitInfoBean.toString());
            }
        }
        if (null != itemSonBeans) {
            for (ItemSonBean itemSonBean : itemSonBeans) {
                sb.append(itemSonBean.toString());
            }
        }
        if (null != docBean) {
            sb.append(docBean.toString());
        }
        sb.append("</" + XmlEleEnum.ITEMINFO.getValue() + ">");
        return sb.toString();
    }

}
