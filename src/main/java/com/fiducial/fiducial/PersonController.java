package com.fiducial.fiducial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @GetMapping("/findAll")
    public ResponseEntity<List<PersonDto>> getAllPersons(){
        return ResponseEntity.ok().body(personService.findAllPerson());
    }

    @PostMapping("/insert")
    public ResponseEntity<String> addPerson(@RequestBody PersonDto p){        

        if (personService.insert(p)){
            return ResponseEntity.ok("Person added!");
        }

        return ResponseEntity.badRequest().body("Fail to add the person");
    }
}
