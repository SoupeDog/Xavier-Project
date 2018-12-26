package org.xavier.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.xavier.common.utils.*;

/**
 * 描述信息：<br/>
 * 自定义Bean对象
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/1/14
 * @since Jdk 1.8
 */
@ComponentScan(value = {"org.xavier.web"})
@Configuration
public class XavierProjectDefaultBean {

    @Bean
    public PropertiesHelper propertiesHelper() {
        return UtilsCreator.getInstance_DefaultPropertiesHelper();
    }

    @Bean
    public SQLHelper sqlHelper() {
        return UtilsCreator.getInstance_DefaultSQLHelper();
    }

    @Bean
    public JsonHelper jsonHelper() {
        return UtilsCreator.getInstance_DefaultJsonHelper(false);
    }

    @Bean
    public ListHelper listHelper() {
        return UtilsCreator.getInstance_DefaultListHelper();
    }

    @Bean
    public MapHelper mapHelper() {
        return UtilsCreator.getInstance_DefaultMapHelper();
    }
}