package org.xavier.web.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
    @Pointcut("@annotation(org.xavier.web.annotation.ControllerLog) && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void pointcutGet() {
    }

    @Pointcut("@annotation(org.xavier.web.annotation.ControllerLog) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void pointcutPost() {
    }

    @Pointcut("@annotation(org.xavier.web.annotation.ControllerLog) && @annotation(org.springframework.web.bind.annotation.PutMapping)")
    private void pointcutPut() {
    }

    @Pointcut("@annotation(org.xavier.web.annotation.ControllerLog) && @annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void pointcutDelete() {
    }

    @Around("pointcutGet() || pointcutPost() || pointcutPut() || pointcutDelete()")
    public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
        // start stopwatch
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName());
        System.out.println(signature.getDeclaringType());
        System.out.println(signature.getDeclaringTypeName());
        System.out.println(signature.getModifiers());
        System.out.println(signature.toLongString());
        System.out.println(signature.toShortString());



        Object retVal = joinPoint.proceed();
        // stop stopwatch
        return retVal;
    }

}
