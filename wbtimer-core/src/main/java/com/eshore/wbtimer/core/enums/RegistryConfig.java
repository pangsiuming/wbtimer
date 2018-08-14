package com.eshore.wbtimer.core.enums;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-01-10 17:53
 */
public class RegistryConfig {
    public static final int BEAT_TIMEOUT = 30;
    public static final int DEAD_TIMEOUT = BEAT_TIMEOUT * 3;

    public enum RegistType{ EXECUTOR, ADMIN }
}
