package com.dungeonmart.ref.v35.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Serializable resourceId) {
        super(String.format("Resource with id %s not found", resourceId.toString()));
    }
}
