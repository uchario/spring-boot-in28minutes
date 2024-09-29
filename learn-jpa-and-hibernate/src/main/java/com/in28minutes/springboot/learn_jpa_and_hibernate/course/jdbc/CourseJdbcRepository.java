package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY =
            """
                insert into course (id, name, author) values (?, ?, ?)
            """;
    private static final String DELETE_QUERY =
            """
                delete from course where id = ?
            """;
    private static final String SELECT_QUERY =
            """
                select * from course where id = ?
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(int courseId) {
        jdbcTemplate.update(DELETE_QUERY, courseId);
    }

    public Course findById(int courseId) {
        return jdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),
                courseId);
    }
}
