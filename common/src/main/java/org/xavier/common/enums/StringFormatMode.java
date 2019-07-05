package org.xavier.common.enums;

/**
 * 描述信息：<br/>
 * 指定特定接口 String 类型枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/7/5
 * @since Jdk 1.8
 */
public enum StringFormatMode {
    /**
     * 默认保持原文
     */
    DEFAULT(0, "保持原文"),
    /**
     * 大写模式
     */
    UPPERCASE(1, "大写"),
    /**
     * 小写模式
     */
    LOWERCASE(2, "小写");

    /**
     * 序号
     */
    private Number index;

    /**
     * 描述信息
     */
    private String description;

    StringFormatMode(Number index, String description) {
        this.index = index;
        this.description = description;
    }

    public Number getIndex() {
        return index;
    }

    public void setIndex(Number index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}