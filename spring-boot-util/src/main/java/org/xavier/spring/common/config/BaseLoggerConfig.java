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
public abstract class BaseLoggerConfig {
    /**
     * 项目名称
     */
    protected String projectName;
    /**
     * 应用名称
     */
    protected String appName;
    /**
     * 应用版本号
     */
    protected String version;
    /**
     * 当前运行环境
     */
    protected EnvironmentEnum currentEnvironment;
    /**
     * 自定义日志工具最低输出级别 ApplicationEnvironmentPreparedEventHyggeSpringBeanRegister 中会尝试重新赋值
     */
    protected LoggerLevelEnum logLevel;
    /**
     * 自定义日志工具文件输出路径 ApplicationEnvironmentPreparedEventHyggeSpringBeanRegister 中会尝试重新赋值
     */
    protected String filePath;
    /**
     * 单个日志文件最大文件大小  10MB 、10KB
     */
    protected String maxFileSize;
    /**
     * 日志文件变更 cron 表达式
     */
    protected String cronTrigger;

    /**
     * 校验日志参数
     */
    public abstract void propertiesCheck();

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getCronTrigger() {
        return cronTrigger;
    }

    public void setCronTrigger(String cronTrigger) {
        this.cronTrigger = cronTrigger;
    }
}