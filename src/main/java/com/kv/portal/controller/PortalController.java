package com.kv.portal.controller;

import com.kv.portal.dto.PersonDTO;
import com.kv.portal.service.PortalService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class PortalController {

    private PortalService portalService;

    @GetMapping(value = "/v1/portal/person")
    public @ResponseBody List<PersonDTO> findByFirstName(
            @RequestParam(name = "first_Name") @NotBlank String firstName){
        return portalService.find(firstName);
    }

    @GetMapping(value = "/v1/portal/person/getall")
    public @ResponseBody List<PersonDTO> findAll(
            @RequestParam(name = "first_Name") @NotBlank String firstName){
        return portalService.findAll();
    }

    @PostMapping(value = "/v1/portal/person")
    public @ResponseBody PersonDTO add(
            @RequestBody @Valid PersonDTO personDTO){
        return portalService.add(personDTO);
    }

    @PutMapping(value = "/v1/portal/person")
    public @ResponseBody PersonDTO update(
            @RequestBody @Valid PersonDTO personDTO){
        return portalService.add(personDTO);
    }

    @DeleteMapping(value = "/v1/portal/person")
    public void update(
            @RequestParam(name = "first_Name") @NotBlank String firstName,
            @RequestParam(name = "last_Name") @NotBlank String lastName){
        portalService.delete(firstName, lastName);
    }


}
