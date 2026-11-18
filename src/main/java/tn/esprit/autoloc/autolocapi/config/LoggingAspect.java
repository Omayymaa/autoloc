package tn.esprit.autoloc.autolocapi.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    //advice exécuté avant chaque méthode
    @Before("execution(* tn.esprit.autoloc.autolocapi.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();
        log.info("Before - Méthode appelée " + methodName + " / Paramètres : " + Arrays.toString(parameters));
    }

    // advice exécuté après chaque méthode
    @After("execution(* tn.esprit.autoloc.autolocapi.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("After - Exécution terminée : " + joinPoint.getSignature().getName());
    }


}
