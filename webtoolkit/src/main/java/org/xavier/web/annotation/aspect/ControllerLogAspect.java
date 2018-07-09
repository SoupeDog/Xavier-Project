package org.xavier.web.annotation.aspect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.xavier.common.enums.ColumnType;
import org.xavier.common.utils.JsonHelper;
import org.xavier.common.utils.UtilsCreator;
import org.xavier.common.utils.base.BaseJsonHelper;
import org.xavier.web.annotation.ControllerLog;
import org.xavier.web.annotation.DefaultControllerLog;
import org.xavier.web.annotation.EnableControllerLog;
import org.xavier.web.logger.XavierLoggerImpl;

import java.lang.reflect.Method;

/**
 * 描述信息：<br/>
 * Controller 层日志注解
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.07.05
 * @since Jdk 1.8
 */
@Aspect
@Component
public class ControllerLogAspect {
    private XavierLoggerImpl logger;

    public ControllerLogAspect() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//反序列化出现多余属性时,选择忽略不抛出异常
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);// 开启允许数字以 0 开头
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //属性为NULL不序列化
        JsonHelper jsonHelper_Log = new BaseJsonHelper(mapper) {
            @Override
            protected void hookGetValueByKey(ColumnType resultType, Object target) {

            }
        };
        this.logger = new XavierLoggerImpl(LogManager.getLogger("XavierLogger"), jsonHelper_Log);
    }

    @Pointcut("@annotation(org.xavier.web.annotation.EnableControllerLog) && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void pointcutGet() {
    }

    @Pointcut("@annotation(org.xavier.web.annotation.EnableControllerLog) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void pointcutPost() {
    }

    @Pointcut("@annotation(org.xavier.web.annotation.EnableControllerLog) && @annotation(org.springframework.web.bind.annotation.PutMapping)")
    private void pointcutPut() {
    }

    @Pointcut("@annotation(org.xavier.web.annotation.EnableControllerLog) && @annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void pointcutDelete() {
    }

    @Around("pointcutGet() || pointcutPost() || pointcutPut() || pointcutDelete()")
    public Object saveLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // start stopwatch
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method currentMethod = signature.getMethod();
        ControllerLog logOBJ = new DefaultControllerLog();
        String[] paths = new String[0];
        if (currentMethod.isAnnotationPresent(GetMapping.class)) {
            paths = currentMethod.getAnnotation(GetMapping.class).value();
            logOBJ.setHttpMethod(HttpMethod.GET);
        } else if (currentMethod.isAnnotationPresent(PostMapping.class)) {
            paths = currentMethod.getAnnotation(PostMapping.class).value();
            logOBJ.setHttpMethod(HttpMethod.POST);
        } else if (currentMethod.isAnnotationPresent(PutMapping.class)) {
            paths = currentMethod.getAnnotation(PutMapping.class).value();
            logOBJ.setHttpMethod(HttpMethod.PUT);
        } else if (currentMethod.isAnnotationPresent(DeleteMapping.class)) {
            paths = currentMethod.getAnnotation(DeleteMapping.class).value();
            logOBJ.setHttpMethod(HttpMethod.DELETE);
        }
        String[] ignoreProperties = currentMethod.getAnnotation(EnableControllerLog.class).ignoreProperties();
        String[] propertiesNames = signature.getParameterNames();
        Object[] propertiesValue = joinPoint.getArgs();
        logOBJ.setStartTs(System.currentTimeMillis());
        logOBJ.initRequest(paths, ignoreProperties, propertiesNames, propertiesValue);
        Object retVal = joinPoint.proceed();
        logOBJ.initResponse(retVal);
        logOBJ.setEndTs(System.currentTimeMillis());
        String logStringVal = logger.getJsonHelper().format(logOBJ);
        switch (logOBJ.httpStatus) {
            case 200:
                logger.always(logStringVal);
                break;
            case 400:
            case 403:
            case 404:
            case 409:
                logger.warn(logStringVal);
                break;
            default:
                logger.error(logStringVal);
        }
        // stop stopwatch
        return retVal;
    }

}