package br.com.erudio.mapper.custom.mapper.custom;

import br.com.erudio.mapper.custom.model.Person;
import org.springframework.stereotype.Service;

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
