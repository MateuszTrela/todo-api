package com.mat.todoapi.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    ITodoRepository todoRepository;

    public TodoController(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username){

        return todoRepository.findByUsername(username);
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo){
        todo.setId(null);
        todo.setUsername(username);

        return todoRepository.save(todo);
    }

}
