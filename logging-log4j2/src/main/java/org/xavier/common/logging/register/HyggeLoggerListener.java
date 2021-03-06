package org.xavier.common.logging.register;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.xavier.common.logging.config.HyggeLogSetting;
import org.xavier.common.logging.HyggeLoggerBuilder;
import org.xavier.common.logging.enums.HyggeLoggerOutputMode;
import org.xavier.common.logging.enums.HyggeLoggerOutputTemplate;
import org.xavier.common.logging.store.OutPutModeValueStore;
import org.xavier.spring.common.HyggeContext;
import org.xavier.spring.common.enums.EnvironmentEnum;
import org.xavier.spring.common.enums.LoggerLevelEnum;
import org.xavier.spring.common.exception.SpringBootUtilRuntimeException;
import org.xavier.spring.common.store.LoggerValueStore;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.20
 * @since Jdk 1.8
 */
public class HyggeLoggerListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        ConfigurableEnvironment environment = applicationEnvironmentPreparedEvent.getEnvironment();
        logSystemCheck(applicationEnvironmentPreparedEvent.getSpringApplication().getClassLoader());
        HyggeLogSetting setting = new HyggeLogSetting();
        setting.setProjectName(environment.getProperty("hygge.logger.projectName", "Hygge"));
        setting.setAppName(HyggeContext.appName);
        setting.setVersion(environment.getProperty("hygge.logger.version", "unknown"));
        setting.setCurrentEnvironment(HyggeContext.currentEnvironment);
        setting.setLogLevel(LoggerLevelEnum.formatByString(environment.getProperty("hygge.logger.level", LoggerValueStore.WARNING_STRING)));
        setting.setFilePath(environment.getProperty("hygge.logger.filePath", "/"));
        setting.setMaxFileSize(environment.getProperty("hygge.logger.maxFileSize", "10MB"));
        // 默认每天变换一次日志文件
        setting.setCronTrigger(environment.getProperty("hygge.logger.cronTrigger", "0 0 0 * * ? "));
        // 设置日志模板
        switch (environment.getProperty("hygge.logger.template", "default").toLowerCase()) {
            case "escape":
                setting.setTemplate(HyggeLoggerOutputTemplate.ESCAPE);
                break;
            default:
                setting.setTemplate(HyggeLoggerOutputTemplate.DEFAULT);
        }
        // 设置日志输出类型
        HyggeLoggerOutputMode outputMode;
        switch (HyggeContext.currentEnvironment) {
            case DEV:
            case INT:
            case VIP:
            case PROD:
                outputMode = HyggeLoggerOutputMode.formatByString(environment.getProperty("hygge.logger.outputType", OutPutModeValueStore.FILE));
                break;
            default:
                outputMode = HyggeLoggerOutputMode.formatByString(environment.getProperty("hygge.logger.outputType", OutPutModeValueStore.CONSOLE));
        }
        setting.setMode(outputMode);

        HyggeLoggerBuilder hyggeLoggerBuilder = new HyggeLoggerBuilder(setting, getLoggerContext());
        if (HyggeContext.currentEnvironment != EnvironmentEnum.PREDEV) {
            hyggeLoggerBuilder.buildFrameworkLogger();
        }
        hyggeLoggerBuilder.buildAppLogger();
        System.out.println("HyggeLogger(1.2.1) init success.");
    }

    private void logSystemCheck(ClassLoader classLoader) {
        String loggingSystem = LoggingSystem.get(classLoader).getClass().getName();
        String expectedLoggingSystem = "org.springframework.boot.logging.log4j2.Log4J2LoggingSystem";
        if (!expectedLoggingSystem.equals(loggingSystem)) {
            throw new SpringBootUtilRuntimeException("The logging system is not Log4J2LoggingSystem but " + loggingSystem);
        }
    }

    private LoggerContext getLoggerContext() {
        return (LoggerContext) LogManager.getContext(false);
    }
}