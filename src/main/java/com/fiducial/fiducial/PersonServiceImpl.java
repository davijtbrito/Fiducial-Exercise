package com.fiducial.fiducial;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
    
    @Autowired
    private PersonRepository personRepository;    

    @Override
    public List<PersonDto> getAllPerson() {        
        
        List<PersonDto> list = new ArrayList<>();

        personRepository.findAll().stream().forEach(p -> list.add(PersonMapper.getDto(p)));

        return list;
    }

    @Override
    public boolean addPerson(PersonDto person) {        

        try{

            Person p = PersonMapper.getEntity(person);

            if (Objects.isNull(getPersonByName(p.getName()))){
                p = personRepository.save(p);
                return true;

            }            

        }catch(Exception e){            
            System.out.println("ERROR: " + e.getMessage());
        }

        return false;
    }

    @Override
    public PersonDto getPersonByName(String name) {

        Person p = personRepository.findByName(name);
        
        return Objects.isNull(p) ? null : PersonMapper.getDto(p);
    }

    @Override
    public void addListPerson(List<PersonDto> list) {
        list.stream().forEach(p -> this.addPerson(p));        
    }
}
