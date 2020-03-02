package com.mahirkole.walkure.aspect;

import com.mahirkole.walkure.exception.CoreException;
import com.mahirkole.walkure.util.CoreResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
/*
@Aspect
@Order(2)
@Component
public class CoreExceptionAdvice extends CoreAspect {

    @Around("execution(* com.mahirkole.walkure.controller.*.*(..)) && !beanAnnotatedWithMapperAspect()")
    public ResponseEntity handleCoreException(ProceedingJoinPoint proceedingJoinPoint) {
        ResponseEntity responseEntity;

        try {
            responseEntity = (ResponseEntity) proceedingJoinPoint.proceed();
        } catch (CoreException coreException) {
            return new ResponseEntity<>(
                    new CoreResponse(false, coreException.getMessage()), HttpStatus.OK);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return new ResponseEntity<>(
                    new CoreResponse(false, throwable.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
*/