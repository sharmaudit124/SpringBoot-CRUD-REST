package com.practice.crudapplication.repositories;

import com.practice.crudapplication.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    public List<Person> findAllByEmailId(String emailId);
}
