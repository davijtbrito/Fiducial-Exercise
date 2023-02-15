package com.fiducial.fiducial;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService{
    
    @Autowired
    private PersonRepository personRepository;    

    @Override
    public List<PersonDto> findAllPerson() {        
        
        List<PersonDto> list = new ArrayList<>();

        personRepository.findAll().stream().forEach(p -> list.add(PersonMapper.getDto(p)));

        return list;
    }

    @Override
    public boolean insert(PersonDto person) {        

        try{

            Person p = PersonMapper.getEntity(person);

            if (Objects.isNull(findByName(p.getName()))){
                p = personRepository.save(p);
                return true;

            }            

        }catch(Exception e){            
            System.out.println("ERROR: " + e.getMessage());
        }

        return false;
    }

    @Override
    public PersonDto findByName(String name) {

        Person p = personRepository.findByName(name);
        
        return Objects.isNull(p) ? null : PersonMapper.getDto(p);
    }
}
