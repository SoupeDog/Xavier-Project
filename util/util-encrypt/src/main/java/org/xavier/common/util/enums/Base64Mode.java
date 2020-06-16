package org.xavier.common.util.enums;

/**
 * 描述信息：<br/>
 * Base64 模式
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.04.10
 * @since Jdk 1.8
 */
public enum Base64Mode {
    /**
     * 默认
     */
    DEFAULT(1, "default");

    private final Integer index;
    private final String val;

    Base64Mode(Integer index, String val) {
        this.index = index;
        this.val = val;
    }

    public Integer getIndex() {
        return index;
    }

    public String getVal() {
        return val;
    }
}