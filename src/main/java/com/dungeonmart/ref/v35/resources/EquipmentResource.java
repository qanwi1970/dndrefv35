package com.dungeonmart.ref.v35.resources;

import com.dungeonmart.ref.v35.entities.Equipment;
import org.springframework.hateoas.ResourceSupport;

public class EquipmentResource extends ResourceSupport {

    private final Equipment equipment;

    public EquipmentResource(Equipment equipment) {
        this.equipment = equipment;
        // TODO add self link
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
