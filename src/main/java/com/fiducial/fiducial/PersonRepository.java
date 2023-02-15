package com.fiducial.fiducial;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for the entity {@link Person} 
 */
public interface PersonRepository extends JpaRepository<Person, Long>{    

    /**
     * Returns the Person using the name as key.
     * @param name
     * @return {@link Person}
     */
    public Person findByName(String name);      
}
