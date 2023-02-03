package com.example.securelogin.security;

import com.example.securelogin.model.Person;
import com.example.securelogin.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private PersonRepository personRepository;

    @Autowired
    public UserDetailServiceImpl(PersonRepository personRepository){
        this.personRepository=personRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person=personRepository.findByEmail(s).get();
        if(person!=null){
            return person;
        }
        throw new UsernameNotFoundException("User email "+person.getEmail()+" did not exist!!");
    }
}
