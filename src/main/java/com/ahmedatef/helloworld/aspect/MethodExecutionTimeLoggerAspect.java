package com.ahmedatef.helloworld.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class MethodExecutionTimeLoggerAspect {

    @Around(value = "execution(* com.ahmedatef.helloworld.service.*.*(..))")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("AROUND ADVICE:");
        stringBuilder.append("[").append(joinPoint.getKind()).append("]\tMethodSignature: ").append(joinPoint.getSignature())
                .append("\tMethodArgs: ").append("(").append(StringUtils.arrayToCommaDelimitedString(joinPoint.getArgs())).append(")");
        stringBuilder.append("\tTimeTaken: ");
        Object returnValue = joinPoint.proceed();
        System.out.println(stringBuilder.append(System.currentTimeMillis() - startTime).append(" ms."));
        return returnValue;
    }
}