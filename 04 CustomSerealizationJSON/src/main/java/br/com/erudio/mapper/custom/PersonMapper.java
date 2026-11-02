package br.com.erudio.mapper.custom;

import br.com.erudio.dto.v2.PersonDTOV2;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityTODTO(Person person) {

        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setNome(person.getNome());
        dto.setSobrenome(person.getSobrenome());
        dto.setEndereco(person.getEndereco());
        dto.setGenero(person.getGenero());
        dto.setNascimento(new Date());

        return dto;
    }


    public Person converDTOTotEntity(Person person) {

        Person entity = new Person();
        entity.setId(person.getId());
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());
        //   entity.setNascimento(new Date());

        return entity;
    }


}
