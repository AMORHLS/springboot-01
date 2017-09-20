package com.hls.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class RoadAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around(value = "execution(public * com.hls.springboot.security.controller.*.*(..))")
    public Object around(final ProceedingJoinPoint pjp){
        try {
            Object result = pjp.proceed();
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
    @Before(value = "execution(public * com.hls.springboot.security.controller.*.*(..))")
    public void before(final JoinPoint jp){
        logger.info("before******"+jp.getTarget().getClass().getSimpleName());
    }
    @AfterReturning(value = "execution(public * com.hls.springboot.security.controller.*.*(..))",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){
        logger.info("afterReturning******"+result);
    }
    @AfterThrowing(value = "execution(public * com.hls.springboot.security.controller.*.*(..))",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e){
        logger.info("afterThrowing*****"+e.getMessage());
    }
    @After(value = "execution(public * com.hls.springboot.security.controller.*.*(..))")
    public void after(JoinPoint jp){
        logger.info("after******"+jp.getTarget().getClass().getSimpleName());
    }
}
