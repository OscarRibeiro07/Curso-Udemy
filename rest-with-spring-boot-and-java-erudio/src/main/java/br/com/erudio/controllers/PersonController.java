package br.com.erudio.controllers;

import br.com.erudio.model.Person;
import br.com.erudio.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController {


        // chamada de injeção de dependencia
        @Autowired
        private PersonServices personServices;

        @RequestMapping(value = "/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
        public Person findById(@PathVariable(value = "id") String id){
            return personServices.findById(id);
        }

}
