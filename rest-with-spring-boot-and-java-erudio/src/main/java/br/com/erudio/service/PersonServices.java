package br.com.erudio.service;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding person by id "+id);
        //mock
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setNome("Oscar");
        person.setSobrenome("Ribeiro");
        person.setEndereco("Gamboa do morro - Cairu - Bahia");
        person.setGenero("Masculino");
        return person;
    }




}
