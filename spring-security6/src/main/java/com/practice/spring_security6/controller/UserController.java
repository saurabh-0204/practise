package com.practice.spring_security6.controller;

import com.practice.spring_security6.entity.User;
import com.practice.spring_security6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User user1 = userRepository.findByUserName(user.getUserName());
        if (!Objects.isNull(user1))
            return "success";
        else
            return "failure";
    }
}
