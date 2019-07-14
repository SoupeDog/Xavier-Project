package org.xavier.common.logging;

import org.xavier.common.logging.store.OutPutModeValueStore;
import org.xavier.spring.common.exception.SpringBootUtilRuntimeException;

/**
 * 描述信息：<br/>
 * 日志模板
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.20
 * @since Jdk 1.8
 */
public enum HyggeLoggerOutputMode {
    /**
     * 控制台输出
     */
    CONSOLE(0, "控制台"),
    /**
     * 日志文件输出
     */
    FILE(1, "文件输出");

    private Byte index;
    private String description;

    public static HyggeLoggerOutputMode formatByString(String target) {
        if (target == null) {
            throw new SpringBootUtilRuntimeException("[null] can't format to [HyggeLoggerOutputMode].");
        }
        String temp = target.toLowerCase();
        switch (temp) {
            case OutPutModeValueStore.CONSOLE:
                return CONSOLE;
            case OutPutModeValueStore.FILE:
                return FILE;
            default:
                throw new SpringBootUtilRuntimeException("[" + temp + "] can't format to [HyggeLoggerOutputMode].");
        }
    }

    HyggeLoggerOutputMode(Number index, String description) {
        this.index = index.byteValue();
        this.description = description;
    }
}