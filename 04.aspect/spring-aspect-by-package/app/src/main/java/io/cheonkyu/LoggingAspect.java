package io.cheonkyu;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
  private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

  LoggingAspect() {
    logger.info("test");
  }

  @Around("execution(* io.cheonkyu.service.*.*(..))")
  public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
    logger.info("Method will execute");

    String methodName = joinPoint.getSignature().getName();
    Object[] argments = joinPoint.getArgs();

    logger.info("Method " + methodName);
    logger.info("with arguments " + Arrays.asList(argments));

    Object returnedByMethod = joinPoint.proceed();

    logger.info("Method executed : " + returnedByMethod);
    return returnedByMethod;
  }
}
