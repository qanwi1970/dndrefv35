package com.dungeonmart.ref.v35.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(UUID domainId) {
        super("Domain with id " + domainId + " not found.");
    }
}
