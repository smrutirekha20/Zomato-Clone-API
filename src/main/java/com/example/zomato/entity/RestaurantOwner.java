package com.example.zomato.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "restaurant_owner")
public class RestaurantOwner extends User{

    @OneToMany(mappedBy = "restaurantOwner",cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;
}
