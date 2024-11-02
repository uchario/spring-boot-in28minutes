package com.in28minutes.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("v1/person")
    public Person getPerson() {
        return new Person("Bob Charlie");
    }

    @GetMapping(path = "person", params = "version=1")
    public Person getPersonRequestParams() {
        return new Person("Arich Tarant");
    }

    @GetMapping(path = "person", headers = "X-API-VERSION=1")
    public Person getPersonRequestHeaders() {
        return new Person("Bukky Sanders");
    }

    @GetMapping(path = "person", produces = "application/vnd.company.app-v1+json")
    public Person getPersonAcceptHeader() {
        return new Person("Sam Klef");
    }
}
