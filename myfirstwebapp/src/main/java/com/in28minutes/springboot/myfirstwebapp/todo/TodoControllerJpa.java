package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoRepository.findByUsername("bukky");
        modelMap.put("todos", todos);
        return "listTodos";
    }
}
