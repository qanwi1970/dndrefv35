package com.dungeonmart.ref.v35.controllers;

import com.dungeonmart.ref.v35.entities.Domain;
import com.dungeonmart.ref.v35.exceptions.DomainNotFoundException;
import com.dungeonmart.ref.v35.repositories.DomainRepository;
import com.dungeonmart.ref.v35.resources.DomainResource;
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
@RequestMapping(path = "/domains")
public class DomainController {

    @Autowired
    private DomainRepository domainRepository;

    @RequestMapping(path = "/{domainId}", method = RequestMethod.GET)
    public HttpEntity<?> find(@PathVariable UUID domainId) {
        Domain domain = domainRepository.findOne(domainId);
        if (domain == null) {
            throw new DomainNotFoundException(domainId);
        } else {
            return new ResponseEntity<>(new DomainResource(domain), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<?> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sortProperty) {
        PageRequest pageRequest = new PageRequest(page, count, new Sort(direction, sortProperty));
        Page<Domain> result = domainRepository.findAll(pageRequest);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<?> create(@RequestBody @Valid Domain domain) {
        Domain savedDomain = domainRepository.save(domain);
        DomainResource domainResource = new DomainResource(savedDomain);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{domainId}")
                .buildAndExpand(savedDomain.getDomainId()).toUri());
        return new ResponseEntity<Object>(domainResource, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{domainId}", method = RequestMethod.PUT)
    public HttpEntity<?> update(@PathVariable UUID domainId, @RequestBody @Valid Domain domain) {
        Domain oldDomain = domainRepository.findOne(domainId);
        if (oldDomain == null) throw new DomainNotFoundException(domainId);

        domain.setDomainId(domainId);

        Domain updatedDomain = domainRepository.save(domain);
        DomainResource domainResource = new DomainResource(updatedDomain);

        return new ResponseEntity<Object>(domainResource, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{domainId}", method = RequestMethod.DELETE)
    public HttpEntity<?> delete(@PathVariable UUID domainId) {
        domainRepository.delete(domainId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
