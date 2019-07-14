package org.xavier.spring.common.enums;

import org.xavier.spring.common.exception.SpringBootUtilRuntimeException;
import org.xavier.spring.common.store.LoggerValueStore;

/**
 * 描述信息：<br/>
 * 日志级别
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/7/10
 * @since Jdk 1.8
 */
public enum LoggerLevelEnum {
    /**
     * 总是级别
     */
    ALWAYS(0, LoggerValueStore.ALWAYS_STRING),
    /**
     * 追踪级别
     */
    TRACE(1, LoggerValueStore.TRACE_STRING),
    /**
     * 调试级别
     */
    DEBUG(2, LoggerValueStore.DEBUG_STRING),

    /**
     * 内部信息级别
     */
    INFO(3, LoggerValueStore.INFO_STRING),
    /**
     * 警告级别
     */
    WARNING(4, LoggerValueStore.WARNING_STRING),
    /**
     * 错误级别
     */
    ERROR(5, LoggerValueStore.ERROR_STRING),
    /**
     * 关闭级别
     */
    OFF(6, LoggerValueStore.OFF_STRING);

    private Byte index;
    private String description;

    LoggerLevelEnum(Number index, String description) {
        this.index = index.byteValue();
        this.description = description;
    }

    public static LoggerLevelEnum formatByString(String target) {
        if (target == null) {
            throw new SpringBootUtilRuntimeException("[null] can't format to [LoggerLevelEnum].");
        }
        String temp = target.toUpperCase();
        switch (temp) {
            case LoggerValueStore.ALWAYS_STRING:
                return ALWAYS;
            case LoggerValueStore.DEBUG_STRING:
                return DEBUG;
            case LoggerValueStore.INFO_STRING:
                return INFO;
            case LoggerValueStore.WARNING_STRING:
                return WARNING;
            case LoggerValueStore.ERROR_STRING:
                return ERROR;
            default:
                throw new SpringBootUtilRuntimeException("[" + temp + "] can't format to [LoggerLevelEnum].");
        }
    }

    public Byte getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}