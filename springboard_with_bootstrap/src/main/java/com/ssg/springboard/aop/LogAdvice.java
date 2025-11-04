package com.ssg.springboard.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LogAdvice {

//  @Before("execution(* com.ssg.springboard.service.BoardService.getList(..))")
//  public void logBefore(){
//    log.info("------------before-----------------------");
//    log.info("------------before-----------------------");
//    log.info("------------before-----------------------");
//  }

  @Around("execution(* com.ssg.springboard.service.BoardService.*(..))")
  public Object logTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

    long start = System.currentTimeMillis();

    Object result = proceedingJoinPoint.proceed();  //메소드를 실행하는 코드

    long end = System.currentTimeMillis();

    long gap = end - start;

    log.info("-------------------------");
    log.info(proceedingJoinPoint.getTarget());
    log.info(proceedingJoinPoint.getSignature());
    log.info("TIME: " + gap);

    if(gap > 100){
      log.warn("-----------------WARN-------------");
    }

    return result;
  }

}