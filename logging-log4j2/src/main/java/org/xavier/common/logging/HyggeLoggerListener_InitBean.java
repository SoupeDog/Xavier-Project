package org.xavier.common.logging;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.20
 * @since Jdk 1.8
 */
public class HyggeLoggerListener_InitBean implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        ConfigurableEnvironment environment = applicationPreparedEvent.getApplicationContext().getEnvironment();
        ConfigurableListableBeanFactory beanFactory = applicationPreparedEvent.getApplicationContext().getBeanFactory();
        if (!beanFactory.containsBean(HyggeLogger.DEFAULT_LOGGER_NAME)) {
            HyggeLogger logger = new HyggeLoggerLog4j2Impl(LogManager.getLogger(HyggeLogger.DEFAULT_LOGGER_NAME));
            beanFactory.registerSingleton(HyggeLogger.DEFAULT_LOGGER_NAME, logger);
            System.out.println("加载成功");
            logger.info("加载成功");
        }
    }
}