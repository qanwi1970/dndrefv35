package com.dungeonmart.ref.v35.controllers;


import com.dungeonmart.ref.v35.entities.Equipment;
import com.dungeonmart.ref.v35.entities.PagingAndSortingEntity;
import com.dungeonmart.ref.v35.exceptions.EquipmentNotFoundException;
import com.dungeonmart.ref.v35.resources.EquipmentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.UUID;

class PagingAndSortingController<T extends PagingAndSortingEntity, K extends Serializable> {

    @Autowired
    private PagingAndSortingRepository<T, K> controllerRepository;

    @RequestMapping(path = "/{resourceId}", method = RequestMethod.GET)
    public HttpEntity<?> get(@PathVariable K resourceId) {
        T resource = controllerRepository.findOne(resourceId);
        if (resource == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<?> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sortProperty) {
        PageRequest pageRequest = new PageRequest(page, count, new Sort(direction, sortProperty));
        Page<T> result = controllerRepository.findAll(pageRequest);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<?> create(@RequestBody @Valid T resource) {
        T savedResource = controllerRepository.save(resource);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{resourceId}")
                .buildAndExpand(savedResource.getId()).toUri());
        return new ResponseEntity<Object>(savedResource, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{resourceId}", method = RequestMethod.PUT)
    public HttpEntity<?> update(@PathVariable K resourceId, @RequestBody @Valid T resource) {
        T oldResource = controllerRepository.findOne(resourceId);
        if (oldResource == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        if (!resourceId.equals(resource.getId())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        T updatedResource = controllerRepository.save(resource);

        return new ResponseEntity<Object>(updatedResource, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{resourceId}", method = RequestMethod.DELETE)
    public HttpEntity<?> delete(@PathVariable K resourceId) {
        controllerRepository.delete(resourceId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
