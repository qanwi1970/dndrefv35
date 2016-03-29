package com.dungeonmart.ref.v35.classes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClassLevelNotFoundException extends RuntimeException {
    public ClassLevelNotFoundException(String className, int level) {
        super(String.format("Level %d not found for class %s", level, className));
    }
}
