package com.example.zomato.service;

import com.example.zomato.entity.FoodType;
import com.example.zomato.mapper.FoodTypeMapper;
import com.example.zomato.repository.FoodTypeRepository;
import com.example.zomato.requestdtos.FoodTypeRequest;
import com.example.zomato.responsedtos.FoodTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodTypeService {

    private final FoodTypeRepository foodTypeRepository;
    private final FoodTypeMapper foodTypeMapper;

    public FoodTypeResponse saveFoodType(FoodTypeRequest foodTypeRequest) {
        FoodType foodType = foodTypeRepository.save(foodTypeMapper.mapToFoodType(foodTypeRequest, new FoodType()));//user is created with unique identifier
        return foodTypeMapper.mapToFoodTypeResponse(foodType);

    }

    public List<String> findAllFoodTypes() {
        List<FoodType> foodTypes = foodTypeRepository.findAll();
            return foodTypes.stream()
                    .map(foodTypeMapper::mapToFoodTypeResponse)
                    .map(FoodTypeResponse::getTitle)
                    .toList();
        }

}


