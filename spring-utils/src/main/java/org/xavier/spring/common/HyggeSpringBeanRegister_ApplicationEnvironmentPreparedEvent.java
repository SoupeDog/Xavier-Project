package org.xavier.spring.common;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 描述信息：<br/>
 * ApplicationEnvironmentPreparedEvent 注册事件
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.18
 * @since Jdk 1.8
 */

public class HyggeSpringBeanRegister_ApplicationEnvironmentPreparedEvent implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.out.println("HyggeSpringBeanRegister_ApplicationEnvironmentPreparedEvent");

    }
}