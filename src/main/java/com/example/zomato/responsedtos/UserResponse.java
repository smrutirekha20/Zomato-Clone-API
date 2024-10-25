package com.example.zomato.responsedtos;

import com.example.zomato.enums.UserRole;
import lombok.Data;

@Data
public class UserResponse {

    private String userId;
    private String firstName;
    private String lastName;
    private UserRole role;
    private String email;

}
