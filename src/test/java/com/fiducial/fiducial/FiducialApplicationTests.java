package com.fiducial.fiducial;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FiducialApplicationTests {

	@Autowired
	private PersonService personService;

	@Test
	void contextLoads() {
	}

	@Test
	void getAllPerson(){

		List<PersonDto> list = personService.findAllPerson();
		System.out.println("All Persons in the Database: " + list);
		assertTrue(list.size() > 0);
	}

	@Test
	void getPerson(){

		PersonDto person = personService.findByName("David");		
		assertTrue(Objects.nonNull(person));
	}

	@Test
	void addPerson(){

		PersonDto person = new PersonDto(null, "Gorbachev");		
		
		assertTrue(personService.insert(person));
		assertFalse(personService.insert(person));
	}
}
