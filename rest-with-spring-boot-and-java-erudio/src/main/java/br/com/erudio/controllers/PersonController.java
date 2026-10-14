package br.com.erudio.controllers;

import br.com.erudio.model.Person;
import br.com.erudio.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Person> findAll(){

            return personServices.findAll();
        }

        @RequestMapping(
                method = RequestMethod.POST,
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE
        )
         public Person create(@RequestBody Person person){
                return personServices.create(person);
        }

}
