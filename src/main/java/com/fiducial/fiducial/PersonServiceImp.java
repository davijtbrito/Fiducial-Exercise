package com.fiducial.fiducial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService{
    
    @Autowired
    private PersonRepository personRepository;    

    @Override
    public List<Person> findAllPerson() {
        List<Person> list = personRepository.findAll();

        System.out.println(list);
        return list;
    }
}
