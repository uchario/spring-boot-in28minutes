package com.in28minutes.learn_spring_aop.aop.data;

import org.springframework.stereotype.Service;

@Service
public class DataService1 {
    public int[] retrieveData() {
        return new int[] {11,22,33};
    }
}
