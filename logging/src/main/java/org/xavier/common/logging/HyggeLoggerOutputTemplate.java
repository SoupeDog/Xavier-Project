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
public enum HyggeLoggerOutputTemplate {
    DEFAULT(0, "默认值");

    private Byte index;
    private String description;

    HyggeLoggerOutputTemplate(Number index, String description) {
        this.index = index.byteValue();
        this.description = description;
    }
}