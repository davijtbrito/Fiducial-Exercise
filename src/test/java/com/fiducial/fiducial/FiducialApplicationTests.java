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

		List<Person> list = personService.findAllPerson();
		System.out.println("All Persons in the Database: " + list);
		assertTrue(list.size() > 0);
	}

	@Test
	void getPerson(){

		Person person = personService.findByName("David");		
		assertTrue(Objects.nonNull(person));
	}

	@Test
	void addPerson(){

		Person person = new Person();		
		person.setName("Gorbachev");
		
		assertTrue(personService.insert(person));
		assertFalse(personService.insert(person));
	}
}
