package br.com.erudio.service;

import br.com.erudio.controllers.PersonController;
import br.com.erudio.data.dto.PersonDTO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.erudio.mapper.ObjectMapper.parse;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper converter;

    public PersonDTO findById(Long id) {
        logger.info("Finding person by id " + id);
        Person person = new Person();
        var entidade = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        var dto = parse(entidade, PersonDTO.class);
        addHateoasLinksRef(dto);
        return dto;

    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating person " + person);
        var entity = parse(person, Person.class);
        var dto = parse(personRepository.save(entity), PersonDTO.class);
        addHateoasLinksRef(dto);
        return dto;
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Update person ");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());
        var dto = parse(personRepository.save(entity), PersonDTO.class);
        addHateoasLinksRef(dto);

        return dto;
    }

    public void delete(Long id) {
        logger.info("Delete person ");
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
        addHateoasLinksRef(new PersonDTO());


    }

    public List<PersonDTO> findAll() {
        logger.info("List person ");
        var persons =  parse(personRepository.findAll(), PersonDTO.class);
        persons.forEach(PersonServices::addHateoasLinksRef);
        return persons;
    }

    private static void addHateoasLinksRef(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("Atualizar").withType("UPDATE"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("Cadastrar").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("Buscar").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withRel("Buscar Por Id").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("Deletar").withType("DELETE"));
    }
}
