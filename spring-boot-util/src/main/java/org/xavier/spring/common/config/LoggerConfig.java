package org.xavier.spring.common.config;

import org.xavier.spring.common.enums.EnvironmentEnum;
import org.xavier.spring.common.enums.LoggerLevelEnum;

/**
 * 描述信息：<br/>
 * 日志配置项
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/7/10
 * @since Jdk 1.8
 */
public class LoggerConfig {
    /**
     * 当前运行环境
     */
    private EnvironmentEnum currentEnvironment;
    /**
     * 自定义日志工具最低输出级别 ApplicationEnvironmentPreparedEventHyggeSpringBeanRegister 中会尝试重新赋值
     */
    protected LoggerLevelEnum logLevel = LoggerLevelEnum.WARNING;
    /**
     * 自定义日志工具文件输出路径 ApplicationEnvironmentPreparedEventHyggeSpringBeanRegister 中会尝试重新赋值
     */
    protected String filePath = null;

    public EnvironmentEnum getCurrentEnvironment() {
        return currentEnvironment;
    }

    public void setCurrentEnvironment(EnvironmentEnum currentEnvironment) {
        this.currentEnvironment = currentEnvironment;
    }

    public LoggerLevelEnum getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LoggerLevelEnum logLevel) {
        this.logLevel = logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = LoggerLevelEnum.formatByString(logLevel);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}