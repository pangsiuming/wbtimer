package com.eshore.wbtimer.executor.service.bean;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/1/29 15:09
 */
public class CommonResultBean extends DBTableParamBean implements Serializable {
    //特别程序标记 true 为 挂起，false 解挂
    private boolean tbFlag;
    //补正告之标记 true 为 挂起，false 解挂
    private boolean bjFlag;
    //子程序天数
    private Integer datesDelay;
    //子程序期限
    private Integer zcxsx;
    //子程序告警状态
    private String alertType;
    //子程序剩余天数
    private Integer restDay;

    public boolean isTbFlag() {
        return tbFlag;
    }

    public void setTbFlag(boolean tbFlag) {
        this.tbFlag = tbFlag;
    }

    public boolean isBjFlag() {
        return bjFlag;
    }

    public void setBjFlag(boolean bjFlag) {
        this.bjFlag = bjFlag;
    }

    public Integer getDatesDelay() {
        return datesDelay;
    }

    public void setDatesDelay(Integer datesDelay) {
        this.datesDelay = datesDelay;
    }

    public Integer getZcxsx() {
        return zcxsx;
    }

    public void setZcxsx(Integer zcxsx) {
        this.zcxsx = zcxsx;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public Integer getRestDay() {
        return restDay;
    }

    public void setRestDay(Integer restDay) {
        this.restDay = restDay;
    }
}
