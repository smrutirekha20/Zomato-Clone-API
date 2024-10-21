package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import com.example.zomato.enums.DietType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {

    @Id
    @GenerateCustomId
    @Column(name = "restaurant_id")
    private String restaurantId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "diet_types")
    @ElementCollection
    private List<DietType> dietTypes;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "image_url")
    private String imageUrl;

}



