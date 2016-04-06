package com.dungeonmart.ref.v35.exceptions;

import java.util.UUID;

public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(UUID domainId) {
        super("Domain with id " + domainId + " not found.");
    }
}
