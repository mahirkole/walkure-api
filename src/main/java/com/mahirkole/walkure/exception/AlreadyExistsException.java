package com.mahirkole.walkure.exception;

import com.mahirkole.walkure.util.CoreResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AlreadyExistsException extends CoreException {

  public AlreadyExistsException(Class entity, String value) {
    super(
        String.format("There is already an %s entity valued as %s", entity.getSimpleName(), value));
  }

  @Override
  public ResponseEntity handle() {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(new CoreResponse(null, super.getMessage()));
  }
}
