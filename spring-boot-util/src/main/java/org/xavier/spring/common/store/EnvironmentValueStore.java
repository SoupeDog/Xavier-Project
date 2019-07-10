package org.xavier.spring.common.store;

/**
 * 描述信息：<br/>
 * 环境静态常量值仓库
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/7/10
 * @since Jdk 1.8
 */
public class EnvironmentValueStore {
    /**
     * 预开发环境 字符串
     */
    public static final String PREDEV_STRING = "predev";
    /**
     * 开发环境 字符串
     */
    public static final String DEV_STRING = "dev";
    /**
     * 系统整合测试环境 字符串
     */
    public static final String INT_STRING = "int";
    /**
     * 灰度测试环境 字符串
     */
    public static final String VIP_STRING = "vip";
    /**
     * 正式环境 字符串
     */
    public static final String PROD_STRING = "prod";
}