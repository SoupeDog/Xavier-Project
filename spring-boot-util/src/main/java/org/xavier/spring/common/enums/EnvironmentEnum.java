package org.xavier.spring.common.enums;

import org.xavier.spring.common.store.EnvironmentValueStore;
import org.xavier.spring.common.exception.SpringBootUtilRuntimeException;

/**
 * 描述信息：<br/>
 * 运行环境枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.24
 * @since Jdk 1.8
 */
public enum EnvironmentEnum {
    /**
     * 预开发环境
     */
    PREDEV(0, EnvironmentValueStore.PREDEV_STRING),
    /**
     * 开发环境
     */
    DEV(1, EnvironmentValueStore.DEV_STRING),
    /**
     * 系统整合测试环境
     */
    INT(2, EnvironmentValueStore.INT_STRING),
    /**
     * 灰度测试环境
     */
    VIP(3, EnvironmentValueStore.VIP_STRING),
    /**
     * 正式环境
     */
    PROD(4, EnvironmentValueStore.PROD_STRING);

    private Byte index;
    private String description;

    EnvironmentEnum(Number index, String description) {
        this.index = index.byteValue();
        this.description = description;
    }

    public static EnvironmentEnum formatByString(String target) {
        if (target == null) {
            throw new SpringBootUtilRuntimeException("[null] can't format to [EnvironmentEnum].");
        }
        String temp = target.toLowerCase();
        switch (temp) {
            case EnvironmentValueStore.PREDEV_STRING:
                return PREDEV;
            case EnvironmentValueStore.DEV_STRING:
                return DEV;
            case EnvironmentValueStore.INT_STRING:
                return INT;
            case EnvironmentValueStore.VIP_STRING:
                return VIP;
            case EnvironmentValueStore.PROD_STRING:
                return PROD;
            default:
                throw new SpringBootUtilRuntimeException("[" + temp + "] can't format to [EnvironmentEnum].");
        }
    }

    public Byte getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}