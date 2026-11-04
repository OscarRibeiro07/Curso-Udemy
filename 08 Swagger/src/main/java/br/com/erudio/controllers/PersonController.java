package br.com.erudio.controllers;

import br.com.erudio.controllers.docs.PersonControllerDocs;
import br.com.erudio.data.dto.PersonDTO;
import br.com.erudio.service.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/person/v1")
@RestController
@Tag(name = "", description = "Endipoint for managing People")
public class PersonController implements PersonControllerDocs {

    @Autowired
    private PersonServices personServices;


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    @Override
    public PersonDTO findById(@PathVariable(value = "id") Long id) {
        return personServices.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)

    @Override
    public List<PersonDTO> findAll() {

        return personServices.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Override
    public PersonDTO create(@RequestBody PersonDTO person) {
        return personServices.create(person);
    }



    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public PersonDTO update(@RequestBody PersonDTO person) {
        return personServices.update(person);
    }


    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
