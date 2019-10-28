package com.asgardianwalkures.walkure.aspect;

import org.aspectj.lang.annotation.Pointcut;

public abstract class CoreAspect {

  @Pointcut("@annotation(com.asgardianwalkures.walkure.annotation.MapperAspect)")
  protected void beanAnnotatedWithMapperAspect() {}
}
