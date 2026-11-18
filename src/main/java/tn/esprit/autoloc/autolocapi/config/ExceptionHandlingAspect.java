package tn.esprit.autoloc.autolocapi.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExceptionHandlingAspect {

    // après une exception levée par une méthode
    @AfterThrowing(pointcut = "execution(* tn.esprit.autoloc.autolocapi.service.*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        log.error("[EXCEPTION] Méthode : {}", joinPoint.getSignature().getName());
        log.error("[EXCEPTION] Type : {}", exception.getClass().getName());
        log.error("[EXCEPTION] Message : {}", exception.getMessage());
    }
}