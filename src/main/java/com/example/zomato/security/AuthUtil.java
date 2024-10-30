package com.example.zomato.security;

import com.example.zomato.entity.User;
import com.example.zomato.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AuthUtil {
    private final UserRepository userRepository;

    public boolean isUserAuthenticated(){
        return this.getAuthentication()!= null;
    }
    private Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getCurrentUsername(){
       return this.getAuthentication().getName();
    }

    public User getCurrentUser(){
        return userRepository.findByEmail(this.getCurrentUsername())
                .orElseThrow(()->new UsernameNotFoundException("Failed to found user"));
    }

}
