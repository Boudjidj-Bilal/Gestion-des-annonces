package org.annonce.Configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Pointcut pour capturer tous les appels aux méthodes des services
    @Pointcut("execution(* org.annonce.service.*.*(..))")
    public void serviceMethods() {}

    // Avant l'exécution d'une méthode
    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Début d'exécution : " + joinPoint.getSignature().toShortString());
        logger.info("Arguments : " + joinPoint.getArgs());
    }

    // Après une exécution réussie
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Fin d'exécution : " + joinPoint.getSignature().toShortString());
        logger.info("Valeur retournée : " + result);
    }

    // Si une exception est levée
    @AfterThrowing(pointcut = "serviceMethods()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Exception dans : " + joinPoint.getSignature().toShortString());
        logger.error("Erreur : " + error.getMessage());
    }
}
