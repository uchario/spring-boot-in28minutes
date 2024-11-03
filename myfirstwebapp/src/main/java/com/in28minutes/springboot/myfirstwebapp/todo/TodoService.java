package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(
                1,
                "arich",
                "Learn Java",
                LocalDate.now().plusYears(1),
                false)
        );
        todos.add(new Todo(
                2,
                "bukky",
                "Learn AWS",
                LocalDate.now().plusYears(2),
                false)
        );
    }

    public List<Todo> findByUsername(String username) {
//        return todos.stream().filter(i -> i.getUsername().equals(username)).toList();
        return todos;
    }
}
