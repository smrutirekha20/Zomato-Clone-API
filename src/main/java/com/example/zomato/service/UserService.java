package com.example.zomato.service;


import com.example.zomato.entity.Customer;
import com.example.zomato.entity.RestaurantOwner;
import com.example.zomato.entity.User;
import com.example.zomato.mapper.UserMapper;
import com.example.zomato.repository.UserRepository;
import com.example.zomato.requestdtos.LoginRequest;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.UserResponse;
import com.example.zomato.security.JWTService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public UserResponse saveUser(UserRequest userRequest) {
        User user= null;
        switch (userRequest.getRole()){
            case RESTAURANT_OWNER -> user = new RestaurantOwner();
            case CUSTOMER -> user = new Customer();
        }
        userMapper.mapToUSer(userRequest,user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));//user is created with unique identifier
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);

    }

    public String login(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword());
        Authentication authentication =authenticationManager.authenticate(token);
        if(authentication.isAuthenticated()){
            return jwtService.generateJWT(loginRequest.getEmail(),5*60*1000L);
        }
        else {
            throw new UsernameNotFoundException("Failed to found username");
        }

    }
}
