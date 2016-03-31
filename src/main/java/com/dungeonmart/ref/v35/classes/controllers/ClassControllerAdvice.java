package com.dungeonmart.ref.v35.classes.controllers;

import com.dungeonmart.ref.v35.classes.exceptions.CharacterClassNotFoundException;
import com.dungeonmart.ref.v35.classes.exceptions.ClassLevelNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ClassControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CharacterClassNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors characterClassNotFoundExceptionHandler(CharacterClassNotFoundException ex) {
        log.info("CharacterClassNotFound", ex);
        return new VndErrors("CharacterClassNotFound", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ClassLevelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors classLevelNotFoundExceptionHandler(ClassLevelNotFoundException ex) {
        log.info("ClassLevelNotFound", ex);
        return new VndErrors("ClassLevelNotFound", ex.getMessage());
    }
}
