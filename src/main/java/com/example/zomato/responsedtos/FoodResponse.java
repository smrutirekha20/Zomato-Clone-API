package com.example.zomato.responsedtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FoodResponse {

    private String foodId;
    private String title;
    private String description;
    private double price;
    private LocalDateTime preparationTime;
    private boolean available;
}
