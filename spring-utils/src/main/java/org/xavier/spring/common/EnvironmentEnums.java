package org.xavier.spring.common;

/**
 * 描述信息：<br/>
 * 运行环境枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.24
 * @since Jdk 1.8
 */
public enum EnvironmentEnums {

    PREDEV(0, "predev"),
    DEV(1, "dev"),
    INT(2, "int"),
    VIP(3, "vip"),
    PROD(4, "prod");

    private Byte index;
    private String description;

    EnvironmentEnums(Number index, String description) {
        this.index = index.byteValue();
        this.description = description;
    }

    public Byte getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}