package com.mat.todoapi.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TodoController {

    ITodoRepository todoRepository;

    public TodoController(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {

        return todoRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {

        if(todoRepository.findById(id).isPresent()){
            return todoRepository.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo){
        todo.setId(null);
        todo.setUsername(username);

        return todoRepository.save(todo);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo){
        if(todoRepository.findById(id).isPresent()) {
            todo.setId(id);
            todo.setUsername(username);
            Todo updatedTodo  = todoRepository.save(todo);
            return ResponseEntity.ok(updatedTodo);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){

        if(todoRepository.findById(id).isPresent()){
            todoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
