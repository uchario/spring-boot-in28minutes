package com.in28minutes.rest.webservices.restful_web_services.controller;

import com.in28minutes.rest.webservices.restful_web_services.repository.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("hello-world")
    public String helloworld() {
        return "Hello World";
    }

    @GetMapping("student")
    public Student getStudent() {
        return new Student("arich");
    }

    @GetMapping("hello/{name}")
    public String getName(@PathVariable String name) {
        return name;
    }
}
