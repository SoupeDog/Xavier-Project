package org.xavier.common.enums;

/**
 * 描述信息：<br/>
 * 指定特定接口 String 返回值用枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.12.22
 * @since Jdk 1.8
 */
public enum StringFormatMode {
    DEFAULT("保持原文"),
    UPPERCASE("大写"),
    LOWERCASE("小写");

    private String description;

    StringFormatMode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
