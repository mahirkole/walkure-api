package com.mahirkole.walkure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NotFoundException extends CoreException {

    public NotFoundException() {
    }

    public NotFoundException(Class entity, String value) {
        super(String.format("No %s entity found valued as %s", entity.getSimpleName(), value));
    }

    @Override
    public ResponseEntity handle() {
        return response(this, HttpStatus.NOT_FOUND);
    }
}
