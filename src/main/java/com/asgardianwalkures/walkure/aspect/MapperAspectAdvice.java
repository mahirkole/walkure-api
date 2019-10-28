package com.asgardianwalkures.walkure.aspect;

import com.asgardianwalkures.walkure.annotation.MapperAspect;
import com.asgardianwalkures.walkure.exception.CoreException;
import com.asgardianwalkures.walkure.exception.MapperNotFoundException;
import com.asgardianwalkures.walkure.mapper.CoreMapper;
import com.asgardianwalkures.walkure.model.CoreModel;
import com.asgardianwalkures.walkure.util.MapperService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
public class MapperAspectAdvice extends CoreAspect {

  private final MapperService mapperService;

  @Autowired
  public MapperAspectAdvice(MapperService mapperService) {
    this.mapperService = mapperService;
  }

  @Around(
      "execution(* com.asgardianwalkures.walkure.controller.*.*(..)) && beanAnnotatedWithMapperAspect()")
  public ResponseEntity mapEntityToDto(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
    Method method = methodSignature.getMethod();
    MapperAspect mapperAspect = method.getAnnotation(MapperAspect.class);
    ResponseEntity responseEntity;

    try {
      responseEntity = (ResponseEntity) proceedingJoinPoint.proceed();
    } catch (CoreException ex) {
      return ex.handle();
    }

    boolean isEntityInstanceOfList = false;
    String source;
    String target;

    HttpStatus httpStatus = responseEntity.getStatusCode();

    if (responseEntity.getBody() instanceof CoreModel) {
      CoreModel entity = (CoreModel) responseEntity.getBody();
      source = entity.getClass().getSimpleName();
    } else if (responseEntity.getBody() instanceof List) {
      List<CoreModel> entities = (List<CoreModel>) responseEntity.getBody();
      if (entities.size() > 0) {
        source = entities.get(0).getClass().getSimpleName();
        isEntityInstanceOfList = true;
      } else {
        return responseEntity;
      }
    } else {
      return responseEntity;
    }

    target = source + "Dto";

    if (mapperAspect.source() != void.class && mapperAspect.target() != void.class) {
      source = mapperAspect.source().getSimpleName();
      target = mapperAspect.target().getSimpleName();
    }

    try {
      CoreMapper mapper = mapperService.getMapper(source, target);
      if (isEntityInstanceOfList) {
        return ResponseEntity.status(httpStatus)
            .body(mapper.toDto((List<CoreModel>) responseEntity.getBody()));
      } else {
        return ResponseEntity.status(httpStatus).body(mapper.toDto(responseEntity.getBody()));
      }
    } catch (MapperNotFoundException ex) {
      return responseEntity;
    }
  }
}
