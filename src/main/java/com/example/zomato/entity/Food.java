package com.example.zomato.entity;

import com.example.zomato.config.GenerateCustomId;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;
@Entity
@Data
@Table(name = "food")
public class Food {

    @Id
    @GenerateCustomId
    @Column(name = "food_id")
    private String foodId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "local_date_time")
    private Duration preparationTime;

    @Column(name = "boolean")
    private boolean available;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private Cuisine cuisine;

    @ManyToOne
    private MenuCategory menuCategory;

    @ManyToOne
    private FoodType foodType;
}
