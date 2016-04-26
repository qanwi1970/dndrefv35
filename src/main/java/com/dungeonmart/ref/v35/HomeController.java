package com.dungeonmart.ref.v35;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @RequestMapping(path = "/info")
    public HttpEntity<?> getInfo() {
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put("name", "Dungeonmart D&D v3.5 Reference");

        return new ResponseEntity<Object>(infoMap, HttpStatus.OK);
    }
}
