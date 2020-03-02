package com.mahirkole.walkure.aspect;

import com.mahirkole.walkure.util.CoreResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
/*
@Aspect
@Order(1)
@Component
public class CoreResponseAdvice extends CoreAspect {

    @Around("execution(* com.mahirkole.walkure.controller.*.*(..)) && !beanAnnotatedWithMapperAspect()")
    public ResponseEntity convertSuccessfullResponseToCoreResponse(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ResponseEntity responseEntity = (ResponseEntity) proceedingJoinPoint.proceed();
        CoreResponse coreResponse = new CoreResponse(responseEntity.getBody());

        return new ResponseEntity(coreResponse, responseEntity.getStatusCode());
    }
}
*/