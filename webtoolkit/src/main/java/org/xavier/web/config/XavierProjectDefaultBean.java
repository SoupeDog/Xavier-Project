package org.xavier.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
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
@Configuration
public class XavierProjectDefaultBean {
    @Autowired
    ObjectMapper mapper;

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
    public XavierLoggerImpl logger() {
        XavierLoggerImpl xavierLogger = new XavierLoggerImpl(LogManager.getLogger("XavierLogger"));
        return xavierLogger;
    }

}
