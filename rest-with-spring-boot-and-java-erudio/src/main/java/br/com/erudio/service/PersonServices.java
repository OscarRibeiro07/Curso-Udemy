package br.com.erudio.service;

import br.com.erudio.data.dto.PersonDTO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.ObjectMapper;
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
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    private PersonRepository personRepository;

    public PersonDTO findById(Long id) {
        logger.info("Finding person by id " + id);
        //mock
        Person person = new Person();
//        person.setNome("Oscar");
//        person.setSobrenome("Ribeiro");
//        person.setEndereco("Gamboa do morro - Cairu - Bahia");
//        person.setGenero("Masculino");
        var entidade =  personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        return parse(entidade, PersonDTO.class);

    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating person " + person);
        var  entity = parse(person, Person.class);
        return parse(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Update person ");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());
       return parse( personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Delete person ");
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);


    }

    public List<PersonDTO> findAll() {

        logger.info("List person ");

        return parse( personRepository.findAll(), PersonDTO.class);
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
