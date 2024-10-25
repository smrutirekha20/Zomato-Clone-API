package com.example.zomato.responsedtos;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class FoodResponse {

    private String foodId;
    private String title;
    private String description;
    private double price;
    private Duration preparationTime;
    private boolean available;
}
