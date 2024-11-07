package com.example.zomato.controller;

import com.example.zomato.requestdtos.LoginRequest;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.AuthResponse;
import com.example.zomato.responsedtos.UserResponse;
import com.example.zomato.service.UserService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ResponseStructure;
import com.example.zomato.utility.SimpleResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<ResponseStructure<AuthResponse>> login(@RequestBody @Valid LoginRequest loginRequest) {
        log.info("Login Requested.");
        AuthResponse authResponse = userService.login(loginRequest);
        HttpHeaders headers = userService.grantCredential(authResponse);

        return appResponseBuilder.success(headers, HttpStatus.OK, "logged in", authResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<ResponseStructure<AuthResponse>> refreshLogin(@CookieValue(required = false,name = "rt") String refreshToken){
        log.info("refresh login ");
        AuthResponse authResponse=userService.refreshLogin(refreshToken);
        HttpHeaders headers=userService.grantCredential(authResponse);

        return appResponseBuilder.success(headers,HttpStatus.OK,"refreshed Login  successfully!!",authResponse);
    }

    @PostMapping("/logout")
    public  ResponseEntity<SimpleResponseStructure> logOut(){
        HttpHeaders headers=userService.logOut();
        return appResponseBuilder.success(HttpStatus.OK,"logged out",headers);
    }
}
