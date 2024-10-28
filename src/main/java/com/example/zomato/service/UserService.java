package com.example.zomato.service;


import com.example.zomato.entity.Customer;
import com.example.zomato.entity.RestaurantOwner;
import com.example.zomato.entity.User;
import com.example.zomato.mapper.UserMapper;
import com.example.zomato.repository.UserRepository;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

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
}
