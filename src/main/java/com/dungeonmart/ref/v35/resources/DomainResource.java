package com.dungeonmart.ref.v35.resources;

import com.dungeonmart.ref.v35.controllers.DomainController;
import com.dungeonmart.ref.v35.entities.Domain;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class DomainResource extends ResourceSupport {

    private final Domain domain;

    public DomainResource(Domain domain) {
        this.domain = domain;
        this.add(linkTo(methodOn(DomainController.class).find(domain.getDomainId())).withSelfRel());
    }

    public Domain getDomain() { return domain; }
}
