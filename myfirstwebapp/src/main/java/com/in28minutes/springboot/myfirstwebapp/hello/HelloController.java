package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @GetMapping("hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! what are you learning today?";
    }

    @GetMapping("say-hello-jsp")
//    @ResponseBody
    public String sayHelloJsp() {
        return "sayHello";
    }
}
