package br.com.erudio.controllers;

import br.com.erudio.data.dto.PersonDTO;
import br.com.erudio.mapper.ObjectMapper;
import br.com.erudio.model.Person;
import br.com.erudio.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {



    // chamada de injeção de dependencia
    @Autowired
    private PersonServices personServices;



    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(@PathVariable(value = "id") Long id) {
        return personServices.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll() {

        return personServices.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person) {
        return personServices.create(person);
    }


    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO person) {
        return personServices.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
            personServices.delete(id);
            return ResponseEntity.noContent().build();
    }


}
