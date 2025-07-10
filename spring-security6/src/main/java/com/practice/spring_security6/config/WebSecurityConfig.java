package com.practice.spring_security6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/register","/login").permitAll()
                        .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

//    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("saurabh")
                .password("{noop}saurabh123").roles("student").build();
        UserDetails user2 = User.withUsername("neha")
                .password("{noop}neha123").roles("teacher")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}
