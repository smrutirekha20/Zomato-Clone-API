package com.example.zomato.service;
import com.example.zomato.entity.*;
import com.example.zomato.exception.CuisineNotFoundByIdException;
import com.example.zomato.exception.FoodNotFoundByIdException;
import com.example.zomato.exception.MenuCategoryNotFoundByIdException;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapper.FoodMapper;
import com.example.zomato.repository.*;
import com.example.zomato.requestdtos.FoodRequest;
import com.example.zomato.responsedtos.FoodResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodMapper foodMapper;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final MenuCategoryRepository menuCategoryRepository;
    private final CuisineRepository cuisineRepository;
    private final FoodTypeRepository foodTypeRepository;

    public FoodResponse saveFood(FoodRequest foodRequest, String restaurantId,String menuCategoryId,String cuisineId,String typeId ) {

        Food food = foodMapper.mapToFood(foodRequest, new Food());
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found by given id"));
        MenuCategory menuCategory=menuCategoryRepository.findById(menuCategoryId)
                .orElseThrow(()->new MenuCategoryNotFoundByIdException("MenuCategory not found by id"));
        Cuisine cuisine = cuisineRepository.findById(cuisineId)
                .orElseThrow(()->new CuisineNotFoundByIdException("Cuisine not found by id"));
        FoodType foodType = foodTypeRepository.findById(typeId)
                .orElseThrow(()->new FoodNotFoundByIdException("Food type not found by id"));

        food.setRestaurant(restaurant);
        food.setMenuCategory(menuCategory);
        food.setCuisine(cuisine);
        food.setFoodType(foodType);
        food = foodRepository.save(food);

        return foodMapper.mapToFoodResponse(food);

    }



}
