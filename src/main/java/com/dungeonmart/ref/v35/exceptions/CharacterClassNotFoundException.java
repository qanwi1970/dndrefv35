package com.dungeonmart.ref.v35.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CharacterClassNotFoundException extends RuntimeException {
    public CharacterClassNotFoundException(UUID classId) {
        super("Character class with id " + classId + " not found.");
    }
}
