package com.github.curriculeon.service;

import com.github.curriculeon.model.Person;
import com.github.curriculeon.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person person) {
        Person personCreated = repository.save(person);
        return personCreated;
    }

    public Person read(Long id) {
        Optional<Person> potentialPerson = repository.findById(id);
        Person person = potentialPerson.get();
        return person;
    }

    public Person update(Long id, Person person) {
        Person personInDataBase = read(id);
        String newFirstName = person.getFirstName();
        String newLastName = person.getLastName();

        personInDataBase.setFirstName(newFirstName);
        personInDataBase.setLastName(newLastName);
        repository.save(personInDataBase);
        return personInDataBase;
    }

    public Person delete(Long id) {
        Person person = read(id);
        repository.delete(person);
        return person;
    }

    public List<Person> readAll() {
        List<Person> personList = new ArrayList<>();
        repository.findAll().forEach(personList::add);
        return personList;
    }
}
