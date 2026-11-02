package br.com.erudio.service;


import br.com.erudio.dto.v1.PersonDTOV1;
import br.com.erudio.dto.v2.PersonDTOV2;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static br.com.erudio.mapper.ObjectMapper.parse;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper converter;

    public PersonDTOV1 findById(Long id) {
        logger.info("Finding person by id " + id);
        //mock
        Person person = new Person();
//        person.setNome("Oscar");
//        person.setSobrenome("Ribeiro");
//        person.setEndereco("Gamboa do morro - Cairu - Bahia");
//        person.setGenero("Masculino");
        var entidade = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        return parse(entidade, PersonDTOV1.class);

    }

    public PersonDTOV1 create(PersonDTOV1 person) {
        logger.info("Creating person " + person);
        var entity = parse(person, Person.class);
        return parse(personRepository.save(entity), PersonDTOV1.class);
    }


    public PersonDTOV2 createv2(Person person) {
        logger.info("Creating person " + person);
        var entity = converter.converDTOTotEntity(person);
        return converter.convertEntityTODTO(personRepository.save(entity));
    }

    public PersonDTOV1 update(PersonDTOV1 person) {
        logger.info("Update person ");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());
        return parse(personRepository.save(entity), PersonDTOV1.class);
    }

    public void delete(Long id) {
        logger.info("Delete person ");
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);


    }

    public List<PersonDTOV1> findAll() {

        logger.info("List person ");

        return parse(personRepository.findAll(), PersonDTOV1.class);
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
