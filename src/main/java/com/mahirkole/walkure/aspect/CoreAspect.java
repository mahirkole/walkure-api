package com.mahirkole.walkure.aspect;

import org.aspectj.lang.annotation.Pointcut;

public abstract class CoreAspect {

  @Pointcut("@annotation(com.mahirkole.walkure.annotation.MapperAspect)")
  protected void beanAnnotatedWithMapperAspect() {}
}
