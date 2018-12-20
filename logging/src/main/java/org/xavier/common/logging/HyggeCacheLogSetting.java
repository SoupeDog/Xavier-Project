package org.xavier.common.logging;

import org.xavier.common.utils.PropertiesHelper;
import org.xavier.common.utils.UtilsCreator;

/**
 * 描述信息：<br/>
 * 日志配置文件
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.20
 * @since Jdk 1.8
 */
public class HyggeCacheLogSetting {
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 应用版本号
     */
    private String version;
    /**
     * 应用子版本号
     */
    private String subVersion;
    /**
     * 日志输入模板
     */
    private HyggeLoggerOutputTemplate template;
    /**
     * 日志输出模式
     */
    private HyggeLoggerOutputMode mode;

    public void propertiesCheck() {
        PropertiesHelper propertiesHelper = UtilsCreator.getInstance_DefaultPropertiesHelper();
        propertiesHelper.stringNotNull(projectName, "[projectName] can't be empty.");
        propertiesHelper.stringNotNull(appName, "[appName] can't be empty.");
        propertiesHelper.stringNotNull(version, "[version] can't be empty.");
        propertiesHelper.stringNotNull(subVersion, "[subVersion] can't be empty.");
        propertiesHelper.objNotNull(template, HyggeLoggerOutputTemplate.class, "[HyggeLoggerOutputTemplate] can't be empty.");
        propertiesHelper.objNotNull(mode, HyggeLoggerOutputMode.class, "[HyggeLoggerOutputMode] can't be empty.");
    }

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

    public String getSubVersion() {
        return subVersion;
    }

    public void setSubVersion(String subVersion) {
        this.subVersion = subVersion;
    }

    public HyggeLoggerOutputTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HyggeLoggerOutputTemplate template) {
        this.template = template;
    }

    public HyggeLoggerOutputMode getMode() {
        return mode;
    }

    public void setMode(HyggeLoggerOutputMode mode) {
        this.mode = mode;
    }
}
