package com.fiducial.fiducial;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{    

    public Person findByName(String name);
    
    public List<Person> findAll();
}
