package com.dungeonmart.ref.v35.exceptions;

import java.util.UUID;

public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException(UUID equipmentId) {
        super("Equipment with id " + equipmentId + " not found.");
    }
}
