package com.example.securelogin.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

import java.util.Collection;

import static javax.persistence.GenerationType.SEQUENCE;
import static com.example.securelogin.security.UserRole.PERSON;

@Entity(name = "Person")
@Table(name = "persons")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")

public class Person implements UserDetails {
    @Id
    @SequenceGenerator(
            name="person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name="name"
    )
    private String name;

    @Column(
            name="email",
            nullable = false
    )
    private String email;

    @Column(
            name = "password",
            nullable = false
    )
    private String password;


    @Column(
            name = "role"
    )
    private int role;

    public Person(String name,String email,String password,int role){
        this.email=email;
        this.name=name;
        this.password=new BCryptPasswordEncoder().encode(password);
        this.role=role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return PERSON.getGrantedAuthorities();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
