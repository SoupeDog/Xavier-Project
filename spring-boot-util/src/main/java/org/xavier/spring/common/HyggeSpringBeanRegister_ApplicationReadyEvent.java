package org.xavier.spring.common;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * 描述信息：<br/>
 * ApplicationReadyEvent 注册事件
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.18
 * @since Jdk 1.8
 */

public class HyggeSpringBeanRegister_ApplicationReadyEvent implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("HyggeSpringBeanRegister_ApplicationReadyEvent");
        ConfigurableListableBeanFactory beanFactory = applicationReadyEvent.getApplicationContext().getBeanFactory();
    }
}