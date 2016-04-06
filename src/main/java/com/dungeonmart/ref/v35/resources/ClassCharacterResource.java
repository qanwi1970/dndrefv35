package com.dungeonmart.ref.v35.resources;

import com.dungeonmart.ref.v35.controllers.ClassController;
import com.dungeonmart.ref.v35.controllers.ClassLevelController;
import com.dungeonmart.ref.v35.entities.ClassCharacter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ClassCharacterResource extends ResourceSupport {

    private final ClassCharacter classCharacter;

    public ClassCharacterResource(ClassCharacter classCharacter) {
        this.classCharacter = classCharacter;
        this.add(linkTo(methodOn(ClassController.class).find(classCharacter.getClassCharacterId())).withSelfRel());
        this.add(linkTo(methodOn(ClassLevelController.class).getAll(classCharacter.getClassCharacterId())).withRel("levels"));
    }

    public ClassCharacter getClassCharacter() {
        return classCharacter;
    }
}
