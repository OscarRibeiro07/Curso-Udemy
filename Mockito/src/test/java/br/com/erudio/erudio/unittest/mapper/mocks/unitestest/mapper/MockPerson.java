package br.com.erudio.erudio.unittest.mapper.mocks.unitestest.mapper;

import br.com.erudio.data.dto.PersonDTO;
import br.com.erudio.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity() {return mockEntity();}

    public PersonDTO mockDTO() {return mockDTO();}

    public List<Person> mockEntityList(){

        List<Person> list = new ArrayList<>();
        for(int i=0;i<14;i++){
            list.add(mockEntity(i));
        }

        return list;
    }

    public List<PersonDTO> mockDTOList(){

        List<PersonDTO> list = new ArrayList<>();
        for(int i=0;i<14;i++){
            list.add(mockDTO(i));
        }
        return list;
    }

    public Person mockEntity(Integer number){
        Person person = new Person();

        person.setNome("Nome teste: " + number);
        person.setSobrenome("Sobrenome teste: " + number);
        person.setEndereco("Endereco teste: " + number);
        person.setGenero("Genero teste: " + number);
        person.setId(number.longValue());
        return person;

    }


    public PersonDTO mockDTO(Integer number){
        PersonDTO personDto = new PersonDTO();

        personDto.setNome("Nome teste: " + number);
        personDto.setSobrenome("Sobrenome teste: " + number);
        personDto.setEndereco("Endereco teste: " + number);
        personDto.setGenero("Genero teste: " + number);
        personDto.setId(number.longValue());
        return personDto;

    }


}
