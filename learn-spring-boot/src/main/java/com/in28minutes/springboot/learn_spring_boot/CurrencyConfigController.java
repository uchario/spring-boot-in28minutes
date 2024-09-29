package com.in28minutes.springboot.learn_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigController {
    @Autowired
    private CurrencyServiceConfig currencyServiceConfig;

    @GetMapping("/currency-config")
    public CurrencyServiceConfig retrieveAllCourses() {
        return currencyServiceConfig;
    }
}
