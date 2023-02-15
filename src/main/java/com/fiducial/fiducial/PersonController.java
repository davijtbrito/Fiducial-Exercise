package com.fiducial.fiducial;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@summary Responsable for the interface between the requests and Persons.}
 * {@literal  }
 * {@literal see also: }
 * {@link PersonDto} 
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @GetMapping("/findAll")
    public ResponseEntity<List<PersonDto>> getAllPersons(){
        return ResponseEntity.ok().body(personService.getAllPerson());
    }


    @GetMapping("/get")
    public ResponseEntity<PersonDto> getPerson(@RequestParam String name){
        PersonDto p = personService.getPersonByName(name);

        if (Objects.nonNull(p)){
            return ResponseEntity.ok().body(p);
        }
        
        return ResponseEntity.badRequest().body(new PersonDto(null, "null"));
    }

    @PostMapping("/insert")
    public ResponseEntity<String> addPerson(@RequestBody PersonDto p){        

        if (personService.addPerson(p)){
            return ResponseEntity.ok("Person added!");
        }

        return ResponseEntity.badRequest().body("Fail to add the person");
    }

    @PostMapping("/insertAll")
    public ResponseEntity<String> addPerson(@RequestBody List<PersonDto> list){        

        personService.addListPerson(list);
        return ResponseEntity.ok("List of Persons were added!");        
    }
}
