package com.dx.spring.beans.aop;

import java.util.List;
import java.util.Arrays;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面：需要把该类放入到IOC容器中、再声明为一个切面。
@EnableAspectJAutoProxy
@Component
public class LoggingAspect {
    // 在这里注册通知方法。

    // 声明该方法为一个前置通知：在目标方法开始之前执行
//    @Before("execution(public int com.dx.spring.beans.aop.IArithmeticCalculator.*(int, int))")
//    public void beforeMethod(JoinPoint joinpoint) {
//        String methodName = joinpoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinpoint.getArgs());
//        System.out.println("before method " + methodName + " with " + args);
//    }
}