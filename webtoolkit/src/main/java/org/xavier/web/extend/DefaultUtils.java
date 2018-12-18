package org.xavier.web.extend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.xavier.common.utils.*;
import org.xavier.web.logger.HyggeLoggerImpl_Log4j2;

/**
 * 描述信息：<br/>
 * 基础工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.01.15
 * @since Jdk 1.8
 */
@Component
public class DefaultUtils {
    @Autowired
    protected ObjectMapper mapper;
    @Autowired
    @Qualifier("jsonHelper_Log")
    protected JsonHelper jsonHelper_Log;
    @Autowired
    @Qualifier("jsonHelper")
    protected JsonHelper jsonHelper;
    @Autowired
    protected SQLHelper sqlHelper;
    @Autowired
    protected PropertiesHelper propertiesHelper;
    @Autowired
    protected ListHelper listHelper;
    @Autowired
    protected MapHelper mapHelper;
    @Autowired
    protected HyggeLoggerImpl_Log4j2 logger;

}
