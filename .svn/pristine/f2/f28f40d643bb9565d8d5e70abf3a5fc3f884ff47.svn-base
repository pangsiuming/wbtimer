package com.eshore.wbtimer.core.enums;

/**
 * 阻塞策略
 */
public enum ExecutorBlockStrategyEnum {
    DISCARD_LATER("等待当前调度完毕"),
    SERIAL_EXECUTION("新增一个调度串行处理"),
    /*CONCURRENT_EXECUTION("并行"),*/
    COVER_EARLY("覆盖之前调度");

    private final String title;
    private ExecutorBlockStrategyEnum(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public static ExecutorBlockStrategyEnum match(String name, ExecutorBlockStrategyEnum defaultItem) {
        if (name != null) {
            for (ExecutorBlockStrategyEnum item:ExecutorBlockStrategyEnum.values()) {
                if (item.name().equals(name)) {
                    return item;
                }
            }
        }
        return defaultItem;
    }
}
