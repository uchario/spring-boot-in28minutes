package com.in28minutes.learn_spring_aop.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {
    @Pointcut("execution(* com.in28minutes.learn_spring_aop.aop.business.*.*(..))")
    public void businessPackageConfig() {
    }

    @Pointcut("bean(*Service*)")
    public void dataPackageConfigUsingBean() {

    }

    @Pointcut("@annotation(com.in28minutes.learn_spring_aop.aop.annotations.TrackTime)")
    public void trackTimeAnnotation() {

    }
}
