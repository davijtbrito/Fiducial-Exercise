package com.fiducial.fiducial;

import java.util.List;

public interface PersonService {
    
    public List<Person> findAllPerson();

    public boolean insert(Person person);

    public Person findByName(String name);
}
