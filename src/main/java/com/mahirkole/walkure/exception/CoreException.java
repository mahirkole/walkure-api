package com.mahirkole.walkure.exception;

import com.mahirkole.walkure.util.CoreResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class CoreException extends Throwable {

    CoreException() {
    }

    CoreException(String message) {
        super(message);
    }

    public abstract ResponseEntity handle();

    public ResponseEntity response(CoreException ex, HttpStatus httpStatus) {
        return new ResponseEntity<>(new CoreResponse(false, ex.getMessage()), httpStatus);
    }
}
