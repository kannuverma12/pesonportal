package com.kv.portal.service.impl;

import com.kv.portal.dto.PersonDTO;
import com.kv.portal.model.Person;
import com.kv.portal.repository.PersonRepository;
import com.kv.portal.service.PortalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@AllArgsConstructor
public class PortalServiceImpl implements PortalService {

    private PersonRepository personRepository;

    @Override
    public List<PersonDTO> findAll() {
        List<Person> persons = personRepository.findAll();
        List<PersonDTO> personDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(persons)) {
            for (Person person : persons) {
                PersonDTO personDTO1 = new PersonDTO();
                BeanUtils.copyProperties(person, personDTO1);
                personDTOS.add(personDTO1);
            }
        }
        return personDTOS;
    }

    @Override public PersonDTO add(PersonDTO personDTO) {
        Person person = new Person();
        BeanUtils.copyProperties(personDTO, person);
        Person person1 = personRepository.save(person);
        PersonDTO personDTO1 = new PersonDTO();
        BeanUtils.copyProperties(person1, personDTO1);
        return personDTO1;
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        Person person = new Person();
        BeanUtils.copyProperties(personDTO, person);
        Person person1 = personRepository.save(person);
        PersonDTO personDTO1 = new PersonDTO();
        BeanUtils.copyProperties(person1, personDTO1);
        return personDTO1;
    }

    @Override
    public List<PersonDTO> find(String firstName) {
        List<Person> persons = personRepository.findAllByFirstName(firstName);
        List<PersonDTO> personDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(persons)) {
            for (Person person : persons) {
                PersonDTO personDTO1 = new PersonDTO();
                BeanUtils.copyProperties(person, personDTO1);
                personDTOS.add(personDTO1);
            }
        }
        return personDTOS;
    }

    @Override
    public void delete(String firstName, String lastName) {
        personRepository.deleteByFirstNameAndLastName(firstName, lastName);
    }
}
