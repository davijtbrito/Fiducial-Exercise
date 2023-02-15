package com.fiducial.fiducial;

import java.util.List;

/**
 * Interface for all Person logic that were required by the exercise. It's 
 * implemented by {@link PersonServiceImpl}
 */
public interface PersonService {
    
    /**
     * Returns all persons in the database.
     * @return a list of {@link PersonDto}
     */
    public List<PersonDto> getAllPerson();

    /**
     * Returns "true" if the person was added successfully. In case there's a person 
     * with the same name — or even any problem during the saving — it will return "false".
     * @param person the person (object from {@link PersonDto}) that will bee added 
     * @return
     */
    public boolean addPerson(PersonDto person);


    /**
     * Add persons in the database.
     * @param list list of {@link PersonDto}.
     */
    public void addListPerson(List<PersonDto> list);

    /**
     * Return the person by the name.
     * @param name the name of the person.
     * @return {@link PersonDto}
     */
    public PersonDto getPersonByName(String name);
}
