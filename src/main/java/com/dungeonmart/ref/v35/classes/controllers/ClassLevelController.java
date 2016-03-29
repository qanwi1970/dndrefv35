package com.dungeonmart.ref.v35.classes.controllers;

import com.dungeonmart.ref.v35.classes.entities.ClassCharacter;
import com.dungeonmart.ref.v35.classes.entities.ClassLevel;
import com.dungeonmart.ref.v35.classes.exceptions.CharacterClassNotFoundException;
import com.dungeonmart.ref.v35.classes.exceptions.ClassLevelNotFoundException;
import com.dungeonmart.ref.v35.classes.repositories.ClassLevelRepository;
import com.dungeonmart.ref.v35.classes.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/classes/{classId}/levels")
public class ClassLevelController {

    @Autowired
    private ClassLevelRepository classLevelRepository;

    @Autowired
    private ClassRepository classRepository;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<ClassLevel>> getAll(@PathVariable("classId") UUID classId) {
        ClassCharacter classCharacter = classRepository.findOne(classId);
        if (classCharacter == null) {
            throw new CharacterClassNotFoundException(classId);
        }
        List<ClassLevel> classLevelList = classLevelRepository.findByName(classCharacter.getName());
        return new ResponseEntity<>(classLevelList, HttpStatus.OK);
    }

    @RequestMapping(path = "/{level}", method = RequestMethod.GET)
    public HttpEntity<ClassLevel> getOne(@PathVariable("classId") UUID classId, @PathVariable("level") int level) {
        ClassCharacter classCharacter = classRepository.findOne(classId);
        if (classCharacter == null) {
            throw new CharacterClassNotFoundException(classId);
        }
        ClassLevel classLevel = classLevelRepository.findByNameAndLevel(classCharacter.getName(), level);
        if (classLevel == null) {
            throw new ClassLevelNotFoundException(classId.toString(), level);
        }
        return new ResponseEntity<>(classLevel, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<ClassLevel> addOne(@PathVariable("classId") UUID classId, @RequestBody @Valid ClassLevel classLevel) {
        ClassLevel addedClassLevel = classLevelRepository.save(classLevel);
        return new ResponseEntity<>(addedClassLevel, HttpStatus.OK);
    }

    @RequestMapping(path = "/{level}", method = RequestMethod.PUT)
    public HttpEntity<ClassLevel> updateOne(@PathVariable("classId") UUID classId,
                                            @PathVariable("level") int level,
                                            @RequestBody @Valid ClassLevel classLevel) {
        ClassLevel updatedClassLevel = classLevelRepository.save(classLevel);
        return new ResponseEntity<>(updatedClassLevel, HttpStatus.OK);
    }

    @RequestMapping(path = "/{level}", method = RequestMethod.DELETE)
    public HttpEntity deleteOne(@PathVariable("classId") UUID classId, @PathVariable("level") int level) {
        ClassCharacter classCharacter = classRepository.findOne(classId);
        if (classCharacter == null) {
            throw new CharacterClassNotFoundException(classId);
        }
        ClassLevel classLevel = classLevelRepository.findByNameAndLevel(classCharacter.getName(), level);
        if (classLevel == null) {
            throw new ClassLevelNotFoundException(classId.toString(), level);
        }
        classLevelRepository.delete(classLevel.getClassLevelId());
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
