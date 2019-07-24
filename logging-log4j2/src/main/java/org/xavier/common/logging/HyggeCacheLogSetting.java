package org.xavier.common.logging;


import org.xavier.common.exception.PropertiesRuntimeException;
import org.xavier.common.util.PropertiesHelper;
import org.xavier.common.util.UtilsCreator;
import org.xavier.spring.common.config.LoggerConfig;
import org.xavier.spring.common.enums.EnvironmentEnum;

import java.util.Objects;

/**
 * 描述信息：<br/>
 * 日志配置文件
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.20
 * @since Jdk 1.8
 */
public class HyggeCacheLogSetting extends LoggerConfig {
    /**
     * 日志输入模板
     */
    private HyggeLoggerOutputTemplate template;
    /**
     * 日志输出模式
     */
    private HyggeLoggerOutputMode mode;

    @Override
    public void propertiesCheck() {
        PropertiesHelper propertiesHelper = UtilsCreator.getDefaultPropertiesHelperInstance();
        propertiesHelper.stringNotNull(projectName, "[projectName] can't be empty.");
        propertiesHelper.stringNotNull(appName, "[appName] can't be empty.");
        propertiesHelper.stringNotNull(version, "[version] can't be empty.");
        try {
            Objects.requireNonNull(template, "[HyggeLoggerOutputTemplate] can't be empty.");
            Objects.requireNonNull(template, "[HyggeLoggerOutputMode] can't be empty.");
        } catch (NullPointerException e) {
            throw new PropertiesRuntimeException(e.getMessage());
        }
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