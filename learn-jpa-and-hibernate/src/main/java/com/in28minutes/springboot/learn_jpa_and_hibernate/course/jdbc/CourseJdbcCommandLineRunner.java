package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "Learn Docker", "in28minutes"));
        courseJdbcRepository.insert(new Course(2, "Learn Java", "in28minutes"));
        courseJdbcRepository.insert(new Course(3, "Learn AWS", "in28minutes"));
        courseJdbcRepository.deleteById(2);
        System.out.println(courseJdbcRepository.findById(3));

        courseJpaRepository.save((new Course(4, "Learn JPA", "in28minutes")));
        courseJpaRepository.save((new Course(5, "Learn Python", "in28minutes")));
        System.out.println(courseJpaRepository.findById(5));
    }
}
