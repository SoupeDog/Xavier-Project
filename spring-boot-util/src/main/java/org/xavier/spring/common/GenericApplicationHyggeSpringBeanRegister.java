package org.xavier.spring.common;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;

/**
 * 描述信息：<br/>
 * GenericApplicationEvent 注册事件
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.18
 * @since Jdk 1.8
 */
public class GenericApplicationHyggeSpringBeanRegister implements GenericApplicationListener {

    @Override
    public boolean supportsEventType(ResolvableType resolvableType) {
        return true;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(applicationEvent+"----");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}