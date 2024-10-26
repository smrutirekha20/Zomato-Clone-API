package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import com.example.zomato.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {

    @Id
    @GenerateCustomId
    @Column(name = "user_id")
    private String userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role")
    private UserRole role;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
