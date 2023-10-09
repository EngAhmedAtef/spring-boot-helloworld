package com.ahmedatef.helloworld.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class MethodLoggingAspect {

    @Pointcut(value = "execution(* com.ahmedatef.helloworld.web.*.*(..))")
    public void controllerPointcut() {}

    @Pointcut(value = "execution(* com.ahmedatef.helloworld.model.*.*(..))")
    public void modelPointcut() {}

    @Pointcut(value = "controllerPointcut() || modelPointcut()")
    public void appPointcut() {}

    @Before(value = "appPointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String stringBuilder = "BEFORE ADVICE:" + '[' + joinPoint.getKind() + ']' + "\tMethodSignature: " + joinPoint.getSignature() +
                "\tMethodArgs(" + StringUtils.arrayToCommaDelimitedString(joinPoint.getArgs()) + ')';
        System.out.println(stringBuilder);
    }
}
