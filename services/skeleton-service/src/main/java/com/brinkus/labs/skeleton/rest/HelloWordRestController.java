package com.brinkus.labs.skeleton.rest;

import com.brinkus.labs.skeleton.exception.ServiceException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/v1/hello",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class HelloWordRestController {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/world"
    )
    public ResponseEntity<String> lookup() throws ServiceException {
        return ResponseEntity.ok(String.format("{\"hello\": \"world\"}"));
    }

}
