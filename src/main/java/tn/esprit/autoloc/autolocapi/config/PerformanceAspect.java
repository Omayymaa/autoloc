package tn.esprit.autoloc.autolocapi.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    // @Around intercepte toutes les méthodes du package service
    @Around("execution(* tn.esprit.autoloc.autolocapi.service.*.*(..))")
    public Object mesurerTemps(ProceedingJoinPoint joinPoint) throws Throwable {

        long debut = System.currentTimeMillis();
        Object resultat = joinPoint.proceed();

        // Calculer et afficher le temps d'exécution en millisecondes
        long duree = System.currentTimeMillis() - debut;
        String nomMethode = joinPoint.getSignature().getName();
        log.info("[PERFORMANCE] {} exécutée en {} ms", nomMethode, duree);

        // Signaler les méthodes lentes (> 1000 ms)
        if (duree > 1000) {
            log.warn("[PERFORMANCE] ATTENTION : la méthode {} est lente ({} ms > 1000 ms)", nomMethode, duree);
        }

        // Retourner le résultat de la méthode interceptée
        return resultat;
    }
}