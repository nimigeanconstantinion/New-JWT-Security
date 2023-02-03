package com.example.securelogin.security;

import com.example.securelogin.jwt.JwtConfig;
import com.example.securelogin.jwt.JwtTokenVerifier;
import com.example.securelogin.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.example.securelogin.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserDetailServiceImpl userDetailsService;


    @Bean
    public SecurityConfigurer securityConfigurerAdapter() {
        return new SecurityConfigurerAdapter() {
            @Override
            public void configure(HttpSecurity http) throws Exception {
                http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and().addFilterBefore(new JwtUsernameAndPasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                        .authorizeRequests().antMatchers("/api/v1/**").authenticated();
            }
        };
    }
}
