package com.example.zomato.mapper;

import com.example.zomato.entity.Food;
import com.example.zomato.requestdtos.FoodRequest;
import com.example.zomato.responsedtos.FoodResponse;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {

    public Food mapToFood(FoodRequest foodRequest, Food food) {
        food.setTitle(foodRequest.getTitle());
        food.setDescription(foodRequest.getDescription());
        food.setPrice(foodRequest.getPrice());
        food.setPreparationTime(foodRequest.getPreparationTime());
        food.setAvailable(foodRequest.isAvailable());

        return food;
    }

    public FoodResponse mapToFoodResponse(Food food) {
        FoodResponse foodResponse = new FoodResponse();

        foodResponse.setFoodId(food.getFoodId());
        foodResponse.setTitle(food.getTitle());
        foodResponse.setDescription(food.getDescription());
        foodResponse.setPrice(food.getPrice());
        foodResponse.setPreparationTime(food.getPreparationTime());
        foodResponse.setAvailable(food.isAvailable());

        return foodResponse;
    }
}
