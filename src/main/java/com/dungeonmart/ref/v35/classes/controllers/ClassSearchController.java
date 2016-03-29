package com.dungeonmart.ref.v35.classes.controllers;

import com.dungeonmart.ref.v35.classes.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class ClassSearchController {

    private final ClassRepository classRepository;

    @Autowired
    public ClassSearchController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List search(@RequestParam("q") String queryTerm) {
        List classes = classRepository.search("%" + queryTerm + "%");
        return classes == null ? new ArrayList<>() : classes;
    }
}
