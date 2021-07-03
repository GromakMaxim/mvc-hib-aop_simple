package com.gromak.spr_mvc_hib_aop.asp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.gromak.spr_mvc_hib_aop.dao.*.*(..) )")
    public Object aroundAllRepositoryMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var v = (MethodSignature)proceedingJoinPoint.getSignature();
        var methodName = v.getName();

        System.out.println("Begin of " + methodName);

        return proceedingJoinPoint.proceed();
    }
}
