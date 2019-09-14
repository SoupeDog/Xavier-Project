package org.xavier.common.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;
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
    private final HyggeLogSetting setting;
    private final LoggerContext logContext;
    private final Configuration logConfiguration;

    public HyggeLoggerBuilder(HyggeLogSetting setting, LoggerContext logContext) {
        this.setting = setting;
        this.logContext = logContext;
        this.logConfiguration = this.logContext.getConfiguration();
    }

    public void buildFrameworkLogger() {
        if (setting == null) {
            throw new SpringBootUtilRuntimeException("[HyggeLogSetting] can't be null.");
        }
        setting.propertiesCheck();
        Appender appender = createFrameworkAppender();
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
            throw new SpringBootUtilRuntimeException("[HyggeLogSetting] can't be null.");
        }
        setting.propertiesCheck();
        Appender appender = createAppAppender();
        AppenderRef ref = AppenderRef.createAppenderRef(HyggeLogger.DEFAULT_LOGGER_NAME, null, null);
        AppenderRef[] refs = new AppenderRef[]{ref};
        appender.start();
        LoggerConfig loggerConfig = LoggerConfig.createLogger(
                false, Level.getLevel(setting.getLogLevel().getDescription()), HyggeLogger.DEFAULT_LOGGER_NAME, "true", refs, null, logConfiguration, null);
        appender.start();
        loggerConfig.addAppender(appender, null, null);
        logConfiguration.addLogger(HyggeLogger.DEFAULT_LOGGER_NAME, loggerConfig);
        this.logContext.updateLoggers();
    }

    private Layout crateLayout(String patten, Configuration logConfiguration) {
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

    private Appender createAppAppender() {
        Appender result;
        HyggeTriggeringPolicy hyggeTriggeringPolicy = new HyggeTriggeringPolicy(setting, logConfiguration);
        String appPatten = createAppPatten();
        Layout layout = crateLayout(appPatten, logConfiguration);
        switch (setting.getMode()) {
            case FILE:
                result = RollingFileAppender.newBuilder().withFileName(setting.getFilePath() + setting.getAppName() + "_app.log")
                        .withFilePattern(setting.getFilePath() + setting.getAppName() + "%d{yyyy-MM-dd}_%i_app.log")
                        .setName("appFileJsonAppender")
                        .withPolicy(hyggeTriggeringPolicy)
                        .setLayout(layout)
                        .withLocking(false)
                        .build();
                break;
            default:
                result = ConsoleAppender.newBuilder().setName("appConsoleJsonAppender")
                        .setLayout(layout)
                        .build();
        }
        return result;
    }

    private String createAppPatten() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"projectName\":\"" + setting.getProjectName() + "\",")
                .append("\"appName\":\"" + setting.getAppName() + "\",")
                .append("\"source\":\"%c{1.}\",")
                .append("\"pid\":${sys:PID},")
                .append("\"hostName\":\"${hostName}\",")
                .append("\"version\":\"" + setting.getVersion() + "\",")
                .append("\"level\":\"%level\",")
                .append("\"ts\":%d{UNIX_MILLIS}{UTC},");
        formatESCAPE(stringBuilder);
        return stringBuilder.toString();
    }

    private Appender createFrameworkAppender() {
        Appender result;
        HyggeTriggeringPolicy hyggeTriggeringPolicy = new HyggeTriggeringPolicy(setting, logConfiguration);
        String frameworkPatten = createFrameworkPatten();
        Layout layout = crateLayout(frameworkPatten, logConfiguration);
        switch (setting.getMode()) {
            case FILE:
                result = RollingFileAppender.newBuilder().withFileName(setting.getFilePath() + setting.getAppName() + "_frwk.log")
                        .withFilePattern(setting.getFilePath() + setting.getAppName() + "%d{yyyy-MM-dd}_%i_frwk.log")
                        .setName("frwkFileJsonAppender")
                        .withPolicy(hyggeTriggeringPolicy)
                        .setLayout(layout)
                        .withLocking(false)
                        .build();
                System.out.println(result);
                break;
            default:
                result = ConsoleAppender.newBuilder().setName("frwkConsoleJsonAppender")
                        .setLayout(layout)
                        .build();
        }
        return result;
    }

    private String createFrameworkPatten() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"type\":\"framework\",")
                .append("\"source\":\"%c{1.}\",")
                .append("\"pid\":${sys:PID},")
                .append("\"hostName\":\"${hostName}\",")
                .append("\"version\":\"" + setting.getVersion() + "\",")
                .append("\"level\":\"%level\",")
                .append("\"ts\":%d{UNIX_MILLIS}{UTC},");
        formatESCAPE(stringBuilder);
        return stringBuilder.toString();
    }

    private void formatESCAPE(StringBuilder stringBuilder) {
        switch (setting.getTemplate()) {
            case ESCAPE:
                stringBuilder.append("\"msg\":\"%escapeJMsg{%msg}\",")
                        .append("\"error\":\"%escapeJMsg{%xwEx}\"}%n");
                break;
            default:
                stringBuilder.append("\"msg\":\"%msg\",")
                        .append("\"error\":\"%xwEx\"}%n");
        }
    }
}