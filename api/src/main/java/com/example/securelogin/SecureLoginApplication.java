package com.example.securelogin;

import com.example.securelogin.model.Person;
import com.example.securelogin.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecureLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureLoginApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(PersonService personService){
//        return args -> {
//                    Person p=new Person("Ionescu","bbb","123",1);
//                    personService.addPerson(p);
//        };
//    }
}
