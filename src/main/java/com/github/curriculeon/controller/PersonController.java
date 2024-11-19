package com.github.curriculeon.controller;

import com.github.curriculeon.model.Person;
import com.github.curriculeon.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/person-controller")
@RestController
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Person person) {
        final Person responseBody = service.create(person);
        final ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> read(@PathVariable Long id) {
        final Person responseBody = service.read(id);
        final ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Person person) {
        final Person responseBody = service.update(id, person);
        final ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        final Person responseBody = service.delete(id);
        final ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<?>> readAll() {
        final List<?> responseBody = service.readAll();
        final ResponseEntity<List<?>> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }
}
