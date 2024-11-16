package com.in28minutes.learn_spring_aop.aop.business;

import com.in28minutes.learn_spring_aop.aop.annotations.TrackTime;
import com.in28minutes.learn_spring_aop.aop.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class BusinessService1 {
    @Autowired
    private DataService1 dataService1;

    @TrackTime
    public int calculateMax() {
        int[] data = dataService1.retrieveData();
//        throw new RuntimeException("Error thrown!");
        return Arrays.stream(data).max().orElse(0);
    }
}
