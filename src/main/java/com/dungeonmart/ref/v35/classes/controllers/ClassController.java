package com.dungeonmart.ref.v35.classes.controllers;

import com.dungeonmart.ref.v35.classes.entities.ClassCharacter;
import com.dungeonmart.ref.v35.classes.exceptions.CharacterClassNotFoundException;
import com.dungeonmart.ref.v35.classes.repositories.ClassRepository;
import com.dungeonmart.ref.v35.classes.resources.ClassCharacterResource;
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
import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/classes")
public class ClassController {
    private final ClassRepository classRepository;

    @Autowired
    public ClassController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<?> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sortProperty) {
        PageRequest pageRequest = new PageRequest(page, count, new Sort(direction, sortProperty));
        Page<ClassCharacter> result = classRepository.findAll(pageRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{classId}", method = RequestMethod.GET)
    public HttpEntity<?> find(@PathVariable UUID classId) {
        ClassCharacter classCharacter = classRepository.findOne(classId);
        if (classCharacter == null) {
            throw new CharacterClassNotFoundException(classId);
        } else {
            return new ResponseEntity<Object>(new ClassCharacterResource(classCharacter), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<?> create(@RequestBody @Valid ClassCharacter classCharacter) {
        long now = Instant.now().getEpochSecond();
        classCharacter.setCreatedTime(now);
        classCharacter.setModifiedTime(now);
        ClassCharacter savedClass = classRepository.save(classCharacter);
        ClassCharacterResource resource = new ClassCharacterResource(savedClass);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{classId}")
                .buildAndExpand(savedClass.getClassCharacterId()).toUri());
        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{classId}", method = RequestMethod.PUT)
    public HttpEntity<?> update(@PathVariable UUID classId, @RequestBody @Valid ClassCharacter classCharacter) {
        ClassCharacter oldClass = classRepository.findOne(classId);
        if (oldClass == null) throw new CharacterClassNotFoundException(classId);

        classCharacter.setClassCharacterId(classId);
        classCharacter.setCreatedTime(oldClass.getCreatedTime());
        classCharacter.setModifiedTime(Instant.now().getEpochSecond());

        ClassCharacter newClass = classRepository.save(classCharacter);
        ClassCharacterResource resource = new ClassCharacterResource(newClass);

        return new ResponseEntity<>(resource, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{classId}", method = RequestMethod.DELETE)
    public HttpEntity<?> delete(@PathVariable UUID classId) {
        classRepository.delete(classId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
