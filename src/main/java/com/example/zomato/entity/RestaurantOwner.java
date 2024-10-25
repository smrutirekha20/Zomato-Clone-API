package com.example.zomato.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant_owner")
public class RestaurantOwner extends User{
}
