package org.xavier.web.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.xavier.common.logging.HyggeLoggerImpl_Log4j2;
import org.xavier.common.utils.UtilsCreator;
import org.xavier.web.annotation.ControllerLog;
import org.xavier.web.annotation.DefaultControllerLog;
import org.xavier.web.annotation.EnableControllerLog;

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
    @Autowired
    private HyggeLoggerImpl_Log4j2 logger;

    public ControllerLogAspect() {
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
        Object returnVal = joinPoint.proceed();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method currentMethod = signature.getMethod();
        // 切入点限定的要求决定了 EnableControllerLog 注解一定存在，故此处直接取
        EnableControllerLog controllerLogAnnotation = currentMethod.getAnnotation(EnableControllerLog.class);

        if (controllerLogAnnotation.enable()) {
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
            if (controllerLogAnnotation != null && controllerLogAnnotation.enableRequestLog()) {
                logOBJ.initRequest(paths, ignoreProperties, propertiesNames, propertiesValue);
            }
            if (controllerLogAnnotation != null && controllerLogAnnotation.enableResponseLog()) {
                logOBJ.initResponse(returnVal);
            }
            logOBJ.setEndTs(System.currentTimeMillis());
            String logStringVal;
            switch (logOBJ.httpStatus) {
                case 200:
                    if (controllerLogAnnotation != null && controllerLogAnnotation.enableSuccessLog()) {
                        logStringVal = UtilsCreator.getInstance_DefaultJsonHelper(false).format(logOBJ);
                        if (logStringVal != null) {
                            logger.always(logStringVal);
                        }
                    }
                    break;
                case 400:
                case 403:
                case 404:
                case 409:
                    logStringVal = UtilsCreator.getInstance_DefaultJsonHelper(false).format(logOBJ);
                    if (logStringVal != null) {
                        logger.warn(logStringVal);
                    }
                    break;
                default:
                    logStringVal = UtilsCreator.getInstance_DefaultJsonHelper(false).format(logOBJ);
                    if (logStringVal != null) {
                        logger.error(logStringVal);
                    }
            }
        }
        return returnVal;
    }
}