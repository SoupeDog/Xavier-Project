package org.xavier.common.utils.bo;

/**
 * 描述信息：<br/>
 * 排序类型枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/5
 * @since Jdk 1.8
 */
public enum SortedTypeEnum {
    DEFAULT(0, "无序"),
    DESC(1, "降序"),
    ASC(2, "升序");

    /**
     * 排序类型标识符
     */
    private byte val;
    /**
     * 描述信息
     */
    private String description;

    SortedTypeEnum(Number val, String description) {
        this.val = val.byteValue();
        this.description = description;
    }

    public byte getVal() {
        return val;
    }

    public String getDescription() {
        return description;
    }
}