package org.xavier.common.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.xavier.common.exception.Universal_500_X_Exception_Runtime;

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
        setting.setProjectName("Hygge");
        setting.setAppName("test");
        setting.setMode(HyggeLoggerOutputMode.FILE);
        setting.setTemplate(HyggeLoggerOutputTemplate.DEFAULT);
        setting.setVersion("1.1");
        setting.setSubVersion("1");
        HyggeLoggerBuilder hyggeLoggerBuilder = new HyggeLoggerBuilder(setting, getLoggerContext());
        hyggeLoggerBuilder.buildFrameworkLogger();
        hyggeLoggerBuilder.buildAppLogger();
        System.out.println("覆盖完成");
    }

    private void logSystemCheck(ClassLoader classLoader) {
        String loggingSystem = LoggingSystem.get(classLoader).getClass().getName();
        if (!loggingSystem.equals("org.springframework.boot.logging.log4j2.Log4J2LoggingSystem")) {
            throw new Universal_500_X_Exception_Runtime(555F, "the logging system is not Log4J2LoggingSystem : " + loggingSystem);
        }
    }

    private LoggerContext getLoggerContext() {
        return (LoggerContext) LogManager.getContext(false);
    }
}