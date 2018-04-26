package com.vinay.learning.spring.aspect.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(-2)// takes care of the order, lowest number takes the highest precedence, negative number also can be given
public class AnalyticsAspect {


    private  Logger myLogger = Logger.getLogger(getClass().getName()) ;

    @Before("com.vinay.learning.spring.aspect.aspects.MyDemoLoggingAspect.allMethodsExceptSettersAndGetters()")
    public void beforePerformAnalytics(JoinPoint joinPoint) {

        myLogger.info(joinPoint.getSignature().getName());
       myLogger.info(joinPoint.getKind());
           myLogger.info(joinPoint.getArgs().toString());

        myLogger.info("Executing @Before in perform analytics");
    }

}
