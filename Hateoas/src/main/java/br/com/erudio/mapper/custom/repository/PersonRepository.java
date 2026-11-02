package br.com.erudio.mapper.custom.repository;

import br.com.erudio.mapper.custom.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
