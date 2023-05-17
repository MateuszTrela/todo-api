package com.mat.todoapi.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        if(request.getUsername() != null && request.getPassword() != null) {
            String token = service.register(request).getToken();
            if(token != null){
                return ResponseEntity.ok(token);
            }
           return ResponseEntity.badRequest().body("Username exist");
        }
        return ResponseEntity.badRequest().build();
    }
}
