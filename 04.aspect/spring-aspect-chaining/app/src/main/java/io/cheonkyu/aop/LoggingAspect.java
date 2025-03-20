package io.cheonkyu.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
  private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

  @Around(value = "@annotation(ToLog)")
  public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
    logger.info("LoggingAspect: Calling");
    Object returnedValue = joinPoint.proceed();
    logger.info("LoggingAspect: Return value ");
    return returnedValue;
  }
}