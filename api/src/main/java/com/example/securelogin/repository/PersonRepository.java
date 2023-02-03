package com.example.securelogin.repository;

import com.example.securelogin.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query("select p  from Person p where p.email=?1")
    Optional<Person> findByEmail(String email);
}
