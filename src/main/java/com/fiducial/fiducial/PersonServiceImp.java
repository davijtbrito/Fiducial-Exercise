package com.fiducial.fiducial;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService{
    
    @Autowired
    private PersonRepository personRepository;    

    @Override
    public List<Person> findAllPerson() {        
        
        return personRepository.findAll();
    }

    @Override
    public boolean insert(Person person) {        

        try{

            if (Objects.isNull(findByName(person.getName()))){
                person = personRepository.save(person);
                return true;
            }            

        }catch(Exception e){            
            System.out.println("ERROR: " + e.getMessage());
        }

        return false;
    }

    @Override
    public Person findByName(String name) {
        
        return personRepository.findByName(name);
    }
}
