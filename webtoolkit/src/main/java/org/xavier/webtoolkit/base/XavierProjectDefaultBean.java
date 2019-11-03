package org.xavier.webtoolkit.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.xavier.common.logging.core.HyggeLogger;
import org.xavier.common.util.*;

/**
 * 描述信息：<br/>
 * 自定义Bean对象
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/1/14
 * @since Jdk 1.8
 */
@ComponentScan(value = {"org.xavier.webtoolkit"})
@Configuration
public class XavierProjectDefaultBean {

    @Bean
    public PropertiesHelper propertiesHelper() {
        return UtilsCreator.getDefaultPropertiesHelperInstance();
    }

    @Bean
    public JsonHelper jsonHelper() {
        return UtilsCreator.getDefaultJsonHelperInstance(false);
    }

    @Bean
    public JsonHelper jsonHelperIndent() {
        return UtilsCreator.getDefaultJsonHelperInstance(true);
    }

    @Bean
    public TimeHelper timeHelper() {
        return UtilsCreator.getDefaultTimeHelperInstance();
    }

    @Bean
    public SqlHelper sqlHelper() {
        return UtilsCreator.getDefaultSqlHelper();
    }

    @Bean
    public RandomHelper randomHelper() {
        return UtilsCreator.getDefaultRandomHelperInstance();
    }

    @Bean
    public CollectionHelper collectionHelper() {
        return UtilsCreator.getDefaultCollectionHelper();
    }
}