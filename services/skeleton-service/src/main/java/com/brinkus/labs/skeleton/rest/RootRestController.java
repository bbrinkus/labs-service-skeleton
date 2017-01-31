package com.brinkus.labs.skeleton.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RootRestController {

    @RequestMapping(
            method = RequestMethod.GET,
            value = { "/v1" }
    )
    public ResponseEntity<String> timestamp() {
        return ResponseEntity.ok(String.format("{\"timestamp\": %d}", System.currentTimeMillis()));
    }

}