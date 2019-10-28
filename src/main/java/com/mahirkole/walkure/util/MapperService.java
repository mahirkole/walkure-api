package com.mahirkole.walkure.util;

import com.mahirkole.walkure.exception.MapperNotFoundException;
import com.mahirkole.walkure.mapper.CoreMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * *
 * https://github.com/sinanyumak/generic-mapper/blob/master/src/main/java/com/sy/genericmapper/GenericMapperService.java
 */
@Component
public class MapperService implements ApplicationContextAware {

  private ApplicationContext applicationContext;
  private Map<String, CoreMapper> mappers = new HashMap<>();

  @PostConstruct
  private void init() {
    Collection<CoreMapper> mappers = getMappers();

    for (CoreMapper mapper : mappers) {
      String targetName =
          GenericTypeResolver.resolveTypeArguments(mapper.getClass(), CoreMapper.class)[0]
              .getSimpleName();
      String sourceName =
          GenericTypeResolver.resolveTypeArguments(mapper.getClass(), CoreMapper.class)[1]
              .getSimpleName();
      this.mappers.put(targetName + "-" + sourceName, mapper);
      this.mappers.put(sourceName + "-" + targetName, mapper);
    }

    getMappers();
  }

  private Collection<CoreMapper> getMappers() {
    return applicationContext.getBeansOfType(CoreMapper.class).values();
  }

  public <SOURCE, TARGET> CoreMapper<SOURCE, TARGET> getMapper(String sourceName, String targetName)
      throws MapperNotFoundException {
    String key = sourceName + "-" + targetName;

    if (this.mappers.containsKey(key)) {
      return this.mappers.get(key);
    } else {
      throw new MapperNotFoundException(sourceName, targetName);
    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}
