package com.in28minutes.learn_spring_aop.aop.data;

import com.in28minutes.learn_spring_aop.aop.annotations.TrackTime;
import org.springframework.stereotype.Service;

@Service
public class DataService2 {
    @TrackTime
    public int[] retrieveData() {
        return new int[] {11,22,33};
    }
}
