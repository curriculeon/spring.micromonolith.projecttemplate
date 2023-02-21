package com.github.curriculeon.controller;

import com.github.curriculeon.model.Person;
import com.github.curriculeon.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @RequestMapping(value = "/create-default", method = RequestMethod.POST)
    public ResponseEntity<Person> create() {
        Person responseBody = service.create(new Person(0L, "Leon", "Hunter"));
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/get-bean", method = RequestMethod.GET)
    @Qualifier("default-person")
    public ResponseEntity<Person> getPersonBean(Person person) {
        return new ResponseEntity<>(person, HttpStatus.OK);
    }


    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person responseBody = service.create(person);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> read(@PathVariable Long id) {
        Person responseBody = service.read(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        Person responseBody = service.update(id, person);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        Person responseBody = service.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> readAll() {
        List<Person> responseBody = service.readAll();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


}
