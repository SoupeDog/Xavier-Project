package org.xavier.common.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.xavier.spring.common.HyggeContext;
import org.xavier.spring.common.enums.EnvironmentEnum;
import org.xavier.spring.common.exception.SpringBootUtilRuntimeException;

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
        HyggeCacheLogSetting setting = new HyggeCacheLogSetting();
        setting.setProjectName(environment.getProperty("hygge.logger.name", "Hygge"));
        setting.setAppName(HyggeContext.appName);
        setting.setCurrentEnvironment(HyggeContext.currentEnvironment);
        switch (HyggeContext.currentEnvironment) {
            case DEV:
            case INT:
            case VIP:
            case PROD:
                setting.setMode(HyggeLoggerOutputMode.FILE);
                break;
            default:
                setting.setMode(HyggeLoggerOutputMode.DEFAULT);
        }

        setting.setTemplate(HyggeLoggerOutputTemplate.DEFAULT);
        setting.setVersion("1.1");
        setting.setSubVersion("1");
        HyggeLoggerBuilder hyggeLoggerBuilder = new HyggeLoggerBuilder(setting, getLoggerContext());
        if (HyggeContext.currentEnvironment != EnvironmentEnum.PREDEV) {
            hyggeLoggerBuilder.buildFrameworkLogger(HyggeContext.currentEnvironment);
        }
        hyggeLoggerBuilder.buildAppLogger(HyggeContext.currentEnvironment);
        System.out.println("覆盖完成");
    }

    private void logSystemCheck(ClassLoader classLoader) {
        String loggingSystem = LoggingSystem.get(classLoader).getClass().getName();
        if (!"org.springframework.boot.logging.log4j2.Log4J2LoggingSystem".equals(loggingSystem)) {
            throw new SpringBootUtilRuntimeException("The logging system is not Log4J2LoggingSystem : " + loggingSystem);
        }
    }

    private LoggerContext getLoggerContext() {
        return (LoggerContext) LogManager.getContext(false);
    }
}