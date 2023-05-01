package com.mat.todoapi.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String description;
    private boolean isDone;
    private LocalDate targetDate;

    public Todo() {
    }

    public Todo(Integer id, String username, String description, boolean isDone, LocalDate targetDate) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.isDone = isDone;
        this.targetDate = targetDate;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                ", targetDate=" + targetDate +
                '}';
    }
}
