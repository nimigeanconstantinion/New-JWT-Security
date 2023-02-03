package com.example.securelogin.service;

import com.example.securelogin.model.Person;
import com.example.securelogin.repository.PersonRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service

public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    public void addPerson(Person p){
        personRepository.save(p);
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public boolean validateLogin(String email,String passw){
        if(personRepository.findByEmail(email).isPresent()&&personRepository.findByEmail(email).get().getPassword()==passw){
            return true;
        }
        return false;
    }

}
