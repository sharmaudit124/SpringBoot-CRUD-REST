package com.practice.crudapplication.services;

import com.practice.crudapplication.entities.Person;
import com.practice.crudapplication.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public Person getPersonById(int personId) {
        return personRepository.findById(personId).orElse(null);
    }

    public List<Person> getPersonByEmail(String emailId) {
        return personRepository.findAllByEmailId(emailId);
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        Person obj = getPersonById(person.getPersonId());
        obj.setPersonId(person.getPersonId());
        obj.setEmailId(person.getEmailId());
        obj.setFirstName(person.getFirstName());
        obj.setLastName(person.getLastName());
        obj.setAddress(person.getAddress());
        obj.setAge(person.getAge());
        personRepository.save(obj);
        return obj;
    }

    public String deletePerson(int personId) {
        personRepository.deleteById(personId);
        return "DELETED";
    }
}
