package com.learnAOP.howUseAOP.config;

import com.learnAOP.howUseAOP.handler.TaskException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Configuration
public class AspectConfig {

    private final Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Before(value = "execution(* com.learnAOP.howUseAOP.services.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint) {
        log.info("Executing {}", joinPoint);
    }

    @After(value = "execution(* com.learnAOP.howUseAOP.services.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint) {
        log.info("Complete execution of {}", joinPoint);
    }

    @Around(value = "execution(* com.learnAOP.howUseAOP.services.*.*(..))")
    public Object taskHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("execution of {} with {} params", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getArgs());

        try {
            return proceedingJoinPoint.proceed();
        } catch (TaskException e) {
            log.info("TaskException Status code: {}", e.getHttpStatus().value());
            log.info("TaskException Message: {}", e.getMessage());

            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @Around(value = "execution(* com.learnAOP.howUseAOP.services.*.*(..))")
    public Object timeTracker(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            Object obj = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();

            log.info("Time spend to complete a task {} is {} ms", proceedingJoinPoint, endTime-startTime);
            return obj;
        } catch (TaskException e) {
            log.info("TaskException Status code: {}", e.getHttpStatus().value());
            log.info("TaskException Message: {}", e.getMessage());

            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }
}
