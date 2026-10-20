package br.com.erudio.service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    private PersonRepository personRepository;

    public Person findById(Long id) {
        logger.info("Finding person by id " + id);
        //mock
        Person person = new Person();
//        person.setNome("Oscar");
//        person.setSobrenome("Ribeiro");
//        person.setEndereco("Gamboa do morro - Cairu - Bahia");
//        person.setGenero("Masculino");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public Person create(Person person) {
        logger.info("Creating person " + person);
        Person savedPerson = personRepository.save(person);
        return person;
    }

    public Person update(Person person) {
        logger.info("Update person ");
        return personRepository.save(person);
    }

    public void delete(Long id) {
        logger.info("Delete person ");
       Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        personRepository.delete(person);


    }

    public List<Person> findAll() {

        logger.info("List person ");

        return personRepository.findAll();
    }
//
//    Person mockPerson(int i) {
//        Person person = new Person();
//        person.setId(counter.incrementAndGet());
//        person.setNome("Nome " + i);
//        person.setSobrenome("Sobrenome " + i);
//        person.setEndereco("Brasil ");
//        person.setGenero("Masculino");
//        return person;
//
//    }


}
