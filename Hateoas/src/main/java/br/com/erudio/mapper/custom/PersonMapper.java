package br.com.erudio.mapper.custom;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

      public Person converDTOTotEntity(Person person) {

        Person entity = new Person();
        entity.setId(person.getId());
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());

        return entity;
    }


}
