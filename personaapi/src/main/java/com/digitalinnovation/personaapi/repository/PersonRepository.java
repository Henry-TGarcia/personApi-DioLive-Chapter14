package com.digitalinnovation.personaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalinnovation.personaapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
