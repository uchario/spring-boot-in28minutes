package com.in28minutes.rest.webservices.restful_web_services.controller;

import com.in28minutes.rest.webservices.restful_web_services.repository.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

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

    @GetMapping("/hello-world-int")
    public String helloWorldInt() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
