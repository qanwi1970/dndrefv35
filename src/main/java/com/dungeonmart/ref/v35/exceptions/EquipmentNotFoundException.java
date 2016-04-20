package com.dungeonmart.ref.v35.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException(UUID equipmentId) {
        super("Equipment with id " + equipmentId + " not found.");
    }
}
