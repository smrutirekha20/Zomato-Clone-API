package com.example.zomato.responsedtos;

import com.example.zomato.enums.UserRole;
import lombok.Data;

import java.time.Duration;

@Data
public class AuthResponse {

    private String userId;
    private String username;
    private UserRole role;
    private Duration accessExpiration;
    private Duration refreshExpiration;
}
