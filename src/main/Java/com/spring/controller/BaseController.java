package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    protected ResponseEntity Ok() {
        return new ResponseEntity(HttpStatus.OK);
    }

    <T> ResponseEntity Ok(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    <T> ResponseEntity BadRequest(T body) {
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity BadRequest() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
