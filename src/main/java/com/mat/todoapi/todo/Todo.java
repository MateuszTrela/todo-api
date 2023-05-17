package com.mat.todoapi.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Todo {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull(message = "username can't be null")
    private String username;
    @Size(min = 1, message = "description must contains at lease 1 character")
    private String description;
    private boolean isDone;
    @NotNull(message = "targetDate can't be null")
    private LocalDate targetDate;

    public Todo(Integer id, String username, String description, boolean isDone, LocalDate targetDate) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.isDone = isDone;
        this.targetDate = targetDate;
    }
}
