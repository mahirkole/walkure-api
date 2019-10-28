package com.mahirkole.walkure.exception;

public class MapperNotFoundException extends Throwable {

  public MapperNotFoundException(String sourceName, String targetName) {
    super(
        String.format(
            "The mapper to convert Source:[%s] to Target:[%s] could not be found! "
                + "Please specify appropriate Source and Target objects",
            sourceName, targetName));
  }
}
