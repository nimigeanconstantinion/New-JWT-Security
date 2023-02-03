package com.example.securelogin.web;

import com.example.securelogin.model.Person;
import com.example.securelogin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/secure-login")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService=personService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/allPersons")

    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person p){

        personService.addPerson(p);
    }
}
