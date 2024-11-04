package com.in28minutes.rest.webservices.restful_web_services.controller;

import com.in28minutes.rest.webservices.restful_web_services.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restful_web_services.jpa.UserRepository;
import com.in28minutes.rest.webservices.restful_web_services.repository.Post;
import com.in28minutes.rest.webservices.restful_web_services.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpa {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("jpa/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("jpa/users/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public User createUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getPostByUser(@PathVariable Integer id) {
        Optional<User> user = getUser(id);
        return user.map(User::getPosts).orElse(null);
    }
}
