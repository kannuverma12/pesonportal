package com.kv.portal.repository;

import com.kv.portal.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

    Person save(Person emp);

    void deleteByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findAllByFirstName(String firstName);



}
