package com.fiducial.fiducial;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
		
		assertTrue(list.size() > 0);
	}

}
