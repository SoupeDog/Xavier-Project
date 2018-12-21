package org.xavier.common.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.xavier.common.exception.Universal_500_X_Exception_Runtime;

/**
 * 描述信息：<br/>
 * 日志工具构造器
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.20
 * @since Jdk 1.8
 */
public class HyggeLoggerBuilder {
    private final HyggeCacheLogSetting setting;
    private final LoggerContext logContext;
    private final Configuration logConfiguration;


    public HyggeLoggerBuilder(HyggeCacheLogSetting setting, LoggerContext logContext) {
        this.setting = setting;
        this.logContext = logContext;
        this.logConfiguration = this.logContext.getConfiguration();
    }

    public void buildFrameworkLogger() {
        if (setting == null) {
            throw new Universal_500_X_Exception_Runtime(555F, "[HyggeCacheLogSetting] can't be null.");
        }
        setting.propertiesCheck();
        Appender appender = getAppender(false, setting.getMode());
        appender.start();
        LoggerConfig rootConfig = logConfiguration.getRootLogger();
        appender.start();
        logConfiguration.addAppender(appender);
        rootConfig.removeAppender("Console");
        rootConfig.addAppender(appender, Level.ALL, null);
        this.logContext.updateLoggers();
    }

    public void buildAppLogger() {
        if (setting == null) {
            throw new Universal_500_X_Exception_Runtime(555F, "[HyggeCacheLogSetting] can't be null.");
        }
        setting.propertiesCheck();
        Appender appender = getAppender(true, setting.getMode());
        AppenderRef ref = AppenderRef.createAppenderRef(HyggeLogger.DEFAULT_LOGGER_NAME, null, null);
        AppenderRef[] refs = new AppenderRef[]{ref};
        appender.start();
        LoggerConfig loggerConfig = LoggerConfig.createLogger(
                false, Level.INFO, HyggeLogger.DEFAULT_LOGGER_NAME, "true", refs, null, logConfiguration, null);
        appender.start();
        loggerConfig.addAppender(appender, null, null);
        logConfiguration.addLogger(HyggeLogger.DEFAULT_LOGGER_NAME, loggerConfig);
        this.logContext.updateLoggers();
    }

    private Appender getAppender(Boolean isApp, HyggeLoggerOutputMode mode) {
        Appender result;
        if (isApp) {
            switch (mode) {
                case FILE:
                    FileAppender.Builder appenderbuilder = FileAppender.newBuilder();
                    appenderbuilder.withFileName(setting.getAppName() + "_app.log").
                            withLocking(false).
                            withName("frwkFileJsonAppender").
                            withLayout(getLayout(
                                    getPatten(isApp, setting.getProjectName(),
                                            setting.getVersion(),
                                            setting.getSubVersion(),
                                            setting.getAppName()),
                                    logConfiguration));
                    result = appenderbuilder.build();
                    break;
                default:
                    ConsoleAppender.Builder cons = ConsoleAppender.newBuilder();
                    cons.withLayout(getLayout(
                            getPatten(isApp, setting.getProjectName(),
                                    setting.getVersion(),
                                    setting.getSubVersion(),
                                    setting.getAppName()),
                            logConfiguration)).
                            withName("frwkConsoleJsonAppender");
                    result = cons.build();
            }
        } else {
            switch (mode) {
                case FILE:
                    FileAppender.Builder appenderbuilder = FileAppender.newBuilder();
                    appenderbuilder.withFileName(setting.getAppName() + "_frwk.log").
                            withLocking(false).
                            withName("frwkFileJsonAppender").
                            withLayout(getLayout(
                                    getPatten(isApp, setting.getProjectName(),
                                            setting.getVersion(),
                                            setting.getSubVersion(),
                                            setting.getAppName()),
                                    logConfiguration));
                    result = appenderbuilder.build();
                    break;
                default:
                    ConsoleAppender.Builder cons = ConsoleAppender.newBuilder();
                    cons.withLayout(getLayout(
                            getPatten(isApp, setting.getProjectName(),
                                    setting.getVersion(),
                                    setting.getSubVersion(),
                                    setting.getAppName()),
                            logConfiguration)).
                            withName("frwkConsoleJsonAppender");
                    result = cons.build();
            }
        }

        return result;
    }


    private Layout getLayout(String patten, Configuration logConfiguration) {
        PatternLayout.Builder laoutBuilder = PatternLayout.newBuilder();
        laoutBuilder.withPattern(patten).
                withPatternSelector(null).
                withConfiguration(logConfiguration).
                withRegexReplacement(null).
                withCharset(null).
                withAlwaysWriteExceptions(true).
                withNoConsoleNoAnsi(false).
                withHeader(null).
                withFooter(null);
        PatternLayout result = laoutBuilder.build();
        return result;
    }

    private String getPatten(Boolean isApp, String projectName, String version, String subVersion, String appName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (isApp) {
            switch (setting.getTemplate()) {
                default:
                    stringBuilder.append("{\"type\":\"" + projectName + "\",").append("\"version\":").append(version).append(",")
                            .append("\"subversion\":").append(subVersion).append(",")
                            .append("\"ts\":%d{UNIX_MILLIS}{UTC},")
                            .append("\"source\":\"%c{1.}\",").append("\"level\":")
                            .append("\"%level\"").append(",").append("\"hostname\":\"${hostName}\"").append(",")
                            .append("\"appname\":\"").append(appName).append("\",").append("\"pid\":${sys:PID},")
                            .append("\"msg\":\"%escapeJMsg{%msg}\",")
                            .append("\"error\":\"%escapeJMsg{%xwEx}\"}%n");
            }
        } else {
            switch (setting.getTemplate()) {
                default:
                    stringBuilder.append("{\"type\":\"framework\",").append("\"source\":\"%c{1.}\",")
                            .append("\"ts\":%d{UNIX_MILLIS}{UTC},")
                            .append("\"level\":").append("\"%level\"").append(",")
                            .append("\"hostname\":\"${hostName}\"").append(",")
                            .append("\"appname\":\"").append(appName).append("\",")
                            .append("\"pid\":${sys:PID},").append("\"msg\":\"%escapeJMsg{%msg}\",")
                            .append("\"error\":\"%escapeJMsg{%xwEx}\"}%n");
            }
        }
        return stringBuilder.toString();
    }

}