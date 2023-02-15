package com.fiducial.fiducial;

import java.util.List;

public interface PersonService {
    
    public List<PersonDto> findAllPerson();

    public boolean insert(PersonDto person);

    public PersonDto findByName(String name);
}
