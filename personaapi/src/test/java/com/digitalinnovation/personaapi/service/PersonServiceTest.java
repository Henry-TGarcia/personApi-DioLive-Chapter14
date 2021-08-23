package com.digitalinnovation.personaapi.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.digitalinnovation.personaapi.dto.request.PersonDTO;
import com.digitalinnovation.personaapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.personaapi.entity.Person;
import com.digitalinnovation.personaapi.repository.PersonRepository;
import com.digitalinnovation.personaapi.utils.PersonUtils;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	// Dependencias
	@Mock
	private PersonRepository repository;

	@InjectMocks
	private PersonService service;

	@Test
	void testGivenPersonDTOThenReturnSuccessSavedMessage() {
		PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        when(repository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = service.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

	private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
		return MessageResponseDTO.builder()
				.message("Person successfully created with ID " + savedPersonId)
				.build();
	}
}
