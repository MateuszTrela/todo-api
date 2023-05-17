package com.mat.todoapi.auth;

import com.mat.todoapi.config.JWtService;
import com.mat.todoapi.user.Role;
import com.mat.todoapi.user.User;
import com.mat.todoapi.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class AuthenticationService {

    private final JWtService jWtService;

    private final UserRepository repository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public AuthenticationService(JWtService jWtService, UserRepository repository) {
        this.jWtService = jWtService;
        this.repository = repository;
    }


    public JwtResponse register(RegisterRequest request){

        if(repository.findByUsername(request.getUsername()).isEmpty()) {

            //create user
            User user = User.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder().encode(request.getPassword()))
                    .role(Role.USER)
                    .build();

            repository.save(user);

            //generate token
            String jwtToken = jWtService.generateToken(user);
            System.out.println("jwtToken : " + jwtToken);
            return JwtResponse
                    .builder()
                    .token(jwtToken)
                    .build();
        }
        return JwtResponse.builder().token(null).build();
    }
}
