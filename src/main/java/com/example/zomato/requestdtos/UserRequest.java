package com.example.zomato.requestdtos;

import com.example.zomato.enums.UserRole;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private UserRole role;
    private String email;
    private String password;
}
