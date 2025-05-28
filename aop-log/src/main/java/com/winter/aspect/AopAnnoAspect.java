package com.winter.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AopAnnoAspect {


    @Pointcut("@annotation(com.winter.annotation.AopAnno)")
    public void pointCut() {

    }


    @Around("pointCut()")
    public Object logExecuteAround(ProceedingJoinPoint joinPoint) throws Throwable {


        log.info("logExecuteAround-beforeProceed ---------------------");

        // 调用proceed(). 执行目标方法
        Object proceed = joinPoint.proceed();

        // 如果目标方法异常, 则proceed()之后的代码不会执行
        log.info("logExecuteAround-afterProceed ---------------------");

        return proceed;

    }


//    @Before("pointCut()")
//    public void logExecuteBefore(JoinPoint joinPoint) {
//
//        log.info("logExecuteBefore ---------------------");
//
//    }
//
//
//    @After("pointCut()")
//    public void logExecuteAfter(JoinPoint joinPoint) {
//
//        log.info("logExecuteAfter ---------------------");
//
//    }


//    @AfterReturning(value = "pointCut()", returning = "result")
//    public void logExecuteAfterReturning(JoinPoint joinPoint, Object result) {
//
//        log.info("logExecuteAfterReturning ---------------------");
//
//    }
//
//
//    @AfterThrowing(value = "pointCut()", throwing = "e")
//    public void logExecuteAfterThrowing(JoinPoint joinPoint, Throwable e) {
//
//        log.info("logExecuteAfterThrowing --------------------");
//
//    }


}
