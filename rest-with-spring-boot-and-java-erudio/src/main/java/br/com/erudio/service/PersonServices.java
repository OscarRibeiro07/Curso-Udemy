package br.com.erudio.service;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Person create(Person person){
        logger.info("Creating person "+person);
        person.setId(counter.incrementAndGet());
        return person;
    }

    public List<Person> findAll(){

        logger.info("List person ");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    Person mockPerson(int i){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setNome("Nome " + i );
        person.setSobrenome("Sobrenome " + i );
        person.setEndereco("Brasil " );
        person.setGenero("Masculino");
        return person;

    }




}
