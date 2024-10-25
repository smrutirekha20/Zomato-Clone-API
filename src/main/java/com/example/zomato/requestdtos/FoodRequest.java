package com.example.zomato.requestdtos;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class FoodRequest {

    private String title;
    private String description;
    private double price;
    private Duration preparationTime;
    private boolean available;

    // Foreign key
//    private String menuCategoryId;
//    private String restaurantId;
//    private String cuisineId;
//    private String typeId;
}
