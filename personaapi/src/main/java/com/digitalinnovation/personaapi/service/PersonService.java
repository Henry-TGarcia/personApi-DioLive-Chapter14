package com.digitalinnovation.personaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovation.personaapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.personaapi.entity.Person;
import com.digitalinnovation.personaapi.repository.PersonRepository;

@Service
public class PersonService {

	// Dependencias
	@Autowired
	private PersonRepository personRepository;

	
	//Métodos
	
	public MessageResponseDTO createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.builder()
				.message("Created person with ID" + savedPerson.getId())
				.build();
	}
}
