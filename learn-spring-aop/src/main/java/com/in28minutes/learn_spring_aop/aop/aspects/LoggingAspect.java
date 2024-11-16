package com.in28minutes.learn_spring_aop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.in28minutes.learn_spring_aop.aop.business.*.*(..))")
    public void logMethodCallBeforeExec(JoinPoint joinPoint) {
        logger.info("Before Aspect - {} Method is called with args: {}", joinPoint, joinPoint.getArgs());
    }

    @After("execution(* com.in28minutes.learn_spring_aop.aop.business.*.*(..))")
    public void logMethodCallAfterExec(JoinPoint joinPoint) {
        logger.info("After Aspect - {} Method is called with args: {}", joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing(
            pointcut = "execution(* com.in28minutes.learn_spring_aop.aop.business.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception.getMessage());
    }

    @AfterReturning(
            pointcut = "execution(* com.in28minutes.learn_spring_aop.aop.business.*.*(..))",
            returning = "resultValue"
    )
    public void logMethodCallAfterReturn(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning Aspect - {} has thrown an exception {}", joinPoint, resultValue);
    }
}
