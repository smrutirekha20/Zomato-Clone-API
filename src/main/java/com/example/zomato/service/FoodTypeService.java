package com.example.zomato.service;

import com.example.zomato.entity.FoodType;
import com.example.zomato.exception.FoodNotFoundByIdException;
import com.example.zomato.mapper.FoodTypeMapper;
import com.example.zomato.repository.FoodTypeRepository;
import com.example.zomato.requestdtos.FoodTypeRequest;
import com.example.zomato.responsedtos.FoodTypeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoodTypeService {

    private final FoodTypeRepository foodTypeRepository;
    private final FoodTypeMapper foodTypeMapper;

    public FoodTypeResponse saveFoodType(FoodTypeRequest foodTypeRequest) {
        if (foodTypeRepository.existsByTitleIgnoreCase(foodTypeRequest.getTitle())) {
            throw new IllegalArgumentException("FoodType with this title already exists.");
        }
        FoodType foodType = foodTypeRepository.save(foodTypeMapper.mapToFoodType(foodTypeRequest, new FoodType()));//user is created with unique identifier
        return foodTypeMapper.mapToFoodTypeResponse(foodType);

    }

    public FoodTypeResponse findFoodTypeById(String typeId) {

        return foodTypeRepository.findById(typeId)
                .map(foodTypeMapper::mapToFoodTypeResponse)
                .orElseThrow(() -> new FoodNotFoundByIdException("food type not found by id"));
    }

}
