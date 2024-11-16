package com.in28minutes.learn_spring_aop.aop.business;

import com.in28minutes.learn_spring_aop.aop.data.DataService1;
import com.in28minutes.learn_spring_aop.aop.data.DataService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {
    @Autowired
    private DataService2 dataService2;

    public int calculateMin() {
        int[] data = dataService2.retrieveData();
//        throw new RuntimeException("Error thrown!");
        return Arrays.stream(data).min().orElse(0);
    }
}
