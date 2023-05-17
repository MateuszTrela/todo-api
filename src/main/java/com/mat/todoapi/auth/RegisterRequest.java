package com.mat.todoapi.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
