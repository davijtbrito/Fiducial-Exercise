package com.fiducial.fiducial;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
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

		List<PersonDto> list = personService.getAllPerson();
		System.out.println("All Persons in the Database: " + list);
		assertTrue(list.size() > 0);
	}

	@Test
	void getPerson(){

		PersonDto person = personService.getPersonByName("David");		
		assertTrue(Objects.nonNull(person));
	}

	@Test
	void addPerson(){

		PersonDto person = new PersonDto(null, "Gorbachev");		
		
		assertTrue(personService.addPerson(person));
		assertFalse(personService.addPerson(person));
	}

	@Test
	void addListPerson(){
		
		int total = personService.getAllPerson().size();

		List<PersonDto> list = new ArrayList<>();
		list.add(new PersonDto(null, "Mikail Gorbachev"));
		list.add(new PersonDto(null, "Margareth Tatcher"));
		list.add(new PersonDto(null, "Ronanld Regan"));
		list.add(new PersonDto(null, "Margareth Tatcher"));

		personService.addListPerson(list);		
		
		int newTotal = personService.getAllPerson().size();

		assertTrue(total == newTotal - 3);		
	}
}
