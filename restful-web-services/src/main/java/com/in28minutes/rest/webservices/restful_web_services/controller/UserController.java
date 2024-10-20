package com.in28minutes.rest.webservices.restful_web_services.controller;

import com.in28minutes.rest.webservices.restful_web_services.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restful_web_services.repository.User;
import com.in28minutes.rest.webservices.restful_web_services.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDaoService userDaoService;

    @GetMapping("users")
    public List<User> getUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("users/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userDaoService.findById(id);
        if(user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    @PostMapping("users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
