package io.cheonkyu.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class SecurityAspect {
  private Logger logger = Logger.getLogger(SecurityAspect.class.getName());

  @Around(value = "@annotation(ToLog)")
  public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
    logger.info("SecurityAspect: Calling");
    Object returnedValue = joinPoint.proceed();
    logger.info("SecurityAspect: Return value " + returnedValue);
    return returnedValue;
  }
}