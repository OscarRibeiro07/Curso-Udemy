package br.com.erudio.service;

import br.com.erudio.data.dto.PersonDTO;
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

    public PersonDTO findById(Long id) {
        logger.info("Finding person by id " + id);
        Person person = new Person();
        var entidade = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        return parse(entidade, PersonDTO.class);

    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating person " + person);
        var entity = parse(person, Person.class);
        return parse(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Update person ");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());
        return parse(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Delete person ");
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);


    }

    public List<PersonDTO> findAll() {
        logger.info("List person ");
        return parse(personRepository.findAll(), PersonDTO.class);
    }

}
