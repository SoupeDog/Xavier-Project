package org.xavier.spring.common;

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
     * 当前运行环境 HyggeSpringBeanRegister_ApplicationEnvironmentPreparedEvent 中会尝试重新赋值
     */
    public volatile static EnvironmentEnums CURRENT_ENVIRONMENT = EnvironmentEnums.PREDEV;

    /**
     * 应用名称 HyggeSpringBeanRegister_ApplicationEnvironmentPreparedEvent 中会尝试重新赋值
     */
    public volatile static String APP_NAME = "Unknown";
    /**
     * 自定义日志工具最低输出级别 HyggeSpringBeanRegister_ApplicationEnvironmentPreparedEvent 中会尝试重新赋值
     */
    public volatile static String HYGGELOGGER_LEVEL = "warning";
    /**
     * 自定义日志工具文件输出路径 HyggeSpringBeanRegister_ApplicationEnvironmentPreparedEvent 中会尝试重新赋值
     */
    public volatile static String HYGGELOGGER_FILE_PATH = "";
}