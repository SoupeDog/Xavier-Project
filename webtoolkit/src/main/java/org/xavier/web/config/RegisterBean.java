//package org.xavier.web.config;
//
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.event.GenericApplicationListener;
//import org.springframework.core.Ordered;
//import org.springframework.core.ResolvableType;
//
///**
// * 描述信息：<br/>
// * (弃置)革命的火种
// *
// * @author Xavier
// * @version 1.0
// * @date 2018.02.01
// * @since Jdk 1.8
// */
//public class RegisterBean implements GenericApplicationListener {
//    @Override
//    public boolean supportsEventType(ResolvableType resolvableType) {
//        System.out.println(resolvableType);
//        return false;
//    }
//
//    @Override
//    public boolean supportsSourceType(Class<?> aClass) {
//        System.out.println(aClass);
//        return false;
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent applicationEvent) {
//        System.out.println(applicationEvent);
//    }
//
//    @Override
//    public int getOrder() {
//        return Ordered.HIGHEST_PRECEDENCE + 21;
//    }
//}
