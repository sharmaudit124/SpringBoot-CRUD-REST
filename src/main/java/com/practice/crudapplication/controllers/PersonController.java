package com.practice.crudapplication.controllers;

import com.practice.crudapplication.entities.Person;
import com.practice.crudapplication.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl service;

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAllPersonDetails() {
        List<Person> personList = service.getAllPerson();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/id/{personId}")
    public ResponseEntity<Person> getPersonDetailById(@PathVariable("personId") int personId) {
        Person person = service.getPersonById(personId);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/email/{emailId}")
    public ResponseEntity<List<Person>> getPersonDetailsByEmailId(@PathVariable("emailId") String emailId) {
        List<Person> person = service.getPersonByEmail(emailId);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<String> addPersonDetail(@RequestBody Person person) {
        Person obj = service.getPersonById(person.getPersonId());
        if (obj == null) {
            service.addPerson(person);
            return new ResponseEntity<>("Data ADDED", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Duplicate Entries with id :" + person.getPersonId() + " not allowed." + "", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePersonDetails(@RequestBody Person person) {
        Person obj = service.getPersonById(person.getPersonId());
        if (obj != null) {
            service.updatePerson(person);
            return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(person, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String>deletePerson(@PathVariable("personId") int personId){
        Person person= service.getPersonById(personId);
        if(person!=null){
            service.deletePerson(personId);
            return new ResponseEntity<>("DELETED",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Data Not Found.",HttpStatus.NOT_FOUND);
        }
    }

}
