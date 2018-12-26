package org.xavier.web.annotation;

import java.lang.annotation.*;

/**
 * 描述信息：<br/>
 * Controller 层日志注解
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.07.05
 * @since Jdk 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableControllerLog {
    /**
     * 日志忽略的参数名称
     */
    String[] ignoreProperties() default {};

    /**
     * 是否开启日志
     */
    boolean enable() default true;

    /**
     * 是否开启成功请求日志
     */
    boolean enableSuccessLog() default false;

    /**
     * 是否开启 request 日志
     */
    boolean enableRequestLog() default true;

    /**
     * 是否开启 response 日志
     */
    boolean enableResponseLog() default true;
}
