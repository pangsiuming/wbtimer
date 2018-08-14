package com.eshore.wbtimer.admin.core.enums;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-11 10:09
 */
public enum ExecutorFailStrategyEnum {
    FAIL_ALARM("失败告警"),

    FAIL_RETRY("失败重试");

    private final String title;
    private ExecutorFailStrategyEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ExecutorFailStrategyEnum match(String name, ExecutorFailStrategyEnum defaultItem) {
        if (name != null) {
            for (ExecutorFailStrategyEnum item: ExecutorFailStrategyEnum.values()) {
                if (item.name().equals(name)) {
                    return item;
                }
            }
        }
        return defaultItem;
    }
}
