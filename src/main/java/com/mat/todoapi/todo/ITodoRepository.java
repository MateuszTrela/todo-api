package com.mat.todoapi.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByUsername(String username);

}
