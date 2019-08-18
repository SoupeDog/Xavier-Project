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
import org.xavier.spring.common.enums.EnvironmentEnum;
import org.xavier.spring.common.exception.SpringBootUtilRuntimeException;

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

    public void buildFrameworkLogger(EnvironmentEnum environment) {
        if (setting == null) {
            throw new SpringBootUtilRuntimeException("[HyggeCacheLogSetting] can't be null.");
        }
        setting.propertiesCheck();
        Appender appender = getAppender(false, environment, setting.getMode());
        appender.start();
        LoggerConfig rootConfig = logConfiguration.getRootLogger();
        appender.start();
        logConfiguration.addAppender(appender);
        rootConfig.removeAppender("Console");
        rootConfig.addAppender(appender, Level.ALL, null);
        this.logContext.updateLoggers();
    }

    public void buildAppLogger(EnvironmentEnum environment) {
        if (setting == null) {
            throw new SpringBootUtilRuntimeException("[HyggeCacheLogSetting] can't be null.");
        }
        setting.propertiesCheck();
        Appender appender = getAppender(true, environment, setting.getMode());
        AppenderRef ref = AppenderRef.createAppenderRef(HyggeLogger.DEFAULT_LOGGER_NAME, null, null);
        AppenderRef[] refs = new AppenderRef[]{ref};
        appender.start();
        LoggerConfig loggerConfig = LoggerConfig.createLogger(
                false, stringToLevel(setting.getLogLevel().getDescription()), HyggeLogger.DEFAULT_LOGGER_NAME, "true", refs, null, logConfiguration, null);
        appender.start();
        loggerConfig.addAppender(appender, null, null);
        logConfiguration.addLogger(HyggeLogger.DEFAULT_LOGGER_NAME, loggerConfig);
        this.logContext.updateLoggers();
    }

    private Appender getAppender(Boolean isApp, EnvironmentEnum environment, HyggeLoggerOutputMode mode) {
        Appender result;
        if (isApp) {
            switch (mode) {
                case FILE:
                    FileAppender.Builder appenderBuilder = FileAppender.newBuilder();
                    appenderBuilder.withFileName(setting.getFilePath() + setting.getAppName() + "_app.log").
                            withLocking(false).
                            setName("frwkFileJsonAppender").
                            setLayout(getLayout(
                                    getPatten(isApp, environment, setting.getProjectName(),
                                            setting.getVersion(),
                                            setting.getAppName()),
                                    logConfiguration));
                    result = appenderBuilder.build();
                    break;
                default:
                    ConsoleAppender.Builder cons = ConsoleAppender.newBuilder();
                    cons.setLayout(getLayout(
                            getPatten(isApp, environment, setting.getProjectName(),
                                    setting.getVersion(),
                                    setting.getAppName()),
                            logConfiguration)).
                            setName("frwkConsoleJsonAppender");
                    result = cons.build();
            }
        } else {
            switch (mode) {
                case FILE:
                    FileAppender.Builder appenderBuilder = FileAppender.newBuilder();
                    appenderBuilder.withFileName(setting.getFilePath() + setting.getAppName() + "_frwk.log").
                            withLocking(false).
                            setName("frwkFileJsonAppender").
                            setLayout(getLayout(
                                    getPatten(isApp, environment, setting.getProjectName(),
                                            setting.getVersion(),
                                            setting.getAppName()),
                                    logConfiguration));
                    result = appenderBuilder.build();
                    break;
                default:
                    ConsoleAppender.Builder cons = ConsoleAppender.newBuilder();
                    cons.setLayout(getLayout(
                            getPatten(isApp, environment, setting.getProjectName(),
                                    setting.getVersion(),
                                    setting.getAppName()),
                            logConfiguration)).
                            setName("frwkConsoleJsonAppender");
                    result = cons.build();
            }
        }
        return result;
    }


    private Layout getLayout(String patten, Configuration logConfiguration) {
        PatternLayout.Builder layoutBuilder = PatternLayout.newBuilder();
        layoutBuilder.withPattern(patten).
                withPatternSelector(null).
                withConfiguration(logConfiguration).
                withRegexReplacement(null).
                withCharset(null).
                withAlwaysWriteExceptions(true).
                withNoConsoleNoAnsi(false).
                withHeader(null).
                withFooter(null);
        PatternLayout result = layoutBuilder.build();
        return result;
    }

    private String getPatten(Boolean isApp, EnvironmentEnum environment, String projectName, String version, String appName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (isApp) {
            switch (setting.getTemplate()) {
                default:
                    switch (environment) {
                        case DEV:
                        case INT:
                        case VIP:
                        case PROD:
                            stringBuilder.append("{\"type\":\"" + projectName + "\",")
                                    .append("\"appName\":\"").append(appName).append("\",")
                                    .append("\"source\":\"%c{1.}\",")
                                    .append("\"pid\":${sys:PID},")
                                    .append("\"hostName\":\"${hostName}\",")
                                    .append("\"version\":").append(version).append(",")
                                    .append("\"level\":").append("\"%level\",")
                                    .append("\"ts\":%d{UNIX_MILLIS}{UTC},")
                                    .append("\"msg\":\"%escapeJMsg{%msg}\",")
                                    .append("\"error\":\"%escapeJMsg{%xwEx}\"}%n");
                            break;
                        default:
                            stringBuilder.append(projectName).append('\t')
                                    .append(version).append('\t')
                                    .append("%d{UNIX_MILLIS}{UTC}").append('\t')
                                    .append("%level").append('\t')
                                    .append("${sys:PID}").append('\t')
                                    .append("${hostName}").append('\t')
                                    .append(appName).append('\t').append("%msg%n");
                    }
            }
        } else {
            switch (setting.getTemplate()) {
                default:
                    switch (environment) {
                        case DEV:
                        case INT:
                        case VIP:
                        case PROD:
                            stringBuilder.append("{\"type\":\"framework\",")
                                    .append("\"source\":\"%c{1.}\",")
                                    .append("\"pid\":${sys:PID},")
                                    .append("\"hostName\":\"${hostName}\",")
                                    .append("\"version\":").append(version).append(",")
                                    .append("\"level\":").append("\"%level\",")
                                    .append("\"ts\":%d{UNIX_MILLIS}{UTC},")
                                    .append("\"msg\":\"%escapeJMsg{%msg}\",")
                                    .append("\"error\":\"%escapeJMsg{%xwEx}\"}%n");
                            break;
                        default:
                    }
            }
        }
        return stringBuilder.toString();
    }

    private Level stringToLevel(String levelStringVal) {
        switch (levelStringVal.toUpperCase()) {
            case "OFF":
                return Level.OFF;
            case "TRACE":
                return Level.TRACE;
            case "DEBUG":
                return Level.DEBUG;
            case "INFO":
                return Level.INFO;
            case "WARNING":
                return Level.WARN;
            case "ERROR":
                return Level.ERROR;
            default:
                return Level.WARN;
        }
    }
}