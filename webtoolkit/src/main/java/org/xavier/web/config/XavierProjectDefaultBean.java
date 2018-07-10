package org.xavier.web.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.xavier.common.enums.ColumnType;
import org.xavier.common.utils.*;
import org.xavier.common.utils.base.BaseJsonHelper;
import org.xavier.web.logger.XavierLoggerImpl;

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
    @ConditionalOnClass(BaseJsonHelper.class)
    public JsonHelper jsonHelper() {
        return UtilsCreator.getInstance_DefaultJsonHelper();
    }

    @Bean
    @ConditionalOnClass(BaseJsonHelper.class)
    public JsonHelper jsonHelper_Log() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, false);// 开启缩进
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);// 开启允许数字以 0 开头
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //属性为NULL不序列化
        return new BaseJsonHelper(mapper) {
            @Override
            protected void hookGetValueByKey(ColumnType resultType, Object target) {

            }
        };
    }

    @Bean
    public ListHelper listHelper() {
        return UtilsCreator.getInstance_DefaultListHelper();
    }

    @Bean
    public MapHelper mapHelper() {
        return UtilsCreator.getInstance_DefaultMapHelper();
    }

    @Bean
    public XavierLoggerImpl logger(JsonHelper jsonHelper_Log) {
        XavierLoggerImpl xavierLogger = new XavierLoggerImpl(LogManager.getLogger("XavierLogger"), jsonHelper_Log);
        return xavierLogger;
    }

}
