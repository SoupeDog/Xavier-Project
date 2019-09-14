package org.xavier.common.logging.enums;

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
    /**
     * 无编码
     */
    DEFAULT(0, "默认值"),
    /**
     * escape编码
     */
    ESCAPE(1, "escape编码");

    private Byte index;
    private String description;

    HyggeLoggerOutputTemplate(Number index, String description) {
        this.index = index.byteValue();
        this.description = description;
    }
}