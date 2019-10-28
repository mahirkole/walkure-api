package com.asgardianwalkures.walkure.exception;

import org.springframework.http.ResponseEntity;

public abstract class CoreException extends Throwable {

  CoreException() {}

  CoreException(String message) {
    super(message);
  }

  public abstract ResponseEntity handle();
}
