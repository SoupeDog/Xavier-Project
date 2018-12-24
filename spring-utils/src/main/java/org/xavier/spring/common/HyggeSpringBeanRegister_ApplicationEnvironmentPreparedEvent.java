package org.xavier.spring.common;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * 描述信息：<br/>
 * ApplicationEnvironmentPreparedEvent 注册事件
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.18
 * @since Jdk 1.8
 */

public class HyggeSpringBeanRegister_ApplicationEnvironmentPreparedEvent implements Ordered, ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.out.println("HyggeSpringBeanRegister_ApplicationEnvironmentPreparedEvent");
        String[] profiles = applicationEnvironmentPreparedEvent.getEnvironment().getActiveProfiles();
        HyggeContext.CURRENT_ENVIRONMENT = analyzeEnvironment(profiles);
        HyggeContext.APP_NAME = applicationEnvironmentPreparedEvent.getEnvironment().getProperty("spring.application.name", "Unknown");
    }

    private EnvironmentEnums analyzeEnvironment(String[] profiles) {
        if (profiles == null || profiles.length < 1) {
            return EnvironmentEnums.PREDEV;
        } else {
            if (arrayContains("PROD", profiles)) {
                return EnvironmentEnums.PROD;
            } else if (arrayContains("VIP", profiles)) {
                return EnvironmentEnums.VIP;
            } else if (arrayContains("INT", profiles)) {
                return EnvironmentEnums.INT;
            } else if (arrayContains("DEV", profiles)) {
                return EnvironmentEnums.DEV;
            } else {
                return EnvironmentEnums.PREDEV;
            }
        }
    }

    private Boolean arrayContains(String target, String[] array) {
        String targetTemp = target.toUpperCase();
        for (String itemTemp : array) {
            if (targetTemp.equals(itemTemp.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getOrder() {
        return LoggingApplicationListener.DEFAULT_ORDER - 1;
    }
}