package com.example.zomato.mapper;

import com.example.zomato.entity.FoodType;
import com.example.zomato.requestdtos.FoodTypeRequest;
import com.example.zomato.responsedtos.FoodTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class FoodTypeMapper {

    public FoodType mapToFoodType(FoodTypeRequest foodTypeRequest, FoodType foodType) {
        foodType.setTitle(foodTypeRequest.getTitle());

        return foodType;
    }

    public FoodTypeResponse mapToFoodTypeResponse(FoodType foodType) {
        FoodTypeResponse foodTypeResponse = new FoodTypeResponse();
        foodTypeResponse.setTypeId(foodType.getTypeId());
        foodTypeResponse.setTitle(foodType.getTitle());

        return foodTypeResponse;
    }
}
