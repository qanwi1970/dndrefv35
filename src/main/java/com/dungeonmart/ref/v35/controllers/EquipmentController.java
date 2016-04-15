package com.dungeonmart.ref.v35.controllers;

import com.dungeonmart.ref.v35.entities.Equipment;
import com.dungeonmart.ref.v35.exceptions.EquipmentNotFoundException;
import com.dungeonmart.ref.v35.repositories.EquipmentRepository;
import com.dungeonmart.ref.v35.resources.EquipmentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @RequestMapping(path = "/{equipmentId}", method = RequestMethod.GET)
    public HttpEntity<?> find(@PathVariable UUID equipmentId) {
        Equipment equipment = equipmentRepository.findOne(equipmentId);
        if (equipment == null) {
            throw new EquipmentNotFoundException(equipmentId);
        } else {
            return new ResponseEntity<>(new EquipmentResource(equipment), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<?> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sortProperty) {
        PageRequest pageRequest = new PageRequest(page, count, new Sort(direction, sortProperty));
        Page<Equipment> result = equipmentRepository.findAll(pageRequest);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<?> create(@RequestBody @Valid Equipment equipment) {
        Equipment savedEquipment = equipmentRepository.save(equipment);
        EquipmentResource equipmentResource = new EquipmentResource(savedEquipment);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{equipmentId}")
                .buildAndExpand(savedEquipment.getEquipmentId()).toUri());
        return new ResponseEntity<Object>(equipmentResource, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{equipmentId}", method = RequestMethod.PUT)
    public HttpEntity<?> update(@PathVariable UUID equipmentId, @RequestBody @Valid Equipment equipment) {
        Equipment oldEquipment = equipmentRepository.findOne(equipmentId);
        if (oldEquipment == null) throw new EquipmentNotFoundException(equipmentId);

        equipment.setEquipmentId(equipmentId);

        Equipment updatedEquipment = equipmentRepository.save(equipment);
        EquipmentResource equipmentResource = new EquipmentResource(updatedEquipment);

        return new ResponseEntity<Object>(equipmentResource, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{equipmentId}", method = RequestMethod.DELETE)
    public HttpEntity<?> delete(@PathVariable UUID equipmentId) {
        equipmentRepository.delete(equipmentId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
