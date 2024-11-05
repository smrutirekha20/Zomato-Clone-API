package com.example.zomato.controller;

import com.example.zomato.requestdtos.LoginRequest;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.UserResponse;
import com.example.zomato.security.JWTService;
import com.example.zomato.service.UserService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
@Slf4j
public class UserController {

    private final UserService userService;
    private final AppResponseBuilder appResponseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody @Valid UserRequest
                                                                           userRequest) {
        UserResponse userResponse = userService.saveUser(userRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "User created", userResponse);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest) {
        log.info("Login Requested.");
        return userService.login(loginRequest);
    }

}
