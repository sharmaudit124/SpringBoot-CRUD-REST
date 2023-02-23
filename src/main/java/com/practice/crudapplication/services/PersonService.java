package com.practice.crudapplication.services;

import com.practice.crudapplication.entities.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAllPerson();
    public Person getPersonById(int personId);
    public List<Person> getPersonByEmail(String emailId);
    public Person addPerson(Person person);
    public Person updatePerson(Person person);
    public String deletePerson(int personId);
}
