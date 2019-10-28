package com.asgardianwalkures.walkure.mapper;

import java.util.List;

public interface CoreMapper<S, T> {
  T toDto(S source);

  S toModel(T target);

  List<T> toDto(List<S> sourceList);

  List<S> toModel(List<T> targetList);
}
