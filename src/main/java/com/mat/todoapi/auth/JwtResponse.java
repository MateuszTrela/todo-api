package com.mat.todoapi.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {

    private String token;

}
