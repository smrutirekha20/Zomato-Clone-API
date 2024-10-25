package com.example.zomato.mapper;


import com.example.zomato.entity.User;
import com.example.zomato.requestdtos.UserRequest;
import com.example.zomato.responsedtos.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUSer(UserRequest userRequest,User user) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setRole(userRequest.getRole());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());

        return user;
    }
    public UserResponse mapToUserResponse(User user){
        UserResponse userResponse=new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setRole(user.getRole());
        userResponse.setEmail(user.getEmail());


        return userResponse;
    }

}
