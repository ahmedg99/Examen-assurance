package tn.spring.springboot.Configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging and performance monitoring.
 */
@Component
@Aspect
@Slf4j
public class Logging {


    /**
     * afficher le message « Bon courage ! » à la fin de l’exécution
     * de chaque méthode du package services et qui commence par get.
     */
    @After("execution(* tn.spring.springboot.Services.Implementation.*.get*(..))")
    public void logControllerMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.debug("Entering method: " + methodName);
        log.info("Bon Courage !");
    }


}
