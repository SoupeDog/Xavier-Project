package org.xavier.spring.common;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.xavier.spring.common.config.LoggerConfig;
import org.xavier.spring.common.enums.EnvironmentEnum;
import org.xavier.spring.common.store.EnvironmentValueStore;

/**
 * 描述信息：<br/>
 * ApplicationEnvironmentPreparedEvent 注册事件
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.18
 * @since Jdk 1.8
 */

public class ApplicationEnvironmentPreparedEventHyggeSpringBeanRegister implements Ordered, ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.out.println("ApplicationEnvironmentPreparedEventHyggeSpringBeanRegister");
        String[] profiles = applicationEnvironmentPreparedEvent.getEnvironment().getActiveProfiles();
        HyggeContext.currentEnvironment = analyzeEnvironment(profiles);
        HyggeContext.appName = applicationEnvironmentPreparedEvent.getEnvironment().getProperty("spring.application.name", "Unknown");
    }

    private EnvironmentEnum analyzeEnvironment(String[] profiles) {
        if (profiles == null || profiles.length < 1) {
            return EnvironmentEnum.PREDEV;
        } else {
            if (arrayContains(EnvironmentValueStore.PROD_STRING, profiles)) {
                return EnvironmentEnum.PROD;
            } else if (arrayContains(EnvironmentValueStore.VIP_STRING, profiles)) {
                return EnvironmentEnum.VIP;
            } else if (arrayContains(EnvironmentValueStore.INT_STRING, profiles)) {
                return EnvironmentEnum.INT;
            } else if (arrayContains(EnvironmentValueStore.DEV_STRING, profiles)) {
                return EnvironmentEnum.DEV;
            } else {
                return EnvironmentEnum.PREDEV;
            }
        }
    }

    private Boolean arrayContains(String target, String[] array) {
        String targetTemp = target.toLowerCase();
        for (String itemTemp : array) {
            if (targetTemp.equals(itemTemp.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getOrder() {
        // 设置优先级比默认值高一点
        return LoggingApplicationListener.DEFAULT_ORDER - 1;
    }
}