package org.xavier.spring.common;

import org.xavier.spring.common.enums.EnvironmentEnum;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.24
 * @since Jdk 1.8
 */
public class HyggeContext {
    /**
     * 当前运行环境 ApplicationEnvironmentPreparedEventHyggeSpringBeanRegister 中会尝试重新赋值
     */
    public volatile static EnvironmentEnum currentEnvironment = EnvironmentEnum.PREDEV;

    /**
     * 应用名称 ApplicationEnvironmentPreparedEventHyggeSpringBeanRegister 中会尝试重新赋值
     */
    public volatile static String appName = null;
}