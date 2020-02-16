package com.kv.portal.service;

import com.kv.portal.dto.PersonDTO;

import java.util.List;

public interface PortalService {

    List<PersonDTO> findAll();
    PersonDTO add(PersonDTO personDTO);

    PersonDTO update(PersonDTO personDTO);

    List<PersonDTO> find(String firstName);

    void delete(String firstName, String lastName);
}
