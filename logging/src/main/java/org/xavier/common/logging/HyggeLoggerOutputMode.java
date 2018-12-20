package org.xavier.common.logging;

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
    DEFAULT(0, "控制台"),
    FILE(1, "文件输出");

    private Byte index;
    private String description;

    HyggeLoggerOutputMode(Number index, String description) {
        this.index = index.byteValue();
        this.description = description;
    }
}