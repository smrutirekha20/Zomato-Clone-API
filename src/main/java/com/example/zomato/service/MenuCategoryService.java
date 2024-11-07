package com.example.zomato.service;

import com.example.zomato.entity.Address;
import com.example.zomato.entity.MenuCategory;
import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.AddressNotFoundByIdException;
import com.example.zomato.exception.MenuCategoryNotFoundByIdException;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapper.MenuCategoryMapper;
import com.example.zomato.repository.MenuCategoryRepository;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.requestdtos.MenuCategoryRequest;
import com.example.zomato.responsedtos.AddressResponse;
import com.example.zomato.responsedtos.MenuCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuCategoryService {
    private final MenuCategoryMapper menuCategoryMapper;
    private final RestaurantRepository restaurantRepository;
    private final MenuCategoryRepository menuCategoryRepository;
    public MenuCategoryResponse saveMenuCategory(MenuCategoryRequest menuCategoryRequest,String restaurantId){

        MenuCategory menuCategory = menuCategoryMapper.mapToMenuCategory(menuCategoryRequest, new MenuCategory());
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found by given id"));

        menuCategory.setRestaurant(restaurant);
        menuCategory = menuCategoryRepository.save(menuCategory);

        return menuCategoryMapper.mapToMenuCategoryResponse(menuCategory);

    }
    public MenuCategoryResponse updateMenuCategory(MenuCategoryRequest menuCategoryRequest,String menuCategoryId){

        return menuCategoryRepository.findById(menuCategoryId)
                .map(exMenuCategory -> {
                    menuCategoryMapper.mapToMenuCategory(menuCategoryRequest, exMenuCategory);
                    exMenuCategory = menuCategoryRepository.save(exMenuCategory);
                    return menuCategoryMapper.mapToMenuCategoryResponse(exMenuCategory);

                })
                .orElseThrow(() -> new MenuCategoryNotFoundByIdException("Failed To Update MenuCategory"));
    }
}
